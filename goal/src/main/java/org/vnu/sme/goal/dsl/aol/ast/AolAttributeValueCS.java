package org.vnu.sme.goal.dsl.aol.ast;

import java.util.Objects;

import org.vnu.sme.goal.dsl.csl.ast.CslSourceLocationCS;

/** rawValue keeps the source text verbatim (quotes included for strings), like CslAttributeCS.defaultValue. */
public record AolAttributeValueCS(String name, String rawValue, CslSourceLocationCS location) {
    public AolAttributeValueCS {
        Objects.requireNonNull(name, "name");
        Objects.requireNonNull(rawValue, "rawValue");
        Objects.requireNonNull(location, "location");
    }
}
