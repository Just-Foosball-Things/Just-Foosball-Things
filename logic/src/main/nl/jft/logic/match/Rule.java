package nl.jft.logic.match;

import nl.jft.common.Identifiable;
import nl.jft.common.util.Arguments;

/**
 * @author Lesley
 */
public class Rule implements Identifiable {

    private final int id;
    private final String description;

    public Rule(int id, String description) {
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
