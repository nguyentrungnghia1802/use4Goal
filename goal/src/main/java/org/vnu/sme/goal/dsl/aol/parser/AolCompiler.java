package org.vnu.sme.goal.dsl.aol.parser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.vnu.sme.goal.dsl.csl.mm.CslModel;
import org.vnu.sme.goal.dsl.csl.parser.CslCompiler;
import org.vnu.sme.goal.dsl.aol.ast.AolModelCS;
import org.vnu.sme.goal.dsl.aol.mm.AolModel;

/** Compiles an .aol object snapshot against the CSL model named in its {@code for} clause. */
public final class AolCompiler {

    public record Result(AolModelCS ast, CslModel csl, Path cslFile, AolModel model, List<String> errors) {
        public Result { errors = List.copyOf(errors); }
        public boolean ok() { return errors.isEmpty() && model != null; }
    }

    private AolCompiler() {}

    public static Result compile(Path file) throws IOException {
        Objects.requireNonNull(file, "file");
        List<String> errors = new ArrayList<>();
        CharStream input = CharStreams.fromPath(file);
        String sourceName = file.toString();

        AOLLexer lexer = new AOLLexer(input);
        AOLParser parser = new AOLParser(new CommonTokenStream(lexer));
        lexer.removeErrorListeners();
        parser.removeErrorListeners();
        ANTLRErrorListener listener = new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int column,
                                    String message, RecognitionException exception) {
                errors.add(format(sourceName, line, column, "syntax", message));
            }
        };
        lexer.addErrorListener(listener);
        parser.addErrorListener(listener);

        AOLParser.ModelContext tree = parser.model();
        if (!errors.isEmpty()) return new Result(null, null, null, null, errors);

        AolModelCS ast = new AOLBuildingVisitor().visitModel(tree);
        Path cslFile = file.toAbsolutePath().getParent().resolve(ast.cslFile()).normalize();

        CslCompiler.Result cslResult;
        try {
            cslResult = CslCompiler.compile(cslFile);
        } catch (IOException ex) {
            errors.add("cannot read CSL file '" + cslFile + "': " + ex.getMessage());
            return new Result(ast, null, cslFile, null, errors);
        }
        if (!cslResult.ok()) {
            errors.add("errors in referenced CSL specification '" + cslFile + "':");
            errors.addAll(cslResult.errors());
            return new Result(ast, cslResult.model(), cslFile, null, errors);
        }

        AolModelFactory.Result factory = AolModelFactory.create(ast, cslResult.model());
        for (AolModelFactory.SemanticError error : factory.errors()) {
            errors.add(format(sourceName, error.location().line(), error.location().column(), "semantic", error.message()));
        }
        return new Result(ast, cslResult.model(), cslFile, factory.model(), errors);
    }

    public static Result compileContent(String aolContent, Path cslFile) {
        Objects.requireNonNull(aolContent, "aolContent");
        Objects.requireNonNull(cslFile, "cslFile");
        List<String> errors = new ArrayList<>();
        CharStream input = CharStreams.fromString(aolContent);
        String sourceName = "counterexample.aol";

        AOLLexer lexer = new AOLLexer(input);
        AOLParser parser = new AOLParser(new CommonTokenStream(lexer));
        lexer.removeErrorListeners();
        parser.removeErrorListeners();
        ANTLRErrorListener listener = new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int column,
                                    String message, RecognitionException exception) {
                errors.add(format(sourceName, line, column, "syntax", message));
            }
        };
        lexer.addErrorListener(listener);
        parser.addErrorListener(listener);

        AOLParser.ModelContext tree = parser.model();
        if (!errors.isEmpty()) return new Result(null, null, cslFile, null, errors);

        AolModelCS ast = new AOLBuildingVisitor().visitModel(tree);

        CslCompiler.Result cslResult;
        try {
            cslResult = CslCompiler.compile(cslFile);
        } catch (IOException ex) {
            errors.add("cannot read CSL file '" + cslFile + "': " + ex.getMessage());
            return new Result(ast, null, cslFile, null, errors);
        }
        if (!cslResult.ok()) {
            errors.add("errors in referenced CSL specification '" + cslFile + "':");
            errors.addAll(cslResult.errors());
            return new Result(ast, cslResult.model(), cslFile, null, errors);
        }

        AolModelFactory.Result factory = AolModelFactory.create(ast, cslResult.model());
        for (AolModelFactory.SemanticError error : factory.errors()) {
            errors.add(format(sourceName, error.location().line(), error.location().column(), "semantic", error.message()));
        }
        return new Result(ast, cslResult.model(), cslFile, factory.model(), errors);
    }

    private static String format(String sourceName, int line, int column, String phase, String message) {
        return sourceName + ":" + line + ":" + column + ": " + phase + ": " + message;
    }
}
