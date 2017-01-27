package nl.jft.logic.match;

import nl.jft.logic.match.event.MatchListener;
import nl.jft.logic.participant.Participant;
import nl.jft.logic.util.LogicTestUtil;
import nl.jft.logic.util.MockMatchListener;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

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
    public void addListener_nullListener_throwsException() {
        expectedException.expect(NullPointerException.class);

        Match match = LogicTestUtil.makeDefaultMatch();
        match.addListener(null);
    }

    @Test
    public void addListener_whenCalled_addsListener() {
        Match match = LogicTestUtil.makeDefaultMatch();
        MockMatchListener listener = new MockMatchListener();

        match.addListener(listener);

        List<MatchListener> expected = Arrays.asList(listener);
        List<MatchListener> actual = match.getListeners();

        assertEquals(expected, actual);
    }

    @Test
    public void removeListener_nullListener_throwsException() {
        expectedException.expect(NullPointerException.class);

        Match match = LogicTestUtil.makeDefaultMatch();
        match.removeListener(null);
    }


    @Test
    public void removeListener_whenCalled_removesListener() {
        Match match = LogicTestUtil.makeDefaultMatch();
        MockMatchListener listener = new MockMatchListener();

        match.addListener(listener);
        match.removeListener(listener);

        List<MatchListener> expected = new ArrayList<>();
        List<MatchListener> actual = match.getListeners();

        assertEquals(expected, actual);
    }

    @Test
    public void start_whenCalled_startsMatch() {
        Match match = LogicTestUtil.makeDefaultMatch();
        match.start();

        MatchStatus expected = MatchStatus.IN_PROGRESS;
        MatchStatus actual = match.getStatus();

        assertEquals(expected, actual);
    }

    @Test
    public void start_whenCalled_callsListener() {
        Match match = LogicTestUtil.makeDefaultMatch();
        MockMatchListener listener = new MockMatchListener();

        match.addListener(listener);
        match.start();

        Match expectedMatch = match;
        Match actualMatch = listener.lastMatchStatusChangedEvent.getMatch();
        assertEquals(expectedMatch, actualMatch);

        MatchStatus expected = MatchStatus.IN_PROGRESS;
        MatchStatus actual = listener.lastMatchStatusChangedEvent.getNewStatus();
        assertEquals(expected, actual);

        expected = MatchStatus.SETUP;
        actual = listener.lastMatchStatusChangedEvent.getOldStatus();
        assertEquals(expected, actual);
    }

    @Test
    public void stop_whenCalled_callsListener() {
        Match match = LogicTestUtil.makeDefaultMatch();
        MockMatchListener listener = new MockMatchListener();

        match.addListener(listener);
        match.start();
        match.stop();

        Match expectedMatch = match;
        Match actualMatch = listener.lastMatchStatusChangedEvent.getMatch();
        assertEquals(expectedMatch, actualMatch);

        MatchStatus expected = MatchStatus.FINISHED;
        MatchStatus actual = listener.lastMatchStatusChangedEvent.getNewStatus();
        assertEquals(expected, actual);

        expected = MatchStatus.IN_PROGRESS;
        actual = listener.lastMatchStatusChangedEvent.getOldStatus();
        assertEquals(expected, actual);
    }

    @Test
    public void start_matchInProgress_throwsException() {
        expectedException.expect(IllegalStateException.class);

        Match match = LogicTestUtil.makeDefaultMatch();
        match.start();
        match.start();
    }

    @Test
    public void start_matchFinished_throwsException() {
        expectedException.expect(IllegalStateException.class);

        Match match = LogicTestUtil.makeDefaultMatch();
        match.start();
        match.stop();
        match.start();
    }

    @Test
    public void stop_whenCalled_stopsMatch() {
        Match match = LogicTestUtil.makeDefaultMatch();
        match.start();
        match.stop();

        MatchStatus expected = MatchStatus.FINISHED;
        MatchStatus actual = match.getStatus();

        assertEquals(expected, actual);
    }

    @Test
    public void stop_matchSetup_throwsException() {
        expectedException.expect(IllegalStateException.class);

        Match match = LogicTestUtil.makeDefaultMatch();
        match.stop();
    }

    @Test
    public void stop_matchFinished_throwsException() {
        expectedException.expect(IllegalStateException.class);

        Match match = LogicTestUtil.makeDefaultMatch();
        match.start();
        match.stop();
        match.stop();
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
    public void addGoal_whenCalled_callsListener() {
        Match match = LogicTestUtil.makeDefaultMatch();
        Goal goal = LogicTestUtil.makeGoalWithUser();
        MockMatchListener listener = new MockMatchListener();

        match.addListener(listener);
        match.addGoal(goal);

        Match expectedMatch = match;
        Match actualMatch = listener.lastGoalScoredEvent.getMatch();
        assertEquals(expectedMatch, actualMatch);

        Goal expected = LogicTestUtil.makeGoalWithUser();
        Goal actual = listener.lastGoalScoredEvent.getGoal();
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
    public void removeGoal_whenCalled_callsListener() {
        Match match = LogicTestUtil.makeDefaultMatch();
        Goal goal = LogicTestUtil.makeGoalWithUser();
        MockMatchListener listener = new MockMatchListener();

        match.addListener(listener);
        match.addGoal(goal);
        match.removeGoal(goal);

        Match expectedMatch = match;
        Match actualMatch = listener.lastGoalRemovedEvent.getMatch();
        assertEquals(expectedMatch, actualMatch);

        Goal expected = LogicTestUtil.makeGoalWithUser();
        Goal actual = listener.lastGoalRemovedEvent.getGoal();
        assertEquals(expected, actual);
    }

    @Test
    public void addRule_nullRule_throwsException() {
        expectedException.expect(NullPointerException.class);

        Match match = LogicTestUtil.makeDefaultMatch();
        match.addRule(null);
    }

    @Test
    public void addRule_whenCalled_addsRule() {
        Match match = LogicTestUtil.makeDefaultMatch();
        Rule rule = LogicTestUtil.makeDefaultRule();

        match.addRule(rule);

        List<Rule> expected = new ArrayList<Rule>() {{
            add(rule);
        }};
        List<Rule> actual = match.getRules();

        assertEquals(expected, actual);
    }

    @Test
    public void removeRule_nullRule_throwsException() {
        expectedException.expect(NullPointerException.class);

        Match match = LogicTestUtil.makeDefaultMatch();
        match.removeRule(null);
    }

    @Test
    public void removeRule_whenCalled_removesRule() {
        Match match = LogicTestUtil.makeDefaultMatch();
        Rule rule = LogicTestUtil.makeDefaultRule();

        match.addRule(rule);
        match.removeRule(rule);

        List<Rule> expected = new ArrayList<>();
        List<Rule> actual = match.getRules();

        assertEquals(expected, actual);
    }

    @Test
    public void equals_sameObjects_returnsTrue() {
        Match match1 = LogicTestUtil.makeDefaultMatch();
        Match match2 = LogicTestUtil.makeDefaultMatch();

        boolean result = match1.equals(match2);
        assertTrue(result);
    }

    @Test
    public void equals_otherMatch_returnsFalse() throws Exception {
        Match match1 = LogicTestUtil.makeDefaultMatch();
        Match match2 = LogicTestUtil.makeMatch(LogicTestUtil.makeDefaultUser(), LogicTestUtil.makeDefaultTeam());

        boolean result = match1.equals(match2);
        assertFalse(result);
    }

    @Test
    public void equals_otherObject_returnsFalse() {
        Match match1 = LogicTestUtil.makeDefaultMatch();
        String match2 = "match2";

        boolean result = match1.equals(match2);
        assertFalse(result);
    }

    @Test
    public void equals_nullObject_returnsFalse() {
        Match match1 = LogicTestUtil.makeDefaultMatch();
        Match match2 = null;

        boolean result = match1.equals(match2);
        assertFalse(result);
    }

    @Test
    public void hashCode_whenCalled_returnsHashCode() {
        Match match1 = LogicTestUtil.makeDefaultMatch();
        Match match2 = LogicTestUtil.makeDefaultMatch();

        boolean result = match1.hashCode() == match2.hashCode();
        assertTrue(result);
    }

    @Test
    public void getStatus_byDefault_returnsSetup() {
        Match match = LogicTestUtil.makeDefaultMatch();

        MatchStatus expected = MatchStatus.SETUP;
        MatchStatus actual = match.getStatus();

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