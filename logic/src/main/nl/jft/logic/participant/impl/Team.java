package nl.jft.logic.participant.impl;

import nl.jft.common.util.Arguments;
import nl.jft.logic.participant.Participant;

/**
 * A {@code Team} represents a group of {@link Participant Participants} that form a team.
 * Implements the {@code Participant} interface as a {@code Team} can partake in {@link nl.jft.logic.match.Match Matches} and {@link nl.jft.logic.tournament.Tournament Tournaments}.
 * A {@code Team} is stored in the database and is thus //TODO add identifiable link.
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

    /**
     * @return
     */
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return teamName;
    }

}
