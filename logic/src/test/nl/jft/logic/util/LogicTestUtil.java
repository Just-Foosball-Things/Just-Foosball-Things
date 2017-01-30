package nl.jft.logic.util;

import nl.jft.common.rating.Rating;
import nl.jft.common.rating.glicko.GlickoRating;
import nl.jft.logic.match.Goal;
import nl.jft.logic.match.Match;
import nl.jft.logic.match.MatchResult;
import nl.jft.logic.match.Rule;
import nl.jft.logic.participant.Participant;
import nl.jft.logic.participant.ParticipantType;
import nl.jft.logic.participant.Title;
import nl.jft.logic.participant.impl.Team;
import nl.jft.logic.participant.impl.User;
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
     * Makes a {@code User} with the following properties:
     * <li>
     * <ul>Id: -1</ul>
     * <ul>Username: "username"</ul>
     * <ul>Rating: {@link #makeDefaultRating()} ()}</ul>
     * <ul>Title: {@link #makeDefaultTitle()}</ul>
     * </li>
     *
     * @return A {@code User} object.
     */
    public static User makeDefaultUser() {
        return makeUser("username", makeDefaultRating(), makeDefaultTitle());
    }

    public static User makeDefaultUser2() {
        return makeUser("username2", makeDefaultRating(), makeDefaultTitle());
    }

    public static User makeDefaultUser3() {
        return makeUser("username3", makeDefaultRating(), makeDefaultTitle());
    }

    public static User makeUser(int id, String username, Rating rating, Title title) {
        return new User(id, username, rating, title);
    }

    public static User makeUser(String username, Rating rating, Title title) {
        return new User(username, rating, title);
    }

    /**
     * Makes a {@code Team} with the following properties:
     * <li>
     * <ul>Id: -1</ul>
     * <ul>Name: "team"</ul>
     * </li>
     *
     * @return A {@code Team} object.
     */
    public static Team makeDefaultTeam() {
        return makeTeam("team", makeDefaultUser(), makeDefaultUser2());
    }

    public static Team makeTeam(int id, String teamName, User firstUser, User secondUser) {
        return new Team(id, teamName, firstUser, secondUser);
    }

    public static Team makeTeam(String teamName, User firstUser, User secondUser) {
        return new Team(teamName, firstUser, secondUser);
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
     * Makes a {@code Goal} with the following properties:
     * <li>
     * <ul>Id: -1</ul>
     * <ul>Participant: {@code null}</ul>
     * <ul>Time: {@link #makeDefaultLocalDateTime()}</ul>
     * </li>
     *
     * @return A {@code Goal} object.
     */
    public static Goal makeGoalNoParticipant() {
        return makeGoal(null, makeDefaultLocalDateTime());
    }

    /**
     * Makes a {@code Goal} with the following properties:
     * <li>
     * <ul>Id: -1</ul>
     * <ul>Participant: {@link #makeDefaultUser()}</ul>
     * <ul>Time: {@link #makeDefaultLocalDateTime()}</ul>
     * </li>
     *
     * @return A {@code Goal} object.
     */
    public static Goal makeGoalWithUser() {
        return makeGoal(makeDefaultUser(), makeDefaultLocalDateTime());

    }

    /**
     * Makes a {@code Goal} with the following properties:
     * <li>
     * <ul>Id: -1</ul>
     * <ul>Participant: {@link #makeDefaultTeam()} ()}</ul>
     * <ul>Time: {@link #makeDefaultLocalDateTime()}</ul>
     * </li>
     *
     * @return A {@code Goal} object.
     */
    public static Goal makeGoalWithTeam() {
        return makeGoal(makeDefaultTeam(), makeDefaultLocalDateTime());
    }

    public static Goal makeGoal(int id, Participant participant, LocalDateTime time) {
        return new Goal(id, participant, time);
    }

    public static Goal makeGoal(Participant participant, LocalDateTime time) {
        return new Goal(participant, time);
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
