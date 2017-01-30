package nl.jft.logic.util;

import nl.jft.common.rating.Rating;
import nl.jft.common.rating.glicko.GlickoRating;
import nl.jft.logic.match.Match;
import nl.jft.logic.match.MatchResult;
import nl.jft.logic.match.Rule;
import nl.jft.logic.participant.Participant;
import nl.jft.logic.participant.ParticipantType;
import nl.jft.logic.participant.Title;
import nl.jft.logic.statistic.StatisticCollection;
import nl.jft.logic.statistic.impl.MatchStatistic;
import nl.jft.logic.statistic.impl.RatingStatistic;
import nl.jft.logic.statistic.impl.TitleStatistic;
import nl.jft.logic.tournament.Tournament;
import nl.jft.logic.tournament.TournamentType;

import java.time.LocalDateTime;
import java.time.Month;

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
     * Makes a {@code LocalDateTime} with the following properties:
     * <li>
     * <ul>Year: 2017</ul>
     * <ul>Month: {@link Month#JANUARY}</ul>
     * <ul>Day: 1</ul>
     * <ul>Hour: 12</ul>
     * <ul>Minute: 1</ul>
     * <ul>Second: 1</ul>
     * </li>
     *
     * @return A {@code LocalDateTime} object.
     */
    public static LocalDateTime makeDefaultLocalDateTime() {
        return LocalDateTime.of(2017, Month.JANUARY, 1, 12, 1, 1);
    }

    /**
     * Makes a {@code Rule} with the following properties:
     * <li>
     * <ul>Id: -1</ul>
     * <ul>Description: "description"</ul>
     * </li>
     *
     * @return A {@code Rule} object.
     */
    public static Rule makeDefaultRule() {
        return makeRule("description");
    }

    public static Rule makeRule(int id, String description) {
        return new Rule(id, description);
    }

    public static Rule makeRule(String description) {
        return new Rule(description);
    }

    /**
     * Makes a {@code Title} with the following properties:
     * <li>
     * <ul>Id: -1</ul>
     * <ul>Name: "name"</ul>
     * </li>
     *
     * @return A {@code Title} object.
     */
    public static Title makeDefaultTitle() {
        return makeTitle("name");
    }

    public static Title makeTitle(int id, String name) {
        return new Title(id, name);
    }

    public static Title makeTitle(String name) {
        return new Title(name);
    }

    public static TitleStatistic makeDefaultTitleStatistic() {
        return new TitleStatistic();
    }

    public static MatchStatistic makeDefaultMatchStatistic() {
        return new MatchStatistic();
    }

    public static RatingStatistic makeDefaultRatingStatistic() {
        return new RatingStatistic();
    }

    /**
     * Makes a {@code Match} with the following properties:
     * <li>
     * <ul>First Participant: {@link #makeDefaultUser()}</ul>
     * <ul>Second Participant: {@link #makeDefaultUser()}</ul>
     * </li>
     *
     * @return A {@code Match} object.
     */
    public static Match makeDefaultMatch() {
        return makeMatch(makeDefaultUser(), makeDefaultUser());
    }

    public static Match makeMatch(Participant firstParticipant, Participant secondParticipant) {
        return new Match(firstParticipant, secondParticipant);
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
