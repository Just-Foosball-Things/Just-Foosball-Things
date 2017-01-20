package nl.jft.logic.match;

import nl.jft.logic.participant.Participant;
import nl.jft.logic.participant.impl.User;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;

/**
 * @author Lesley
 */
public class GoalTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void construct_nullTime_throwsException() {
        expectedException.expect(NullPointerException.class);

        Participant participant = makeUser();
        Goal goal = new Goal(0, participant, null);
    }

    @Test
    public void getId_whenCalled_returnsId() {
        Goal goal = makeGoalWithUser(); // Default id = 0.

        int expected = 0;
        int actual = goal.getId();

        assertEquals(expected, actual);
    }

    @Test
    public void getParticipant_nullParticipant_returnsNull() {
        Goal goal = makeGoalNoParticipant();

        Participant expected = null;
        Participant actual = goal.getParticipant();

        assertEquals(expected, actual);
    }

    @Test
    public void getParticipant_userParticipant_returnsUser() {
        Goal goal = makeGoalWithUser();

        Participant expected = new User("username");
        Participant actual = goal.getParticipant();

        assertEquals(expected, actual);
    }

    private Goal makeGoalNoParticipant() {
        return new Goal(0, null, makeLocalDateTime());
    }

    private Goal makeGoalWithUser() {
        return new Goal(0, makeUser(), makeLocalDateTime());
    }

    private Participant makeUser() {
        return new User("username");
    }

    private LocalDateTime makeLocalDateTime() {
        return LocalDateTime.of(2017, Month.JANUARY, 1, 12, 1, 1);
    }

}