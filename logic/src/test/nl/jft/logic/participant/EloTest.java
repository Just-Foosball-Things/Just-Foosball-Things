package nl.jft.logic.participant;

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
    public void construct_negativeRating_throwsException() {
        expectedException.expect(IllegalArgumentException.class);

        Elo elo = LogicTestUtil.makeElo(-1, -1, LogicTestUtil.makeDefaultLocalDateTime());
    }

    @Test
    public void construct_negativeTime_throwsException() {
        expectedException.expect(NullPointerException.class);

        Elo elo = LogicTestUtil.makeElo(-1, 1500, null);
    }

    @Test
    public void equals_sameObjects_returnsTrue() {
        Elo Elo1 = LogicTestUtil.makeDefaultElo();
        Elo Elo2 = LogicTestUtil.makeDefaultElo();

        boolean result = Elo1.equals(Elo2);
        assertTrue(result);
    }

    @Test
    public void equals_otherElo_returnsFalse() throws Exception {
        Elo Elo1 = LogicTestUtil.makeDefaultElo();
        Elo Elo2 = LogicTestUtil.makeElo(-1, 2000, LogicTestUtil.makeDefaultLocalDateTime());

        boolean result = Elo1.equals(Elo2);
        assertFalse(result);
    }

    @Test
    public void equals_otherObject_returnsFalse() {
        Elo Elo1 = LogicTestUtil.makeDefaultElo();
        String Elo2 = "Elo2";

        boolean result = Elo1.equals(Elo2);
        assertFalse(result);
    }

    @Test
    public void equals_nullObject_returnsFalse() {
        Elo Elo1 = LogicTestUtil.makeDefaultElo();
        Elo Elo2 = null;

        boolean result = Elo1.equals(Elo2);
        assertFalse(result);
    }

    @Test
    public void hashCode_whenCalled_returnsHashCode() {
        Elo Elo1 = LogicTestUtil.makeDefaultElo();
        Elo Elo2 = LogicTestUtil.makeDefaultElo();

        boolean result = Elo1.hashCode() == Elo2.hashCode();
        assertTrue(result);
    }

    @Test
    public void getId_whenCalled_returnsId() {
        Elo elo = LogicTestUtil.makeDefaultElo();

        int expected = -1;
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

        LocalDateTime expected = LogicTestUtil.makeDefaultLocalDateTime();
        LocalDateTime actual = elo.getTime();

        assertEquals(expected, actual);
    }

}