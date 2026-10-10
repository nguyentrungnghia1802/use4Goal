package org.vnu.sme.goal.dsl.normml.mm;

import java.util.*;
import org.vnu.sme.goal.dsl.normml.ast.NormModelCS.Location;

/** Immutable, schema-typed graph. References store resolved, unique local identifiers. */
public record NormModel(String name, Map<String, Element> elements, String source) {
    public NormModel { elements = Collections.unmodifiableMap(new LinkedHashMap<>(elements)); }
    public record Element(String id, String type, Map<String, List<String>> values, Location location) {
        public Element {
            Map<String,List<String>> copy = new LinkedHashMap<>();
            values.forEach((k,v) -> copy.put(k, List.copyOf(v)));
            values = Collections.unmodifiableMap(copy);
        }
        public List<String> values(String feature) { return values.getOrDefault(feature, List.of()); }
        public String value(String feature) { return values(feature).isEmpty() ? "" : values(feature).getFirst(); }
        @Override public String toString() { return type + " " + id; }
    }
    public Element element(String id) { return elements.get(id); }
}
