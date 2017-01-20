package nl.jft.common.util.util;

import nl.jft.common.util.elo.EloExpectation;
import nl.jft.common.util.elo.EloExpectationResult;

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
}
