package org.vnu.sme.goal.cslstate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.vnu.sme.goal.feature.cslstate.ConformanceReportBuilder;
import org.vnu.sme.goal.verify.cslstate.CslBpmnStateTraceEvaluator.Verdict;
import org.vnu.sme.goal.verify.cslstate.CslBpmnWholeProcessValidator;
import org.vnu.sme.goal.verify.cslstate.CslStateEvaluationSession;
import org.vnu.sme.goal.verify.cslstate.CslStateScenario;

class CslBpmnStateTraceEvaluatorTest {
    private static final Path CLASSROOM = Path.of("src/main/resources/examples/classroom");

    @Test
    void infersEveryFormalClassroomFlowIncludingStartGatewaysAndEnd() throws Exception {
        CslStateScenario scenario = CslStateScenario.load(CLASSROOM.resolve("classroom_process.cslscenario"));
        CslStateEvaluationSession session = CslStateEvaluationSession.load(scenario.cslFile());
        session.loadBpmn(scenario.bpmnFile());
        for (Path state : scenario.stateFiles()) session.addState(state);

        var trace = session.evaluateBpmnTrace();
        assertEquals(Verdict.AMBIGUOUS, trace.verdict(), () -> trace.summary() + " " + trace.steps());
        assertEquals("bottom::classroomReady", trace.steps().get(0).alternatives().get(0).flowId());
        assertEquals("beginLesson::prepSplit", trace.steps().get(2).alternatives().get(0).flowId());
        assertEquals(Set.of("prepSplit::setupSlides", "prepSplit::checkAttendanceRoster"),
                trace.steps().get(3).alternatives().stream()
                        .map(alternative -> alternative.flowId()).collect(java.util.stream.Collectors.toSet()));
        assertEquals("attendLesson::classFinished",
                trace.steps().get(16).alternatives().get(0).flowId());
        assertEquals(2, trace.completedPaths(), trace::summary);
        assertEquals(2, trace.steps().get(6).alternatives().size(),
                "XOR choice is structural until the selected flow Post_B is executed");
        assertTrue(session.states().stream().allMatch(state -> state.falseCount() == 0),
                "every state in the conformant trace must satisfy the CSL invariants");
    }

    @Test
    void reportsTheFormalFlowWhoseSourcePostconditionFails() throws Exception {
        assertInvalidScenario("classroom_error_postcondition.cslscenario", 2, "Post_B=false");
        assertEquals(Verdict.NON_CONFORMANT,
                evaluateScenario("classroom_error_out_of_order.cslscenario").verdict());
        assertEquals(Verdict.NON_CONFORMANT,
                evaluateScenario("classroom_error_wrong_branch.cslscenario").verdict());
        assertEquals(Verdict.AMBIGUOUS,
                evaluateScenario("classroom_ambiguous_parallel.cslscenario").verdict());
    }

    @Test
    void kodkodGeneratesClassroomStatesFromBoundaryWithoutAolScenario() throws Exception {
        CslStateEvaluationSession session = CslStateEvaluationSession.load(CLASSROOM.resolve("classroom.csl"));
        session.loadBpmn(CLASSROOM.resolve("classroom.bpmn2"));
        session.loadBoundary(CLASSROOM.resolve("classroom.cslboundary"));
        assertTrue(session.states().isEmpty(), "whole validation must not load an AOL scenario");

        var result = session.validateWholeBpmnOnly();
        assertEquals(CslBpmnWholeProcessValidator.Verdict.VALID,
                result.verdict(), () -> result.summary() + " " + result.processes());
        assertEquals("Kodkod / SAT4J", result.backend());
        assertEquals(3, result.loopBound());
        assertTrue(result.processes().get(0).transitions() > 0);
        assertTrue(result.processes().get(0).completedStates() > 0);
        assertTrue(result.processes().get(0).boundedExecutions() > 0);
        assertTrue(result.processes().get(0).solverCalls() > 0);
        assertTrue(result.processes().get(0).witnessStates().size() > 1,
                "a SAT Kodkod model must be decoded into a generated object-diagram path");
    }

    @Test
    void wholeValidationDerivesIStarGoalsFromGeneratedCslPaths() throws Exception {
        CslStateEvaluationSession session = CslStateEvaluationSession.load(CLASSROOM.resolve("classroom.csl"));
        session.loadBpmn(CLASSROOM.resolve("classroom.bpmn2"));
        session.loadIStar(CLASSROOM.resolve("classroom.istar"));
        session.loadBoundary(CLASSROOM.resolve("classroom.cslboundary"));

        var result = session.validateWholeBpmnProcess();
        assertEquals(CslBpmnWholeProcessValidator.ConsistencyVerdict.CONSISTENT,
                result.consistency(), result::summary);
        assertTrue(result.realizableExecutions() > 0);
        assertEquals(result.realizableExecutions(), result.goalAchievingExecutions());
        assertTrue(result.rootGoals().contains("Teacher.ClassCompleted"));
        assertTrue(result.rootGoals().contains("Student.ParticipatesInClass"));
        assertTrue(result.mappings().stream().anyMatch(mapping ->
                mapping.activityId().equals("recordAttendanceManually")
                        && mapping.leafId().equals("RecordAttendanceManually")));
        var report = ConformanceReportBuilder.build(result);
        assertTrue(report.stream().anyMatch(row -> row.type().equals("MAPPING")
                && row.status().equals("INFERRED_MAPPING")), report::toString);
        assertTrue(report.stream().noneMatch(row -> row.type().equals("COUNTERMEASURE")),
                report::toString);
        assertTrue(session.states().isEmpty(), "integrated whole validation must not load AOL");
    }

    @Test
    void distinguishesFullWeakAndMissingCrossModelConsistency(@TempDir Path temp) throws Exception {
        Path csl = temp.resolve("case.csl");
        Path istar = temp.resolve("case.istar");
        Path boundary = temp.resolve("case.cslboundary");
        Files.writeString(csl, """
                csl v2.0 CaseModel {
                  role Worker { }
                  group Case {
                    done : Boolean default false;
                    Worker [1];
                  }
                }
                """);
        Files.writeString(istar, """
                istar CaseGoals {
                  role Worker {
                    goal WorkRemainsDone : Sustain condition {[ self.group.done ]}
                  }
                }
                """);
        Files.writeString(boundary, """
                csl-bpmn-boundary v1.0 CaseBound {
                  snapshots 8;
                  loop-bound 2;
                  integer -1..1;
                  objects Case 1;
                  objects Worker 1;
                  links Case_contains_Worker 1;
                }
                """);

        assertEquals(CslBpmnWholeProcessValidator.ConsistencyVerdict.CONSISTENT,
                integrated(temp, csl, istar, boundary, "strong", """
                        activity good { type task lane Worker post {[ self.done ]} flow closed }
                        """).consistency());
        var weak = integrated(temp, csl, istar, boundary, "weak", """
                        gateway choose { lane Worker type xor flow good flow bad }
                        activity good { type task lane Worker post {[ self.done ]} flow closed }
                        activity bad { type task lane Worker post {[ not self.done ]} flow closed }
                        """);
        assertEquals(CslBpmnWholeProcessValidator.ConsistencyVerdict.WEAK_CONFORMANCE,
                weak.consistency());
        assertEquals(CslBpmnWholeProcessValidator.RiskVerdict.NON_RISKY, weak.risk(),
                "a never-achieved Sustain Goal remains unknown rather than violated");
        assertEquals(CslBpmnWholeProcessValidator.ConsistencyVerdict.INCONSISTENT,
                integrated(temp, csl, istar, boundary, "missing", """
                        activity bad { type task lane Worker post {[ not self.done ]} flow closed }
                        """).consistency());

        var risk = integrated(temp, csl, istar, boundary, "risk", """
                activity good { type task lane Worker post {[ self.done ]} flow broken }
                activity broken { type task lane Worker post {[ not self.done ]} flow closed }
                """);
        assertEquals(CslBpmnWholeProcessValidator.ConsistencyVerdict.INCONSISTENT,
                risk.consistency());
        assertEquals(CslBpmnWholeProcessValidator.RiskVerdict.RISKY, risk.risk());
        assertEquals(1, risk.riskyExecutions());

        var recovered = integrated(temp, csl, istar, boundary, "recovered", """
                activity good { type task lane Worker post {[ self.done ]} flow broken }
                activity broken { type task lane Worker post {[ not self.done ]} flow repaired }
                activity repaired { type task lane Worker post {[ self.done ]} flow closed }
                """);
        assertEquals(CslBpmnWholeProcessValidator.ConsistencyVerdict.INCONSISTENT,
                recovered.consistency(), "Sustain violations must persist after re-establishment");
        assertEquals(CslBpmnWholeProcessValidator.RiskVerdict.RISKY, recovered.risk());
    }

    private static CslBpmnWholeProcessValidator.ValidationResult integrated(
            Path temp, Path csl, Path istar, Path boundary, String name, String body) throws Exception {
        Path bpmn = temp.resolve(name + ".bpmn2");
        String first = body.contains("gateway choose") ? "choose" : body.contains("activity good") ? "good" : "bad";
        Files.writeString(bpmn, """
                model CaseProcess {
                  pool Work for Case { lane Worker; }
                  start opened { lane Worker trigger none flow %s }
                  %s
                  end closed { lane Worker trigger none }
                }
                """.formatted(first, body));
        CslStateEvaluationSession session = CslStateEvaluationSession.load(csl);
        session.loadBpmn(bpmn);
        session.loadIStar(istar);
        session.loadBoundary(boundary);
        return session.validateWholeBpmnProcess();
    }

    @Test
    void infersActivityFromStateOnlyScenarioAndReachesEnd(@TempDir Path temp) throws Exception {
        Path csl = temp.resolve("case.csl");
        Path bpmn = temp.resolve("case.bpmn2");
        Path before = temp.resolve("state_00.aol");
        Path after = temp.resolve("state_01.aol");
        Path scenarioFile = temp.resolve("case.cslscenario");

        Files.writeString(csl, """
                csl v2.0 CaseModel {
                  group Case {
                    completed : Boolean default false;
                  }
                  context Case inv CompletedIsBoolean:
                    self.completed = true or self.completed = false;
                }
                """);
        Files.writeString(bpmn, """
                model CaseProcess {
                  pool Work for Case {
                    lane Worker;
                  }
                  start opened {
                    lane Worker
                    trigger none
                    flow completeCase
                  }
                  activity completeCase {
                    type task
                    lane Worker
                    pre {[ not self.completed ]}
                    post {[ self.completed ]}
                    flow closed
                  }
                  end closed {
                    lane Worker
                    trigger none
                  }
                }
                """);
        Files.writeString(before, """
                aol v2.0 Before for "case.csl" {
                  group Case as case1;
                }
                """);
        Files.writeString(after, """
                aol v2.0 After for "case.csl" {
                  group Case as case1 { completed = true; }
                }
                """);
        Files.writeString(scenarioFile, """
                csl-state-scenario v1.0 CaseRun {
                  csl "case.csl";
                  bpmn "case.bpmn2";
                  state "state_00.aol";
                  state "state_00.aol";
                  state "state_00.aol";
                  state "state_01.aol";
                }
                """);

        CslStateScenario scenario = CslStateScenario.load(scenarioFile);
        assertEquals(4, scenario.stateFiles().size());
        assertEquals(csl.toAbsolutePath(), scenario.cslFile());

        CslStateEvaluationSession session = CslStateEvaluationSession.load(scenario.cslFile());
        session.loadBpmn(scenario.bpmnFile());
        for (Path state : scenario.stateFiles()) session.addState(state);

        var trace = session.evaluateBpmnTrace();
        assertEquals(Verdict.CONFORMANT, trace.verdict(), trace::summary);
        assertEquals(3, trace.steps().size());
        assertEquals("completeCase::closed", trace.steps().get(2).alternatives().get(0).flowId());
        assertEquals("Work", trace.steps().get(0).alternatives().get(0).processId());
        assertEquals("case1", trace.steps().get(0).alternatives().get(0).selfObject());
        assertEquals(1, trace.completedPaths(), trace::summary);

        Path boundary = temp.resolve("case.cslboundary");
        Files.writeString(boundary, """
                csl-bpmn-boundary v1.0 CaseBound {
                  snapshots 5;
                  loop-bound 3;
                  integer -2..2;
                  objects Case 1;
                }
                """);
        session.loadBoundary(boundary);
        var whole = session.validateWholeBpmnOnly();
        assertEquals(CslBpmnWholeProcessValidator.Verdict.VALID, whole.verdict(), whole::summary);

        Path impossibleBpmn = temp.resolve("impossible.bpmn2");
        Files.writeString(impossibleBpmn, """
                model ImpossibleProcess {
                  pool Work for Case { lane Worker; }
                  start opened { lane Worker trigger none flow impossible }
                  activity impossible {
                    type task lane Worker
                    post {[ self.completed and not self.completed ]}
                    flow closed
                  }
                  end closed { lane Worker trigger none }
                }
                """);
        CslStateEvaluationSession impossible = CslStateEvaluationSession.load(csl);
        impossible.loadBpmn(impossibleBpmn);
        impossible.loadBoundary(boundary);
        var invalidWhole = impossible.validateWholeBpmnOnly();
        assertEquals(CslBpmnWholeProcessValidator.Verdict.INVALID,
                invalidWhole.verdict(), invalidWhole::summary);
        assertTrue(invalidWhole.processes().get(0).detail().contains("UNSATISFIABLE"),
                invalidWhole.processes().get(0)::detail);
        assertTrue(invalidWhole.processes().get(0).solverCalls() > 0);
        assertTrue(invalidWhole.processes().get(0).counterexample().stream()
                .anyMatch(flow -> flow.equals("impossible -> closed")));
    }

    @Test
    void rejectsStatePairThatViolatesTheOnlyEnabledActivityPostcondition(@TempDir Path temp) throws Exception {
        Path csl = temp.resolve("case.csl");
        Path bpmn = temp.resolve("case.bpmn2");
        Path before = temp.resolve("before.aol");
        Path after = temp.resolve("after.aol");
        Files.writeString(csl, """
                csl v2.0 CaseModel { group Case { completed : Boolean default false; } }
                """);
        Files.writeString(bpmn, """
                model CaseProcess {
                  pool Work for Case { lane Worker; }
                  start opened { lane Worker trigger none flow completeCase }
                  activity completeCase {
                    type task lane Worker
                    post {[ self.completed ]}
                    flow closed
                  }
                  end closed { lane Worker trigger none }
                }
                """);
        Files.writeString(before, """
                aol v2.0 Before for "case.csl" { group Case as case1; }
                """);
        Files.writeString(after, """
                aol v2.0 After for "case.csl" { group Case as case1; }
                """);

        CslStateEvaluationSession session = CslStateEvaluationSession.load(csl);
        session.loadBpmn(bpmn);
        session.addState(before);
        session.addState(before);
        session.addState(before);
        session.addState(after);

        var trace = session.evaluateBpmnTrace();
        assertEquals(Verdict.NON_CONFORMANT, trace.verdict());
        assertTrue(trace.steps().get(2).detail().contains("Post_B=false"), trace.steps().get(2)::detail);
    }

    @Test
    void kodkodCutsAFormalLoopAfterThreeCyclicFlowExecutions(@TempDir Path temp) throws Exception {
        Path csl = temp.resolve("loop.csl");
        Path bpmn = temp.resolve("loop.bpmn2");
        Path state = temp.resolve("state.aol");
        Path boundary = temp.resolve("loop.cslboundary");
        Files.writeString(csl, """
                csl v2.0 LoopModel { group Case { enabled : Boolean default true; } }
                """);
        Files.writeString(bpmn, """
                model LoopProcess {
                  pool Work for Case { lane Worker; }
                  start opened { lane Worker trigger none flow spin }
                  gateway spin {
                    lane Worker
                    type xor
                    flow spin post {[ self.enabled ]}
                  }
                }
                """);
        Files.writeString(state, """
                aol v2.0 LoopState for "loop.csl" { group Case as case1; }
                """);
        Files.writeString(boundary, """
                csl-bpmn-boundary v1.0 LoopBound {
                  snapshots 10;
                  loop-bound 3;
                  integer -1..1;
                  objects Case 1;
                }
                """);

        CslStateEvaluationSession session = CslStateEvaluationSession.load(csl);
        session.loadBpmn(bpmn);
        session.loadBoundary(boundary);

        var result = session.validateWholeBpmnOnly();
        assertEquals(CslBpmnWholeProcessValidator.Verdict.VALID,
                result.verdict(), result::summary);
        var process = result.processes().get(0);
        assertEquals(1, process.loopCutoffs());
        assertEquals(1, process.boundedExecutions());
        assertEquals(2, process.solverCalls(), "one boundary preflight plus one route query");
        assertEquals(0, process.completedStates());
        assertEquals(6, process.witnessStates().size(),
                "initial flow + entry flow + three loop flows produce six state_at_i relations");
    }

    private static void assertInvalidScenario(String name, int failedStep, String detail) throws Exception {
        var trace = evaluateScenario(name);
        assertEquals(Verdict.NON_CONFORMANT, trace.verdict(), trace::summary);
        assertEquals(failedStep, trace.steps().size() - 1);
        assertEquals(Verdict.NON_CONFORMANT, trace.steps().get(failedStep).verdict());
        assertTrue(trace.steps().get(failedStep).detail().contains(detail),
                trace.steps().get(failedStep)::detail);
    }

    private static org.vnu.sme.goal.verify.cslstate.CslBpmnStateTraceEvaluator.TraceResult
            evaluateScenario(String name) throws Exception {
        CslStateScenario scenario = CslStateScenario.load(CLASSROOM.resolve(name));
        CslStateEvaluationSession session = CslStateEvaluationSession.load(scenario.cslFile());
        session.loadBpmn(scenario.bpmnFile());
        for (Path state : scenario.stateFiles()) session.addState(state);
        return session.evaluateBpmnTrace();
    }
}
