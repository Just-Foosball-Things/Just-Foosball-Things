package nl.jft.logic.participant;

import nl.jft.common.Identifiable;
import nl.jft.common.util.Arguments;

/**
 * A {@code Title} is an estethic label given to a {@link nl.jft.logic.participant.impl.User} under certain conditions.
 *
 * @author Lesley
 */
public class Title implements Identifiable {

    private final int id;
    private final String description;

    /**
     * Initiates a new {@code Title} using the given {@code id} and {@code description}.
     *
     * @param id          The {@code id} of this {@code Title}, used by external layers.
     * @param description The {@code description} of this {@code Title}, should not be {@code null} or empty.
     */
    public Title(int id, String description) {
        this.id = id;
        this.description = Arguments.requireNotEmpty(description);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Title)) {
            return false;
        }

        Title o = (Title) other;
        return o.id == id && o.description.equals(description);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public int getId() {
        return id;
    }

    /**
     * Gets the {@code description} of this {@code Title}.
     *
     * @return The {@code description} of this {@code Title}.
     */
    public String getDescription() {
        return description;
    }

}
