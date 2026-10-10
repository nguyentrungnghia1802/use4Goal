package org.vnu.sme.goal.dsl.normml.parser;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import org.antlr.v4.runtime.*;
import org.vnu.sme.goal.dsl.normml.ast.NormModelCS;
import org.vnu.sme.goal.dsl.normml.mm.*;

public final class NormCompiler {
    public record Result(NormModelCS ast, NormModel model, List<String> errors) {
        public Result { errors = List.copyOf(errors); }
        public boolean ok() { return model != null && errors.isEmpty(); }
    }
    private NormCompiler() {}
    public static Result compile(Path file) throws IOException { return compile(Files.readString(file), file.toString()); }
    public static Result compile(String source) { return compile(source, "<memory>"); }
    public static Result compile(String source, String sourceName) {
        Objects.requireNonNull(source); Objects.requireNonNull(sourceName);
        List<String> errors = new ArrayList<>();
        var lexer = new NormMLLexer(CharStreams.fromString(source));
        var parser = new NormMLParser(new CommonTokenStream(lexer));
        var listener = new BaseErrorListener() {
            @Override public void syntaxError(Recognizer<?,?> r, Object token, int line, int column,
                    String message, RecognitionException e) {
                errors.add(sourceName + ":" + line + ":" + column + ": syntax: " + message);
            }
        };
        lexer.removeErrorListeners(); parser.removeErrorListeners();
        lexer.addErrorListener(listener); parser.addErrorListener(listener);
        var tree = parser.model();
        if (!errors.isEmpty()) return new Result(null, null, errors);
        NormModelCS ast = NormBuildingVisitor.build(tree);
        var model = new NormModelFactory(sourceName, errors).create(ast, source);
        return new Result(ast, errors.isEmpty() ? model : null, errors);
    }
    /** Headless entry point, with nonzero exit status on a rejected file. */
    public static void main(String[] args) throws IOException {
        if (args.length != 1) { System.err.println("Usage: NormCompiler model.normml"); System.exit(2); }
        Result r = compile(Path.of(args[0]));
        if (!r.ok()) { r.errors().forEach(System.err::println); System.exit(1); }
        System.out.println("Compiled NormML " + r.model().name() + " (" + (r.model().elements().size()-1) + " declarations)");
    }
}
