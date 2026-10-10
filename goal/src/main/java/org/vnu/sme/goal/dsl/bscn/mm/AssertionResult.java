package org.vnu.sme.goal.dsl.bscn.mm;

/** Result of evaluating a lightweight scenario assertion. */
public record AssertionResult(String expression, boolean holds, String detail) {}
