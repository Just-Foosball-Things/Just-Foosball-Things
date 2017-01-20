package nl.jft.logic.util;

import nl.jft.logic.match.Goal;
import nl.jft.logic.match.Rule;
import nl.jft.logic.participant.impl.Team;
import nl.jft.logic.participant.impl.User;

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
     * <ul>Username: "username"</ul>
     * </li>
     *
     * @return A {@code User} object.
     */
    public static User makeDefaultUser() {
        return new User(-1, "username");
    }

    public static User makeUser(int id, String username) {
        return new User(id, username);
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
        return new Team(-1, "team");
    }

    public static Team makeTeam(int id, String teamName) {
        return new Team(id, teamName);
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
        return new Goal(-1, null, makeDefaultLocalDateTime());
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
        return new Goal(-1, makeDefaultUser(), makeDefaultLocalDateTime());
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
        return new Goal(-1, makeDefaultTeam(), makeDefaultLocalDateTime());
    }

    /**
     * Makes a {@code Rule} with the following properties:
     * <li>
     * <ul>Id: -1</ul>
     * </li>
     *
     * @return
     */
    public static Rule makeDefaultRule() {
        return makeRule(-1, "description");
    }

    public static Rule makeRule(int id, String description) {
        return new Rule(id, description);
    }
}
