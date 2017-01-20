package nl.jft.logic.match;

import nl.jft.logic.participant.Participant;
import nl.jft.logic.util.LogicTestUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDateTime;

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

        Participant participant = LogicTestUtil.makeDefaultUser();
        Goal goal = new Goal(0, participant, null);
    }

    @Test
    public void getId_whenCalled_returnsId() {
        Goal goal = LogicTestUtil.makeGoalWithUser(); // Default id = 0.

        int expected = -1;
        int actual = goal.getId();

        assertEquals(expected, actual);
    }

    @Test
    public void getParticipant_nullParticipant_returnsNull() {
        Goal goal = LogicTestUtil.makeGoalNoParticipant();

        Participant expected = null;
        Participant actual = goal.getParticipant();

        assertEquals(expected, actual);
    }

    @Test
    public void getParticipant_userParticipant_returnsUser() {
        Goal goal = LogicTestUtil.makeGoalWithUser();

        Participant expected = LogicTestUtil.makeDefaultUser();
        Participant actual = goal.getParticipant();

        assertEquals(expected, actual);
    }

    @Test
    public void getParticipant_teamParticipant_returnsTeam() {
        Goal goal = LogicTestUtil.makeGoalWithTeam();

        Participant expected = LogicTestUtil.makeDefaultTeam();
        Participant actual = goal.getParticipant();

        assertEquals(expected, actual);
    }

    @Test
    public void getTime_whenCalled_returnsTime() {
        Goal goal = LogicTestUtil.makeGoalNoParticipant();

        LocalDateTime expected = LogicTestUtil.makeDefaultLocalDateTime();
        LocalDateTime actual = goal.getTime();

        assertEquals(expected, actual);
    }

}