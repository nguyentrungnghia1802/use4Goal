package org.vnu.sme.goal.dsl.aol.ast;

import java.util.List;
import java.util.Objects;

import org.vnu.sme.goal.dsl.csl.ast.CslSourceLocationCS;

public record AolEntityInstanceCS(String entityType, String instanceId,
                                  List<AolAttributeValueCS> attributeValues, CslSourceLocationCS location) {
    public AolEntityInstanceCS {
        Objects.requireNonNull(entityType, "entityType");
        Objects.requireNonNull(instanceId, "instanceId");
        attributeValues = List.copyOf(attributeValues);
        Objects.requireNonNull(location, "location");
    }
}
