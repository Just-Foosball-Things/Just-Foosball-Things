package nl.jft.logic.util;

import nl.jft.logic.match.event.MatchListener;
import nl.jft.logic.match.event.impl.GoalRemovedEvent;
import nl.jft.logic.match.event.impl.GoalScoredEvent;
import nl.jft.logic.match.event.impl.MatchStatusChangedEvent;

/**
 * @author Lesley
 */
public class MockMatchListener implements MatchListener {

    public MatchStatusChangedEvent lastMatchStatusChangedEvent;
    public GoalScoredEvent lastGoalScoredEvent;
    public GoalRemovedEvent lastGoalRemovedEvent;

    @Override
    public void onMatchStatusChanged(MatchStatusChangedEvent event) {
        lastMatchStatusChangedEvent = event;
    }

    @Override
    public void onGoalScored(GoalScoredEvent event) {
        lastGoalScoredEvent = event;
    }

    @Override
    public void onGoalRemoved(GoalRemovedEvent event) {
        lastGoalRemovedEvent = event;
    }

}
