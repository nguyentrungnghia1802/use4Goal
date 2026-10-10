package org.vnu.sme.goal.dsl.normml.view;

import org.tzi.use.gui.views.diagrams.classdiagram.ClassNode;
import org.tzi.use.uml.mm.MClass;
import org.vnu.sme.goal.dsl.normml.mm.NormModel;

/** USE draws the class header, attribute and operation compartments unchanged. */
final class NormClassNode extends ClassNode {
    private final String id;
    NormClassNode(MClass cls, NormModel.Element element, NormDiagramOptions options) {
        super(cls, options);
        id = element.id();
        String type = switch (element.type()) {
            case "Norm", "Sanction" -> element.value("type");
            case "AtomicAction", "CompositeAction" -> element.value("kind");
            default -> element.type();
        };
        fLabel = id + " : " + type;
    }
    @Override public String getId() { return id; }
    @Override public String name() { return id; }
}
