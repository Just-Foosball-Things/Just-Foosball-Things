package nl.jft.logic.participant;

import nl.jft.common.Identifiable;
import nl.jft.common.util.Arguments;
import nl.jft.common.util.Numbers;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * An {@code Elo} represents the rating of a {@link Participant}. This class provides information about what the rating is, and when it was achieved.
 * It is of the type {@link Identifiable} so that it can be stored in a database.
 *
 * @author Lesley
 */
public class Elo implements Identifiable {

    private final int id;
    private final double rating;
    private final LocalDateTime time;

    /**
     * Initializes a new {@code Elo} using the given arguments.
     *
     * @param id     The {@code id} of this {@code Elo}, used by external parties to identify this {@code Elo}.
     * @param rating The actual {@code Rating} tied to this {@code Elo}, should not be negative.
     * @param time   The {@code Time} at which this {@code Elo}-rating was achieved, should not be {@code null}.
     */
    public Elo(int id, double rating, LocalDateTime time) {
        this.id = id;
        this.rating = Arguments.requireNotNegative(rating);
        this.time = Objects.requireNonNull(time);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Elo)) {
            return false;
        }

        Elo o = (Elo) other;
        return o.id == id && Numbers.checkEqual(o.rating, rating) && o.time.equals(time);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + Double.hashCode(rating);
        result = 31 * result + time.hashCode();
        return result;
    }

    @Override
    public int getId() {
        return id;
    }

    /**
     * Gets the actual {@code Rating} tied to this {@code Elo}.
     *
     * @return A {@code double} representing the actual {@code Rating} tied to this {@code Elo}.
     */
    public double getRating() {
        return rating;
    }

    /**
     * Gets the {@code Time} at which this {@code Elo}-rating was achieved.
     *
     * @return A {@code LocalDateTime} representing the {@code Time} at which this {@code Elo}-rating was achieved.
     */
    public LocalDateTime getTime() {
        return time;
    }

}
