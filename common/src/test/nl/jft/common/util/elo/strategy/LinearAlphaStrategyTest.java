package nl.jft.common.util.elo.strategy;

import nl.jft.common.util.elo.EloExpectation;
import nl.jft.common.util.util.CommonTestUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Oscar de Leeuw
 */
public class LinearAlphaStrategyTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private LinearAlphaStrategy strategy;
    private EloExpectation expectation;

    @Before
    public void setUp() throws Exception {
        strategy = new LinearAlphaStrategy();
        expectation = CommonTestUtil.getDefaultExpectation();
    }

    @Test
    public void getExpectedScore_withDefaultEloExpectation_returnsExpectedScore() throws Exception {
        double expected = 0.94675978479;
        double actual = strategy.getExpectedScore(expectation.getFirstElo(), expectation.getSecondElo());

        Assert.assertEquals(expected, actual, 0.0000000001d);
    }

    @Test
    public void getActualScore_withDefaultEloExpectation_returnsActualScore() throws Exception {
        double expected = 0.75;
        double actual = strategy.getActualScore(expectation.getFirstGoalsScored(), expectation.getSecondGoalsScored(), expectation.getMaxGoals());

        Assert.assertEquals(expected, actual, 0.0000001d);
    }

    @Test
    public void calculate_withDefaultEloExpectation_returnsRating() throws Exception {
        double expected = 2992.12960861;
        double actual = strategy.calculateNewRating(expectation.getFirstElo(), expectation.getSecondElo(),
                expectation.getFirstGoalsScored(), expectation.getSecondGoalsScored(), expectation.getMaxGoals());

        Assert.assertEquals(expected, actual, 0.0000001d);
    }
}