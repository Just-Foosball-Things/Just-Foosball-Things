package nl.jft.logic.participant.impl;

import nl.jft.common.util.Arguments;
import nl.jft.logic.LogicConstants;
import nl.jft.logic.participant.Elo;
import nl.jft.logic.participant.Participant;
import nl.jft.logic.util.EloUtil;

import java.util.Objects;

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

    private final User firstUser;
    private final User secondUser;

    /**
     * Initializes a new {@code Team} by invoking an other constructor ({@link #Team(int, String, User, User)}.
     *
     * @param teamName
     * @param firstUser
     * @param secondUser
     */
    public Team(String teamName, User firstUser, User secondUser) {
        this(LogicConstants.INTERNAL_ID, teamName, firstUser, secondUser);
    }

    /**
     * Creates a new {@code Team}.
     *
     * @param id         The {@code Id} of the {@code team} in the database.
     * @param teamName   The {@code name} of the {@code Team}. Cannot be {@code null} or an empty {@code String}.
     * @param firstUser  The first {@link User} in this {@code Team}, should be {@code null}.
     * @param secondUser The second {@code User} in this {@code Team}, should be {@code null}.
     * @throws NullPointerException     If {@code firstUser} is {@code null}.
     * @throws NullPointerException     If {@code secondUser} is {@code null}.
     * @throws IllegalArgumentException If given {@code Users} are the same.
     */
    public Team(int id, String teamName, User firstUser, User secondUser) {
        this.id = id;
        this.teamName = Arguments.requireNotEmpty(teamName);
        this.firstUser = Objects.requireNonNull(firstUser);
        this.secondUser = Objects.requireNonNull(secondUser);

        if (firstUser.equals(secondUser)) {
            throw new IllegalArgumentException("Users cannot be the same.");
        }
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Team)) {
            return false;
        }

        Team o = (Team) other;
        return o.id == id && o.teamName.equals(teamName)
                && o.firstUser.equals(firstUser) && o.secondUser.equals(secondUser);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + teamName.hashCode();
        result = 31 * result + firstUser.hashCode();
        result = 31 * result + secondUser.hashCode();
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

    @Override
    public Elo getElo() {
        return EloUtil.calculateCombinedElo(firstUser.getElo(), secondUser.getElo());
    }

}
