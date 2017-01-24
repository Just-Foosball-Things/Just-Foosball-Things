package nl.jft.logic.participant;

import nl.jft.logic.LogicConstants;
import nl.jft.logic.util.LogicTestUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * @author Lesley
 */
public class EloTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void construct_negativeRatingOnly_throwsException() {
        expectedException.expect(IllegalArgumentException.class);

        Elo elo = LogicTestUtil.makeElo(-1);
    }

    @Test
    public void construct_negativeRating_throwsException() {
        expectedException.expect(IllegalArgumentException.class);

        Elo elo = LogicTestUtil.makeElo(LogicConstants.INTERNAL_ID, -1, LogicTestUtil.makeDefaultLocalDateTime());
    }

    @Test
    public void construct_negativeTime_throwsException() {
        expectedException.expect(NullPointerException.class);

        Elo elo = LogicTestUtil.makeElo(LogicConstants.INTERNAL_ID, 1500, null);
    }


    @Test
    public void equals_sameObjects_returnsTrue() {
        Elo elo1 = LogicTestUtil.makeDefaultElo();
        Elo elo2 = LogicTestUtil.makeDefaultElo();

        boolean result = elo1.equals(elo2);
        assertTrue(result);
    }

    @Test
    public void equals_otherInstance_returnsFalse() {
        Elo elo1 = LogicTestUtil.makeDefaultElo();
        Elo elo2 = null;

        boolean result = elo1.equals(elo2);
        assertFalse(result);
    }

    @Test
    public void equals_differentIds_returnsFalse() {
        Elo elo1 = LogicTestUtil.makeElo(1, 1500, LogicTestUtil.makeDefaultLocalDateTime());
        Elo elo2 = LogicTestUtil.makeElo(2, 1500, LogicTestUtil.makeDefaultLocalDateTime());

        boolean result = elo1.equals(elo2);
        assertFalse(result);
    }

    @Test
    public void equals_differentRatings_returnsFalse() {
        Elo elo1 = LogicTestUtil.makeElo(1, 1500, LogicTestUtil.makeDefaultLocalDateTime());
        Elo elo2 = LogicTestUtil.makeElo(1, 1600, LogicTestUtil.makeDefaultLocalDateTime());

        boolean result = elo1.equals(elo2);
        assertFalse(result);
    }

    @Test
    public void equals_differentTimes_returnsFalse() {
        Elo elo1 = LogicTestUtil.makeElo(1, 1500, LocalDateTime.MIN);
        Elo elo2 = LogicTestUtil.makeElo(1, 1500, LocalDateTime.MAX);

        boolean result = elo1.equals(elo2);
        assertFalse(result);
    }

    @Test
    public void hashCode_whenCalled_returnsHashCode() {
        Elo elo1 = LogicTestUtil.makeDefaultElo();
        Elo elo2 = LogicTestUtil.makeDefaultElo();

        boolean result = elo1.hashCode() == elo2.hashCode();
        assertTrue(result);
    }

    @Test
    public void getId_whenCalled_returnsId() {
        Elo elo = LogicTestUtil.makeDefaultElo();

        int expected = LogicConstants.INTERNAL_ID;
        int actual = elo.getId();

        assertEquals(expected, actual);
    }

    @Test
    public void getRating_whenCalled_returnsRating() {
        Elo elo = LogicTestUtil.makeDefaultElo();

        double expected = 1500d;
        double actual = elo.getRating();

        assertEquals(expected, actual, 0.0000001d);
    }

    @Test
    public void getTime_whenCalled_returnsTime() {
        Elo elo = LogicTestUtil.makeDefaultElo();

        LocalDateTime expected = LogicConstants.INTERNAL_DATETIME;
        LocalDateTime actual = elo.getTime();

        assertEquals(expected, actual);
    }

}