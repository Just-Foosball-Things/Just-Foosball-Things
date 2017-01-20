package nl.jft.logic.match;

import nl.jft.common.Identifiable;
import nl.jft.logic.participant.Participant;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * A {@code Goal} represents a {@code Goal} made by a {@link nl.jft.logic.participant.Participant} in a {@link Match}.
 * It contains metadata about the {@code Goal} such as who scored it, and when it was scored.
 *
 * @author Lesley
 */
public class Goal implements Identifiable {

    private final int id;
    private final Participant participant;
    private final LocalDateTime time;

    /**
     * Initializes a new Goal using the given id, participant and time.
     *
     * @param id          The {@code id} (dependant on an external system such as a database) of this {@code Goal}.
     * @param participant The {@code participant} who scored this {@code Goal}. Can be {@code null} to indicate the scorer is unknown.
     * @param time        The {@code time} at which {@code Goal} was scored, should not be null.
     */
    public Goal(int id, Participant participant, LocalDateTime time) {
        this.id = id;
        this.participant = participant;
        this.time = Objects.requireNonNull(time);
    }

    @Override
    public int getId() {
        return id;
    }

    public Participant getParticipant() {
        return participant;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
