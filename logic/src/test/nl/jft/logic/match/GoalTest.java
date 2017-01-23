package nl.jft.logic.match;

import nl.jft.logic.participant.Participant;
import nl.jft.logic.participant.impl.User;
import nl.jft.logic.util.LogicTestUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

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
    public void equals_sameObjects_returnsTrue() {
        Goal goal1 = LogicTestUtil.makeGoalWithUser();
        Goal goal2 = LogicTestUtil.makeGoalWithUser();

        boolean result = goal1.equals(goal2);
        assertTrue(result);
    }

    @Test
    public void equals_otherGoal_returnsFalse() throws Exception {
        Goal goal1 = LogicTestUtil.makeGoalWithUser();
        Goal goal2 = LogicTestUtil.makeGoalWithTeam();

        boolean result = goal1.equals(goal2);
        assertFalse(result);
    }

    @Test
    public void equals_otherObject_returnsFalse() {
        Goal goal1 = LogicTestUtil.makeGoalWithUser();
        String goal2 = "goal2";

        boolean result = goal1.equals(goal2);
        assertFalse(result);
    }

    @Test
    public void equals_nullObject_returnsFalse() {
        Goal goal1 = LogicTestUtil.makeGoalWithUser();
        Goal goal2 = null;

        boolean result = goal1.equals(goal2);
        assertFalse(result);
    }

    @Test
    public void hashCode_whenCalled_returnsHashCode() {
        User user1 = LogicTestUtil.makeDefaultUser();
        User user2 = LogicTestUtil.makeDefaultUser();

        boolean result = user1.hashCode() == user2.hashCode();
        assertTrue(result);
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