package org.vnu.sme.goal.dsl.normml.parser;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.tzi.use.parser.ParseErrorHandler;
import org.tzi.use.parser.ocl.OCLLexer;
import org.tzi.use.parser.ocl.OCLParser;

/** Syntax only: CSL state and self binding are supplied at execution time. */
final class NormOclSyntax {
    private NormOclSyntax() {}

    static void validate(String expression) {
        StringWriter diagnostics = new StringWriter();
        PrintWriter writer = new PrintWriter(diagnostics);
        ParseErrorHandler errors = new ParseErrorHandler("<invariant>", writer);
        OCLLexer lexer = new OCLLexer(new ANTLRStringStream(expression));
        OCLParser parser = new OCLParser(new CommonTokenStream(lexer));
        lexer.init(errors);
        parser.init(errors);
        try {
            parser.expressionOnly();
        } catch (RecognitionException exception) {
            throw new IllegalArgumentException("Invalid OCL at " + exception.line + ":"
                    + exception.charPositionInLine + ": " + exception, exception);
        }
        writer.flush();
        if (errors.errorCount() != 0) {
            throw new IllegalArgumentException(diagnostics.toString().trim());
        }
    }
}
