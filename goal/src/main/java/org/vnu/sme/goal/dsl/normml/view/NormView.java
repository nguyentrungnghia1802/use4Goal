package org.vnu.sme.goal.dsl.normml.view;

import java.awt.*;
import java.nio.file.Path;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import org.tzi.use.gui.main.MainWindow;
import org.tzi.use.gui.main.ViewFrame;
import org.tzi.use.gui.views.View;
import org.vnu.sme.goal.dsl.normml.mm.*;

/** Inspect compiled declarations and all local relations without modifying the USE session. */
public final class NormView extends JPanel implements View {
    private NormDiagram diagram;
    private NormDiagram createDiagram(NormModel model, Path source) {
        diagram = new NormDiagram(new java.io.PrintWriter(System.out, true));
        if (source != null) diagram.setSourceFile(source);
        diagram.setModel(model);
        if (source != null) diagram.loadDefaultLayout();
        return diagram;
    }
    public NormView(NormModel model) { this(model, null); }
    private NormView(NormModel model, Path source) {
        super(new BorderLayout());
        var tabs=new JTabbedPane();
        tabs.addTab("Diagram",new JScrollPane(createDiagram(model, source)));
        var root=new DefaultMutableTreeNode(model.name());
        for (var e:model.elements().values()) {
            if (e.type().equals("NormModel")) continue;
            var n=new DefaultMutableTreeNode(e);
            e.values().forEach((key,value)->n.add(new DefaultMutableTreeNode(key+" : "+String.join(", ",value))));
            root.add(n);
        }
        var sourceArea=new JTextArea(model.source());sourceArea.setEditable(false);
        sourceArea.setFont(new Font(Font.MONOSPACED,Font.PLAIN,13));sourceArea.setCaretPosition(0);
        tabs.addTab("Specification",new JScrollPane(sourceArea));
        var split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,new JScrollPane(new JTree(root)),tabs);
        split.setDividerLocation(280);add(split);
    }
    public static void openUseDesktop(MainWindow parent,NormModel model,Path path) {
        var view=new NormView(model, path);var frame=new ViewFrame("NormML — "+path.getFileName(),view,"Diagram.gif");
        frame.getContentPane().add(view,BorderLayout.CENTER);parent.addNewViewFrame(frame);frame.setSize(1100,750);
    }
    public static void openPopupWindow(MainWindow parent,NormModel model,Path path) {
        var frame=new JFrame("NormML — "+path.getFileName());frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var view = new NormView(model, path); frame.setContentPane(view);frame.setSize(1100,750);frame.setLocationRelativeTo(parent);frame.setVisible(true);
    }
    @Override public void detachModel() { diagram.stopLayoutThread(); }
}
