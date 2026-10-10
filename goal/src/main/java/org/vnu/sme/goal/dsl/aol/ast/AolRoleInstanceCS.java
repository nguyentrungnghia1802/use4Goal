package org.vnu.sme.goal.dsl.aol.ast;

import java.util.List;
import java.util.Objects;

import org.vnu.sme.goal.dsl.csl.ast.CslSourceLocationCS;

/** One object in sigma_Class(r), where r is an CSL Role. */
public record AolRoleInstanceCS(String roleType, String instanceId,
                                List<AolAttributeValueCS> attributeValues,
                                CslSourceLocationCS location) {
    public AolRoleInstanceCS {
        Objects.requireNonNull(roleType, "roleType");
        Objects.requireNonNull(instanceId, "instanceId");
        attributeValues = List.copyOf(attributeValues);
        Objects.requireNonNull(location, "location");
    }
}
