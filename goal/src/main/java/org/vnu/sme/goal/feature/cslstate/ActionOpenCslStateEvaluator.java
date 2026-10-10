package org.vnu.sme.goal.feature.cslstate;

import java.util.Objects;

import javax.swing.JDialog;
import javax.swing.SwingUtilities;

import org.tzi.use.gui.main.MainWindow;
import org.tzi.use.runtime.gui.IPluginAction;
import org.tzi.use.runtime.gui.IPluginActionDelegate;

/** Opens bounded goal-process conformance checking over CSL states. */
public final class ActionOpenCslStateEvaluator implements IPluginActionDelegate {
    @Override
    public void performAction(IPluginAction pluginAction) {
        Objects.requireNonNull(pluginAction, "pluginAction");
        MainWindow mainWindow = pluginAction.getParent();
        Runnable open = () -> {
            CslStateEvaluatorForm form = new CslStateEvaluatorForm(mainWindow);
            form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            form.setLocationRelativeTo(mainWindow);
            form.setVisible(true);
        };
        if (SwingUtilities.isEventDispatchThread()) open.run();
        else SwingUtilities.invokeLater(open);
    }
}
