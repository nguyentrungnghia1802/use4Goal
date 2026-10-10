package org.vnu.sme.goal.translate.cslistarbpmn2use;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.tzi.use.parser.use.USECompiler;
import org.tzi.use.uml.mm.ModelFactory;
import org.vnu.sme.goal.dsl.csl.parser.CslCompiler;
import org.vnu.sme.goal.dsl.bpmn.parser.BpmnCompiler;
import org.vnu.sme.goal.dsl.istar.parser.IStarCompiler;

class CslBpmnIStar2UseTranslatorTest {
    private static final Path CLASSROOM = Path.of("src/main/resources/examples/classroom");

    @Test
    void combinesStructureGoalsAndProcessIntoOneCompilableUseModel() throws Exception {
        var csl = CslCompiler.compile(CLASSROOM.resolve("classroom.csl"));
        var bpmn = BpmnCompiler.compile(CLASSROOM.resolve("classroom.bpmn2"));
        var istar = IStarCompiler.compile(CLASSROOM.resolve("classroom.istar"));
        assertTrue(csl.ok(), () -> String.join("\n", csl.errors()));
        assertTrue(bpmn.ok(), () -> String.join("\n", bpmn.errors()));
        assertTrue(istar.ok(), () -> String.join("\n", istar.errors()));

        var result = CslBpmnIStar2UseTranslator.translate(
                csl.model(), bpmn.model(), istar.model());
        assertTrue(result.ok(), () -> String.join("\n", result.diagnostics()));
        assertTrue(result.useText().contains("class Teacher\nattributes\n  id : Integer"));
        assertTrue(result.useText().contains("ClassCompleted_condition() : Boolean"));
        assertTrue(result.useText().contains("  beginLesson()"));
        assertTrue(result.useText().contains("context Teacher::beginLesson()"));
        assertTrue(result.toclText().contains("sometime self.ClassCompleted_condition()"));
        assertTrue(result.toclText().contains("inv BPMN_TeachingSession_start_classroomReady_occurs:"));
        assertTrue(result.toclText().contains("sometime isCalled(classroomReady())"));
        assertTrue(result.toclText().contains("inv BPMN_TeachingSession_before_beginLesson:"));
        assertUseCompiles(result.useText());
    }

    @Test
    void fileServiceWritesBothArtifacts(@TempDir Path output) {
        var result = CslBpmnIStarUseOclService.translate(
                CLASSROOM.resolve("classroom.csl"),
                CLASSROOM.resolve("classroom.bpmn2"),
                CLASSROOM.resolve("classroom.istar"), output);
        assertTrue(result.ok(), () -> String.join("\n", result.allDiagnostics()));
        assertNotNull(result.written());
        assertTrue(Files.isRegularFile(result.written().useFile()));
        assertTrue(Files.isRegularFile(result.written().toclFile()));
    }

    private static void assertUseCompiles(String use) {
        StringWriter errors = new StringWriter();
        var model = USECompiler.compileSpecification(use, "generated-all.use",
                new PrintWriter(errors), new ModelFactory());
        assertNotNull(model, () -> errors + "\n" + use);
    }
}
