package org.vnu.sme.goal.dsl.normml.parser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.vnu.sme.goal.dsl.normml.ast.NormModelCS;
import org.vnu.sme.goal.dsl.normml.ast.NormModelCS.Declaration;
import org.vnu.sme.goal.dsl.normml.ast.NormModelCS.Location;
import org.vnu.sme.goal.dsl.normml.ast.NormModelCS.Property;
import org.vnu.sme.goal.dsl.normml.ast.NormModelCS.Value;

/** Builds the NormML CS model from the metamodel-specific ANTLR parse tree. */
public final class NormBuildingVisitor extends NormMLBaseVisitor<Object> {
    private NormModelCS model;

    public static NormModelCS build(NormMLParser.ModelContext context) {
        NormBuildingVisitor visitor = new NormBuildingVisitor();
        visitor.visitModel(context);
        return visitor.model;
    }

    @Override
    public Object visitModel(NormMLParser.ModelContext context) {
        List<Declaration> declarations = context.declaration().stream()
                .map(this::buildDeclaration)
                .toList();
        model = new NormModelCS(context.IDENT().getText(), declarations);
        return model;
    }

    private Declaration buildDeclaration(NormMLParser.DeclarationContext declaration) {
        ParserRuleContext concrete = (ParserRuleContext) declaration.getChild(0);
        return switch (concrete) {
            case NormMLParser.OrganizationDeclContext c -> declaration("Organization", c.IDENT().getText(), c.organizationProperty(), c);
            case NormMLParser.AgentDeclContext c -> declaration("Agent", c.IDENT().getText(), c.agentProperty(), c);
            case NormMLParser.RoleDeclContext c -> declaration("Role", c.IDENT().getText(), c.roleProperty(), c);
            case NormMLParser.DataTypeDeclContext c -> declaration("DataType", c.IDENT().getText(), c.nameProperty(), c);
            case NormMLParser.EntityResourceDeclContext c -> declaration("EntityResource", c.IDENT().getText(), c.entityResourceProperty(), c);
            case NormMLParser.AttributeResourceDeclContext c -> declaration("AttributeResource", c.IDENT().getText(), c.attributeResourceProperty(), c);
            case NormMLParser.AssociationEndResourceDeclContext c -> declaration("AssociationEndResource", c.IDENT().getText(), c.associationEndResourceProperty(), c);
            case NormMLParser.AgentActionDeclContext c -> declaration("AgentAction", c.IDENT().getText(), c.agentActionProperty(), c);
            case NormMLParser.MessageResourceDeclContext c -> declaration("MessageResource", c.IDENT().getText(), c.messageResourceProperty(), c);
            case NormMLParser.AtomicActionDeclContext c -> declaration("AtomicAction", c.IDENT().getText(), c.atomicActionProperty(), c);
            case NormMLParser.CompositeActionDeclContext c -> declaration("CompositeAction", c.IDENT().getText(), c.compositeActionProperty(), c);
            case NormMLParser.NormDeclContext c -> declaration("Norm", c.IDENT().getText(), c.normProperty(), c);
            case NormMLParser.BeforeDeclContext c -> declaration("Before", c.IDENT().getText(), c.beforeProperty(), c);
            case NormMLParser.AfterDeclContext c -> declaration("After", c.IDENT().getText(), c.afterProperty(), c);
            case NormMLParser.BetweenDeclContext c -> declaration("Between", c.IDENT().getText(), c.betweenProperty(), c);
            case NormMLParser.IfDeclContext c -> declaration("If", c.IDENT().getText(), c.ifProperty(), c);
            case NormMLParser.DateDeclContext c -> declaration("Date", c.IDENT().getText(), c.dateValueProperty(), c);
            case NormMLParser.SanctionDeclContext c -> declaration("Sanction", c.IDENT().getText(), c.sanctionProperty(), c);
            case NormMLParser.ConditionDeclContext c -> declaration("Condition", c.IDENT().getText(), c.conditionBodyProperty(), c);
            default -> throw new IllegalStateException("Unsupported NormML declaration: " + concrete.getText());
        };
    }

    private Declaration declaration(String type, String id,
                                    List<? extends ParserRuleContext> properties,
                                    ParserRuleContext context) {
        return new Declaration(type, id, properties.stream().map(this::buildProperty).toList(), location(context));
    }

    /**
     * Concrete property rules all have the form feature ':' value ';'. ANTLR
     * has already selected the legal value form for that exact Ecore feature.
     */
    private Property buildProperty(ParserRuleContext wrapper) {
        ParserRuleContext property = unwrap(wrapper);
        String name = property.getStart().getText();
        List<NormMLParser.ReferenceContext> references = new ArrayList<>();
        collectReferences(property, references);

        List<Value> values;
        if (!references.isEmpty() || containsReferenceList(property)) {
            values = references.stream()
                    .map(reference -> new Value(reference.IDENT().getText(), true, false))
                    .toList();
        } else {
            String text = property.getChild(2).getText();
            boolean quoted = text.length() >= 2 && text.charAt(0) == '"';
            values = List.of(new Value(quoted ? unquote(text) : text, false, quoted));
        }
        return new Property(name, values, location(property));
    }

    private static ParserRuleContext unwrap(ParserRuleContext context) {
        ParserRuleContext current = context;
        while (current.getChildCount() == 1 && current.getChild(0) instanceof ParserRuleContext child) {
            current = child;
        }
        return current;
    }

    private static void collectReferences(ParseTree tree, List<NormMLParser.ReferenceContext> result) {
        if (tree instanceof NormMLParser.ReferenceContext reference) {
            result.add(reference);
            return;
        }
        for (int index = 0; index < tree.getChildCount(); index++) {
            collectReferences(tree.getChild(index), result);
        }
    }

    private static boolean containsReferenceList(ParseTree tree) {
        if (tree instanceof NormMLParser.ReferenceListContext) return true;
        for (int index = 0; index < tree.getChildCount(); index++) {
            if (containsReferenceList(tree.getChild(index))) return true;
        }
        return false;
    }

    private static Location location(ParserRuleContext context) {
        return new Location(context.getStart().getLine(), context.getStart().getCharPositionInLine());
    }

    private static String unquote(String text) {
        StringBuilder result = new StringBuilder();
        for (int index = 1; index < text.length() - 1; index++) {
            char value = text.charAt(index);
            if (value == '\\') {
                value = switch (text.charAt(++index)) {
                    case 'n' -> '\n';
                    case 'r' -> '\r';
                    case 't' -> '\t';
                    default -> text.charAt(index);
                };
            }
            result.append(value);
        }
        return result.toString();
    }
}
