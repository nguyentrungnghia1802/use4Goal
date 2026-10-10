package org.vnu.sme.goal.cslstate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.vnu.sme.goal.feature.cslstate.ConformanceReportBuilder;
import org.vnu.sme.goal.verify.cslstate.CslBpmnWholeProcessValidator.ConsistencyVerdict;
import org.vnu.sme.goal.verify.cslstate.CslBpmnWholeProcessValidator.GoalStatus;
import org.vnu.sme.goal.verify.cslstate.CslBpmnWholeProcessValidator.RiskVerdict;
import org.vnu.sme.goal.verify.cslstate.CslStateEvaluationSession;

class ProposalReviewWholeConsistencyTest {
    private static final Path EXAMPLE = Path.of(
            "src/main/resources/examples/sales_forecast/proposal_review_whole");

    @Test
    void detectsThatUpdateWithoutRevalidationBreaksOnlyOneBpmnBranch() throws Exception {
        CslStateEvaluationSession session = CslStateEvaluationSession.load(
                EXAMPLE.resolve("proposal_review.csl"));
        session.loadBpmn(EXAMPLE.resolve("proposal_review.bpmn2"));
        session.loadIStar(EXAMPLE.resolve("proposal_review.istar"));
        session.loadBoundary(EXAMPLE.resolve("proposal_review.cslboundary"));

        var result = session.validateWholeBpmnProcess();
        assertEquals(ConsistencyVerdict.WEAK_CONFORMANCE, result.consistency(),
                () -> result.summary() + " " + result.processes());
        assertEquals(RiskVerdict.RISKY, result.risk(), result::summary);
        assertEquals(2, result.realizableExecutions(), result::summary);
        assertEquals(1, result.goalAchievingExecutions(), result::summary);
        assertEquals(1, result.nonGoalAchievingExecutions(), result::summary);
        assertEquals(1, result.riskyExecutions(), result::summary);
        assertEquals(java.util.List.of("ProposalManager.ProposalSuccessfullyCompleted", "Customer.ProposalReceived"), result.rootGoals());
        assertTrue(result.processes().get(0).counterexample().stream()
                .anyMatch(flow -> flow.contains("updateProposal")));
        assertTrue(result.processes().get(0).failureCheckpoint() > 0);
        assertTrue(result.processes().get(0).invalidatingStep().startsWith("updateProposal ->"),
                result.processes().get(0)::invalidatingStep);
        assertTrue(result.processes().get(0).counterexampleStates().stream()
                .anyMatch(state -> state.contains("currentRevision=2")
                        && state.contains("validationRevision=1")));
        assertTrue(result.processes().get(0).counterexampleGoals().stream()
                .anyMatch(goal -> goal.goal().endsWith("CurrentRevisionValidated")
                        && goal.status() == GoalStatus.VIOLATED));
        assertTrue(result.processes().get(0).repairHints().stream()
                .anyMatch(hint -> hint.contains("CurrentRevisionValidated")
                        && hint.contains("Validate proposal")),
                result.processes().get(0).repairHints()::toString);
        assertTrue(result.mappings().stream().anyMatch(mapping ->
                mapping.activityId().equals("validateProposal")
                        && mapping.leafId().equals("ValidateProposal")));
        assertTrue(result.mappings().stream().anyMatch(mapping ->
                mapping.activityId().equals("updateProposal")
                        && mapping.leafId().equals("UpdateProposal")));
        var report = ConformanceReportBuilder.build(result);
        assertTrue(report.stream().anyMatch(row -> row.type().equals("MAPPING")
                && row.status().equals("MAPPED_BEFORE_FAILURE")));
        assertTrue(report.stream().anyMatch(row -> row.type().equals("MAPPING")
                && row.bpmnElement().contains("updateProposal")
                && row.status().equals("INVALIDATING_STEP")), report::toString);
        assertTrue(report.stream().anyMatch(row -> row.type().equals("COUNTERMEASURE")
                && row.evidenceOrAction().contains("Validate proposal")), report::toString);
        assertTrue(session.states().isEmpty(), "whole validation must generate states, not load AOL");
    }
}
