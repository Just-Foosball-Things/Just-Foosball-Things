package nl.jft.common.util.elo;

import java.util.Objects;

/**
 * The {@code EloExpectationResult} represents the result of a calculation of {@link EloExpectationCalculator}.
 * This class stores the used {@link EloExpectation} and the new Elo-ratings and errors of the expected new Elo-ratings.
 *
 * @author Oscar de Leeuw
 * @author Lesley
 */
public class EloExpectationResult {

    private final EloExpectation expectation;

    private final double newFirstRating;
    private final double newSecondRating;

    private final double firstError;
    private final double secondError;

    /**
     * Creates a new {@code EloExpectationResult} using the given parameters.
     *
     * @param expectation     The {@code EloExpectation} that was used to calculate these results.
     * @param newFirstRating  The new Elo-rating of the first player.
     * @param newSecondRating The new Elo-rating of the second player.
     * @param firstError      The error between the calculated Elo-rating and the desired rating for the first player.
     * @param secondError     The error between the calculated Elo-rating and the desired rating for the second player.
     */
    public EloExpectationResult(EloExpectation expectation, double newFirstRating, double newSecondRating, double firstError, double secondError) {
        Objects.requireNonNull(expectation);

        this.expectation = expectation;
        this.newFirstRating = newFirstRating;
        this.newSecondRating = newSecondRating;
        this.firstError = firstError;
        this.secondError = secondError;
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
     * The new Elo-rating of the first player.
     *
     * @return A {@code double} that represents the new Elo-rating of the first player.
     */
    public double getNewFirstRating() {
        return newFirstRating;
    }

    /**
     * The new Elo-rating of the second player.
     *
     * @return A {@code double} that represents the new Elo-rating of the second player.
     */
    public double getNewSecondRating() {
        return newSecondRating;
    }

    /**
     * The difference between the calculated Elo-rating and the desired Elo-rating of the first player.
     *
     * @return A {@code double} that represents the error of the first player.
     */
    public double getFirstError() {
        return firstError;
    }

    /**
     * The difference between the calculated Elo-rating and the desired Elo-rating of the first player.
     *
     * @return A {@code double} that represents the error of the first player.
     */
    public double getSecondError() {
        return secondError;
    }

}
