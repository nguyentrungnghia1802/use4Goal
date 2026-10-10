package org.vnu.sme.goal.dsl.normml.ast;

import java.util.List;

/** Source syntax, retaining locations before reference resolution. */
public record NormModelCS(String name, List<Declaration> declarations) {
    public NormModelCS { declarations = List.copyOf(declarations); }
    public record Location(int line, int column) {}
    public record Value(String text, boolean reference, boolean quoted) {}
    public record Property(String name, List<Value> values, Location location) {
        public Property { values = List.copyOf(values); }
    }
    public record Declaration(String type, String id, List<Property> properties, Location location) {
        public Declaration { properties = List.copyOf(properties); }
    }
}
