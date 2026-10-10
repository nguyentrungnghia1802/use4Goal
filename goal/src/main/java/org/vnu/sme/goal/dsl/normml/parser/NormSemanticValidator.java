package org.vnu.sme.goal.dsl.normml.parser;

import java.util.*;
import java.util.function.BiConsumer;
import org.vnu.sme.goal.dsl.normml.mm.NormModel;
import org.vnu.sme.goal.dsl.normml.mm.NormModel.Element;

/** Ecore invariant equivalents; local-reference invariants follow from the closed document graph. */
final class NormSemanticValidator {
    static void validate(NormModel model, BiConsumer<Element,String> error) {
        Set<String> names=new HashSet<>();
        for (Element e:model.elements().values()) {
            switch(e.type()) {
                case "Norm" -> {
                    if (e.value("name").isEmpty() || !names.add(e.value("name"))) error.accept(e,"Norm name must be nonempty and unique");
                    if (e.values("roles").isEmpty() && e.values("agents").isEmpty() && e.values("organizations").isEmpty()) error.accept(e,"Norm requires a subject");
                }
                case "Organization" -> {
                    if (cycle(model,e.id(),e.id(),"subOrganizations",new HashSet<>())) error.accept(e,"Organization hierarchy contains a cycle");
                }
                case "AtomicAction", "CompositeAction" -> {
                    String resource=model.element(e.value("resource")).type(), kind=e.value("kind");
                    boolean compatible;
                    if (e.type().equals("AtomicAction")) {
                        Set<String> allowed=switch(resource) {
                            case "EntityResource", "AssociationEndResource" -> Set.of("AtomicCreate","AtomicRead","AtomicUpdate","AtomicDelete");
                            case "AttributeResource" -> Set.of("AtomicRead","AtomicUpdate");
                            case "AgentAction" -> Set.of("AtomicExecute");
                            default -> Set.of("AtomicSend","AtomicReceive");
                        };
                        compatible=allowed.contains(kind);
                    } else {
                        String expected=switch(kind) {
                            case "EntityRead", "EntityUpdate", "EntityFullAccess" -> "EntityResource";
                            case "AttributeFullAccess" -> "AttributeResource";
                            case "AssociationEndFullAccess" -> "AssociationEndResource";
                            default -> "MessageResource";
                        };
                        compatible=resource.equals(expected);
                        if (cycle(model,e.id(),e.id(),"subordinateActions",new HashSet<>())) error.accept(e,"Composite action contains a cycle");
                    }
                    if (!compatible) error.accept(e,kind+" is incompatible with "+resource);
                }
                case "Before", "After" -> {
                    String actions=e.type().equals("Before")?"beforeActions":"afterActions";
                    if (e.values(actions).isEmpty() && e.values("dates").isEmpty()) error.accept(e,"Constraint requires an action or date boundary");
                }
                case "Between" -> {
                    String start=e.value("startDate"), end=e.value("endDate");
                    if (start.isEmpty() && e.values("afterActions").isEmpty()) error.accept(e,"Between requires opening boundary");
                    if (end.isEmpty() && e.values("beforeActions").isEmpty()) error.accept(e,"Between requires closing boundary");
                    if (!start.isEmpty() && start.equals(end)) error.accept(e,"Between date boundaries must differ");
                    Set<String> boundaries=new HashSet<>();
                    if (!start.isEmpty()) boundaries.add(start); if (!end.isEmpty()) boundaries.add(end);
                    if (!boundaries.equals(new HashSet<>(e.values("dates")))) error.accept(e,"Between dates must equal its selected date boundaries");
                    if (!Collections.disjoint(e.values("afterActions"),e.values("beforeActions"))) error.accept(e,"Between action boundaries must differ");
                }
                case "If" -> { if (!e.values("dates").isEmpty()) error.accept(e,"If does not accept dates"); }
                case "Condition" -> {
                    if (e.value("condExpr").isBlank() || e.value("condLang").isBlank()) error.accept(e,"Condition expression and language must be nonempty");
                    else if (!e.value("condLang").equals("OCL")) error.accept(e,"Unsupported condition language: "+e.value("condLang"));
                    else try { NormOclSyntax.validate(e.value("condExpr")); }
                    catch (IllegalArgumentException ex) { error.accept(e,"OCL: "+ex.getMessage()); }
                }
                default -> { }
            }
        }
    }
    private static boolean cycle(NormModel model,String origin,String current,String feature,Set<String> seen) {
        if (!seen.add(current)) return false;
        for (String next:model.element(current).values(feature))
            if (next.equals(origin) || cycle(model,origin,next,feature,seen)) return true;
        return false;
    }
}
