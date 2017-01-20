package nl.jft.common.util.util;

import nl.jft.common.util.elo.EloExpectation;

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
}
