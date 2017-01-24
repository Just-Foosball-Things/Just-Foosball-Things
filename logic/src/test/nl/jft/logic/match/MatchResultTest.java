package nl.jft.logic.match;

import nl.jft.logic.util.LogicTestUtil;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Lesley
 */
public class MatchResultTest {

    @Test
    public void equals_sameObjects_returnsTrue() {
        MatchResult matchResult1 = LogicTestUtil.makeDefaultMatchResult();
        MatchResult matchResult2 = LogicTestUtil.makeDefaultMatchResult();

        boolean result = matchResult1.equals(matchResult2);
        assertTrue(result);
    }

    @Test
    public void equals_otherMatchResult_returnsFalse() throws Exception {
        MatchResult matchResult1 = LogicTestUtil.makeDefaultMatchResult();
        MatchResult matchResult2 = LogicTestUtil.makeMatchResult(-1, LogicTestUtil.makeMatch(LogicTestUtil.makeDefaultUser(), LogicTestUtil.makeDefaultTeam()));

        boolean result = matchResult1.equals(matchResult2);
        assertFalse(result);
    }

    @Test
    public void equals_otherObject_returnsFalse() {
        MatchResult matchResult1 = LogicTestUtil.makeDefaultMatchResult();
        String matchResult2 = "matchResult2";

        boolean result = matchResult1.equals(matchResult2);
        assertFalse(result);
    }

    @Test
    public void equals_nullObject_returnsFalse() {
        MatchResult matchResult1 = LogicTestUtil.makeDefaultMatchResult();
        MatchResult matchResult2 = null;

        boolean result = matchResult1.equals(matchResult2);
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

        int expected = -1;
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