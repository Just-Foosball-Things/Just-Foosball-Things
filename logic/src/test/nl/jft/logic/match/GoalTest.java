package nl.jft.logic.match;

import nl.jft.logic.LogicConstants;
import nl.jft.logic.participant.Participant;
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
    public void construct_nullTimeOnly_throwsException() {
        expectedException.expect(NullPointerException.class);

        Participant participant = LogicTestUtil.makeDefaultUser();
        Goal goal = LogicTestUtil.makeGoal(participant, null);
    }

    @Test
    public void construct_nullTime_throwsException() {
        expectedException.expect(NullPointerException.class);

        Participant participant = LogicTestUtil.makeDefaultUser();
        Goal goal = LogicTestUtil.makeGoal(LogicConstants.INTERNAL_ID, participant, null);
    }

    @Test
    public void equals_sameObjects_returnsTrue() {
        Goal goal1 = LogicTestUtil.makeGoalWithTeam();
        Goal goal2 = LogicTestUtil.makeGoalWithTeam();

        boolean result = goal1.equals(goal2);
        assertTrue(result);
    }

    @Test
    public void equals_otherInstance_returnsFalse() {
        Goal goal1 = LogicTestUtil.makeGoalWithTeam();
        Goal goal2 = null;

        boolean result = goal1.equals(goal2);
        assertFalse(result);
    }

    @Test
    public void equals_nullFirstParticipant_returnsFalse() {
        Goal goal1 = LogicTestUtil.makeGoal(null, LogicTestUtil.makeDefaultLocalDateTime());
        Goal goal2 = LogicTestUtil.makeGoalWithUser();

        boolean result = goal1.equals(goal2);
        assertFalse(result);
    }

    @Test
    public void equals_nullSecondParticipant_returnsFalse() {
        Goal goal1 = LogicTestUtil.makeGoalWithUser();
        Goal goal2 = LogicTestUtil.makeGoal(null, LogicTestUtil.makeDefaultLocalDateTime());

        boolean result = goal1.equals(goal2);
        assertFalse(result);
    }

    @Test
    public void equals_differentIds_returnsFalse() {
        Goal goal1 = LogicTestUtil.makeGoal(1, LogicTestUtil.makeDefaultUser(), LogicTestUtil.makeDefaultLocalDateTime());
        Goal goal2 = LogicTestUtil.makeGoal(2, LogicTestUtil.makeDefaultUser(), LogicTestUtil.makeDefaultLocalDateTime());

        boolean result = goal1.equals(goal2);
        assertFalse(result);
    }

    @Test
    public void equals_differentParticipants_returnsFalse() {
        Goal goal1 = LogicTestUtil.makeGoal(LogicTestUtil.makeDefaultUser(), LogicTestUtil.makeDefaultLocalDateTime());
        Goal goal2 = LogicTestUtil.makeGoal(LogicTestUtil.makeDefaultUser2(), LogicTestUtil.makeDefaultLocalDateTime());

        boolean result = goal1.equals(goal2);
        assertFalse(result);
    }

    @Test
    public void equals_differentTimes_returnsFalse() {
        Goal goal1 = LogicTestUtil.makeGoal(LogicTestUtil.makeDefaultUser(), LocalDateTime.MIN);
        Goal goal2 = LogicTestUtil.makeGoal(LogicTestUtil.makeDefaultUser(), LocalDateTime.MAX);

        boolean result = goal1.equals(goal2);
        assertFalse(result);
    }

    @Test
    public void hashCode_whenCalled_returnsHashCode() {
        Goal goal1 = LogicTestUtil.makeGoalWithUser();
        Goal goal2 = LogicTestUtil.makeGoalWithUser();

        boolean result = goal1.hashCode() == goal2.hashCode();
        assertTrue(result);
    }

    @Test
    public void hashCode_nullParticipant_returnsHashCode() {
        Goal goal1 = LogicTestUtil.makeGoalNoParticipant();
        Goal goal2 = LogicTestUtil.makeGoalNoParticipant();

        boolean result = goal1.hashCode() == goal2.hashCode();
        assertTrue(result);
    }

    @Test
    public void getId_whenCalled_returnsId() {
        Goal goal = LogicTestUtil.makeGoalWithUser(); // Default id = 0.

        int expected = LogicConstants.INTERNAL_ID;
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