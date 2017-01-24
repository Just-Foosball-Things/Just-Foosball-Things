package nl.jft.common.glicko;

import nl.jft.common.util.util.CommonTestUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * @author Oscar de Leeuw
 */
public class RatingTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void constructor_withNegativeDoubleFirstArgument_expectsException() throws Exception {
        expectedException.expect(IllegalArgumentException.class);

        new Rating(-1d, 350d, 0.06);
    }

    @Test
    public void constructor_withZeroDoubleFirstArgument_expectsException() throws Exception {
        expectedException.expect(IllegalArgumentException.class);

        new Rating(0d, 350d, 0.06);
    }

    @Test
    public void constructor_withPositiveDoubleFirstArgument_noException() throws Exception {
        Rating rating = new Rating(150d, 350d, 0.06);

        assertNotNull(rating);
    }

    @Test
    public void constructor_withNegativeDoubleSecondArgument_expectsException() throws Exception {
        expectedException.expect(IllegalArgumentException.class);

        new Rating(1500d, -350d, 0.06);
    }

    @Test
    public void constructor_withZeroDoubleSecondArgument_expectsException() throws Exception {
        expectedException.expect(IllegalArgumentException.class);

        new Rating(1500d, 0d, 0.06);
    }

    @Test
    public void constructor_withNegativeDoubleThirdArgument_expectsException() throws Exception {
        expectedException.expect(IllegalArgumentException.class);

        new Rating(1500d, 350d, -0.06);
    }

    @Test
    public void constructor_withZeroDoubleThirdArgument_expectsException() throws Exception {
        expectedException.expect(IllegalArgumentException.class);

        new Rating(1500d, 350d, 0d);
    }

    @Test
    public void getRating_withDefault_returnsDouble() throws Exception {
        Rating rating = CommonTestUtil.getDefaultRating(); //Rating = 1500

        double expected = 1500d;
        double actual = rating.getRating();

        assertEquals(expected, actual, 0.00001d);
    }

    @Test
    public void getDeviation_withDefault_returnsDouble() throws Exception {
        Rating rating = CommonTestUtil.getDefaultRating(); //Deviation = 350

        double expected = 350d;
        double actual = rating.getDeviation();

        assertEquals(expected, actual, 0.00001d);
    }

    @Test
    public void getVolatility_withDefault_returnsDouble() throws Exception {
        Rating rating = CommonTestUtil.getDefaultRating(); //Volatility = 0.06

        double expected = 0.06d;
        double actual = rating.getVolatility();

        assertEquals(expected, actual, 0.00001d);
    }

    @Test
    public void hashcode_sameObjects_areEqual() throws Exception {
        int expected = CommonTestUtil.getDefaultRating().hashCode();
        int actual = CommonTestUtil.getDefaultRating().hashCode();

        assertEquals(expected, actual);
    }

    @Test
    public void hashcode_otherObjects_areNotEqual() throws Exception {
        int expected = CommonTestUtil.getDefaultRating().hashCode();
        int actual = "string".hashCode();

        assertNotEquals(expected, actual);
    }

    @Test
    public void hashcode_nullObjects_areNotEqual() throws Exception {
        int expected = CommonTestUtil.getDefaultRating().hashCode();
        int actual = 0;

        assertNotEquals(expected, actual);
    }

    @Test
    public void equals_sameObjects_returnsTrue() throws Exception {
        Rating expected = CommonTestUtil.getDefaultRating();
        Rating actual = CommonTestUtil.getDefaultRating();

        boolean result = expected.equals(actual);
        assertTrue(result);
    }

    @Test
    public void equals_nullObjects_returnsFalse() throws Exception {
        Rating expected = CommonTestUtil.getDefaultRating();
        Rating actual = null;

        boolean result = expected.equals(actual);
        assertFalse(result);
    }

    @Test
    public void equals_otherObjects_returnsFalse() throws Exception {
        Rating expected = CommonTestUtil.getDefaultRating();
        String actual = "string";

        boolean result = expected.equals(actual);
        assertFalse(result);
    }
}