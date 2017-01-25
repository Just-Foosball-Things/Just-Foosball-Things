package nl.jft.common.glicko;

import java.util.List;

/**
 * @author Oscar de Leeuw
 */
public class StandardGlickoCalculator implements GlickoCalculator {

    private static final double DEFAULT_RATING = 1500d;
    private static final double DEFAULT_DEVIATION = 350d;
    private static final double DEFAULT_VOLATILITY = 0.06;
    private static final double DEFAULT_TAU = 0.75;
    private static final double MULTIPLIER = 173.7178;
    private static final double CONVERGENCE_TOLERANCE = 0.000001;
    private static final int ITERATION_MAX = 3000;

    /**
     * Calculates the mu value as described in step 2 of Glickman's paper: <br>
     * {@code mu = (rating - 1500)/173.7178}
     *
     * @param rating The current rating of the player.
     * @return A {@code double} that represents mu.
     */
    public double mu(double rating) {
        return (rating - DEFAULT_RATING) / MULTIPLIER;
    }

    /**
     * Calculates the phi value as described in step 2 of Glickman's paper: <br>
     * {@code phi = deviation / 173.7178}
     *
     * @param deviation The current deviation of the player.
     * @return a {@code double} that represents phi.
     */
    public double phi(double deviation) {
        return deviation / MULTIPLIER;
    }

    /**
     * Evaluates the g function as described in step 3 of Glickman's paper: <br>
     * {@code g(phi) = 1 / (sqrt(1 + 3*phi^2/pi^2))}
     *
     * @param deviation The deviation of the player.
     * @return a {@code double} that represents g(phi).
     */
    public double g(double deviation) {
        double phi = phi(deviation);

        return 1d / Math.sqrt(1d + 3d * Math.pow(phi, 2d) / Math.pow(Math.PI, 2d));
    }

    /**
     * Evaluates the E function as described in step 3 of Glickman's paper: <br>
     * {@code E(mu, muJ, phiJ) = 1 / (1 + exp(-g(phiJ)*(mu - muJ)))}
     *
     * @param rating            The rating of the player.
     * @param opponentRating    The rating of the opposing player.
     * @param opponentDeviation The deviation of the opposing player.
     * @return a {@code double} that represents {@code E(mu, muJ, phiJ)}.
     */
    public double e(double rating, double opponentRating, double opponentDeviation) {
        double mu = mu(rating);
        double muJ = mu(opponentRating);
        double gPhiJ = g(opponentDeviation);

        return 1d / (1d + Math.exp(-gPhiJ * (mu - muJ)));
    }

    /**
     * Evaluates the v function as described in step 3 of Glickman's paper: <br>
     * {@code v = 1d / (g(phiJ)^2 * E(mu,muJ,phiJ) * (1 - E(mu,muj,phiJ)))} <br>
     * This implementation does not support evaluating multiple results at the same time.
     * Within the JFT-application every result will immediately be processed
     * and it will not be possible to play multiple games at the same {@code GlickoRating}.
     *
     * @param rating            The rating of the player.
     * @param opponentRating    The rating of the opposing player.
     * @param opponentDeviation The deviation of the opposing player.
     * @return a {@code double} that represents {@code v}.
     */
    public double v(double rating, double opponentRating, double opponentDeviation) {
        double gPhiJ = g(opponentDeviation);
        double e = e(rating, opponentRating, opponentDeviation);

        return 1d / (Math.pow(gPhiJ, 2d) * e * (1d - e));
    }


    public double delta(double rating, double opponentRating, double opponentDeviation, double actualScore) {
        double v = v(rating, opponentRating, opponentDeviation);
        double gPhiJ = g(opponentDeviation);
        double e = e(rating, opponentRating, opponentDeviation);

        return v * (gPhiJ * (actualScore - e));
    }

    @Override
    public GlickoCalculationResult calculateNewRating(GlickoResult result) {
        return null;
    }

    @Override
    public List<GlickoCalculationResult> calculateNewRatings(List<GlickoResult> results) {
        return null;
    }
}
