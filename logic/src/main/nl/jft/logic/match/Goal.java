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
     * @param time        The {@code time} at which this {@code Goal} was scored, should not be null.
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

    /**
     * Gets the {@link Participant} who scored this {@code Goal}. May be {@code null} if it is unknown who scored this {@code Goal}.
     *
     * @return The {@code Participant} who scored this {@code Goal}.
     */
    public Participant getParticipant() {
        return participant;
    }

    /**
     * Gets the {@code time} at which this {@code Goal} was scored.
     *
     * @return The {@code time} at which this {@code Goal} was scored.
     */
    public LocalDateTime getTime() {
        return time;
    }
}
