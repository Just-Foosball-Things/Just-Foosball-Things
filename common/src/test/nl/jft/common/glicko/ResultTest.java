package nl.jft.common.glicko;

import nl.jft.common.util.util.CommonTestUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Oscar de Leeuw
 */
public class ResultTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void constructor_withNullFirstArgument_throwsException() throws Exception {
        expectedException.expect(NullPointerException.class);

        makeResult(null, CommonTestUtil.getDefaultRating(), 5, 10);
    }

    @Test
    public void constructor_withNullSecondArgument_throwsException() throws Exception {
        expectedException.expect(NullPointerException.class);

        makeResult(CommonTestUtil.getDefaultRating(), null, 5, 10);
    }

    @Test
    public void constructor_withSameArgument_throwsException() throws Exception {
        expectedException.expect(IllegalArgumentException.class);

        Rating winner = CommonTestUtil.getDefaultRating();
        Rating loser = winner;

        makeResult(winner, loser, 5, 10);
    }

    @Test
    public void constructor_withDifferentArgument_isNotNull() throws Exception {
        Rating winner = CommonTestUtil.getDefaultRating();
        Rating loser = CommonTestUtil.getDefaultRating();

        Result result = makeResult(winner, loser, 5, 10);

        assertNotNull(result);
    }

    @Test
    public void constructor_withTooLargeGoalDifference_throwsException() throws Exception {
        expectedException.expect(IllegalArgumentException.class);

        Rating winner = CommonTestUtil.getDefaultRating();
        Rating loser = CommonTestUtil.getDefaultRating();

        Result result = makeResult(winner, loser, 11, 10);
    }

    @Test
    public void constructor_withNegativeGoalDifference_throwsException() throws Exception {
        expectedException.expect(IllegalArgumentException.class);

        Rating winner = CommonTestUtil.getDefaultRating();
        Rating loser = CommonTestUtil.getDefaultRating();

        Result result = makeResult(winner, loser, -11, 10);
    }

    @Test
    public void constructor_withZeroGoalDifference_throwsException() throws Exception {
        expectedException.expect(IllegalArgumentException.class);

        Rating winner = CommonTestUtil.getDefaultRating();
        Rating loser = CommonTestUtil.getDefaultRating();

        Result result = makeResult(winner, loser, 0, 10);
    }

    @Test
    public void constructor_withNegativeMaxGoal_throwsException() throws Exception {
        expectedException.expect(IllegalArgumentException.class);

        Rating winner = CommonTestUtil.getDefaultRating();
        Rating loser = CommonTestUtil.getDefaultRating();

        Result result = makeResult(winner, loser, 5, -10);
    }

    @Test
    public void constructor_withZeroMaxGoal_throwsException() throws Exception {
        expectedException.expect(IllegalArgumentException.class);

        Rating winner = CommonTestUtil.getDefaultRating();
        Rating loser = CommonTestUtil.getDefaultRating();

        Result result = makeResult(winner, loser, 5, 0);
    }

    @Test
    public void getWinner_withDefault_returnsRating() throws Exception {
        Result result = CommonTestUtil.getDefaultResult();

        Rating expected = CommonTestUtil.getDefaultRating();
        Rating actual = result.getWinner();

        assertEquals(expected, actual);
    }

    @Test
    public void getLoser_withDefault_returnsRating() throws Exception {
        Result result = CommonTestUtil.getDefaultResult();

        Rating expected = CommonTestUtil.getDefaultRating();
        Rating actual = result.getLoser();

        assertEquals(expected, actual);
    }

    @Test
    public void getGoalDifference_withDefault_returnsInt() throws Exception {
        Result result = CommonTestUtil.getDefaultResult(); //GoalDifference = 5

        int expected = 5;
        int actual = result.getGoalDifference();

        assertEquals(expected, actual);
    }

    @Test
    public void getMaximumGoal_withDefault_returnsInt() throws Exception {
        Result result = CommonTestUtil.getDefaultResult(); //MaxGoals = 10

        int expected = 10;
        int actual = result.getMaxGoals();

        assertEquals(expected, actual);
    }

    private Result makeResult(Rating winner, Rating loser, int goalDif, int maxGoal) {
        return new Result(winner, loser, goalDif, maxGoal);
    }
}