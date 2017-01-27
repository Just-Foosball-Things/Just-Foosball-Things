package nl.jft.logic.match.event.impl;

import nl.jft.logic.match.Goal;
import nl.jft.logic.match.Match;
import nl.jft.logic.util.LogicTestUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * @author Lesley
 */
public class GoalRemovedEventTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void construct_nullMatch_throwsException() {
        expectedException.expect(NullPointerException.class);

        Goal goal = LogicTestUtil.makeGoalWithUser();
        GoalRemovedEvent event = new GoalRemovedEvent(null, goal);
    }

    @Test
    public void construct_nullGoal_throwsException() {
        expectedException.expect(NullPointerException.class);

        Match match = LogicTestUtil.makeDefaultMatch();
        GoalRemovedEvent event = new GoalRemovedEvent(match, null);
    }

    @Test
    public void getMatch_whenCalled_returnsGoal() {
        Match match = LogicTestUtil.makeDefaultMatch();
        Goal goal = LogicTestUtil.makeGoalWithUser();
        GoalRemovedEvent event = new GoalRemovedEvent(match, goal);

        Match expected = LogicTestUtil.makeDefaultMatch();
        Match actual = event.getMatch();

        assertEquals(expected, actual);
    }

    @Test
    public void getGoal_whenCalled_returnsGoal() {
        Match match = LogicTestUtil.makeDefaultMatch();
        Goal goal = LogicTestUtil.makeGoalWithUser();
        GoalRemovedEvent event = new GoalRemovedEvent(match, goal);

        Goal expected = LogicTestUtil.makeGoalWithUser();
        Goal actual = event.getGoal();

        assertEquals(expected, actual);
    }

}