package org.vnu.sme.goal.dsl.csl.view;

import java.util.LinkedHashMap;
import java.util.Map;

import org.tzi.use.api.UseApiException;
import org.tzi.use.api.UseModelApi;
import org.tzi.use.uml.mm.MAggregationKind;
import org.tzi.use.uml.mm.MAssociation;
import org.tzi.use.uml.mm.MClass;
import org.tzi.use.uml.mm.MModel;
import org.tzi.use.uml.mm.ModelFactory;
import org.vnu.sme.goal.dsl.csl.mm.*;

/**
 * Presentation adapter from CSL semantics to USE's UML metamodel.
 *
 * <p>This is deliberately the only layer that knows both metamodels. Views consume
 * real {@link MClass}/{@link MAssociation} objects and therefore reuse USE's class
 * and association components; parser and CSL semantic classes remain GUI-free.</p>
 */
final class CslUseViewModel {
    final MModel model;
    final Map<String, MClass> classes;
    final Map<String, MAssociation> associations;

    private CslUseViewModel(MModel model, Map<String, MClass> classes,
                            Map<String, MAssociation> associations) {
        this.model = model;
        this.classes = Map.copyOf(classes);
        this.associations = Map.copyOf(associations);
    }

    static CslUseViewModel build(CslModel csl) {
        try {
            MModel useModel = new ModelFactory().createModel("__csl_view__");
            UseModelApi api = new UseModelApi(useModel);
            Map<String, MClass> classes = new LinkedHashMap<>();
            Map<String, MAssociation> associations = new LinkedHashMap<>();

            for (CslEnum value : csl.enums()) api.createEnumeration(value.name(), value.literals());
            // Opaque CSL data types are first-class UML data types in the
            // presentation model. They must be registered before attributes
            // reference them; mapping them to String would change the model.
            for (CslNamedDataType value : csl.namedDataTypes()) {
                api.createDataType(value.sourceName(), false);
            }
            for (CslEntity value : csl.entities()) classes.put(value.name(), api.createClass(value.name(), false));
            for (CslRole value : csl.roles()) classes.put(value.name(), api.createClass(value.name(), false));
            for (CslGroup value : csl.groups()) classes.put(value.name(), api.createClass(value.name(), false));

            csl.entities().forEach(value -> addAttributes(api, value.name(), value.attributes()));
            csl.roles().forEach(value -> addAttributes(api, value.name(), value.attributes()));
            csl.groups().forEach(value -> addAttributes(api, value.name(), value.attributes()));
            for (CslGeneralization value : csl.generalizations()) {
                if (csl.findRole(value.specific()).isPresent()) continue;
                api.createGeneralization(value.specific(), value.general());
            }
            for (CslRelation value : csl.relations()) {
                int aggregation = switch (value.kind()) {
                    case AGGREGATION -> MAggregationKind.AGGREGATION;
                    case COMPOSITION -> MAggregationKind.COMPOSITION;
                    default -> MAggregationKind.NONE;
                };
                String sourceRole = value.source().roleName().orElse("source_" + value.name());
                String targetRole = value.target().roleName().orElse("target_" + value.name());
                MAssociation association = api.createAssociation(value.name(),
                        value.source().type(), sourceRole,
                        multiplicity(value.source().multiplicity()), aggregation,
                        value.target().type(), targetRole,
                        multiplicity(value.target().multiplicity()), MAggregationKind.NONE);
                associations.put(value.name(), association);
            }
            for (CslGroup context : csl.orgContexts()) {
                for (CslGroupMember member : context.members()) {
                    String assocName = CslContainment.relationName(context.name(), member.type());
                    if (!associations.containsKey(assocName)) {
                        MAssociation association = api.createAssociation(assocName,
                                context.name(), CslContainment.wholeRoleName(),
                                multiplicity(CslCardinality.bounded(1, 1)), MAggregationKind.COMPOSITION,
                                member.type(), CslContainment.partRoleName(member.type()),
                                multiplicity(member.multiplicity()), MAggregationKind.NONE);
                        associations.put(assocName, association);
                    }
                }
            }
            return new CslUseViewModel(useModel, classes, associations);
        } catch (UseApiException exception) {
            String detail = exception.getCause() != null ? exception.getCause().getMessage() : exception.getMessage();
            throw new IllegalArgumentException(
                    "Cannot adapt CSL model to USE diagram metamodel: " + detail, exception);
        }
    }

    private static void addAttributes(UseModelApi api, String owner, java.util.List<CslAttribute> attributes) {
        for (CslAttribute attribute : attributes) {
            try {
                api.createAttribute(owner, attribute.name(), attribute.type().sourceName());
            } catch (UseApiException exception) {
                throw new IllegalArgumentException("Invalid CSL attribute '" + owner + "." + attribute.name() + "'", exception);
            }
        }
    }

    private static String multiplicity(CslCardinality value) {
        if (value.max().isPresent() && value.min() == value.max().getAsInt()) return Integer.toString(value.min());
        return value.min() + ".." + (value.max().isPresent() ? value.max().getAsInt() : "*");
    }
}
