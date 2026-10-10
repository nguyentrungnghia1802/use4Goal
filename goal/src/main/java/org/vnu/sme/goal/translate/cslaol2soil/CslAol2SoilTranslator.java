package org.vnu.sme.goal.translate.cslaol2soil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.vnu.sme.goal.dsl.csl.mm.CslAttribute;
import org.vnu.sme.goal.dsl.csl.mm.CslDataType;
import org.vnu.sme.goal.dsl.csl.mm.CslEntity;
import org.vnu.sme.goal.dsl.csl.mm.CslEnum;
import org.vnu.sme.goal.dsl.csl.mm.CslGroup;
import org.vnu.sme.goal.dsl.csl.mm.CslModel;
import org.vnu.sme.goal.dsl.csl.mm.CslOwner;
import org.vnu.sme.goal.dsl.csl.mm.CslPrimitiveType;
import org.vnu.sme.goal.dsl.csl.mm.CslRelation;
import org.vnu.sme.goal.dsl.csl.mm.CslRole;
import org.vnu.sme.goal.dsl.aol.mm.AolEntityInstance;
import org.vnu.sme.goal.dsl.aol.mm.AolGroupInstance;
import org.vnu.sme.goal.dsl.aol.mm.AolLink;
import org.vnu.sme.goal.dsl.aol.mm.AolModel;
import org.vnu.sme.goal.dsl.aol.mm.AolPlay;

/**
 * Transforms a validated AOL snapshot into the line-oriented shell/SOIL input
 * consumed by {@code IStarUseTraceCompiler}.
 *
 * <p>The generated classifier and association identifiers deliberately follow
 * {@code Csl2UseTranslator}: explicit CSL relations reserve names first, then
 * each owner reserves its generated associations in declaration order.</p>
 */
public final class CslAol2SoilTranslator {
    private CslAol2SoilTranslator() {
    }

    public static String transform(CslModel csl, AolModel aol) {
        Objects.requireNonNull(csl, "csl");
        Objects.requireNonNull(aol, "aol");

        AssociationCatalog associations = associationCatalog(csl);
        StringBuilder soil = new StringBuilder()
                .append("-- Generated from AOL. Regenerate instead of editing this file.\n")
                .append("-- Class and association identifiers mirror Csl2UseTranslator.\n\n");

        Set<String> emittedObjectNames = new LinkedHashSet<>();
        Map<String, InstanceRef> instances = new LinkedHashMap<>();
        List<GroupOccurrence> groups = new ArrayList<>();

        String agentClass = generatedAgentName(csl);
        for (String agentId : aol.agents()) {
            String objectName = emitObject(soil, emittedObjectNames, agentId, agentClass,
                    agentProfileAttributes(csl, aol.agentProfileRoles().get(agentId)),
                    aol.agentAttributeValues().getOrDefault(agentId, Map.of()));
            String profile = aol.agentProfileRoles().get(agentId);
            registerInstance(instances,
                    new InstanceRef(InstanceKind.AGENT, profile != null ? profile : agentClass, agentId, objectName));
        }

        for (AolGroupInstance group : aol.groupInstances()) {
            emitGroupObjects(soil, csl, group, groups, instances, emittedObjectNames);
        }
        for (AolEntityInstance entity : aol.topLevelEntities()) {
            emitEntityObject(soil, csl, entity, instances, emittedObjectNames);
        }

        soil.append('\n');
        for (GroupOccurrence occurrence : groups) {
            emitGroupLinks(soil, csl, associations, occurrence, instances);
        }
        for (AolLink link : aol.links()) {
            emitExplicitLink(soil, csl, associations, link, instances);
        }
        return soil.toString();
    }

    private static void emitGroupObjects(StringBuilder soil, CslModel csl, AolGroupInstance group,
                                         List<GroupOccurrence> groups,
                                         Map<String, InstanceRef> instances,
                                         Set<String> emittedObjectNames) {
        CslGroup groupType = findGroup(csl, group.typeName());
        String groupObject = emitObject(soil, emittedObjectNames, group.instanceId(), group.typeName(),
                groupAttributes(csl, group.typeName()), group.attributeValues());
        registerInstance(instances,
                new InstanceRef(InstanceKind.GROUP, group.typeName(), group.instanceId(), groupObject));
        groups.add(new GroupOccurrence(group, groupObject));

        for (AolPlay play : group.plays()) {
            CslRole role = csl.findRole(play.roleType())
                    .orElseThrow(() -> new IllegalArgumentException("Unknown CSL role '" + play.roleType() + "'"));
            String objectName = emitObject(soil, emittedObjectNames, play.instanceId(), role.name(),
                    roleAttributes(csl, role.name()), play.attributeValues());
            registerInstance(instances,
                    new InstanceRef(InstanceKind.PLAY, role.name(), play.instanceId(), objectName));
        }
        for (AolEntityInstance entity : group.entities()) {
            emitEntityObject(soil, csl, entity, instances, emittedObjectNames);
        }
        for (AolGroupInstance subgroup : group.subgroups()) {
            emitGroupObjects(soil, csl, subgroup, groups, instances, emittedObjectNames);
        }
    }

    private static void emitEntityObject(StringBuilder soil, CslModel csl, AolEntityInstance entity,
                                         Map<String, InstanceRef> instances,
                                         Set<String> emittedObjectNames) {
        CslEntity entityType = csl.findEntity(entity.entityType())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Unknown CSL entity '" + entity.entityType() + "'"));
        String objectName = emitObject(soil, emittedObjectNames, entity.instanceId(), entityType.name(),
                entityAttributes(csl, entityType.name()), entity.attributeValues());
        registerInstance(instances,
                new InstanceRef(InstanceKind.ENTITY, entityType.name(), entity.instanceId(), objectName));
    }

    private static String emitObject(StringBuilder soil, Set<String> emittedObjectNames,
                                     String instanceId, String typeName,
                                     List<CslAttribute> attributes,
                                     Map<String, String> explicitValues) {
        String objectName = id(instanceId);
        if (!emittedObjectNames.add(objectName)) {
            throw new IllegalArgumentException("Duplicate USE object identifier '" + objectName + "'");
        }
        soil.append("!create ").append(objectName).append(" : ").append(id(typeName)).append('\n');
        emitAttributes(soil, objectName, attributes, explicitValues);
        return objectName;
    }

    private static void emitAttributes(StringBuilder soil, String objectName,
                                       List<CslAttribute> attributes,
                                       Map<String, String> explicitValues) {
        for (CslAttribute attribute : attributes) {
            String rawValue = explicitValues.get(attribute.name());
            if (rawValue == null) {
                rawValue = attribute.defaultValue().orElse(null);
            }
            if (rawValue == null) {
                continue;
            }
            soil.append("!set ").append(objectName).append('.').append(id(attribute.name()))
                    .append(" := ").append(soilLiteral(attribute.type(), rawValue)).append('\n');
        }
    }

    private static void emitGroupLinks(StringBuilder soil, CslModel csl,
                                       AssociationCatalog associations,
                                       GroupOccurrence occurrence,
                                       Map<String, InstanceRef> instances) {
        AolGroupInstance group = occurrence.group();

        for (AolPlay play : group.plays()) {
            RoleOwnerAssociation owner = findRoleOwner(csl, associations, group.typeName(), play.roleType());
            InstanceRef playRef = requireInstance(instances, play.instanceId());
            emitInsert(soil, id(play.agentId()), playRef.objectName(), owner.playsAssociation());
            emitInsert(soil, occurrence.objectName(), playRef.objectName(), owner.membershipAssociation());
        }

        for (AolEntityInstance entity : group.entities()) {
            RelationBinding membership = findGroupEntityRelation(
                    csl, associations, group.typeName(), entity.entityType());
            InstanceRef entityRef = requireInstance(instances, entity.instanceId());
            if (membership.groupIsSource()) {
                emitInsert(soil, occurrence.objectName(), entityRef.objectName(),
                        membership.relation().associationName());
            } else {
                emitInsert(soil, entityRef.objectName(), occurrence.objectName(),
                        membership.relation().associationName());
            }
        }

        for (AolGroupInstance subgroup : group.subgroups()) {
            GroupOwnerAssociation owner = findGroupOwner(
                    csl, associations, group.typeName(), subgroup.typeName());
            InstanceRef subgroupRef = requireInstance(instances, subgroup.instanceId());
            emitInsert(soil, occurrence.objectName(), subgroupRef.objectName(), owner.associationName());
        }
    }

    private static void emitExplicitLink(StringBuilder soil, CslModel csl,
                                         AssociationCatalog associations, AolLink link,
                                         Map<String, InstanceRef> instances) {
        TranslatedRelation translated = associations.relations().stream()
                .filter(value -> value.relation().name().equals(link.relationName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "Unknown CSL relation '" + link.relationName() + "'"));

        InstanceRef source = requireInstance(instances, link.sourceInstanceId());
        CslRelation relation = translated.relation();
        boolean sourceAtCslSource;
        String expectedTargetType;
        if (matchesEndpointType(csl, source, relation.source().type())) {
            sourceAtCslSource = true;
            expectedTargetType = relation.target().type();
        } else if (matchesEndpointType(csl, source, relation.target().type())) {
            sourceAtCslSource = false;
            expectedTargetType = relation.source().type();
        } else {
            throw new IllegalArgumentException("Instance '" + link.sourceInstanceId()
                    + "' does not match relation '" + link.relationName() + "'");
        }

        for (String targetId : link.targetInstanceIds()) {
            InstanceRef target = requireInstance(instances, targetId);
            if (!matchesEndpointType(csl, target, expectedTargetType)) {
                throw new IllegalArgumentException("Instance '" + targetId
                        + "' does not match relation '" + link.relationName()
                        + "' endpoint '" + expectedTargetType + "'");
            }
            if (sourceAtCslSource) {
                emitInsert(soil, source.objectName(), target.objectName(), translated.associationName());
            } else {
                emitInsert(soil, target.objectName(), source.objectName(), translated.associationName());
            }
        }
    }

    private static void emitInsert(StringBuilder soil, String sourceObject,
                                   String targetObject, String associationName) {
        soil.append("!insert (").append(sourceObject).append(", ").append(targetObject)
                .append(") into ").append(associationName).append('\n');
    }

    private static AssociationCatalog associationCatalog(CslModel csl) {
        Set<String> usedNames = new HashSet<>();
        List<TranslatedRelation> relations = new ArrayList<>();
        for (CslRelation relation : csl.relations()) {
            relations.add(new TranslatedRelation(relation, unique(usedNames, relation.name())));
        }

        List<RoleOwnerAssociation> roleOwners = new ArrayList<>();
        List<GroupOwnerAssociation> groupOwners = new ArrayList<>();
        for (CslOwner owner : csl.owners()) {
            if (csl.findRole(owner.target()).isPresent()) {
                String plays = unique(usedNames, "Agent_plays_" + owner.target());
                String membership = unique(usedNames, owner.target() + "_in_" + owner.sourceGroup());
                roleOwners.add(new RoleOwnerAssociation(owner, plays, membership));
            } else {
                String name = unique(usedNames, "Owner_" + owner.sourceGroup() + "_" + owner.target());
                groupOwners.add(new GroupOwnerAssociation(owner, name));
            }
        }
        return new AssociationCatalog(
                List.copyOf(relations), List.copyOf(roleOwners), List.copyOf(groupOwners));
    }

    private static RoleOwnerAssociation findRoleOwner(CslModel csl, AssociationCatalog associations,
                                                      String groupType, String roleType) {
        for (RoleOwnerAssociation value : associations.roleOwners()) {
            if (value.owner().sourceGroup().equals(groupType)
                    && value.owner().target().equals(roleType)) {
                return value;
            }
        }
        return associations.roleOwners().stream()
                .filter(value -> isGroupOrSubtype(csl, groupType, value.owner().sourceGroup())
                        && isRoleOrSubtype(csl, roleType, value.owner().target()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "No CSL owner maps role '" + roleType + "' into group '" + groupType + "'"));
    }

    private static GroupOwnerAssociation findGroupOwner(CslModel csl, AssociationCatalog associations,
                                                        String parentType, String childType) {
        for (GroupOwnerAssociation value : associations.groupOwners()) {
            if (value.owner().sourceGroup().equals(parentType)
                    && value.owner().target().equals(childType)) {
                return value;
            }
        }
        return associations.groupOwners().stream()
                .filter(value -> isGroupOrSubtype(csl, parentType, value.owner().sourceGroup())
                        && isGroupOrSubtype(csl, childType, value.owner().target()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "No CSL owner maps subgroup '" + childType + "' into group '" + parentType + "'"));
    }

    private static RelationBinding findGroupEntityRelation(CslModel csl,
                                                           AssociationCatalog associations,
                                                           String groupType, String entityType) {
        RelationBinding exact = null;
        for (TranslatedRelation translated : associations.relations()) {
            CslRelation relation = translated.relation();
            if (relation.source().type().equals(groupType)
                    && relation.target().type().equals(entityType)) {
                exact = new RelationBinding(translated, true);
            } else if (relation.target().type().equals(groupType)
                    && relation.source().type().equals(entityType)) {
                exact = new RelationBinding(translated, false);
            }
        }
        if (exact != null) {
            return exact;
        }

        RelationBinding inherited = null;
        for (TranslatedRelation translated : associations.relations()) {
            CslRelation relation = translated.relation();
            if (isGroupOrSubtype(csl, groupType, relation.source().type())
                    && isEntityOrSubtype(csl, entityType, relation.target().type())) {
                inherited = new RelationBinding(translated, true);
            } else if (isGroupOrSubtype(csl, groupType, relation.target().type())
                    && isEntityOrSubtype(csl, entityType, relation.source().type())) {
                inherited = new RelationBinding(translated, false);
            }
        }
        if (inherited == null) {
            throw new IllegalArgumentException("No CSL relation maps entity '" + entityType
                    + "' into group '" + groupType + "'");
        }
        return inherited;
    }

    private static boolean matchesEndpointType(CslModel csl, InstanceRef instance, String declaredType) {
        return switch (instance.kind()) {
            case AGENT -> csl.findRole(declaredType).filter(CslRole::isAbstract).isPresent()
                    && isRoleOrSubtype(csl, instance.typeName(), declaredType);
            case PLAY -> isRoleOrSubtype(csl, instance.typeName(), declaredType);
            case ENTITY -> isEntityOrSubtype(csl, instance.typeName(), declaredType);
            case GROUP -> isGroupOrSubtype(csl, instance.typeName(), declaredType);
        };
    }

    private static boolean isRoleOrSubtype(CslModel csl, String actual, String declared) {
        String current = actual;
        Set<String> seen = new LinkedHashSet<>();
        while (seen.add(current)) {
            if (current.equals(declared)) {
                return true;
            }
            CslRole role = csl.findRole(current).orElse(null);
            if (role == null || role.parentRoles().isEmpty()) {
                return false;
            }
            current = role.parentRoles().get(0);
        }
        return false;
    }

    private static boolean isEntityOrSubtype(CslModel csl, String actual, String declared) {
        String current = actual;
        Set<String> seen = new LinkedHashSet<>();
        while (seen.add(current)) {
            if (current.equals(declared)) {
                return true;
            }
            CslEntity entity = csl.findEntity(current).orElse(null);
            if (entity == null || entity.specializes().isEmpty()) {
                return false;
            }
            current = entity.specializes().get();
        }
        return false;
    }

    private static boolean isGroupOrSubtype(CslModel csl, String actual, String declared) {
        String current = actual;
        Set<String> seen = new LinkedHashSet<>();
        while (seen.add(current)) {
            if (current.equals(declared)) {
                return true;
            }
            CslGroup group = findGroupOrNull(csl, current);
            if (group == null || group.specializes().isEmpty()) {
                return false;
            }
            current = group.specializes().get();
        }
        return false;
    }

    private static List<CslAttribute> roleAttributes(CslModel csl, String roleName) {
        CslRole role = csl.findRole(roleName)
                .orElseThrow(() -> new IllegalArgumentException("Unknown CSL role '" + roleName + "'"));
        // Concrete ancestor state is stored on its own AOL occurrence and reached through
        // CslOclPropertyResolver. Never copy inherited defaults into the child occurrence.
        return role.attributes();
    }

    private static List<CslAttribute> entityAttributes(CslModel csl, String entityName) {
        List<CslEntity> hierarchy = new ArrayList<>();
        Set<String> seen = new LinkedHashSet<>();
        String current = entityName;
        while (seen.add(current)) {
            CslEntity entity = csl.findEntity(current).orElse(null);
            if (entity == null) {
                break;
            }
            hierarchy.add(entity);
            if (entity.specializes().isEmpty()) {
                break;
            }
            current = entity.specializes().get();
        }
        Collections.reverse(hierarchy);
        LinkedHashMap<String, CslAttribute> result = new LinkedHashMap<>();
        hierarchy.forEach(entity -> entity.attributes().forEach(attribute -> result.put(attribute.name(), attribute)));
        return List.copyOf(result.values());
    }

    private static List<CslAttribute> groupAttributes(CslModel csl, String groupName) {
        List<CslGroup> hierarchy = new ArrayList<>();
        Set<String> seen = new LinkedHashSet<>();
        String current = groupName;
        while (seen.add(current)) {
            CslGroup group = findGroupOrNull(csl, current);
            if (group == null) {
                break;
            }
            hierarchy.add(group);
            if (group.specializes().isEmpty()) {
                break;
            }
            current = group.specializes().get();
        }
        Collections.reverse(hierarchy);
        LinkedHashMap<String, CslAttribute> result = new LinkedHashMap<>();
        hierarchy.forEach(group -> group.attributes().forEach(attribute -> result.put(attribute.name(), attribute)));
        return List.copyOf(result.values());
    }

    private static String soilLiteral(CslDataType type, String rawValue) {
        if (type == CslPrimitiveType.STRING) {
            return "'" + escapeUseString(decodeString(rawValue)) + "'";
        }
        if (type instanceof CslEnum) {
            String literal = rawValue.strip();
            if (literal.startsWith("#")) {
                literal = literal.substring(1);
            }
            return "#" + id(literal);
        }
        return rawValue.strip();
    }

    private static String decodeString(String rawValue) {
        String value = rawValue;
        if (value.length() >= 2) {
            char first = value.charAt(0);
            char last = value.charAt(value.length() - 1);
            if ((first == '"' && last == '"') || (first == '\'' && last == '\'')) {
                value = value.substring(1, value.length() - 1);
            }
        }

        StringBuilder decoded = new StringBuilder(value.length());
        for (int i = 0; i < value.length(); i++) {
            char current = value.charAt(i);
            if (current != '\\' || i + 1 >= value.length()) {
                decoded.append(current);
                continue;
            }
            char escaped = value.charAt(++i);
            switch (escaped) {
                case 'n' -> decoded.append('\n');
                case 'r' -> decoded.append('\r');
                case 't' -> decoded.append('\t');
                case 'b' -> decoded.append('\b');
                case 'f' -> decoded.append('\f');
                case '\\' -> decoded.append('\\');
                case '\'' -> decoded.append('\'');
                case '"' -> decoded.append('"');
                default -> decoded.append(escaped);
            }
        }
        return decoded.toString();
    }

    private static String escapeUseString(String value) {
        StringBuilder escaped = new StringBuilder(value.length());
        for (int i = 0; i < value.length(); i++) {
            char current = value.charAt(i);
            switch (current) {
                case '\n' -> escaped.append("\\n");
                case '\r' -> escaped.append("\\r");
                case '\t' -> escaped.append("\\t");
                case '\b' -> escaped.append("\\b");
                case '\f' -> escaped.append("\\f");
                case '\\' -> escaped.append("\\\\");
                case '\'' -> escaped.append("\\'");
                case '"' -> escaped.append("\\\"");
                default -> escaped.append(current);
            }
        }
        return escaped.toString();
    }

    private static void registerInstance(Map<String, InstanceRef> instances, InstanceRef instance) {
        if (instances.putIfAbsent(instance.instanceId(), instance) != null) {
            throw new IllegalArgumentException(
                    "Duplicate AOL instance identifier '" + instance.instanceId() + "'");
        }
    }

    private static InstanceRef requireInstance(Map<String, InstanceRef> instances, String instanceId) {
        InstanceRef value = instances.get(instanceId);
        if (value == null) {
            throw new IllegalArgumentException("Unknown AOL instance '" + instanceId + "'");
        }
        return value;
    }

    private static CslGroup findGroup(CslModel csl, String groupName) {
        CslGroup value = findGroupOrNull(csl, groupName);
        if (value == null) {
            throw new IllegalArgumentException("Unknown CSL group '" + groupName + "'");
        }
        return value;
    }

    private static CslGroup findGroupOrNull(CslModel csl, String groupName) {
        return csl.groups().stream()
                .filter(group -> group.name().equals(groupName))
                .findFirst()
                .orElse(null);
    }

    private static String generatedAgentName(CslModel model) {
        boolean occupied = model.entities().stream().anyMatch(value -> value.name().equals("Agent"))
                || model.roles().stream().anyMatch(value -> value.name().equals("Agent"))
                || model.groups().stream().anyMatch(value -> value.name().equals("Agent"));
        return occupied ? "CSLAgent" : "Agent";
    }

    /** Attributes available to an Agent are those of its abstract profile and its
     * abstract ancestors. Concrete-role state remains on the corresponding play object. */
    private static List<CslAttribute> agentProfileAttributes(CslModel csl, String profileRole) {
        if (profileRole == null) return List.of(); // legacy `agent a, b;` declaration
        Map<String, CslAttribute> attributes = new LinkedHashMap<>();
        String current = profileRole;
        Set<String> seen = new LinkedHashSet<>();
        while (current != null && seen.add(current)) {
            String roleName = current;
            CslRole role = csl.findRole(roleName)
                    .orElseThrow(() -> new IllegalArgumentException("Unknown Agent profile '" + roleName + "'"));
            if (!role.isAbstract()) {
                throw new IllegalArgumentException("Agent profile '" + profileRole + "' must be abstract");
            }
            role.attributes().forEach(attribute -> attributes.putIfAbsent(attribute.name(), attribute));
            current = role.parentRoles().isEmpty() ? null : role.parentRoles().get(0);
        }
        return List.copyOf(attributes.values());
    }

    private static String unique(Set<String> used, String proposed) {
        String base = id(proposed);
        String value = base;
        for (int suffix = 2; !used.add(value); suffix++) {
            value = base + "_" + suffix;
        }
        return value;
    }

    private static String id(String value) {
        if (value == null || value.isBlank()) {
            return "unnamed";
        }
        String clean = value.replaceAll("[^A-Za-z0-9_]", "_");
        return Character.isDigit(clean.charAt(0)) ? "_" + clean : clean;
    }

    private enum InstanceKind {
        AGENT,
        PLAY,
        ENTITY,
        GROUP
    }

    private record InstanceRef(InstanceKind kind, String typeName,
                               String instanceId, String objectName) {
    }

    private record GroupOccurrence(AolGroupInstance group, String objectName) {
    }

    private record TranslatedRelation(CslRelation relation, String associationName) {
    }

    private record RoleOwnerAssociation(CslOwner owner, String playsAssociation,
                                        String membershipAssociation) {
    }

    private record GroupOwnerAssociation(CslOwner owner, String associationName) {
    }

    private record AssociationCatalog(List<TranslatedRelation> relations,
                                      List<RoleOwnerAssociation> roleOwners,
                                      List<GroupOwnerAssociation> groupOwners) {
    }

    private record RelationBinding(TranslatedRelation relation, boolean groupIsSource) {
    }
}
