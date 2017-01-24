package nl.jft.common.util.elo.strategy;

import nl.jft.common.util.elo.EloCalculationStrategy;

/**
 * The {@code LinearAlphaStrategy} is an implementation of {@code EloCalculationStrategy}.
 * It approaches the evaluation of a foosball game linearly.
 *
 * The constant factors used are:
 * <li>
 *     <ul>{@link #K_FACTOR}</ul>
 *     <ul>{@link #RATING_FACTOR}</ul>
 *     <ul>{@link #INITIAL_SCORE}</ul>
 * </li>
 *
 * @author Oscar de Leeuw
 */
public class LinearAlphaStrategy implements EloCalculationStrategy {

    private static final int K_FACTOR = 40;
    private static final int RATING_FACTOR = 400;

    private static final double INITIAL_SCORE = 0.5d;

    @Override
    public double calculateNewRating(double currentRating, double opponentRating, int goalsScored, int goalsConceded, int maxGoals) {

        double expectedScore = getExpectedScore(currentRating, opponentRating);
        double actualScore = getActualScore(goalsScored, goalsConceded, maxGoals);

        return currentRating + K_FACTOR * (actualScore - expectedScore);
    }

    /**
     * Gets the expected score for two given ratings.
     *
     * @param currentRating  The current rating of the player for which to calculate the expected score.
     * @param opponentRating The current rating of the opposing player.
     * @return The expected outcome of the game.
     */
    public double getExpectedScore(double currentRating, double opponentRating) {
        return 1 / (1 + Math.pow(10, (opponentRating - currentRating) / RATING_FACTOR));
    }

    /**
     * Gets the actual score from a game.
     *
     * @param goalsScored   The amount of goals scored.
     * @param goalsConceded The amount of goals conceded.
     * @param maxGoals      The maximum amount of goals for a single game.
     * @return The actual score of the the game.
     */
    public double getActualScore(int goalsScored, int goalsConceded, int maxGoals) {
        return INITIAL_SCORE + (((double) goalsScored - (double) goalsConceded) / (2d * (double) maxGoals));
    }

}
