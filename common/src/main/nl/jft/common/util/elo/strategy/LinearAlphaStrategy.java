package nl.jft.common.util.elo.strategy;

import nl.jft.common.util.elo.EloCalculationStrategy;

/**
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

    private double getExpectedScore(double currentRating, double opponentRating) {
        return 1 / (1 + Math.pow(10, (opponentRating - currentRating) / RATING_FACTOR));
    }

    private double getActualScore(int goalsScored, int goalsConceded, int maxGoals) {
        return INITIAL_SCORE + (goalsScored - goalsConceded) / (2 * maxGoals);
    }

}
