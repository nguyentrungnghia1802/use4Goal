package org.vnu.sme.goal.dsl.normml.view;

import java.awt.Dimension;
import java.awt.Font;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.AbstractAction;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;

import com.ximpleware.AutoPilot;
import com.ximpleware.NavException;
import com.ximpleware.XPathEvalException;
import com.ximpleware.XPathParseException;
import org.tzi.use.gui.util.PersistHelper;
import org.tzi.use.gui.views.diagrams.DiagramGraph;
import org.tzi.use.gui.views.diagrams.DiagramView;
import org.tzi.use.gui.views.diagrams.elements.PlaceableNode;
import org.tzi.use.gui.views.diagrams.elements.edges.EdgeBase;
import org.tzi.use.gui.views.diagrams.elements.edges.BinaryAssociationOrLinkEdge;
import org.tzi.use.gui.views.diagrams.event.ActionLoadLayout;
import org.tzi.use.gui.views.diagrams.event.ActionSaveLayout;
import org.tzi.use.gui.views.diagrams.event.DiagramInputHandling;
import org.vnu.sme.goal.dsl.normml.mm.NormModel;
import org.w3c.dom.Element;

@SuppressWarnings("serial")
public final class NormDiagram extends DiagramView {
    private final Map<String, PlaceableNode> nodeMap = new LinkedHashMap<>();
    private final DiagramInputHandling inputHandling;
    private NormModel model;
    private NormUseViewModel useViewModel;
    private Path sourceFile;
    private String switchActionLabel;
    private Runnable switchAction;

    public NormDiagram(PrintWriter log) {
        super(new NormDiagramOptions(), log);
        inputHandling = new DiagramInputHandling(fNodeSelection, fEdgeSelection, this);
        addMouseListener(inputHandling);
        addKeyListener(inputHandling);
        setFocusable(true);
        fActionSaveLayout = new ActionSaveLayout("USE NormML layout", "dlt", this);
        fActionLoadLayout = new ActionLoadLayout("USE NormML layout", "dlt", this);
        getOptions().setDoAntiAliasing(true);
        getOptions().setShowAssocNames(false);
    }

    @Override
    public NormDiagramOptions getOptions() {
        return (NormDiagramOptions) fOpt;
    }

    public void setSwitchAction(String label, Runnable action) {
        this.switchActionLabel = label;
        this.switchAction = action;
    }

    public void setSourceFile(Path sourceFile) {
        this.sourceFile = sourceFile;
        if (sourceFile != null) {
            fOpt = new NormDiagramOptions(sourceFile);
            fActionSaveLayout = new ActionSaveLayout("USE NormML layout", "dlt", this);
            fActionLoadLayout = new ActionLoadLayout("USE NormML layout", "dlt", this);
            getOptions().setDoAntiAliasing(true);
        getOptions().setShowAssocNames(false);
        }
    }

    public void setModel(NormModel model) {
        this.model = model;
        rebuild();
    }/**
 * WHY: Diagram geometry is mutually dependent; rebuild computes the connected
 * positions together to avoid overlaps and unstable results from piecemeal updates.
 */


    private void rebuild() {
        nodeMap.clear();
        fGraph = new DiagramGraph();
        if (model == null) {
            repaint();
            return;
        }
        useViewModel = NormUseViewModel.build(model);
        int[] rows = new int[5];
        for (var element : model.elements().values()) {
            if (element.type().equals("NormModel")) continue;
            int column = switch (element.type()) {
                case "Organization", "Role", "Agent" -> 0;
                case "AgentAction", "EntityResource", "AttributeResource", "MessageResource", "AssociationEndResource", "DataType" -> 1;
                case "AtomicAction", "CompositeAction" -> 2;
                case "Norm" -> 3;
                default -> 4;
            };
            var node = new NormClassNode(useViewModel.classes.get(element.id()), element, getOptions());
            node.setPosition(40 + column * 350, 40 + rows[column]++ * 180);
            nodeMap.put(element.id(), node);
            fGraph.add(node);
        }
        setPreferredSize(new Dimension(1850, Math.max(800, java.util.Arrays.stream(rows).max().orElse(0) * 180 + 80)));
        for (var link : useViewModel.links) {
            var ends = link.association().associationEnds().iterator();
            var edge = BinaryAssociationOrLinkEdge.create(nodeMap.get(link.source()), nodeMap.get(link.target()),
                    ends.next(), ends.next(), this, link.association());
            fGraph.addEdge(edge);
        }
        initialize();
        applyNormRoleNames();
        invalidateContent(true);
        revalidate();
        repaint();
    }

    /**
     * USE cannot paint a navigable association end whose role name is empty.
     * A NormML reference without an EOpposite therefore keeps a nonempty
     * internal name and hides that synthetic source label. Reapply this after
     * loading old layouts because whitespace-only labels were persisted as
     * empty XML elements by earlier plugin builds.
     */
    private void applyNormRoleNames() {
        for (var edge : fGraph.getEdges()) {
            if (edge instanceof BinaryAssociationOrLinkEdge binary) {
                for (var link : useViewModel.links) if (link.association().name().equals(edge.getName())) {
                    boolean hasSourceRole = !link.sourceRole().isBlank();
                    binary.getSourceRolename().setName(hasSourceRole ? link.sourceRole() : "source");
                    binary.getSourceRolename().setVisible(hasSourceRole);
                    binary.getTargetRolename().setName(
                            link.targetRole().isBlank() ? "target" : link.targetRole());
                }
            }
        }
    }

    @Override
    protected PopupMenuInfo unionOfPopUpMenu() {
        // Preserve the complete USE DiagramView popup (attributes, association names,
        // role names, alignment, grid, anti-aliasing, grayscale and every layout).
        // NormML contributes only its own navigation command.
        PopupMenuInfo popupInfo = super.unionOfPopUpMenu();
        JPopupMenu popupMenu = popupInfo.popupMenu;

        // Multiplicity is a ClassDiagram-specific addition in USE (not part of the
        // DiagramView base popup), but NormML uses the same binary association edge.
        JCheckBoxMenuItem multiplicities = new JCheckBoxMenuItem("Show multiplicities");
        multiplicities.setState(getOptions().isShowMutliplicities());
        multiplicities.addItemListener(event -> {
            getOptions().setShowMutliplicities(event.getStateChange() == java.awt.event.ItemEvent.SELECTED);
            invalidateContent(true);
        });
        popupMenu.insert(multiplicities, popupInfo.generalShowHideStart + 2);
        popupInfo.generalShowHideLength++;

        if (switchAction != null && switchActionLabel != null) {
            popupMenu.addSeparator();
            popupMenu.add(new AbstractAction(switchActionLabel) {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    switchAction.run();
                }
            });
        }
        return popupInfo;
    }

    @Override
    public Set<? extends PlaceableNode> getHiddenNodes() {
        return Collections.emptySet();
    }

    @Override
    public void storePlacementInfos(PersistHelper helper, Element rootElement) {
        for (PlaceableNode node : nodeMap.values()) {
            node.storePlacementInfo(helper, rootElement, false);
        }
        for (EdgeBase edge : fGraph.getEdges()) {
            edge.storePlacementInfo(helper, rootElement, false);
        }
    }

    @Override
    public void restorePlacementInfos(PersistHelper helper, int version) {
        helper.getNav().push();
        AutoPilot ap = new AutoPilot(helper.getNav());
        try {
            ap.selectXPath("./edge[@type='BinaryEdge']");
            while (ap.evalXPath() != -1) {
                String name = helper.getElementStringValue("name");
                for (EdgeBase edge : fGraph.getEdges()) {
                    if (edge.getName().equals(name)) edge.restorePlacementInfo(helper, version);
                }
            }
            ap.resetXPath();
            ap.selectXPath("./node");
            while (ap.evalXPath() != -1) {
                String name = helper.getElementStringValue("name");
                PlaceableNode node = nodeMap.get(name);
                if (node != null) {
                    node.restorePlacementInfo(helper, version);
                    invalidateNode(node);
                }
            }
        } catch (XPathParseException | XPathEvalException | NavException ex) {
            fLog.append(ex.getMessage()).append('\n');
        } finally {
            ap.resetXPath();
            helper.getNav().pop();
        }
        applyNormRoleNames();
    }

    @Override
    public void showAll() {}

    @Override
    public void hideAll() {
        throw new UnsupportedOperationException("NormML diagram does not support hiding all nodes.");
    }

    @Override
    public DiagramData getVisibleData() {
        return new DiagramData() {
            @Override public Set<PlaceableNode> getNodes() { return new java.util.LinkedHashSet<>(fGraph.getNodes()); }
            @Override public Set<EdgeBase> getEdges() { return Collections.unmodifiableSet(fGraph.getEdges()); }
            @Override public boolean hasNodes() { return !fGraph.isEmpty(); }
        };
    }

    @Override
    public DiagramData getHiddenData() {
        return new DiagramData() {
            @Override public Set<PlaceableNode> getNodes() { return Collections.emptySet(); }
            @Override public Set<EdgeBase> getEdges() { return Collections.emptySet(); }
            @Override public boolean hasNodes() { return false; }
        };
    }

    @Override
    public void resetLayout() {
        setModel(model);
    }

    @Override
    protected String getDefaultLayoutFileSuffix() {
        String name = sourceFile == null ? (model == null ? "normml" : model.name()) : sourceFile.getFileName().toString();
        return "_" + name + "_default.dlt";
    }
}
