package org.vnu.sme.goal.feature.opencsl;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

import org.tzi.use.gui.main.MainWindow;
import org.vnu.sme.goal.dsl.csl.parser.CslCompiler;
import org.vnu.sme.goal.dsl.csl.view.CslView;

/** Application boundary for the State View Model use case. */
public final class CslOpenService {
    public enum Target { USE_DESKTOP, POPUP_WINDOW }
    public record Result(boolean opened, List<String> errors) {
        public Result { errors = List.copyOf(errors); }
    }

    private final MainWindow mainWindow;

    public CslOpenService(MainWindow mainWindow) {
        this.mainWindow = Objects.requireNonNull(mainWindow, "mainWindow");
    }

    public Result open(Path source, Target target) {
        try {
            CslCompiler.Result compiled = CslCompiler.compile(source);
            if (!compiled.ok()) return new Result(false, compiled.errors());
            if (target == Target.POPUP_WINDOW) {
                CslView.openPopupWindow(mainWindow, compiled.model(), source);
            } else {
                CslView.openUseDesktop(mainWindow, compiled.model(), source);
            }
            return new Result(true, List.of());
        } catch (IOException exception) {
            return new Result(false, List.of("cannot read '" + source + "': " + exception.getMessage()));
        }
    }
}
