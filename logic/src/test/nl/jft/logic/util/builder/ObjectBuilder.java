package nl.jft.logic.util.builder;

import nl.jft.logic.util.TeamBuilder;

/**
 * @author Lesley
 */
public final class ObjectBuilder {

    private ObjectBuilder() {
    }

    public static TeamBuilder team() {
        return new TeamBuilder();
    }

}
