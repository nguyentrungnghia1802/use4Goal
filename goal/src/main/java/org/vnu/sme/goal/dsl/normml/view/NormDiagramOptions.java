package org.vnu.sme.goal.dsl.normml.view;

import java.nio.file.Path;
import org.tzi.use.gui.views.diagrams.classdiagram.ClassDiagramOptions;

/** Reuse USE class-diagram display and persistence options. */
public final class NormDiagramOptions extends ClassDiagramOptions {
    public NormDiagramOptions() { }
    public NormDiagramOptions(Path source) { super(source); }
}
