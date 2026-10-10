package org.vnu.sme.goal.normml;

import java.nio.file.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.vnu.sme.goal.dsl.normml.parser.NormCompiler;
import org.vnu.sme.goal.dsl.normml.parser.NormMLParser;
import org.vnu.sme.goal.dsl.normml.view.NormView;

class NormCompilerTest {
    private String example() throws Exception {return Files.readString(Path.of("src/test/resources/normml/all-norm-kinds.normml"));}
    private void rejected(String source,String text) {
        var r=NormCompiler.compile(source,"test.normml");assertFalse(r.ok());assertNull(r.model());
        assertTrue(r.errors().stream().anyMatch(s->s.contains(text)),r.errors().toString());
    }
    @Test void compilesAllNormKindsAndResolvesInverseContainment() throws Exception {
        var r=NormCompiler.compile(example());assertTrue(r.ok(),r.errors().toString());
        assertEquals("proposal",r.model().element("update").value("resource"));
        assertEquals("review",r.model().element("active").value("norm"));
        assertEquals("review",r.model().element("reward").value("sanctionedNorms"));
        assertEquals("OCL",r.model().element("editable").value("condLang"));
        System.setProperty("use.gui.view.classdiagram.class.minheight", "20");
        System.setProperty("use.gui.view.classdiagram.class.minwidth", "20");
        javax.swing.SwingUtilities.invokeAndWait(()-> {
            var view = new NormView(r.model());
            assertNotNull(view);
            view.detachModel();
        });
    }
    @Test void rejectsMissingAndWrongTypeReferences() throws Exception {
        rejected(example().replace("organization: @reviewOffice","organization: @missing"),"Unknown reference");
        rejected(example().replace("organization: @reviewOffice","organization: @Boolean"),"expects Organization");
    }
    @Test void rejectsSyntaxAndUnknownFeatures() throws Exception {
        rejected(example().replace("type: Reward;","type: Reward"),"syntax");
        rejected(example().replace("type: Reward;","unknown: Reward;"),"syntax");
    }
    @Test void rejectsEnumAndActionMismatch() throws Exception {
        rejected(example().replace("AtomicRead","Flying"),"syntax");
        rejected(example().replace("AtomicRead","AtomicSend"),"incompatible");
    }
    @Test void rejectsContainmentAndMissingSubject() throws Exception {
        rejected(example().replace("condition: @editable","condition: @ready"),"Multiple containment");
        rejected(example().replace("roles: [@manager]; access:","access:"),"requires a subject");
    }
    @Test void rejectsCyclesAndTimeBoundaryErrors() throws Exception {
        rejected(example().replace("subordinateActions: [@read, @update]","subordinateActions: [@fullAccess]"),"cycle");
        rejected(example().replace("Organization reviewOffice {","Organization reviewOffice { parent: @reviewOffice;"),"cycle");
        rejected(example().replace("endDate: @end","endDate: @start"),"date boundaries must differ");
    }
    @Test void rejectsMalformedOclAndUnsupportedLanguage() throws Exception {
        rejected(example().replace("self.proposal.validated = false","self.proposal.validated ="),"OCL:");
        rejected(example().replace("Condition editable {","Condition editable { condLang: SQL;"),"Unsupported condition language");
    }
    @Test void rejectsDuplicateDeclarationsPropertiesAndUncontainedObjects() throws Exception {
        rejected(example().replace("DataType Boolean { }","DataType Boolean { } DataType Boolean { }"),"Duplicate or reserved");
        rejected(example().replace("kind: AtomicRead;","kind: AtomicRead; kind: AtomicUpdate;"),"Duplicate feature");
        rejected(example().replace("Condition editable {","Condition orphan { condExpr: \"true\"; } Condition editable {"),"Uncontained");
    }
    @Test void supportsCommentsEscapesAndForwardReferences() {
        var r=NormCompiler.compile("normml Empty { // comment\n Organization org { name: \"A\\\"B\"; } /* end */ }");
        assertTrue(r.ok(),r.errors().toString());assertEquals("A\"B",r.model().element("org").value("name"));
    }

    @Test void generatedParserHasDedicatedRuleForEveryConcreteEcoreClass() throws Exception {
        var rules = java.util.Set.of(NormMLParser.ruleNames);
        assertTrue(rules.containsAll(java.util.Set.of(
                "organizationDecl", "agentDecl", "roleDecl", "dataTypeDecl",
                "entityResourceDecl", "attributeResourceDecl", "associationEndResourceDecl",
                "agentActionDecl", "messageResourceDecl", "atomicActionDecl",
                "compositeActionDecl", "normDecl", "beforeDecl", "afterDecl",
                "betweenDecl", "ifDecl", "dateDecl", "sanctionDecl", "conditionDecl")));
        rejected(example().replace("Organization reviewOffice", "Unknown reviewOffice"), "syntax");
    }
}
