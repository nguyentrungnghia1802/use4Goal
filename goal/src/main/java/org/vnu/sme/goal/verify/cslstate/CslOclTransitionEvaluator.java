package org.vnu.sme.goal.verify.cslstate;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.vnu.sme.goal.dsl.aol.state.CslSystemState;
import org.vnu.sme.goal.dsl.bpmn.mm.ActivityConstraint;
import org.vnu.sme.goal.trace.cslTrace.nativecsl.NativeOclEvaluator;

/** Evaluates BPMN OCL contracts directly over one or two native CSL states. */
final class CslOclTransitionEvaluator {
    private static final Pattern AT_PRE_PATH = Pattern.compile(
            "\\b(self(?:\\.[A-Za-z_][A-Za-z0-9_]*)+)@pre\\b");

    private CslOclTransitionEvaluator() {}

    static boolean preconditionsHold(List<ActivityConstraint> constraints,
                                     CslSystemState state, String selfId) {
        for (ActivityConstraint condition : constraints) {
            if (!evaluateSingle(condition.oclBody(), state, selfId)) return false;
        }
        return true;
    }

    static boolean postconditionsHold(List<ActivityConstraint> constraints,
                                      CslSystemState before, CslSystemState after,
                                      String selfId) {
        for (ActivityConstraint condition : constraints) {
            String expression = substituteAtPre(condition.oclBody(), before, selfId);
            if (!evaluateSingle(expression, after, selfId)) return false;
        }
        return true;
    }

    static boolean expressionHolds(String expression, CslSystemState state, String selfId) {
        return expression == null || expression.isBlank() || evaluateSingle(expression, state, selfId);
    }

    static boolean postExpressionHolds(String expression, CslSystemState before,
                                       CslSystemState after, String selfId) {
        return expression == null || expression.isBlank()
                || evaluateSingle(substituteAtPre(expression, before, selfId), after, selfId);
    }

    private static boolean evaluateSingle(String expression, CslSystemState state, String selfId) {
        List<Object> context = new ArrayList<>(1);
        if (selfId != null) {
            CslSystemState.ObjectValue self = state.object(selfId);
            if (self == null) return false;
            context.add(self);
        }
        return NativeOclEvaluator.evaluate(expression, state, context);
    }

    private static String substituteAtPre(String expression, CslSystemState before, String selfId) {
        if (expression == null || expression.isBlank() || !expression.contains("@pre")) return expression;
        Matcher matcher = AT_PRE_PATH.matcher(expression);
        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            Object value = resolveBeforePath(matcher.group(1), before, selfId);
            matcher.appendReplacement(result, Matcher.quoteReplacement(toOclLiteral(value)));
        }
        matcher.appendTail(result);
        if (result.indexOf("@pre") >= 0) {
            throw new IllegalArgumentException("unsupported @pre expression; expected self.<property-path>@pre");
        }
        return result.toString();
    }

    private static Object resolveBeforePath(String path, CslSystemState before, String selfId) {
        if (selfId == null) throw new IllegalArgumentException("@pre requires a bound process self object");
        Object value = before.object(selfId);
        if (value == null) throw new IllegalArgumentException("missing pre-state self object " + selfId);
        String[] parts = path.split("\\.");
        for (int i = 1; i < parts.length; i++) value = before.property(value, parts[i]);
        return value;
    }

    private static String toOclLiteral(Object value) {
        if (value instanceof Boolean || value instanceof Number) return String.valueOf(value);
        if (value instanceof Enum<?> enumeration) return "#" + enumeration.name();
        if (value instanceof String text) {
            if (text.matches("[A-Za-z_][A-Za-z0-9_]*")) return "#" + text;
            if (text.indexOf('\'') < 0) return "'" + text + "'";
        }
        throw new IllegalArgumentException("unsupported scalar @pre value: " + value);
    }
}
