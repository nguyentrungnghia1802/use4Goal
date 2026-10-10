package org.vnu.sme.goal.dsl.aol;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.vnu.sme.goal.dsl.csl.parser.CslCompiler;
import org.vnu.sme.goal.translate.csl2use.Csl2UseTranslator;
import org.vnu.sme.goal.dsl.aol.parser.AolCompiler;
import org.vnu.sme.goal.translate.cslaol2soil.CslAol2SoilTranslator;

class AolAgentProfileTest {
    private static final Path BASE = Path.of("src/main/resources/examples/MultiLevelOrganization");

    @Test
    void abstractProfileStateIsEmittedOnAgentAndOccurrenceStateStaysOnRole() throws Exception {
        var csl = CslCompiler.compile(BASE.resolve("MultiLevelOrganization.csl"));
        var aol = AolCompiler.compile(BASE.resolve("MultiLevelOrganization.aol"));
        assertTrue(csl.ok(), () -> String.join("\n", csl.errors()));
        assertTrue(aol.ok(), () -> String.join("\n", aol.errors()));

        String use = Csl2UseTranslator.translate(csl.model());
        String soil = CslAol2SoilTranslator.transform(csl.model(), aol.model());

        assertTrue(use.contains("class Agent\nattributes\n  name : String\n  phone : String"));
        assertTrue(use.contains("abstract class Person\nend"));
        assertTrue(soil.contains("!set alice.name := 'Alice'"));
        assertTrue(soil.contains("!set alice.phone := '0999999'"));
        assertTrue(soil.contains("!set aliceMember.email := 'alice@example.org'"));
        assertTrue(soil.contains("!set aliceDepartmentParty.hasCalendar := true"));
    }

    @Test
    void profileAssociationBecomesAgentToAgentLink() throws Exception {
        Path mtg = Path.of("src/main/resources/examples/mtg");
        var csl = CslCompiler.compile(mtg.resolve("mtg.csl"));
        var aol = AolCompiler.compile(mtg.resolve("mtg.aol"));
        assertTrue(csl.ok(), () -> String.join("\n", csl.errors()));
        assertTrue(aol.ok(), () -> String.join("\n", aol.errors()));

        String use = Csl2UseTranslator.translate(csl.model());
        String soil = CslAol2SoilTranslator.transform(csl.model(), aol.model());
        assertTrue(use.contains("association knowsPhoneOf between\n  Agent[0..*]"));
        assertTrue(soil.contains("!insert (bob, alice) into knowsPhoneOf"));
        assertTrue(soil.contains("!insert (bob, carol) into knowsPhoneOf"));
        assertTrue(soil.contains("!set architectureReview.detailsDecided := false"));
    }
}
