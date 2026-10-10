package org.vnu.sme.goal.dsl.normml.view;

import java.util.*;
import org.tzi.use.api.UseModelApi;
import org.tzi.use.api.UseApiException;
import org.tzi.use.uml.mm.*;
import org.vnu.sme.goal.dsl.normml.mm.*;

/** Presentation-only UML model for the native USE class/association widgets. */
final class NormUseViewModel {
    record Link(String source, String target, MAssociation association, String sourceRole, String targetRole) {}
    final Map<String,MClass> classes = new LinkedHashMap<>();
    final List<Link> links = new ArrayList<>();
    final MModel model = new ModelFactory().createModel("NormMLView");
    static NormUseViewModel build(NormModel norm) {
        var result = new NormUseViewModel();
        var api = new UseModelApi(result.model);
        var schema = NormSchema.INSTANCE;
        try {
            Set<String> enums = new HashSet<>();
            for (var element : norm.elements().values()) {
                if (element.type().equals("NormModel")) continue;
                result.classes.put(element.id(), api.createClass("N_" + element.id(), false));
            }
            for (var element : norm.elements().values()) {
                if (!result.classes.containsKey(element.id())) continue;
                for (var feature : schema.features(element.type()).values()) {
                    if (feature.reference()) continue;
                    var type = schema.type(feature.type());
                    String displayType = "String";
                    if (type != null && type.enumeration()) {
                        displayType = type.name();
                        if (enums.add(displayType)) api.createEnumeration(displayType, type.literals());
                    }
                    api.createAttribute("N_" + element.id(), feature.name(), displayType);
                }
            }
            Set<String> seen = new HashSet<>();
            int index = 0;
            for (var element : norm.elements().values()) {
                if (!result.classes.containsKey(element.id())) continue;
                for (var feature : schema.features(element.type()).values()) {
                    if (!feature.reference()) continue;
                    for (String target : element.values(feature.name())) {
                        if (!result.classes.containsKey(target)) continue;
                        String key = element.id() + "/" + feature.name() + "/" + target;
                        if (!seen.add(key)) continue;
                        var inverse = schema.features(norm.element(target).type()).get(feature.opposite());
                        if (inverse != null) seen.add(target + "/" + inverse.name() + "/" + element.id());
                        // Orient compositions from the owning end, irrespective of declaration order.
                        String source = element.id();
                        var end = feature;
                        if (inverse != null && inverse.containment()) {
                            source = target; target = element.id(); end = inverse; inverse = feature;
                        }
                        String id = "relation_" + index++;
                        MAssociation association = api.createAssociation(id,
                            "N_" + source, "source_" + id,
                            inverse == null ? "0..*" : multiplicity(inverse),
                            end.containment() ? MAggregationKind.COMPOSITION : MAggregationKind.NONE,
                            "N_" + target, "target_" + id, multiplicity(end), MAggregationKind.NONE);
                        result.links.add(new Link(source, target, association, inverse == null ? "" : inverse.name(), end.name()));
                    }
                }
            }
            return result;
        } catch (UseApiException ex) {
            throw new IllegalArgumentException("Cannot create NormML class diagram: " + ex.getMessage(), ex);
        }
    }
    private static String multiplicity(NormSchema.Feature f) {
        return f.lower() == f.upper() ? Integer.toString(f.lower()) : f.lower()+".."+(f.upper()<0?"*":f.upper());
    }
}
