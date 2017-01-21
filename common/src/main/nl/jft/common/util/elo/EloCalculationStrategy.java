package nl.jft.common.util.elo;

/**
 * An {@code EloCalculationStrategy} is a strategy to calculate a new Elo-rating based on the given parameters.
 *
 * @author Oscar de Leeuw
 * @author Lesley
 */
@FunctionalInterface
public interface EloCalculationStrategy {

    /**
     * Calculates a new Elo-rating for a {@link java.util.concurrent.Exchanger.Participant particpant}
     * using the given parameters.
     *
     * @param currentRating The current rating of the player.
     * @param goalsScored   The amount of goals the {@code Participant} scored.
     * @param goalsConceded The amount of goals the {@code Participant} conceded.
     * @param maxGoals      The amount of goals that result in a win of a game.
     * @return The new rating of the {@code Participant}.
     */
    double calculateNewRating(double currentRating, int goalsScored, int goalsConceded, int maxGoals);

}
