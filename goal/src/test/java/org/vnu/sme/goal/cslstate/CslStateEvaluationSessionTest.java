package org.vnu.sme.goal.cslstate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.vnu.sme.goal.dsl.csl.mm.RelationKind;
import org.vnu.sme.goal.dsl.aol.state.CslSystemState.Kind;
import org.vnu.sme.goal.dsl.aol.state.CslSystemStateCompiler;
import org.vnu.sme.goal.verify.cslstate.CslStateEvaluationSession;

class CslStateEvaluationSessionTest {
    private static final Path CLASSROOM = Path.of("src/main/resources/examples/classroom");

    @Test
    void evaluatesClassroomOclDirectlyOverThreeCslStates() throws Exception {
        var session = CslStateEvaluationSession.load(CLASSROOM.resolve("classroom.csl"));

        var teacherComposition = session.cslModel().relations().stream()
                .filter(value -> value.name().equals("Classroom_contains_Teacher"))
                .findFirst().orElseThrow();
        assertEquals(RelationKind.COMPOSITION, teacherComposition.kind());
        assertEquals("Classroom", teacherComposition.source().type());
        assertEquals("Teacher", teacherComposition.target().type());

        var initial = session.addState(CLASSROOM.resolve("classroom_state_01_initial.aol"));
        var completed = session.addState(CLASSROOM.resolve("classroom_state_02_completed.aol"));
        var invalid = session.addState(CLASSROOM.resolve("classroom_state_03_invalid.aol"));

        assertEquals(4, session.cslModel().invariants().size());
        assertTrue(initial.structureValid(), initial::structureReport);
        assertEquals(4, initial.trueCount(), initial.constraints().toString());
        assertEquals(0, initial.falseCount());
        assertTrue(completed.structureValid(), completed::structureReport);
        assertEquals(4, completed.trueCount());
        assertEquals(0, completed.falseCount());
        assertTrue(invalid.structureValid(), invalid::structureReport);
        assertEquals(0, invalid.trueCount());
        assertEquals(4, invalid.falseCount());
        assertEquals(0, invalid.errorCount());
        assertEquals(Kind.GROUP, invalid.state().object("classroom1").kind());
        assertEquals(Kind.ROLE, invalid.state().object("teacher1").kind());
        assertEquals(Kind.ROLE, invalid.state().object("student1").kind());
        assertEquals(2, invalid.state().objectsOfType("Person").size(),
                "Role inheritance must not use domain inclusion");
        assertFalse(invalid.state().object("teacher1").attributes().containsKey("active"),
                "a child Role object stores only directly declared attributes");
        assertEquals(Boolean.TRUE, invalid.state().property(invalid.state().object("teacher1"), "active"),
                "inherited Role property lookup must follow sigma_Play to the Person object");
        assertSame(invalid.state().object("teacherPerson"),
                invalid.state().property(invalid.state().object("teacher1"), "playOf"));
        assertSame(invalid.state().object("classroom1"),
                invalid.state().property(invalid.state().object("teacher1"), "group"));
        assertEquals(2, invalid.state().associationLinkCount());
        assertEquals(2, invalid.state().playLinkCount());
        assertNotSame(initial.state(), completed.state());
        assertEquals(3, session.states().size());
    }

    @Test
    void rejectsAgentAndReportsMissingRequiredSigmaPlay(@TempDir Path temp) throws Exception {
        Path csl = CLASSROOM.resolve("classroom.csl").toAbsolutePath().normalize();
        var session = CslStateEvaluationSession.load(csl);

        Path withAgent = temp.resolve("with_agent.aol");
        Files.writeString(withAgent, """
                aol v2.0 WithAgent for "%s" {
                  agent obsolete;
                }
                """.formatted(csl));
        var agentResult = CslSystemStateCompiler.compile(withAgent, csl, session.cslModel());
        assertNull(agentResult.state());
        assertTrue(agentResult.diagnostics().stream().anyMatch(value -> value.contains("Agent is not part")));

        Path missingPlay = temp.resolve("missing_play.aol");
        Files.writeString(missingPlay, """
                aol v2.0 MissingPlay for "%s" {
                  group Classroom as classroom1;
                  role Person as teacherPerson;
                  role Teacher as teacher1;
                  role Person as studentPerson;
                  role Student as student1;
                  link Classroom_contains_Teacher : classroom1 -> teacher1;
                  link Classroom_contains_Student : classroom1 -> student1;
                }
                """.formatted(csl));
        var missingPlayResult = CslSystemStateCompiler.compile(missingPlay, csl, session.cslModel());
        assertTrue(missingPlayResult.state() != null);
        assertTrue(missingPlayResult.diagnostics().stream()
                .anyMatch(value -> value.contains("exactly one sigma_Play parent")));
    }
}
