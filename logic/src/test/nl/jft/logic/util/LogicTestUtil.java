package nl.jft.logic.util;

import nl.jft.logic.participant.ParticipantType;
import nl.jft.logic.tournament.Tournament;
import nl.jft.logic.tournament.TournamentType;

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
     * Makes a {@code Tournaent} with the following properties:
     * <li>
     * <ul>TournamentType: {@link TournamentType#KNOCKOUT}</ul>
     * <ul>ParticipantType: {@link ParticipantType#SOLO}</ul>
     * </li>
     *
     * @return
     */
    public static Tournament makeDefaultTournament() {
        return makeTournament(TournamentType.KNOCKOUT, ParticipantType.SOLO);
    }

    public static Tournament makeTournament(TournamentType tournamentType, ParticipantType participantType) {
        return new Tournament(tournamentType, participantType);
    }

}
