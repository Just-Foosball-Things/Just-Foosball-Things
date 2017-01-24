package nl.jft.common.glicko;

import nl.jft.common.util.Arguments;

/**
 * The {@code GlickoResult} class represents the outcome of a match between two players.
 * {@code GlickoResult} holds a winner, loser and the difference in goals, as well as the goal limit for that game.
 *
 * @author Oscar de Leeuw
 */
public class GlickoResult {

    private final GlickoRating winner;
    private final GlickoRating loser;

    private final int goalDifference;
    private final int maxGoals;

    /**
     * Creates a new {@code GlickoResult}.
     *
     * @param winner         The {@code GlickoRating}-object that represents the winner of the match.
     * @param loser          The {@code GlickoRating}-object that represents the loser of the match.
     * @param goalDifference The difference in goals between the winner and loser.
     * @param maxGoals       The maximum amount of goals for this game.
     * @throws NullPointerException     When a given reference is {@code null}.
     * @throws IllegalArgumentException When the parameters {@code winner} and {@code loser} are the same instance.
     * @throws IllegalArgumentException When the {@code goalDifference} is larger than the {@code maxGoals}.
     * @throws IllegalArgumentException When {@code goalDifference} or {@code maxGoals} is not positive.
     */
    public GlickoResult(GlickoRating winner, GlickoRating loser, int goalDifference, int maxGoals) {
        this.winner = Arguments.requireNotSame(winner, loser);
        this.loser = Arguments.requireNotSame(loser, winner);

        if (goalDifference > maxGoals) {
            throw new IllegalArgumentException("Goal difference cannot be larger than maximum goals.");
        }

        this.goalDifference = (int) Arguments.requirePositive(goalDifference);
        this.maxGoals = (int) Arguments.requirePositive(maxGoals);
    }

    /**
     * The {@code GlickoRating}-object that represents the winner of this {@code GlickoResult}.
     *
     * @return A {@code GlickoRating}-object.
     */
    public GlickoRating getWinner() {
        return winner;
    }

    /**
     * The {@code GlickoRating}-object that represents the loser of this {@code GlickoResult}.
     *
     * @return A {@code GlickoRating}-object.
     */
    public GlickoRating getLoser() {
        return loser;
    }

    /**
     * The goal difference between the winner and loser of this {@code GlickoResult}.
     *
     * @return An {@code int}.
     */
    public int getGoalDifference() {
        return goalDifference;
    }

    /**
     * The maximum amount of goals for a game in this {@code GlickoResult}.
     *
     * @return An {@code int}.
     */
    public int getMaxGoals() {
        return maxGoals;
    }
}
