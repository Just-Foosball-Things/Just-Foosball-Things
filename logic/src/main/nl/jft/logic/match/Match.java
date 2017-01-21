package nl.jft.logic.match;

import nl.jft.logic.participant.Participant;

import java.util.Objects;

/**
 * A {@code Match} is a game between two {@link nl.jft.logic.participant.Participant participants}. {@link Goal goals}
 * can be scored, and added, in a {@code Match} to determine the winning {@code Participant}.
 *
 * @author Lesley
 */
public class Match {

    private final Participant firstParticipant;
    private final Participant secondParticipant;

    public Match(Participant firstParticipant, Participant secondParticipant) {
        this.firstParticipant = Objects.requireNonNull(firstParticipant);
        this.secondParticipant = Objects.requireNonNull(secondParticipant);
    }

    public Participant getFirstParticipant() {
        return firstParticipant;
    }

    public Participant getSecondParticipant() {
        return secondParticipant;
    }
}
