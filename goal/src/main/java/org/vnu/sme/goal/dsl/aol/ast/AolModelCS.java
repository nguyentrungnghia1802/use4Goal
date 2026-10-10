package org.vnu.sme.goal.dsl.aol.ast;

import java.util.List;
import java.util.Objects;

import org.vnu.sme.goal.dsl.csl.ast.CslSourceLocationCS;

public record AolModelCS(String version, String name, String cslFile,
                         List<AolAgentCS> agents, List<AolGroupInstanceCS> groupInstances,
                         List<AolEntityInstanceCS> entities, List<AolRoleInstanceCS> roles,
                         List<AolPlayLinkCS> playLinks, List<AolLinkCS> links,
                         CslSourceLocationCS location) {
    public AolModelCS {
        Objects.requireNonNull(version, "version");
        Objects.requireNonNull(name, "name");
        Objects.requireNonNull(cslFile, "cslFile");
        agents = List.copyOf(agents);
        groupInstances = List.copyOf(groupInstances);
        entities = List.copyOf(entities);
        roles = List.copyOf(roles);
        playLinks = List.copyOf(playLinks);
        links = List.copyOf(links);
        Objects.requireNonNull(location, "location");
    }
}
