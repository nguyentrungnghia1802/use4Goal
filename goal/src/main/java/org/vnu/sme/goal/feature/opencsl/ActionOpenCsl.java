package org.vnu.sme.goal.feature.opencsl;

import java.util.Objects;

import javax.swing.JDialog;
import javax.swing.SwingUtilities;

import org.tzi.use.gui.main.MainWindow;
import org.tzi.use.runtime.gui.IPluginAction;
import org.tzi.use.runtime.gui.IPluginActionDelegate;
public final class ActionOpenCsl implements IPluginActionDelegate {

    @Override
    public void performAction(IPluginAction pluginAction) {
        Objects.requireNonNull(pluginAction, "pluginAction");
        MainWindow mainWindow = pluginAction.getParent();
        Runnable openCsl = () -> openCslForm(mainWindow);
        if (SwingUtilities.isEventDispatchThread()) openCsl.run();
        else SwingUtilities.invokeLater(openCsl);
    }

    private static void openCslForm(MainWindow mainWindow) {
        CslForm form = new CslForm(mainWindow, new CslOpenService(mainWindow));
        form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        form.setResizable(true);
        form.setLocationRelativeTo(mainWindow);
        form.setVisible(true);
    }
}
