package nl.jft.common.util.elo;

import java.util.Objects;

/**
 * The {@code EloExpectationResult} represents the result of a calculation of {@link EloExpectationCalculator}.
 * This class stores the used {@link EloExpectation} and the new ratings and errors of the expected new ratings.
 *
 * @author Oscar de Leeuw
 */
public class EloExpectationResult {

    private final EloExpectation expectation;

    private final double newRating1;
    private final double newRating2;

    private final double error1;
    private final double error2;

    /**
     * Creates a new {@code EloExpectationResult}.
     *
     * @param exp        The {@code EloExpectation} that was used to calculate these results.
     * @param newRating1 The new rating of player one.
     * @param newRating2 The new rating of player two.
     * @param error1     The error between the calculated rating and the desired rating for player one.
     * @param error2     The error between the calculated rating and the desired rating for player two.
     */
    public EloExpectationResult(EloExpectation exp, double newRating1, double newRating2, double error1, double error2) {
        Objects.requireNonNull(exp, "Expectation cannot be null.");

        this.expectation = exp;
        this.newRating1 = newRating1;
        this.newRating2 = newRating2;
        this.error1 = error1;
        this.error2 = error2;
    }

    /**
     * Gets the {@code EloExpectation} that was used to calculate these results.
     *
     * @return The {@code EloExpectation} used to calculate these results.
     */
    public EloExpectation getExpectation() {
        return expectation;
    }

    /**
     * The new Elo-rating of player one.
     *
     * @return A double that represents the new Elo-rating of player one.
     */
    public double getNewRating1() {
        return newRating1;
    }

    /**
     * The new Elo-rating of player two.
     *
     * @return A double that represents the new Elo-rating of player two.
     */
    public double getNewRating2() {
        return newRating2;
    }

    /**
     * The difference between the calculated Elo-rating and the desired Elo-rating of player one.
     *
     * @return A double that represents the error.
     */
    public double getError1() {
        return error1;
    }

    /**
     * The difference between the calculated Elo-rating and the desired Elo-rating of player two.
     *
     * @return A double that represents the error.
     */
    public double getError2() {
        return error2;
    }
}
