package org.vnu.sme.goal.dsl.aol.ast;

import java.util.Objects;

import org.vnu.sme.goal.dsl.csl.ast.CslSourceLocationCS;

/** One sigma_Play(parentRole, childRole) link between Role object identifiers. */
public record AolPlayLinkCS(String parentInstanceId, String childInstanceId,
                            CslSourceLocationCS location) {
    public AolPlayLinkCS {
        Objects.requireNonNull(parentInstanceId, "parentInstanceId");
        Objects.requireNonNull(childInstanceId, "childInstanceId");
        Objects.requireNonNull(location, "location");
    }
}
