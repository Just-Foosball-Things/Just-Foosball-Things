package nl.jft.logic.match.event;

import nl.jft.logic.match.Match;
import nl.jft.logic.match.event.impl.GoalRemovedEvent;
import nl.jft.logic.match.event.impl.GoalScoredEvent;
import nl.jft.logic.match.event.impl.MatchStatusChangedEvent;

/**
 * A {@code MatchListener} can be used to get notified about certain events in a {@link Match}.
 *
 * @author Lesley
 */
public interface MatchListener {

    void onMatchStatusChanged(MatchStatusChangedEvent event);

    void onGoalScored(GoalScoredEvent event);

    void onGoalRemoved(GoalRemovedEvent event);

}
