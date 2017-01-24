package nl.jft.logic.participant;

import nl.jft.logic.util.LogicTestUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

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