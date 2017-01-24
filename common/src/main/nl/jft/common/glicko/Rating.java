package nl.jft.common.glicko;

import nl.jft.common.util.Arguments;

/**
 * Holds a players Glicko-2 rating.
 * <p>
 * A Glicko-2 rating approaches the skill value of a player through numerical means.
 * This is done by using a standard deviation and volatility.
 * The standard deviation represents the certainty about a players rating and the volatility represents the consistency of a player.
 *
 * @author Oscar de Leeuw
 */
public class Rating {

    private final double rating;
    private final double deviation;
    private final double volatility;

    /**
     * Creates a new {@code Rating}.
     * All values must be non-zero and not negative.
     *
     * @param rating     The rating of the player.
     * @param deviation  The rating deviation of the player.
     * @param volatility The volatility of the player.
     */
    public Rating(double rating, double deviation, double volatility) {
        this.rating = Arguments.requirePositive(rating);
        this.deviation = Arguments.requirePositive(deviation);
        this.volatility = Arguments.requirePositive(volatility);
    }

    /**
     * Gets the rating of the player.
     *
     * @return A {@code double} that represents the rating of the player.
     */
    public double getRating() {
        return rating;
    }

    /**
     * Gets the deviation of the player, represents the range of ratings the player is likely in.
     * For newer players this range is bigger than experienced players.
     *
     * @return A {@code double} that represents the deviation.
     */
    public double getDeviation() {
        return deviation;
    }

    /**
     * Gets the volatility of the player. The more consistent a player plays the lower the volatility.
     *
     * @return A {@code double} that represents the volatility of the player.
     */
    public double getVolatility() {
        return volatility;
    }
}
