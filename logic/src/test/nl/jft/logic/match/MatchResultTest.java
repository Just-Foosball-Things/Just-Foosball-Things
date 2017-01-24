package nl.jft.logic.match;

import nl.jft.logic.LogicConstants;
import nl.jft.logic.util.LogicTestUtil;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * @author Lesley
 */
public class MatchResultTest {

    @org.junit.Rule
    public final ExpectedException expectedException = ExpectedException.none();

    public void construct_nullMatchOnly_throwsException() {
        expectedException.expect(NullPointerException.class);

        MatchResult result = LogicTestUtil.makeMatchResult(null);
    }

    @Test
    public void construct_nullMatch_throwsException() {
        expectedException.expect(NullPointerException.class);

        MatchResult result = LogicTestUtil.makeMatchResult(LogicConstants.INTERNAL_ID, null);
    }

    @Test
    public void equals_sameObjects_returnsTrue() {
        MatchResult result1 = LogicTestUtil.makeDefaultMatchResult();
        MatchResult result2 = LogicTestUtil.makeDefaultMatchResult();

        boolean result = result1.equals(result2);
        assertTrue(result);
    }

    @Test
    public void equals_otherInstance_returnsFalse() {
        MatchResult result1 = LogicTestUtil.makeDefaultMatchResult();
        MatchResult result2 = null;

        boolean result = result1.equals(result2);
        assertFalse(result);
    }

    @Test
    public void equals_differentIds_returnsFalse() {
        MatchResult result1 = LogicTestUtil.makeMatchResult(1, LogicTestUtil.makeDefaultMatch());
        MatchResult result2 = LogicTestUtil.makeMatchResult(2, LogicTestUtil.makeDefaultMatch());

        boolean result = result1.equals(result2);
        assertFalse(result);
    }

    @Test
    public void equals_differentMatches_returnsFalse() {
        Match firstMatch = LogicTestUtil.makeMatch(LogicTestUtil.makeDefaultUser(), LogicTestUtil.makeDefaultUser2());
        Match secondMatch = LogicTestUtil.makeMatch(LogicTestUtil.makeDefaultUser2(), LogicTestUtil.makeDefaultUser3());

        MatchResult result1 = LogicTestUtil.makeMatchResult(1, firstMatch);
        MatchResult result2 = LogicTestUtil.makeMatchResult(1, secondMatch);

        boolean result = result1.equals(result2);
        assertFalse(result);
    }

    @Test
    public void hashCode_whenCalled_returnsHashCode() {
        MatchResult matchResult1 = LogicTestUtil.makeDefaultMatchResult();
        MatchResult matchResult2 = LogicTestUtil.makeDefaultMatchResult();

        boolean result = matchResult1.hashCode() == matchResult2.hashCode();
        assertTrue(result);
    }

    @Test
    public void getId_whenCalled_returnsId() {
        MatchResult result = LogicTestUtil.makeDefaultMatchResult();

        int expected = LogicConstants.INTERNAL_ID;
        int actual = result.getId();

        assertEquals(expected, actual);
    }

    @Test
    public void getMatch_whenCalled_returnsMatch() {
        MatchResult result = LogicTestUtil.makeDefaultMatchResult();

        Match expected = LogicTestUtil.makeDefaultMatch();
        Match actual = result.getMatch();

        assertEquals(expected, actual);
    }

}