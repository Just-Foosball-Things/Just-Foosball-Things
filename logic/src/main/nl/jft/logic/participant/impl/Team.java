package nl.jft.logic.participant.impl;

import nl.jft.common.util.Arguments;
import nl.jft.logic.participant.Participant;

/**
 * A {@code Team} represents a group of {@link Participant Participants} that form a team.
 * Implements the {@code Participant} interface as a {@code Team} can partake in {@link nl.jft.logic.match.Match Matches} and {@link nl.jft.logic.tournament.Tournament Tournaments}.
 * A {@code Team} is stored in the database and is thus {@link nl.jft.common.Identifiable Identifiable}.
 *
 * @author Lesley
 * @author Oscar de Leeuw
 */
public class Team implements Participant {

    private final int id;
    private final String teamName;

    /**
     * Creates a new {@code Team}.
     *
     * @param id       The {@code Id} of the {@code team} in the database.
     * @param teamName The {@code name} of the {@code Team}. Cannot be {@code null} or an empty {@code String}.
     */
    public Team(int id, String teamName) {
        this.id = id;
        this.teamName = Arguments.requireNotEmpty(teamName);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Team)) {
            return false;
        }

        Team o = (Team) other;
        return o.id == id && o.teamName.equals(teamName);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + teamName.hashCode();
        return result;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return teamName;
    }

}
