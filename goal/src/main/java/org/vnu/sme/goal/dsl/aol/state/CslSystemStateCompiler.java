package org.vnu.sme.goal.dsl.aol.state;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.vnu.sme.goal.dsl.csl.ast.CslSourceLocationCS;
import org.vnu.sme.goal.dsl.csl.mm.CslAttribute;
import org.vnu.sme.goal.dsl.csl.mm.CslCardinality;
import org.vnu.sme.goal.dsl.csl.mm.CslEnum;
import org.vnu.sme.goal.dsl.csl.mm.CslModel;
import org.vnu.sme.goal.dsl.csl.mm.CslRelation;
import org.vnu.sme.goal.dsl.aol.ast.AolAttributeValueCS;
import org.vnu.sme.goal.dsl.aol.ast.AolModelCS;
import org.vnu.sme.goal.dsl.aol.parser.AOLBuildingVisitor;
import org.vnu.sme.goal.dsl.aol.parser.AOLLexer;
import org.vnu.sme.goal.dsl.aol.parser.AOLParser;
import org.vnu.sme.goal.dsl.aol.state.CslSystemState.AssociationLink;
import org.vnu.sme.goal.dsl.aol.state.CslSystemState.Kind;
import org.vnu.sme.goal.dsl.aol.state.CslSystemState.ObjectValue;
import org.vnu.sme.goal.dsl.aol.state.CslSystemState.PlayLink;

/** Compiles AOL v2 snapshots into the formal CSL system-state tuple. */
public final class CslSystemStateCompiler {
    public record Result(Path cslFile, CslSystemState state, List<String> diagnostics) {
        public Result { diagnostics = List.copyOf(diagnostics); }
        public boolean valid() { return state != null && diagnostics.isEmpty(); }
    }

    private CslSystemStateCompiler() {}

    public static Result compile(Path file, Path expectedCslFile, CslModel model) throws IOException {
        Objects.requireNonNull(file, "file");
        Objects.requireNonNull(expectedCslFile, "expectedCslFile");
        Objects.requireNonNull(model, "model");
        Path source = file.toAbsolutePath().normalize();
        return compile(CharStreams.fromPath(source), source, expectedCslFile, model, true);
    }

    public static Result compileContent(String content, Path expectedCslFile, CslModel model) {
        Objects.requireNonNull(content, "content");
        Objects.requireNonNull(expectedCslFile, "expectedCslFile");
        Objects.requireNonNull(model, "model");
        Path cslFile = expectedCslFile.toAbsolutePath().normalize();
        return compile(CharStreams.fromString(content), cslFile.resolveSibling("counterexample.aol"),
                cslFile, model, false);
    }

    private static Result compile(CharStream input, Path source, Path expectedCslFile,
                                  CslModel model, boolean validateCslReference) {
        List<String> syntax = new ArrayList<>();
        AOLLexer lexer = new AOLLexer(input);
        AOLParser parser = new AOLParser(new CommonTokenStream(lexer));
        BaseErrorListener listener = new BaseErrorListener() {
            @Override public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                    int line, int column, String message, RecognitionException exception) {
                syntax.add(format(source, new CslSourceLocationCS(line, column), "syntax", message));
            }
        };
        lexer.removeErrorListeners(); parser.removeErrorListeners();
        lexer.addErrorListener(listener); parser.addErrorListener(listener);
        AOLParser.ModelContext tree = parser.model();
        if (!syntax.isEmpty()) return new Result(null, null, syntax);

        AolModelCS ast = new AOLBuildingVisitor().visitModel(tree);
        Path referencedCslFile = source.getParent().resolve(ast.cslFile()).normalize();
        if (validateCslReference && !sameFile(expectedCslFile, referencedCslFile)) {
            return new Result(referencedCslFile, null, List.of("State snapshot references '" + referencedCslFile
                    + "', expected CSL specification '" + expectedCslFile + "'"));
        }
        Path cslFile = validateCslReference ? referencedCslFile : expectedCslFile.toAbsolutePath().normalize();
        return new Builder(source, cslFile, ast, model).build();
    }

    private static final class Builder {
        private final Path source;
        private final Path cslFile;
        private final AolModelCS ast;
        private final CslModel model;
        private final List<String> diagnostics = new ArrayList<>();
        private final Map<String, ObjectValue> objects = new LinkedHashMap<>();
        private final List<AssociationLink> associations = new ArrayList<>();
        private final List<PlayLink> plays = new ArrayList<>();
        private final Map<String, CslRelation> relations;
        private int fatalErrors;

        Builder(Path source, Path cslFile, AolModelCS ast, CslModel model) {
            this.source = source; this.cslFile = cslFile; this.ast = ast; this.model = model;
            this.relations = CslSystemState.relationIndex(model);
        }

        Result build() {
            if (!ast.version().equals("v2.0")) {
                fatal(ast.location(), "Formal state snapshots require version v2.0");
            }
            for (var agent : ast.agents()) {
                addObject(agent.name(), "Agent", Kind.AGENT, Map.of(), agent.location());
            }
            for (var group : ast.groupInstances()) {
                if (!group.subgroups().isEmpty() || !group.plays().isEmpty() || !group.entities().isEmpty()) {
                    fatal(group.location(), "State snapshot Group blocks contain attributes only; represent containment"
                            + " with an explicit composition link");
                }
                var type = model.findGroup(group.typeName());
                if (type.isEmpty()) fatal(group.location(), "unknown Group type '" + group.typeName() + "'");
                else addObject(group.instanceId(), group.typeName(), Kind.GROUP,
                        values(attributesForGroup(group.typeName()), group.attributeValues(), group.location()),
                        group.location());
            }
            for (var entity : ast.entities()) {
                var type = model.findEntity(entity.entityType());
                if (type.isEmpty()) fatal(entity.location(), "unknown Entity type '" + entity.entityType() + "'");
                else addObject(entity.instanceId(), entity.entityType(), Kind.ENTITY,
                        values(attributesForEntity(entity.entityType()), entity.attributeValues(), entity.location()),
                        entity.location());
            }
            for (var role : ast.roles()) {
                var type = model.findRole(role.roleType());
                if (type.isEmpty()) fatal(role.location(), "unknown Role type '" + role.roleType() + "'");
                else addObject(role.instanceId(), role.roleType(), Kind.ROLE,
                        values(attributesForRole(role.roleType()), role.attributeValues(), role.location()),
                        role.location());
            }
            if (fatalErrors > 0) return new Result(cslFile, null, diagnostics);

            buildAssociationLinks();
            buildPlayLinks();
            if (fatalErrors > 0) return new Result(cslFile, null, diagnostics);
            validateAssociationMultiplicities();
            validateRequiredPlayLinks();
            CslSystemState state = new CslSystemState(model, objects, associations, plays);
            return new Result(cslFile, state, diagnostics);
        }

        private void addObject(String id, String type, Kind kind, Map<String, Object> values,
                               CslSourceLocationCS location) {
            if (objects.putIfAbsent(id, new ObjectValue(id, type, kind, values)) != null) {
                fatal(location, "duplicate object identifier '" + id + "'");
            }
        }

        private void buildAssociationLinks() {
            Set<String> seen = new LinkedHashSet<>();
            for (var declaration : ast.links()) {
                CslRelation relation = relations.get(declaration.relationName());
                if (relation == null) {
                    fatal(declaration.location(), "unknown Association '" + declaration.relationName() + "'");
                    continue;
                }
                ObjectValue sourceObject = objects.get(declaration.sourceInstanceId());
                if (sourceObject == null) {
                    fatal(declaration.location(), "unknown source object '" + declaration.sourceInstanceId() + "'");
                    continue;
                }
                if (!conforms(sourceObject, relation.source().type())) {
                    fatal(declaration.location(), "object '" + sourceObject.id() + "' of type '"
                            + sourceObject.type() + "' does not conform to source endpoint '"
                            + relation.source().type() + "'");
                }
                for (String targetId : declaration.targetInstanceIds()) {
                    ObjectValue targetObject = objects.get(targetId);
                    if (targetObject == null) {
                        fatal(declaration.location(), "unknown target object '" + targetId + "'");
                        continue;
                    }
                    if (!conforms(targetObject, relation.target().type())) {
                        fatal(declaration.location(), "object '" + targetObject.id() + "' of type '"
                                + targetObject.type() + "' does not conform to target endpoint '"
                                + relation.target().type() + "'");
                    }
                    String key = relation.name() + "\0" + sourceObject.id() + "\0" + targetObject.id();
                    if (!seen.add(key)) fatal(declaration.location(), "duplicate Association link '"
                            + relation.name() + "(" + sourceObject.id() + ", " + targetObject.id() + ")'");
                    else associations.add(new AssociationLink(relation.name(), sourceObject.id(), targetObject.id()));
                }
            }
        }

        private void buildPlayLinks() {
            Set<String> seen = new LinkedHashSet<>();
            for (var declaration : ast.playLinks()) {
                ObjectValue parent = objects.get(declaration.parentInstanceId());
                ObjectValue child = objects.get(declaration.childInstanceId());
                if (parent == null || child == null) {
                    fatal(declaration.location(), "play endpoints must reference existing Agent or Role objects");
                    continue;
                }
                if (parent.kind() == Kind.AGENT) {
                    if (child.kind() != Kind.ROLE) {
                        fatal(declaration.location(), "Agent can only play Role objects");
                        continue;
                    }
                    String key = parent.id() + "\0" + child.id();
                    if (!seen.add(key)) fatal(declaration.location(), "duplicate play link from '"
                            + parent.id() + "' to '" + child.id() + "'");
                    else plays.add(new PlayLink(parent.id(), child.id()));
                    continue;
                }
                if (parent.kind() != Kind.ROLE || child.kind() != Kind.ROLE) {
                    fatal(declaration.location(), "play endpoints between roles must both be Role objects");
                    continue;
                }
                var childType = model.findRole(child.type()).orElseThrow();
                if (!childType.parentRoles().contains(parent.type())) {
                    fatal(declaration.location(), "Role '" + child.type() + "' is not a direct child of Role '"
                            + parent.type() + "'");
                    continue;
                }
                String key = parent.id() + "\0" + child.id();
                if (!seen.add(key)) fatal(declaration.location(), "duplicate play link from '"
                        + parent.id() + "' to '" + child.id() + "'");
                else plays.add(new PlayLink(parent.id(), child.id()));
            }
        }

        private void validateRequiredPlayLinks() {
            if (model.isRevisedCore()) return;
            for (ObjectValue child : objects.values()) {
                if (child.kind() != Kind.ROLE) continue;
                var role = model.findRole(child.type()).orElseThrow();
                for (String parentType : role.parentRoles()) {
                    long count = plays.stream().filter(link -> link.childRoleId().equals(child.id()))
                            .map(link -> objects.get(link.parentRoleId()))
                            .filter(parent -> parent != null && parent.type().equals(parentType)).count();
                    if (count != 1) constraint(ast.location(), "Role object '" + child.id() + "' of type '"
                            + child.type() + "' requires exactly one sigma_Play parent of type '"
                            + parentType + "', found " + count);
                }
            }
        }

        private void validateAssociationMultiplicities() {
            for (CslRelation relation : relations.values()) {
                List<ObjectValue> sources = objects.values().stream()
                        .filter(object -> conforms(object, relation.source().type())).toList();
                List<ObjectValue> targets = objects.values().stream()
                        .filter(object -> conforms(object, relation.target().type())).toList();
                for (ObjectValue sourceObject : sources) {
                    long count = associations.stream().filter(link -> link.relationName().equals(relation.name())
                            && link.sourceId().equals(sourceObject.id())).count();
                    checkMultiplicity(relation, sourceObject.id(), "target", relation.target().multiplicity(), count);
                }
                for (ObjectValue targetObject : targets) {
                    long count = associations.stream().filter(link -> link.relationName().equals(relation.name())
                            && link.targetId().equals(targetObject.id())).count();
                    checkMultiplicity(relation, targetObject.id(), "source", relation.source().multiplicity(), count);
                }
            }
        }

        private void checkMultiplicity(CslRelation relation, String objectId, String end,
                                       CslCardinality cardinality, long count) {
            boolean valid = count >= cardinality.min()
                    && (cardinality.max().isEmpty() || count <= cardinality.max().getAsInt());
            if (!valid) constraint(ast.location(), "Association '" + relation.name() + "' at object '"
                    + objectId + "' has " + count + " " + end + " link(s), expected "
                    + cardinalityText(cardinality));
        }

        private Map<String, Object> values(List<CslAttribute> declared,
                                           List<AolAttributeValueCS> supplied,
                                           CslSourceLocationCS objectLocation) {
            Map<String, CslAttribute> definitions = new LinkedHashMap<>();
            declared.forEach(attribute -> definitions.put(attribute.name(), attribute));
            Map<String, String> raw = new LinkedHashMap<>();
            for (AolAttributeValueCS value : supplied) {
                if (!definitions.containsKey(value.name())) {
                    fatal(value.location(), "unknown direct attribute '" + value.name() + "'");
                } else if (raw.putIfAbsent(value.name(), value.rawValue()) != null) {
                    fatal(value.location(), "duplicate value for attribute '" + value.name() + "'");
                }
            }
            Map<String, Object> result = new LinkedHashMap<>();
            for (CslAttribute attribute : declared) {
                String value = raw.get(attribute.name());
                if (value == null) value = attribute.defaultValue().orElse(null);
                if (value == null) {
                    if (!attribute.optional()) fatal(objectLocation, "required attribute '"
                            + attribute.name() + "' has no value");
                    continue;
                }
                Object typed = typedValue(attribute, value, objectLocation);
                if (typed != null) result.put(attribute.name(), typed);
            }
            return result;
        }

        private Object typedValue(CslAttribute attribute, String raw, CslSourceLocationCS location) {
            try {
                return switch (attribute.type().sourceName()) {
                    case "Boolean" -> {
                        if (!raw.equals("true") && !raw.equals("false")) throw new IllegalArgumentException();
                        yield Boolean.valueOf(raw);
                    }
                    case "Integer" -> Long.valueOf(raw);
                    case "Real" -> Double.valueOf(raw);
                    case "String" -> {
                        if (raw.length() < 2 || raw.charAt(0) != '"' || raw.charAt(raw.length() - 1) != '"')
                            throw new IllegalArgumentException();
                        yield raw.substring(1, raw.length() - 1);
                    }
                    default -> {
                        CslEnum enumeration = model.enums().stream()
                                .filter(value -> value.name().equals(attribute.type().sourceName()))
                                .findFirst().orElse(null);
                        if (enumeration != null) {
                            String literal = raw.replaceFirst("^.*::", "");
                            if (!enumeration.literals().contains(literal)) throw new IllegalArgumentException();
                            yield literal;
                        }
                        if (model.namedDataTypes().stream()
                                .noneMatch(type -> type.sourceName().equals(attribute.type().sourceName()))) {
                            throw new IllegalArgumentException();
                        }
                        yield raw.length() >= 2 && raw.startsWith("\"") && raw.endsWith("\"")
                                ? raw.substring(1, raw.length() - 1) : raw;
                    }
                };
            } catch (RuntimeException ex) {
                fatal(location, "value '" + raw + "' is invalid for attribute '" + attribute.name()
                        + " : " + attribute.type().sourceName() + "'");
                return null;
            }
        }

        private List<CslAttribute> attributesForEntity(String type) {
            List<CslAttribute> result = new ArrayList<>();
            String current = type;
            Set<String> seen = new LinkedHashSet<>();
            while (current != null && seen.add(current)) {
                var entity = model.findEntity(current).orElse(null);
                if (entity == null) break;
                result.addAll(entity.attributes());
                current = entity.specializes().orElse(null);
            }
            return result;
        }

        private List<CslAttribute> attributesForGroup(String type) {
            List<CslAttribute> result = new ArrayList<>();
            String current = type;
            Set<String> seen = new LinkedHashSet<>();
            while (current != null && seen.add(current)) {
                var group = model.findGroup(current).orElse(null);
                if (group == null) break;
                result.addAll(group.attributes());
                current = group.specializes().orElse(null);
            }
            return result;
        }

        private List<CslAttribute> attributesForRole(String type) {
            var role = model.findRole(type).orElse(null);
            return role == null ? List.of() : List.copyOf(role.attributes());
        }

        private boolean conforms(ObjectValue object, String expected) {
            if (object.type().equals(expected)) return true;
            if (object.kind() == Kind.ROLE) return false;
            String current = object.type();
            Set<String> seen = new LinkedHashSet<>();
            while (seen.add(current)) {
                if (object.kind() == Kind.ENTITY) {
                    var entity = model.findEntity(current).orElse(null);
                    current = entity == null ? null : entity.specializes().orElse(null);
                } else {
                    var group = model.findGroup(current).orElse(null);
                    current = group == null ? null : group.specializes().orElse(null);
                }
                if (current == null) return false;
                if (current.equals(expected)) return true;
            }
            return false;
        }

        private void fatal(CslSourceLocationCS location, String message) {
            fatalErrors++;
            diagnostics.add(format(source, location, "semantic", message));
        }

        private void constraint(CslSourceLocationCS location, String message) {
            diagnostics.add(format(source, location, "state", message));
        }
    }

    private static boolean sameFile(Path expected, Path actual) {
        try { return Files.isSameFile(expected, actual); }
        catch (IOException ex) { return expected.toAbsolutePath().normalize().equals(actual); }
    }

    private static String cardinalityText(CslCardinality value) {
        return "[" + value.min() + ".." + (value.max().isPresent()
                ? value.max().getAsInt() : "*") + "]";
    }

    private static String format(Path source, CslSourceLocationCS location, String phase, String message) {
        return source + ":" + location.line() + ":" + location.column() + ": " + phase + ": " + message;
    }
}
