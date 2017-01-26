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
     * Calculates the value of v as described in step 3 of Glickman's paper: <br>
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

    /**
     * Calculates the value of {@code delta} as described in step 4 of Glickman's paper: <br>
     * {@code delta = v * g(phiJ) * (sJ - e(mu,muJ,phiJ))} <br>
     * This implementation does not support evaluating multiple results simultaneously.
     *
     * @param rating            The rating of the player.
     * @param opponentRating    The rating of the opposing player.
     * @param opponentDeviation The deviation of the opposing player.
     * @param actualScore       The actual score of the game.
     * @return a {@code double} that represents {@code delta}.
     */
    public double delta(double rating, double opponentRating, double opponentDeviation, double actualScore) {
        double v = v(rating, opponentRating, opponentDeviation);
        double gPhiJ = g(opponentDeviation);
        double e = e(rating, opponentRating, opponentDeviation);

        return v * (gPhiJ * (actualScore - e));
    }

    /**
     * Calculates the value of {@code a} as described in step 5.1 of Glickman's paper: <br>
     * {@code a = ln(sigma^2)} where sigma is the volatility of the player
     *
     * @param volatility The volatility of the player.
     * @return a {@code double} that represents {@code a}.
     */
    public double a(double volatility) {
        return Math.log(Math.pow(volatility, 2));
    }

    /**
     * Evaluates the function {@code f} as described in step 5.1 of Glickman's paper: <br>
     * {@code f(x) = ((e^x * (delta^2 - phi^2 - v - e^x)) / (2*(phi^2+v+e^x)^2)) - ((x-a)/tau^2)} <br>
     * Function is known to be prone to rounding errors as evaluating the function through Google,
     * or Wolfram Alpha, yields slightly different results.
     *
     * @param x     The parameter for which to evaluate the function {@code f}.
     * @param delta The value of {@link #delta(double, double, double, double)}.
     * @param phi   The value of {@link #phi(double)}.
     * @param v     The value of {@link #v(double, double, double)}.
     * @param a     The value of {@link #a(double)}.
     * @param tau   The value of {@code tau}.
     * @return a {@code double} that represents {@code f(x)}.
     */
    public double f(double x, double delta, double phi, double v, double a, double tau) {
        double numerator = Math.exp(x) * (Math.pow(delta, 2d) - Math.pow(phi, 2d) - v - Math.exp(x));
        double denominator = 2d * Math.pow((Math.pow(phi, 2d) + v + Math.exp(x)), 2d);

        double firstTerm = numerator / denominator;
        double secondTerm = (x - a) / Math.pow(tau, 2d);

        return firstTerm - secondTerm;
    }

    /**
     * Calculates the new volatility as described in step 5.2-5.5 in Glickman's paper.
     * This method iterates through the iterative algorithm described in step 5.
     *
     * @param delta       The value of {@link #delta(double, double, double, double)}.
     * @param phi         The value of {@link #phi(double)}.
     * @param v           The value of {@link #v(double, double, double)}.
     * @param a           The value of {@link #a(double)}.
     * @param tau         The value of {@code tau}.
     * @param convergence the value to which the iterative algorithm should converge.
     * @return a {@code double} that represents the new volatility of a player.
     */
    public double newSigma(double delta, double phi, double v, double a, double tau, double convergence) {
        double bigA = a;
        double bigB;

        //step 5.2

        if (Math.pow(delta, 2) > Math.pow(phi, 2) + v) {
            bigB = Math.log(Math.pow(delta, 2) + Math.pow(phi, 2) + v);
        } else {
            int k = 1;
            while (f((a - k * tau), delta, phi, v, a, tau) < 0) {
                k++;
            }
            bigB = a - k * tau;
        }

        //step 5.3

        double fOfA = f(bigA, delta, phi, v, a, tau);
        double fOfB = f(bigB, delta, phi, v, a, tau);

        //step 5.4

        while (Math.abs(bigA - bigB) > convergence) {
            double bigC = bigA + (bigA - bigB) * fOfA / (fOfB - fOfA);
            double fOfC = f(bigC, delta, phi, v, a, tau);

            if (fOfC * fOfB < 0) {
                bigA = bigB;
                fOfA = fOfB;
            } else {
                fOfA = fOfA / 2d;
            }

            bigB = bigC;
            fOfB = fOfC;
        }

        //step 5.5

        return Math.exp(bigA/2);
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
