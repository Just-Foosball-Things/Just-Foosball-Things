package nl.jft.common.util.elo;

import nl.jft.common.util.util.CommonTestUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * @author Oscar de Leeuw
 */
public class EloExpectationTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void constructor_withInvalidString_expectIllegalArgumentException() throws Exception {
        expectedException.expect(IllegalArgumentException.class);

        EloExpectation expectation = new EloExpectation("1,2");
    }

    @Test
    public void constructor_withNullString_expectNullPointerException() throws Exception {
        expectedException.expect(NullPointerException.class);

        EloExpectation expectation = new EloExpectation(null);
    }

    @Test
    public void constructor_withEmptyString_expectIllegalArgumentException() throws Exception {
        expectedException.expect(IllegalArgumentException.class);

        EloExpectation expectation = new EloExpectation("");
    }

    @Test
    public void constructor_withInvalidDouble_expectNumberFormatException() throws Exception {
        expectedException.expect(NumberFormatException.class);

        EloExpectation expectation = new EloExpectation("3000,2500,10.0,5,10,10,-2");
    }

    @Test
    public void getElo1_whenCalled_returnDouble() throws Exception {
        EloExpectation expectation = CommonTestUtil.getDefaultExpectation(); //Elo1 = 3000.

        double expected = 3000d;
        double actual = expectation.getElo1();

        assertEquals(expected, actual, 0.01d);
    }

    @Test
    public void getElo2_whenCalled_returnDouble() throws Exception {
        EloExpectation expectation = CommonTestUtil.getDefaultExpectation(); //Elo2 = 2500.

        double expected = 2500d;
        double actual = expectation.getElo2();

        assertEquals(expected, actual, 0.01d);
    }

    @Test
    public void getDelta1_whenCalled_returnDouble() throws Exception {
        EloExpectation expectation = CommonTestUtil.getDefaultExpectation(); //Delta1 = 10.

        double expected = 10d;
        double actual = expectation.getDelta1();

        assertEquals(expected, actual, 0.01d);
    }

    @Test
    public void getDelta2_whenCalled_returnDouble() throws Exception {
        EloExpectation expectation = CommonTestUtil.getDefaultExpectation(); //Delta2 = -2.

        double expected = -2d;
        double actual = expectation.getDelta2();

        assertEquals(expected, actual, 0.01d);
    }

    @Test
    public void getGoals1_whenCalled_returnInt() throws Exception {
        EloExpectation expectation = CommonTestUtil.getDefaultExpectation(); //Goals1 = 10.

        int expected = 10;
        int actual = expectation.getGoals1();

        assertEquals(expected, actual);
    }

    @Test
    public void getGoals2_whenCalled_returnInt() throws Exception {
        EloExpectation expectation = CommonTestUtil.getDefaultExpectation(); //Goals1 = 5.

        int expected = 5;
        int actual = expectation.getGoals2();

        assertEquals(expected, actual);
    }

    @Test
    public void getMaxGoals_whenCalled_returnInt() throws Exception {
        EloExpectation expectation = CommonTestUtil.getDefaultExpectation(); //MaxGoals = 10.

        int expected = 10;
        int actual = expectation.getMaxGoals();

        assertEquals(expected, actual);
    }
}