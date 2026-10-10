package org.vnu.sme.goal.cslstate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.vnu.sme.goal.verify.cslstate.CslBpmnBoundary;
import org.vnu.sme.goal.verify.cslstate.CslStateEvaluationSession;

class CslBpmnBoundaryTest {
    private static final Path CLASSROOM = Path.of("src/main/resources/examples/classroom");

    @Test
    void parsesTheClassroomSymbolicScope() throws Exception {
        var session = CslStateEvaluationSession.load(CLASSROOM.resolve("classroom.csl"));
        CslBpmnBoundary boundary = session.loadBoundary(CLASSROOM.resolve("classroom.cslboundary"));

        assertEquals(24, boundary.snapshots());
        assertEquals(3, boundary.loopBound());
        assertEquals(new CslBpmnBoundary.Scope(2, 2), boundary.objectScopes().get("Person"));
        assertEquals(new CslBpmnBoundary.Scope(1, 1),
                boundary.linkScopes().get("Classroom_contains_Student"));
    }

    @Test
    void rejectsABoundaryThatDoesNotScopeEveryCslClassifier(@TempDir Path temp) throws Exception {
        var session = CslStateEvaluationSession.load(CLASSROOM.resolve("classroom.csl"));
        Path incomplete = temp.resolve("incomplete.cslboundary");
        Files.writeString(incomplete, """
                csl-bpmn-boundary v1.0 Incomplete {
                  snapshots 4;
                  loop-bound 3;
                  integer -1..1;
                  objects Classroom 1;
                }
                """);

        IllegalArgumentException error = assertThrows(IllegalArgumentException.class,
                () -> session.loadBoundary(incomplete));
        assertTrue(error.getMessage().contains("missing objects scope for Person"), error::getMessage);
        assertTrue(error.getMessage().contains("missing objects scope for Teacher"), error::getMessage);
    }
}
