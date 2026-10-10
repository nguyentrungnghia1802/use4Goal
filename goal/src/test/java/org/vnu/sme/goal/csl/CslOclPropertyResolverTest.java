package org.vnu.sme.goal.dsl.csl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.vnu.sme.goal.dsl.csl.parser.CslCompiler;
import org.vnu.sme.goal.dsl.csl.ocl.CslOclPropertyResolver;

class CslOclPropertyResolverTest {

    private static final String MEETING_CSL = """
            csl v2.0 MeetingSchedulerShadow {
              role MeetingParty { phone : String; hasCalendar : Boolean; }
              role Secretary extends MeetingParty;
              role Participant extends MeetingParty { timetableCollected : Boolean; }
              association knowsPhoneOf {
                MeetingParty [*] role knower;
                MeetingParty [*] role knownContact;
              }
              group MeetingUnit {
                detailsDecided : Boolean;
                Secretary [0..1];
                Participant [2..*];
              }
            }
            """;

    @Test
    void rewritesReadableCslNavigationWithoutExposingUseAssociationEnds() throws Exception {
        CslCompiler.Result compiled = CslCompiler.compile(MEETING_CSL);
        assertTrue(compiled.ok(), () -> String.join("\n", compiled.errors()));

        String source = """
                self.group.detailsDecided and
                self.group.Participant->forAll(participant |
                  participant.phone <> '' and
                  self.knownContact->includes(participant))
                """;
        String rewritten = CslOclPropertyResolver.rewrite(
                compiled.model(), "Secretary", Map.of("participant", "Participant"), source);

        assertTrue(rewritten.contains("self.meetingUnit.detailsDecided"));
        assertTrue(rewritten.contains("self.meetingUnit.participant"));
        assertTrue(rewritten.contains("participant.meetingParty.phone"), rewritten);
        assertTrue(rewritten.contains("self.meetingParty.knownContact"), rewritten);
        assertFalse(rewritten.contains(".group"));
        assertFalse(rewritten.contains(".agent"));
    }

    @Test
    void contextualRoleFacadeMakesAgentProfileNavigationTransparent() throws Exception {
        CslCompiler.Result compiled = CslCompiler.compile(MEETING_CSL);
        assertTrue(compiled.ok(), () -> String.join("\n", compiled.errors()));

        String rewritten = CslOclPropertyResolver.rewrite(compiled.model(), "Secretary",
                Map.of("participant", "Participant"), """
                self.knownContact->includes(participant) and
                participant.phone <> '' and
                not participant.hasCalendar and
                not participant.timetableCollected
                """);

        assertTrue(rewritten.contains("self.meetingParty.knownContact"));
        assertTrue(rewritten.contains("includes(participant.meetingParty)"));
        assertTrue(rewritten.contains("participant.meetingParty.phone"));
        assertTrue(rewritten.contains("participant.meetingParty.hasCalendar"));
        assertTrue(rewritten.contains("participant.timetableCollected"),
                "a concrete role-occurrence attribute must not be projected to Agent");
    }
}
