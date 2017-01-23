package nl.jft.logic.match;

import nl.jft.logic.participant.Participant;
import nl.jft.logic.util.LogicTestUtil;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

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
    public void addGoal_nullGoal_throwsException() {
        expectedException.expect(NullPointerException.class);

        Match match = LogicTestUtil.makeDefaultMatch();
        match.addGoal(null);
    }

    @Test
    public void addGoal_whenCalled_addsGoal() {
        Match match = LogicTestUtil.makeDefaultMatch();
        Goal goal = LogicTestUtil.makeGoalWithUser();

        match.addGoal(goal);

        List<Goal> expected = new ArrayList<Goal>() {{
            add(goal);
        }};
        List<Goal> actual = match.getGoals();

        assertEquals(expected, actual);
    }

    @Test
    public void removeGoal_nullGoal_throwsException() {
        expectedException.expect(NullPointerException.class);

        Match match = LogicTestUtil.makeDefaultMatch();
        match.removeGoal(null);
    }

    @Test
    public void removeGoal_whenCalled_removesGoal() {
        Match match = LogicTestUtil.makeDefaultMatch();
        Goal goal = LogicTestUtil.makeGoalWithUser();

        match.addGoal(goal);
        match.removeGoal(goal);

        List<Goal> expected = new ArrayList<>();
        List<Goal> actual = match.getGoals();

        assertEquals(expected, actual);
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