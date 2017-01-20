package nl.jft.common.util.elo;

/**
 * An {@code EloCalculationStrategy} is a strategy to calculating a new Elo-rating based on the given parameters.
 *
 * @author Oscar de Leeuw
 */
public interface EloCalculationStrategy {
    /**
     * Calculates a new Elo-rating with the given parameters.
     *
     * @param currentRating The current rating of the player.
     * @param goalsFor      The goals that the player scored.
     * @param goalsAgainst  The goals that were against the player.
     * @param maxGoals      The maximum amount of goals.
     * @return The new rating of the player.
     */
    double calculateNewRating(double currentRating, int goalsFor, int goalsAgainst, int maxGoals);
}
