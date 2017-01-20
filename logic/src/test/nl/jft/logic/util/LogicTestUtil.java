package nl.jft.logic.util;

import nl.jft.logic.participant.impl.Team;
import nl.jft.logic.participant.impl.User;

/**
 * Test utilities for unit testing the Logic module of the JFT project.
 * Contains make methods for different classes within the Logic module.
 *
 * @author Oscar de Leeuw
 */
public final class LogicTestUtil {

    private LogicTestUtil() {
        throw new UnsupportedOperationException("Should not be called.");
    }

    /**
     * Makes a {@code User} with the following properties:
     * <li>
     * <ul>Username: "username"</ul>
     * </li>
     *
     * @return A {@code User} object.
     */
    public static User makeDefaultUser() {
        return new User("username");
    }

    /**
     * Makes a {@code Team} with the following properties:
     * <li>
     * <ul>Id: -1</ul>
     * <ul>Name: "team"</ul>
     * </li>
     *
     * @return A {@code Team} object.
     */
    public static Team makeDefaultTeam() {
        return new Team(-1, "team");
    }
}
