package nl.jft.common.util.util;

import nl.jft.common.rating.glicko.GlickoCalculationResult;
import nl.jft.common.rating.glicko.GlickoRating;
import nl.jft.common.rating.glicko.GlickoResult;
import nl.jft.common.util.elo.EloExpectation;
import nl.jft.common.util.elo.EloExpectationResult;
import nl.jft.common.util.util.mocks.MockScoreCalculator;

/**
 * @author Oscar de Leeuw
 */
public class CommonTestUtil {

    /**
     * Creates an {@code EloExpectation} with the following properties:
     * <li>
     * <ul>Elo1:        3000</ul>
     * <ul>Elo2:        2500</ul>
     * <ul>Goals1:      10</ul>
     * <ul>Goals2:      5</ul>
     * <ul>MaxGoals:    10</ul>
     * <ul>Delta1:      10</ul>
     * <ul>Delta2:      -2</ul>
     * </li>
     *
     * @return A default {@code EloExpectation}.
     */
    public static EloExpectation getDefaultExpectation() {
        return new EloExpectation("3000,2500,10,5,10,10,-2");
    }

    /**
     * Creates an {@code EloExpectationResult} with the following properties:
     * <li>
     * <ul>EloExpectation:      Default</ul>
     * <ul>NewRating1:          3010</ul>
     * <ul>NewRating2:          2498</ul>
     * <ul>Error1:              0</ul>
     * <ul>Error2:              0</ul>
     * </li>
     *
     * @return A default {@code EloExpectationResult}.
     */
    public static EloExpectationResult getDefaultExpectationResult() {
        return new EloExpectationResult(getDefaultExpectation(), 3010d, 2498d, 0d, 0d);
    }

    /**
     * Creates a new {@code GlickoRating} with the following properties:
     * <li>
     * <ul>GlickoRating:      1500</ul>
     * <ul>Deviation:   350</ul>
     * <ul>Volatility:  0.06</ul>
     * </li>
     *
     * @return a default {@code GlickoRating}.
     */
    public static GlickoRating getDefaultRating() {
        return new GlickoRating(1500, 350, 0.06);
    }

    /**
     * Creates a new {@code GlickoResult} with the following properties:
     * <li>
     * <ul>Winner:          DefaultRating</ul>
     * <ul>Loser:           DefaultRating</ul>
     * <ul>GoalDifference:  5</ul>
     * <ul>MaxGoals:        10</ul>
     * </li>
     *
     * @return a default {@code GlickoResult}.
     */
    public static GlickoResult getDefaultResult() {
        return new GlickoResult(getDefaultRating(), getDefaultRating(), 5, 10, new MockScoreCalculator());
    }

    /**
     * Creates a new {@code GlickoCalculationResult} with the following properties:
     * <li>
     * <ul>Winner:      DefaultRating</ul>
     * <ul>Loser:       DefaultRating</ul>
     * </li>
     *
     * @return a default {@code GlickoCalculationResult}.
     */
    public static GlickoCalculationResult getDefaultCalculationResult() {
        return new GlickoCalculationResult(getDefaultRating(), getDefaultRating());
    }

}
