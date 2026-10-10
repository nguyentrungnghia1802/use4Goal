package org.vnu.sme.goal.verify.cslstate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.vnu.sme.goal.dsl.csl.mm.CslInvariant;
import org.vnu.sme.goal.dsl.csl.mm.CslModel;
import org.vnu.sme.goal.dsl.csl.parser.CslCompiler;
import org.vnu.sme.goal.dsl.aol.state.CslSystemState;
import org.vnu.sme.goal.dsl.aol.state.CslSystemStateCompiler;
import org.vnu.sme.goal.dsl.istar.mm.GoalModel;
import org.vnu.sme.goal.dsl.istar.parser.IStarCompiler;
import org.vnu.sme.goal.trace.cslTrace.nativecsl.NativeOclEvaluator;

/**
 * Evaluates OCL invariants directly over typed CSL states and concrete snapshots.
 *
 * <p>This class deliberately has no dependency on USE's {@code MModel},
 * {@code MSystem}, SOIL, or the CSL-to-USE translator. Entity, Role and Group
 * remain distinct CSL classifier kinds throughout compilation and evaluation.</p>
 */
public final class CslStateEvaluationSession {
    public enum TruthValue {
        TRUE, FALSE, UNDEFINED, ERROR
    }

    public record ConstraintResult(String name, String context, String expression,
                                   TruthValue result, String detail) {
        public ConstraintResult {
            Objects.requireNonNull(name, "name");
            Objects.requireNonNull(context, "context");
            Objects.requireNonNull(expression, "expression");
            Objects.requireNonNull(result, "result");
            detail = detail == null ? "" : detail;
        }
    }

    public record StateResult(int index, Path aolFile, CslSystemState state,
                              boolean structureValid, String structureReport,
                              List<String> inputDiagnostics,
                              List<ConstraintResult> constraints) {
        public StateResult {
            Objects.requireNonNull(aolFile, "aolFile");
            Objects.requireNonNull(state, "state");
            structureReport = structureReport == null ? "" : structureReport;
            inputDiagnostics = List.copyOf(inputDiagnostics);
            constraints = List.copyOf(constraints);
        }

        public int objectCount() { return state.objectCount(); }
        public int linkCount() { return state.linkCount(); }
        public long trueCount() { return count(TruthValue.TRUE); }
        public long falseCount() { return count(TruthValue.FALSE); }
        public long undefinedCount() { return count(TruthValue.UNDEFINED); }
        public long errorCount() { return count(TruthValue.ERROR); }

        private long count(TruthValue value) {
            return constraints.stream().filter(result -> result.result() == value).count();
        }
    }

    private final Path cslFile;
    private final CslModel cslModel;
    private final String cslSource;
    private final List<StateResult> states = new ArrayList<>();
    private CslBpmnStateTraceEvaluator bpmnEvaluator;
    private CslBpmnBoundary boundary;
    private Path istarFile;
    private GoalModel goalModel;
    private String istarSource;

    private CslStateEvaluationSession(Path cslFile, CslModel cslModel, String cslSource) {
        this.cslFile = cslFile;
        this.cslModel = cslModel;
        this.cslSource = cslSource;
    }

    public static CslStateEvaluationSession load(Path cslFile) throws IOException {
        Objects.requireNonNull(cslFile, "cslFile");
        Path source = cslFile.toAbsolutePath().normalize();
        CslCompiler.Result csl = CslCompiler.compile(source);
        if (!csl.ok()) {
            throw new IllegalArgumentException("CSL compilation failed:\n" + String.join("\n", csl.errors()));
        }
        return new CslStateEvaluationSession(source, csl.model(), Files.readString(source));
    }

    public Path cslFile() { return cslFile; }
    public CslModel cslModel() { return cslModel; }
    public String cslSource() { return cslSource; }
    public List<StateResult> states() { return List.copyOf(states); }
    public CslBpmnStateTraceEvaluator bpmnEvaluator() { return bpmnEvaluator; }
    public CslBpmnBoundary boundary() { return boundary; }
    public Path istarFile() { return istarFile; }
    public GoalModel goalModel() { return goalModel; }
    public String istarSource() { return istarSource; }

    /** Loads the BPMN specification whose execution is to be inferred from the AOL state chain. */
    public CslBpmnStateTraceEvaluator loadBpmn(Path bpmnFile) throws IOException {
        bpmnEvaluator = CslBpmnStateTraceEvaluator.load(bpmnFile, cslModel);
        return bpmnEvaluator;
    }

    /** Loads the finite symbolic scope used only by whole-process validation. */
    public CslBpmnBoundary loadBoundary(Path boundaryFile) throws IOException {
        boundary = CslBpmnBoundary.load(boundaryFile, cslModel);
        return boundary;
    }

    /** Loads the iStar requirements whose markings are derived from generated CSL states. */
    public GoalModel loadIStar(Path file) throws IOException {
        Objects.requireNonNull(file, "file");
        Path source = file.toAbsolutePath().normalize();
        IStarCompiler.Result compiled = IStarCompiler.compile(source);
        if (!compiled.ok()) {
            throw new IllegalArgumentException("iStar compilation failed:\n"
                    + String.join("\n", compiled.errors()));
        }
        istarFile = source;
        goalModel = compiled.model();
        istarSource = Files.readString(source);
        return goalModel;
    }

    public void clearStates() {
        states.clear();
    }

    public CslBpmnStateTraceEvaluator.TraceResult evaluateBpmnTrace() {
        if (bpmnEvaluator == null) throw new IllegalStateException("Load a BPMN specification first");
        return bpmnEvaluator.evaluate(states);
    }

    /**
     * Kodkod realization of bounded CSL/BPMN/iStar consistency. iStar is
     * evaluated over generated CSL paths; AOL snapshots are deliberately not used.
     */
    public CslBpmnWholeProcessValidator.ValidationResult validateWholeBpmnProcess() {
        if (bpmnEvaluator == null) throw new IllegalStateException("Load a BPMN specification first");
        if (boundary == null) throw new IllegalStateException("Load a CSL/BPMN boundary first");
        if (goalModel == null) throw new IllegalStateException("Load an iStar requirement model first");
        return new CslBpmnWholeProcessValidator().validate(bpmnEvaluator, cslModel, boundary, goalModel);
    }

    /** Backward-compatible BPMN-only bounded validation used by focused BPMN clients. */
    public CslBpmnWholeProcessValidator.ValidationResult validateWholeBpmnOnly() {
        if (bpmnEvaluator == null) throw new IllegalStateException("Load a BPMN specification first");
        if (boundary == null) throw new IllegalStateException("Load a CSL/BPMN boundary first");
        return new CslBpmnWholeProcessValidator().validate(bpmnEvaluator, cslModel, boundary);
    }

    /** Adds one complete AOL snapshot and evaluates CSL invariants without a USE conversion. */
    public StateResult addState(Path aolFile) throws IOException {
        Objects.requireNonNull(aolFile, "aolFile");
        Path source = aolFile.toAbsolutePath().normalize();
        CslSystemStateCompiler.Result aol = CslSystemStateCompiler.compile(source, cslFile, cslModel);
        if (aol.state() == null) {
            throw new IllegalArgumentException("AOL v2 compilation failed:\n"
                    + String.join("\n", aol.diagnostics()));
        }
        CslSystemState snapshot = aol.state();
        List<ConstraintResult> constraints = evaluateConstraints(snapshot);
        boolean structureValid = aol.diagnostics().isEmpty();
        String structureReport = structureValid ? "CSL structure valid"
                : String.join("\n", aol.diagnostics());
        StateResult result = new StateResult(states.size(), source, snapshot,
                structureValid, structureReport, aol.diagnostics(), constraints);
        states.add(result);
        return result;
    }

    private List<ConstraintResult> evaluateConstraints(CslSystemState snapshot) {
        List<ConstraintResult> results = new ArrayList<>(cslModel.invariants().size());
        for (CslInvariant invariant : cslModel.invariants()) {
            try {
                List<CslSystemState.ObjectValue> contextObjects = snapshot.objectsOfType(invariant.contextType());
                List<String> violations = new ArrayList<>();
                for (CslSystemState.ObjectValue self : contextObjects) {
                    boolean value = NativeOclEvaluator.evaluate(
                            invariant.expression(), snapshot, List.of(self));
                    if (!value) violations.add(self.id());
                }
                boolean holds = violations.isEmpty();
                String detail = contextObjects.isEmpty()
                        ? "true (no instances of context " + invariant.contextType() + ")"
                        : holds ? "true for " + contextObjects.size() + " instance(s)"
                        : "false for: " + String.join(", ", violations);
                results.add(new ConstraintResult(invariant.qualifiedName(), invariant.contextType(),
                        invariant.expression(), holds ? TruthValue.TRUE : TruthValue.FALSE, detail));
            } catch (RuntimeException ex) {
                results.add(new ConstraintResult(invariant.qualifiedName(), invariant.contextType(),
                        invariant.expression(), TruthValue.ERROR, message(ex)));
            }
        }
        return List.copyOf(results);
    }

    private static String message(Throwable throwable) {
        String value = throwable.getMessage();
        return value == null || value.isBlank() ? throwable.getClass().getSimpleName() : value;
    }
}
