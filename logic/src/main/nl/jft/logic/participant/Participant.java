package nl.jft.logic.participant;

import nl.jft.common.Identifiable;

/**
 * The {@code Participant} interface defines a participant that can partake in {@link nl.jft.logic.match.Match Matches} and {@link nl.jft.logic.tournament.Tournament Tournamements}.
 * A {@code Participant} is stored in the database and thus should be {@code Identifiable}.
 *
 * @author Lesley
 * @author Oscar de Leeuw
 */
public interface Participant extends Identifiable {

    /**
     * Gets the name of the {@code Participant}.
     *
     * @return A {@code String} that represents the name of the {@code Participant}.
     */
    String getName();

}
