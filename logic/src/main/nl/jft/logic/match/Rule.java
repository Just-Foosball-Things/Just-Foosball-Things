package nl.jft.logic.match;

import nl.jft.common.Identifiable;
import nl.jft.common.util.Arguments;

/**
 * A {@code Rule} defines what should and should not be allowed during a {@link Match}.
 *
 * @author Lesley
 */
public class Rule implements Identifiable {

    private final int id;
    private final String description;

    /**
     * Initiates a new {@code Rule} using the given {@code id} and {@code description}.
     *
     * @param id          The {@code id} of this {@code Rule}, used by external layers.
     * @param description The {@code description} of this {@code Rule}, this contains the actual definition
     *                    of this {@code Rule}, should not be {@code null} or empty.
     */
    public Rule(int id, String description) {
        this.id = id;
        this.description = Arguments.requireNotEmpty(description);
    }

    @Override
    public int getId() {
        return id;
    }

    /**
     * Gets the {@code description} of this {@code Rule}.
     *
     * @return The {@code description} of this {@code Rule}.
     */
    public String getDescription() {
        return description;
    }

}
