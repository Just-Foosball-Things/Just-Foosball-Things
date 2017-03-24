package nl.jft.logic.util.builder;

import nl.jft.logic.LogicConstants;
import nl.jft.logic.match.Goal;
import nl.jft.logic.participant.Participant;

import java.util.Date;

/**
 * @author Lesley
 */
public final class GoalBuilder {

    private int id;
    private Participant participant;
    private Date time;

    public GoalBuilder() {
        id = LogicConstants.INTERNAL_ID;
        participant = ObjectBuilder.user().build();
        time = LogicConstants.INTERNAL_DATETIME;
    }

    public GoalBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public GoalBuilder withParticipant(Participant participant) {
        this.participant = participant;
        return this;
    }

    public GoalBuilder withTime(Date time) {
        this.time = time;
        return this;
    }

    public Goal build() {
        return new Goal(id, participant, time);
    }

    public Goal build2() {
        return new Goal(participant, time);
    }

}
