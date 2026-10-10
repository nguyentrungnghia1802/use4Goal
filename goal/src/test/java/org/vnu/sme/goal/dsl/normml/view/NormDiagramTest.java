package org.vnu.sme.goal.dsl.normml.view;

import java.nio.file.Path;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.junit.jupiter.api.Test;
import org.tzi.use.gui.views.diagrams.classdiagram.ClassNode;
import org.tzi.use.gui.views.diagrams.elements.edges.BinaryAssociationOrLinkEdge;
import org.vnu.sme.goal.dsl.normml.parser.NormCompiler;
import static org.junit.jupiter.api.Assertions.*;

class NormDiagramTest {
    @Test void exampleRendersThreeNormKindsWithNativeClassesAndAssociations() throws Exception {
        Path source = Path.of("../examples/NormML/proposal-review.normml");
        var result = NormCompiler.compile(source);
        assertTrue(result.ok(), result.errors().toString());
        assertEquals(java.util.Set.of("NormObligation", "NormPermission", "NormProhibition"),
            result.model().elements().values().stream().filter(e -> e.type().equals("Norm"))
                .map(e -> e.value("type")).collect(java.util.stream.Collectors.toSet()));
        System.setProperty("use.gui.view.classdiagram.class.minheight", "20");
        System.setProperty("use.gui.view.classdiagram.class.minwidth", "20");
        javax.swing.SwingUtilities.invokeAndWait(() -> {
            var diagram = new NormDiagram(new PrintWriter(new StringWriter()));
            try {
                diagram.setSourceFile(source);
                diagram.setModel(result.model());
                // Regression: an older saved layout contains <name/> for
                // unidirectional source roles. Loading it must not crash USE.
                diagram.loadDefaultLayout();
                assertEquals(result.model().elements().size()-1, diagram.getVisibleData().getNodes().size());
                assertTrue(diagram.getVisibleData().getNodes().stream().allMatch(ClassNode.class::isInstance));
                assertFalse(diagram.getVisibleData().getEdges().isEmpty());
                assertTrue(diagram.getVisibleData().getEdges().stream().allMatch(BinaryAssociationOrLinkEdge.class::isInstance));
                diagram.getVisibleData().getEdges().stream()
                    .map(BinaryAssociationOrLinkEdge.class::cast)
                    .forEach(edge -> {
                        assertFalse(edge.getSourceRolename().name().isBlank());
                        assertFalse(edge.getTargetRolename().name().isBlank());
                    });
                diagram.setSize(1900,1300);
                var image = new java.awt.image.BufferedImage(1900,1300,java.awt.image.BufferedImage.TYPE_INT_RGB);
                var graphics=image.createGraphics();
                try { diagram.paint(graphics); } finally { graphics.dispose(); }
            } finally { diagram.stopLayoutThread(); }
        });
    }
}
