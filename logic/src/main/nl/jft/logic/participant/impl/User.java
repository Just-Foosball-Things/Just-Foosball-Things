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

    private final int id;
    private final String username;

    /**
     * Initializes a new {@code User} using the given {@code username}.
     *
     * @param id The {@code id} of this {@code User}.
     * @param username The {@code username} of this {@code User}. Should not be {@code null} or empty.
     * @throws NullPointerException     If the given {@code username} was null.
     * @throws IllegalArgumentException IF the given {@code username} was empty.
     */
    public User(int id, String username) {
        this.id = id;
        this.username = Arguments.requireNotEmpty(username);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof User)) {
            return false;
        }

        User o = (User) other;
        return o.username.equals(username);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + username.hashCode();
        return result;
    }

    @Override
    public String getName() {
        return username;
    }

    @Override
    public int getId() {
        return id;
    }
}
