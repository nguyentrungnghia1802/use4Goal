package org.vnu.sme.goal.feature.opennormml;

import java.util.Objects;

import javax.swing.JDialog;
import javax.swing.SwingUtilities;

import org.tzi.use.gui.main.MainWindow;
import org.tzi.use.runtime.gui.IPluginAction;
import org.tzi.use.runtime.gui.IPluginActionDelegate;
public final class ActionOpenNormML implements IPluginActionDelegate {

    @Override
    public void performAction(IPluginAction pluginAction) {
        Objects.requireNonNull(pluginAction, "pluginAction");
        MainWindow mainWindow = pluginAction.getParent();
        Runnable openNormML = () -> openNormMLForm(mainWindow);
        if (SwingUtilities.isEventDispatchThread()) openNormML.run();
        else SwingUtilities.invokeLater(openNormML);
    }

    private static void openNormMLForm(MainWindow mainWindow) {
        NormMLForm form = new NormMLForm(mainWindow, new NormMLOpenService(mainWindow));
        form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        form.setResizable(true);
        form.setLocationRelativeTo(mainWindow);
        form.setVisible(true);
    }
}
