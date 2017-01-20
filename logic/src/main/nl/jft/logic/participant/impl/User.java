package nl.jft.logic.participant.impl;

import nl.jft.common.util.Arguments;
import nl.jft.logic.participant.Participant;

/**
 * A {@code User} represents a registered user within this application.
 * Implements the {@link Participant} interface because a {@code User} can partake in {@link nl.jft.logic.match.Match matches} and {@link nl.jft.logic.tournament.Tournament tournaments}.
 *
 * @author Lesley
 * @author Oscar de Leeuw
 */
public class User implements Participant {

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
    public String getName() {
        return username;
    }

}
