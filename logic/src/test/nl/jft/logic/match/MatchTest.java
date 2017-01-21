package nl.jft.logic.match;

import nl.jft.logic.participant.Participant;
import nl.jft.logic.util.LogicTestUtil;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * @author Lesley
 */
public class MatchTest {

    @org.junit.Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void construct_nullFirstParticipant_throwsException() {
        expectedException.expect(NullPointerException.class);

        Match match = LogicTestUtil.makeMatch(null, LogicTestUtil.makeDefaultUser());
    }

    @Test
    public void construct_nullSecondParticipant_throwsException() {
        expectedException.expect(NullPointerException.class);

        Match match = LogicTestUtil.makeMatch(LogicTestUtil.makeDefaultUser(), null);
    }

    @Test
    public void getFirstParticipant_whenCalled_returnsFirstParticipant() {
        Match match = LogicTestUtil.makeDefaultMatch();

        Participant expected = LogicTestUtil.makeDefaultUser();
        Participant actual = match.getFirstParticipant();

        assertEquals(expected, actual);
    }

    @Test
    public void getSecondParticipant_whenCalled_returnsSecondParticipant() {
        Match match = LogicTestUtil.makeDefaultMatch();

        Participant expected = LogicTestUtil.makeDefaultUser();
        Participant actual = match.getSecondParticipant();

        assertEquals(expected, actual);
    }

}