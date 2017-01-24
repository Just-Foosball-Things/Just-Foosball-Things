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
    private final String name;

    /**
     * Initiates a new {@code Title} using the given {@code id} and {@code name}.
     *
     * @param id   The {@code id} of this {@code Title}, used by external layers.
     * @param name The {@code name} of this {@code Title}, should not be {@code null} or empty.
     */
    public Title(int id, String name) {
        this.id = id;
        this.name = Arguments.requireNotEmpty(name);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Title)) {
            return false;
        }

        Title o = (Title) other;
        return o.id == id && o.name.equals(name);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public int getId() {
        return id;
    }

    /**
     * Gets the {@code name} of this {@code Title}.
     *
     * @return The {@code name} of this {@code Title}.
     */
    public String getName() {
        return name;
    }

}
