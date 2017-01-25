package nl.jft.common.glicko;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * @author Oscar de Leeuw
 */
public class StandardGlickoCalculatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private StandardGlickoCalculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new StandardGlickoCalculator();
    }

    @Test
    public void mu_with1500Argument_returnsDouble() throws Exception {
        double expected = 0;
        double actual = calculator.mu(1500);

        assertEquals(expected, actual, 0.00001d);
    }

    @Test
    public void mu_with2000Argument_returnsDouble() throws Exception {
        double expected = 2.8782312;
        double actual = calculator.mu(2000);

        assertEquals(expected, actual, 0.00001d);
    }

    @Test
    public void mu_with1000Argument_returnsDouble() throws Exception {
        double expected = -2.87823124631;
        double actual = calculator.mu(1000);

        assertEquals(expected, actual, 0.00001d);
    }

    @Test
    public void mu_with1400Argument_returnsDouble() throws Exception {
        double expected = -0.5756;
        double actual = calculator.mu(1400);

        assertEquals(expected, actual, 0.0001d);
    }

    @Test
    public void mu_with1550Argument_returnsDouble() throws Exception {
        double expected = 0.2878;
        double actual = calculator.mu(1550);

        assertEquals(expected, actual, 0.0001d);
    }

    @Test
    public void mu_with1700Argument_returnsDouble() throws Exception {
        double expected = 1.1513;
        double actual = calculator.mu(1700);

        assertEquals(expected, actual, 0.0001d);
    }

    @Test
    public void phi_with350Argument_returnsDouble() throws Exception {
        double expected = 2.01476187242;
        double actual = calculator.phi(350);

        assertEquals(expected, actual, 0.00001d);
    }

    @Test
    public void phi_with250Argument_returnsDouble() throws Exception {
        double expected = 1.43911562315;
        double actual = calculator.phi(250);

        assertEquals(expected, actual, 0.00001d);
    }

    @Test
    public void phi_with500Argument_returnsDouble() throws Exception {
        double expected = 2.87823124631;
        double actual = calculator.phi(500);

        assertEquals(expected, actual, 0.00001d);
    }

    @Test
    public void phi_with30Argument_returnsDouble() throws Exception {
        double expected = 0.1727;
        double actual = calculator.phi(30);

        assertEquals(expected, actual, 0.0001d);
    }

    @Test
    public void phi_with100Argument_returnsDouble() throws Exception {
        double expected = 0.5756;
        double actual = calculator.phi(100);

        assertEquals(expected, actual, 0.0001d);
    }

    @Test
    public void phi_with300Argument_returnsDouble() throws Exception {
        double expected = 1.7269;
        double actual = calculator.phi(300);

        assertEquals(expected, actual, 0.0001d);
    }

    @Test
    public void g_with500Argument_returnsDouble() throws Exception {
        double expected = 0.53314574144;
        double actual = calculator.g(500);

        assertEquals(expected, actual, 0.0000001d);
    }

    @Test
    public void g_with350Argument_returnsDouble() throws Exception {
        double expected = 0.6690694125804828;
        double actual = calculator.g(350);

        assertEquals(expected, actual, 0.0000001d);
    }

    @Test
    public void g_with300Argument_returnsDouble() throws Exception {
        double expected = 0.724235478087;
        double actual = calculator.g(300);

        assertEquals(expected, actual, 0.0000001d);
    }

    @Test
    public void g_with200Argument_returnsDouble() throws Exception {
        double expected = 0.8442815045061;
        double actual = calculator.g(200);

        assertEquals(expected, actual, 0.0000001d);
    }

    @Test
    public void g_with100Argument_returnsDouble() throws Exception {
        double expected = 0.9531;
        double actual = calculator.g(100);

        assertEquals(expected, actual, 0.0001d);
    }

    @Test
    public void g_with30Argument_returnsDouble() throws Exception {
        double expected = 0.9955;
        double actual = calculator.g(30);

        assertEquals(expected, actual, 0.0001d);
    }

    @Test
    public void e_with1500Rating2000Rating350Deviation_returnsDouble() throws Exception {
        double expected = 0.1272232377;
        double actual = calculator.e(1500, 2000, 350);

        assertEquals(expected, actual, 0.0000001d);
    }

    @Test
    public void e_with1000Rating3000Rating350Deviation_returnsDouble() throws Exception {
        double expected = 0.00045129138;
        double actual = calculator.e(1000, 3000, 350);

        assertEquals(expected, actual, 0.0000001d);
    }

    @Test
    public void e_with1500Rating1500Rating250Deviation_returnsDouble() throws Exception {
        double expected = 0.5;
        double actual = calculator.e(1500, 1500, 250);

        assertEquals(expected, actual, 0.0000001d);
    }

    @Test
    public void e_with1500Rating1400Rating30Deviation_returnsDouble() throws Exception {
        double expected = 0.639;
        double actual = calculator.e(1500, 1400, 30);

        assertEquals(expected, actual, 0.001d);
    }

    @Test
    public void e_with1500Rating1550Rating100Deviation_returnsDouble() throws Exception {
        double expected = 0.432;
        double actual = calculator.e(1500, 1550, 100);

        assertEquals(expected, actual, 0.001d);
    }

    @Test
    public void e_with1500Rating1700Rating300Deviation_returnsDouble() throws Exception {
        double expected = 0.303;
        double actual = calculator.e(1500, 1700, 300);

        assertEquals(expected, actual, 0.001d);
    }

    @Test
    public void v_with1500Rating2000Rating350Deviation_returnsDouble() throws Exception {
        double expected = 20.1181494346357595;
        double actual = calculator.v(1500, 2000, 350);

        //e = 0.1272232377
        //g = 0.6690694125804828

        assertEquals(expected, actual, 0.0000001d);
    }

    @Test
    public void v_with1000Rating3000Rating350Deviation_returnsDouble() throws Exception {
        double expected = 4952.18257166890839;
        double actual = calculator.v(1000, 3000, 350);

        //e = 0.00045129138
        //g = 0.6690694125804828

        assertEquals(expected, actual, 0.0001d);
    }

    @Test
    public void v_with1500Rating1500Rating200Deviation_returnsDouble() throws Exception {
        double expected = 5.61158364199695;
        double actual = calculator.v(1500, 1500, 200);

        //e = 0.5
        //g = 0.8442815045061

        assertEquals(expected, actual, 0.0000001d);
    }
}