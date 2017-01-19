package nl.jft.logic;

import nl.jft.logic.util.Arguments;

/**
 * A {@code User} represents a person using/in the System.
 *
 * @author Lesley
 */
public class User {

    private final String username;

    /**
     * Initializes a new {@code User} using the given {@code username}.
     *
     * @param username The {@code username} of this {@code User}. Should not be {@code null} or empty.
     * @throws NullPointerException     If the given {@code username} was null.
     * @throws IllegalArgumentException IF the given {@code username} was empty.
     */
    public User(String username) {
        this.username = Arguments.requireNotEmpty(username);
    }

    /**
     * Gets the {@code username} of this {@code User}.
     *
     * @return The {@code username} of this {@code User}.
     */
    public String getUsername() {
        return username;
    }

}
