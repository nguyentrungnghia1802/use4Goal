package org.vnu.sme.goal.feature.opennormml;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

import org.tzi.use.gui.main.MainWindow;
import org.vnu.sme.goal.dsl.normml.parser.NormCompiler;
import org.vnu.sme.goal.dsl.normml.view.NormView;

/** Application boundary for the Norm View Model use case. */
public final class NormMLOpenService {
    public enum Target { USE_DESKTOP, POPUP_WINDOW }
    public record Result(boolean opened, List<String> errors) {
        public Result { errors = List.copyOf(errors); }
    }

    private final MainWindow mainWindow;

    public NormMLOpenService(MainWindow mainWindow) {
        this.mainWindow = Objects.requireNonNull(mainWindow, "mainWindow");
    }

    public Result open(Path source, Target target) {
        try {
            NormCompiler.Result compiled = NormCompiler.compile(source);
            if (!compiled.ok()) return new Result(false, compiled.errors());
            if (target == Target.POPUP_WINDOW) {
                NormView.openPopupWindow(mainWindow, compiled.model(), source);
            } else {
                NormView.openUseDesktop(mainWindow, compiled.model(), source);
            }
            return new Result(true, List.of());
        } catch (IOException exception) {
            return new Result(false, List.of("cannot read '" + source + "': " + exception.getMessage()));
        }
    }
}
