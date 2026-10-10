package org.vnu.sme.goal.dsl.csl.ocl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.vnu.sme.goal.dsl.csl.mm.CslAttribute;
import org.vnu.sme.goal.dsl.csl.mm.CslModel;
import org.vnu.sme.goal.dsl.csl.mm.CslOwner;
import org.vnu.sme.goal.dsl.csl.mm.CslRole;

/**
 * Rewrites CSL's transparent inherited Role-property syntax before USE compiles OCL.
 *
 * <p>{@code self.x} is left untouched when {@code x} is local. When {@code x} is declared by a
 * play-chain ancestor Role (see {@code Csl2UseTranslator}, {@code goal/docs/CSL_OCL_SEMANTICS.md}
 * §3.4-§3.7), the value is read by walking the lower-camel owner navigation
 * one hop per {@code extends} edge between the context Role and the declaring ancestor. Every
 * hop is single-valued in that direction (the parent side of a play-chain association is
 * always {@code [1]}), so this is always a plain navigation chain -- never a search over
 * candidates, unlike the pre-play-chain design.</p>
 */
public final class CslOclPropertyResolver {
    private static final Pattern SELF_PROPERTY = Pattern.compile("\\bself\\s*\\.\\s*([A-Za-z_][A-Za-z0-9_]*)");

    private CslOclPropertyResolver() {}

    public static String rewrite(CslModel csl, String contextRole, String source) {
        return rewrite(csl, contextRole, Map.of(), source);
    }

    /**
     * Rewrites transparent properties for every contextual role variable. A Role is an OCL
     * facade: local properties stay on the role occurrence, while properties declared by a
     * play-chain ancestor are projected through the chain to that ancestor's occurrence.
     */
    public static String rewrite(CslModel csl, String contextRole,
                                 Map<String, String> contextualVariables, String source) {
        if (csl == null || source == null || source.isBlank()) return source;
        // Older BPMN/iStar examples were written when every Role was linked
        // directly to Agent.  Role `extends` is now represented by a play
        // chain, so the direct owner of a child Role is its parent Role.  Do
        // this compatibility rewrite even when the OCL context is a Group
        // (the common BPMN case), where the role-specific rewriting below is
        // intentionally not applicable.
        String rewritten = rewriteLegacyGeneratedNavigation(csl, source);
        CslRole context = csl.findRole(contextRole).orElse(null);
        if (context == null) return rewritten;

        rewritten = rewriteCslNavigationAliases(csl, context, rewritten);
        Map<String, String> variables = new LinkedHashMap<>(contextualVariables);
        variables.put("self", contextRole);
        rewritten = rewriteContextualRoleProperties(csl, variables, rewritten);
        Matcher matcher = SELF_PROPERTY.matcher(rewritten);
        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            String property = matcher.group(1);
            Declaration declaration = declaration(csl, context, property);
            if (declaration == null || declaration.role().name().equals(context.name())) continue;
            String replacement = chainAccess(csl, "self", context, declaration.role().name(), property);
            if (replacement != null) matcher.appendReplacement(result, Matcher.quoteReplacement(replacement));
        }
        matcher.appendTail(result);
        return result.toString();
    }

    /** Normalizes the verbose association-end names emitted by older CSL translators. */
    private static String rewriteLegacyGeneratedNavigation(CslModel csl, String source) {
        String result = source;
        for (CslRole role : csl.roles()) {
            Optional<String> parent = role.parentRoles().stream().findFirst();
            String owner = parent.orElse("Agent");
            String ownerNavigation = parent.map(CslOclPropertyResolver::lowerFirst).orElse("agent");
            result = replaceWord(result, "source_Agent_plays_" + id(role.name()), ownerNavigation);
            result = replaceWord(result, "source_CSLAgent_plays_" + id(role.name()), ownerNavigation);
            result = replaceWord(result, "source_" + id(owner) + "_plays_" + id(role.name()), ownerNavigation);
            result = replaceWord(result, "target_Agent_plays_" + id(role.name()), playRole(role.name()));
            result = replaceWord(result, "target_CSLAgent_plays_" + id(role.name()), playRole(role.name()));
            result = replaceWord(result, "target_" + id(owner) + "_plays_" + id(role.name()),
                    playRole(role.name()));
        }
        for (CslOwner owner : csl.owners()) {
            if (csl.findRole(owner.target()).isPresent()) {
                String association = id(owner.target()) + "_in_" + id(owner.sourceGroup());
                result = replaceWord(result, "source_" + association, lowerFirst(owner.sourceGroup()));
                result = replaceWord(result, "target_" + association, lowerFirst(owner.target()));
            } else {
                String association = "Owner_" + id(owner.sourceGroup()) + "_" + id(owner.target());
                result = replaceWord(result, "source_" + association, lowerFirst(owner.sourceGroup()));
                result = replaceWord(result, "target_" + association, lowerFirst(owner.target()));
            }
        }
        return result;
    }

    private static String replaceWord(String source, String oldName, String newName) {
        return source.replaceAll("\\b" + Pattern.quote(oldName) + "\\b", Matcher.quoteReplacement(newName));
    }

    private static String rewriteContextualRoleProperties(
            CslModel csl, Map<String, String> variables, String source) {
        String result = source;

        // Association endpoint role names declared on a Role type: navigating through them (or
        // passing a variable to their ->includes(...)) from a variable typed at a DESCENDANT of
        // that Role must first walk the play chain up to the occurrence that actually
        // participates in the association -- a descendant is a separate occurrence, not the
        // same object (R6), so it cannot stand in directly.
        Map<String, String> navigationDeclaredOn = new LinkedHashMap<>();
        for (var relation : csl.relations()) {
            if (csl.findRole(relation.source().type()).isPresent()) {
                relation.source().roleName().ifPresent(nm -> navigationDeclaredOn.putIfAbsent(nm, relation.source().type()));
            }
            if (csl.findRole(relation.target().type()).isPresent()) {
                relation.target().roleName().ifPresent(nm -> navigationDeclaredOn.putIfAbsent(nm, relation.target().type()));
            }
        }

        for (var variable : variables.entrySet()) {
            String name = variable.getKey();
            CslRole role = csl.findRole(variable.getValue()).orElse(null);
            if (role == null) continue;

            // Attributes declared by a play-chain ancestor.
            Set<String> ancestorAttrNames = new LinkedHashSet<>();
            CslRole walker = role;
            while (walker.parentRoles().stream().findFirst().isPresent()) {
                CslRole parent = csl.findRole(walker.parentRoles().get(0)).orElse(null);
                if (parent == null) break;
                parent.attributes().forEach(a -> ancestorAttrNames.add(a.name()));
                walker = parent;
            }
            for (String attrName : ancestorAttrNames) {
                Declaration declaration = declaration(csl, role, attrName);
                if (declaration == null || declaration.role().name().equals(role.name())) continue;
                String replacement = chainAccess(csl, name, role, declaration.role().name(), attrName);
                if (replacement == null) continue;
                result = result.replaceAll(
                        "\\b" + Pattern.quote(name) + "\\s*\\.\\s*" + Pattern.quote(attrName) + "\\b",
                        Matcher.quoteReplacement(replacement));
            }

            // Association navigation declared on a play-chain ancestor.
            for (var nav : navigationDeclaredOn.entrySet()) {
                String navRoleName = nav.getKey();
                String declaringType = nav.getValue();
                if (declaringType.equals(role.name()) || !isProperAncestor(csl, role, declaringType)) continue;
                String toAncestor = chainAccess(csl, name, role, declaringType, null);
                if (toAncestor == null) continue;
                result = result.replaceAll(
                        "\\b" + Pattern.quote(name) + "\\s*\\.\\s*" + Pattern.quote(navRoleName) + "\\b",
                        Matcher.quoteReplacement(toAncestor + "." + id(navRoleName)));
                result = result.replaceAll(
                        "(\\." + Pattern.quote(id(navRoleName)) + "\\s*->\\s*includes\\(\\s*)"
                                + Pattern.quote(name) + "(\\s*\\))",
                        "$1" + Matcher.quoteReplacement(toAncestor) + "$2");
            }
        }
        return result;
    }

    /**
     * Keeps generated USE association-end names out of user OCL.
     *
     * <ul>
     *   <li>{@code self.group} is the nearest CSL Group occurrence owning {@code self};</li>
     *   <li>{@code self.group.RoleName} is that Group's occurrence(s) of {@code RoleName};</li>
     *   <li>{@code self.agent} walks the whole play chain up to the Agent playing {@code self};</li>
     *   <li>{@code participant.agent} uses the Role name of a conventional lower-camel
     *       iterator variable to reach the corresponding Agent the same way.</li>
     * </ul>
     */
    private static String rewriteCslNavigationAliases(CslModel csl, CslRole context, String source) {
        String group = ownerGroup(csl, context.name());
        String result = source;
        if (group != null) {
            String groupAccess = "self." + lowerFirst(group);
            for (CslOwner owner : csl.owners()) {
                if (!owner.sourceGroup().equals(group) || csl.findRole(owner.target()).isEmpty()) continue;
                String member = owner.target();
                result = result.replaceAll(
                        "\\bself\\s*\\.\\s*group\\s*\\.\\s*" + Pattern.quote(member) + "\\b",
                        Matcher.quoteReplacement(groupAccess + "." + lowerFirst(member)));
            }
            result = result.replaceAll("\\bself\\s*\\.\\s*group\\b", Matcher.quoteReplacement(groupAccess));
        }

        result = result.replaceAll("\\bself\\s*\\.\\s*agent\\b",
                Matcher.quoteReplacement(chainAccess(csl, "self", context, null, null)));
        for (CslRole role : csl.roles()) {
            String variable = lowerFirst(role.name());
            String toAgent = chainAccess(csl, variable, role, null, null);
            result = result.replaceAll(
                    "\\b" + Pattern.quote(variable) + "\\s*\\.\\s*agent\\b",
                    Matcher.quoteReplacement(toAgent));
        }
        return result;
    }

    private static Declaration declaration(CslModel csl, CslRole context, String property) {
        String current = context.name();
        Set<String> seen = new LinkedHashSet<>();
        while (seen.add(current)) {
            CslRole role = csl.findRole(current).orElse(null);
            if (role == null) return null;
            for (CslAttribute attribute : role.attributes()) {
                if (attribute.name().equals(property)) return new Declaration(role, attribute);
            }
            if (role.parentRoles().isEmpty()) return null;
            current = role.parentRoles().get(0);
        }
        return null;
    }

    /**
     * Builds the play-chain navigation from {@code selfExpr} (typed {@code context}) up to the
     * occurrence of {@code stopAtRoleName} (or, if {@code null}, all the way to the Agent
     * playing {@code context}), optionally appending {@code .property}. Every hop is
     * lower-camel owner role ({@code agent} or the parent Role name) -- always
     * single-valued in this direction, since the
     * owner side of a play-chain association is always {@code [1]} -- so this never needs a
     * search or an {@code ->any(...)}.
     */
    private static String chainAccess(CslModel csl, String selfExpr, CslRole context,
                                      String stopAtRoleName, String property) {
        StringBuilder nav = new StringBuilder(selfExpr);
        CslRole current = context;
        while (stopAtRoleName == null || !current.name().equals(stopAtRoleName)) {
            Optional<String> parent = current.parentRoles().stream().findFirst();
            nav.append('.').append(parent.map(CslOclPropertyResolver::lowerFirst).orElse("agent"));
            if (parent.isEmpty()) break;
            CslRole next = csl.findRole(parent.get()).orElse(null);
            if (next == null) return null;
            current = next;
        }
        if (property != null) nav.append('.').append(id(property));
        return nav.toString();
    }

    private static boolean isProperAncestor(CslModel csl, CslRole role, String ancestorTypeName) {
        CslRole current = role;
        while (true) {
            Optional<String> parent = current.parentRoles().stream().findFirst();
            if (parent.isEmpty()) return false;
            if (parent.get().equals(ancestorTypeName)) return true;
            current = csl.findRole(parent.get()).orElse(null);
            if (current == null) return false;
        }
    }

    private static String ownerGroup(CslModel csl, String role) {
        return csl.owners().stream()
                .filter(owner -> owner.target().equals(role))
                .map(CslOwner::sourceGroup)
                .findFirst().orElse(null);
    }

    private static String id(String value) {
        String clean = value.replaceAll("[^A-Za-z0-9_]", "_");
        return Character.isDigit(clean.charAt(0)) ? "_" + clean : clean;
    }

    private static String lowerFirst(String value) {
        String clean = id(value);
        return Character.toLowerCase(clean.charAt(0)) + clean.substring(1);
    }

    private static String playRole(String value) {
        return "play_" + lowerFirst(value);
    }

    private record Declaration(CslRole role, CslAttribute attribute) {}
}
