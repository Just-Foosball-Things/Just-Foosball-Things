package nl.jft.logic.util;

import nl.jft.common.rating.Rating;
import nl.jft.common.rating.glicko.GlickoRating;
import nl.jft.logic.match.Match;
import nl.jft.logic.match.MatchResult;
import nl.jft.logic.participant.ParticipantType;
import nl.jft.logic.statistic.StatisticCollection;
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
     * Makes a {@code MatchResult} with the following properties:
     * <lu>
     * <ul>Id: -1</ul>
     * <ul>Match: {@link #makeDefaultMatch()}</ul>
     * </lu>
     *
     * @return A {@code MatchResult} object.
     */
    public static MatchResult makeDefaultMatchResult() {
        return makeMatchResult(makeDefaultMatch());
    }

    public static MatchResult makeMatchResult(int id, Match match) {
        return new MatchResult(id, match);
    }

    public static MatchResult makeMatchResult(Match match) {
        return new MatchResult(match);
    }

    /**
     * Makes a {@link nl.jft.common.rating.glicko.GlickoRating} with the following properties:
     * <li>
     * <ul>Rating: 1500</ul>
     * <ul>Deviation: 350</ul>
     * <ul>Volatility: 0.06</ul>
     * </li>
     *
     * @return A {@code Elo} object.
     */
    public static Rating makeDefaultRating() {
        return new GlickoRating(1500, 350, 0.06);
    }

    public static Rating makeRating(double rating) {
        return new GlickoRating(rating, 350, 0.06);
    }

    public static StatisticCollection makeDefaultStatisticCollection() {
        return new StatisticCollection();
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
