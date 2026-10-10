package org.vnu.sme.goal.cslstate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.vnu.sme.goal.verify.cslstate.CslBpmnWholeProcessValidator.ConsistencyVerdict;
import org.vnu.sme.goal.verify.cslstate.CslBpmnWholeProcessValidator.RiskVerdict;
import org.vnu.sme.goal.verify.cslstate.CslStateEvaluationSession;

class PurchaseOrderConsistencyTest {
    private static final Path EXAMPLE = Path.of(
            "src/main/resources/examples/purchase_order");

    @Test
    void evaluatesPurchaseOrderProcess() throws Exception {
        CslStateEvaluationSession session = CslStateEvaluationSession.load(
                EXAMPLE.resolve("purchase_order.csl"));
        session.loadBpmn(EXAMPLE.resolve("purchase_order.bpmn2"));
        session.loadIStar(EXAMPLE.resolve("purchase_order.istar"));
        session.loadBoundary(EXAMPLE.resolve("purchase_order.cslboundary"));

        long started = System.nanoTime();
        var result = session.validateWholeBpmnProcess();
        long elapsedMillis = (System.nanoTime() - started) / 1_000_000;
        System.out.printf("PurchaseOrder: executions=%d, conformant=%d, "
                        + "nonConformant=%d, risky=%d, time=%d ms%n",
                result.realizableExecutions(), result.goalAchievingExecutions(),
                result.nonGoalAchievingExecutions(), result.riskyExecutions(), elapsedMillis);
        System.out.println(result.summary());

        assertTrue(result.realizableExecutions() > 0, result::summary);
    }
}
