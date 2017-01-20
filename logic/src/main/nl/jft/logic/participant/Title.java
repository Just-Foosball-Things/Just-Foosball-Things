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

    public Title(int id, String description) {
        this.id = id;
        this.description = Arguments.requireNotEmpty(description);
    }

    @Override
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

}
