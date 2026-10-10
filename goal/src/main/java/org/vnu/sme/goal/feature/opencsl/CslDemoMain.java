package org.vnu.sme.goal.feature.opencsl;

import java.nio.file.Path;

import org.vnu.sme.goal.dsl.csl.parser.CslCompiler;
import org.vnu.sme.goal.dsl.csl.view.CslSpecText;

public final class CslDemoMain {

    private CslDemoMain() {}

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("usage: CslDemoMain input.csl");
            System.exit(2);
        }
        CslCompiler.Result result = CslCompiler.compile(Path.of(args[0]));
        if (!result.ok()) {
            result.errors().forEach(System.err::println);
            System.exit(1);
        }
        System.out.print(CslSpecText.render(result.model()));
    }
}
