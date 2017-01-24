package nl.jft.common.util.elo;

import nl.jft.common.util.util.CommonTestUtil;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Oscar de Leeuw
 */
public class EloExpectationResultTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void constructor_withNullArgument_expectsNullPointerException() throws Exception {
        expectedException.expect(NullPointerException.class);

        EloExpectationResult result = new EloExpectationResult(null, 0, 0, 0, 0);
    }

    @Test
    public void getNewRating1_withDefault_returnsDouble() throws Exception {
        EloExpectationResult result = CommonTestUtil.getDefaultExpectationResult(); //newRating1 = 3010

        double expected = 3010d;
        double actual = result.getNewFirstRating();

        Assert.assertEquals(expected, actual, 0.01d);
    }

    @Test
    public void getNewRating2_withDefault_returnsDouble() throws Exception {
        EloExpectationResult result = CommonTestUtil.getDefaultExpectationResult(); //newRating2 = 2498

        double expected = 2498d;
        double actual = result.getNewSecondRating();

        Assert.assertEquals(expected, actual, 0.01d);
    }

    @Test
    public void getError1_withDefault_returnsDouble() throws Exception {
        EloExpectationResult result = CommonTestUtil.getDefaultExpectationResult(); //error1 = 0

        double expected = 0d;
        double actual = result.getFirstError();

        Assert.assertEquals(expected, actual, 0.01d);
    }

    @Test
    public void getError2_withDefault_returnsDouble() throws Exception {
        EloExpectationResult result = CommonTestUtil.getDefaultExpectationResult(); //error2 = 0

        double expected = 0d;
        double actual = result.getSecondError();

        Assert.assertEquals(expected, actual, 0.01d);
    }

    @Test
    public void getEloExpectation_withDefault_returnsEloExpectation() throws Exception {
        EloExpectationResult result = CommonTestUtil.getDefaultExpectationResult(); //eloExpectation = defaultEloExpectation

        EloExpectation expected = CommonTestUtil.getDefaultExpectation();
        EloExpectation actual = result.getExpectation();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toString_withDefault_shouldNotBeNull() throws Exception {
        EloExpectationResult result = CommonTestUtil.getDefaultExpectationResult();

        Assert.assertNotNull(result.toString());
    }
}
