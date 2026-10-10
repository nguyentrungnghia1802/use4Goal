package org.vnu.sme.goal.feature.conformance;

import java.nio.file.Path;

import org.vnu.sme.goal.verify.conformance.CslBpmnIStarConformanceChecker;

/**
 * First end-to-end checker for the four-file workflow:
 * CSL -> generated USE, SOIL initial/execution state, i* goals, BPMN+OCL solution.
 */
public final class CslBpmnIStarConformanceMain {

    private CslBpmnIStarConformanceMain() {}

    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            System.err.println("usage: CslBpmnIStarConformanceMain model.csl init.soil model.istar model.bpmn2");
            System.exit(2);
        }

        Path cslFile = Path.of(args[0]);
        Path soilFile = Path.of(args[1]);
        Path istarFile = Path.of(args[2]);
        Path bpmnFile = Path.of(args[3]);

        CslBpmnIStarConformanceChecker.Result result =
                CslBpmnIStarConformanceChecker.check(cslFile, soilFile, istarFile, bpmnFile);
        if (!result.ok()) {
            result.errors().forEach(System.err::println);
            System.err.println("Verdict       : " + result.verdict());
            System.exit(1);
        }
        System.out.println("Generated USE : " + result.generatedUse());
        System.out.println("Execution SOIL: " + result.executionSoil());
        System.out.println("Checkpoints   : " + result.checkpoints());
        System.out.println("CSL invariants: " + (result.cslFailures().isEmpty() ? "PASS" : "FAIL"));
        result.cslFailures().forEach(f -> System.out.println("  - " + f));
        System.out.println("BPMN OCL      : " + (result.bpmnFailures().isEmpty() ? "PASS" : "FAIL"));
        result.bpmnFailures().forEach(f -> System.out.println("  - " + f));
        System.out.println("i* root goals : " + (result.goalFailures().isEmpty() ? "PASS" : "FAIL"));
        result.goalFailures().forEach(f -> System.out.println("  - " + f));
        System.out.println("Verdict       : " + result.verdict());
    }
}
