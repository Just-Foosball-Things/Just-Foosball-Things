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
    public void phi_with200Argument_returnsDouble() throws Exception {
        double expected = 1.1513;
        double actual = calculator.phi(200);

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

    @Test
    public void delta_with1500Rating2000Rating350Deviation_returnsDouble() throws Exception {
        double expected = 11.747957867219615;
        double actual = calculator.delta(1500, 2000, 350, 1);

        //v = 20.1181494346357595
        //e = 0.1272232377
        //g = 0.6690694125804828

        assertEquals(expected, actual, 0.0000001d);
    }

    @Test
    public void delta_with1000Rating3000Rating350Deviation_returnsDouble() throws Exception {
        double expected = 1655.18165406207357949;
        double actual = calculator.delta(1000, 3000, 350, 0.5);

        //v = 4952.18257166890839;
        //e = 0.00045129138
        //g = 0.6690694125804828

        assertEquals(expected, actual, 0.0001d);
    }

    @Test
    public void delta_with1500Rating1500Rating200Deviation_returnsDouble() throws Exception {
        double expected = -2.3688781399635;
        double actual = calculator.delta(1500, 1500, 200, 0);

        //v = 5.61158364199695
        //e = 0.5
        //g = 0.8442815045061

        assertEquals(expected, actual, 0.0000001d);
    }

    @Test
    public void a_with006Volatility_returnsDouble() throws Exception {
        double expected = -10.231991619;
        double actual = calculator.a(0.006);

        assertEquals(expected, actual, 0.0000001d);
    }

    @Test
    public void a_with007Volatility_returnsDouble() throws Exception {
        double expected = -9.92369025985364;
        double actual = calculator.a(0.007);

        assertEquals(expected, actual, 0.0001d);
    }

    @Test
    public void a_with005Volatility_returnsDouble() throws Exception {
        double expected = -10.59663473309607;
        double actual = calculator.a(0.005);

        assertEquals(expected, actual, 0.0000001d);
    }

    @Test
    public void f_testOne_returnsDouble() throws Exception {
        double expected = -19.7201890814611;
        double actual = calculator.f(1, 11.747957867219615, 1.43911562315, 20.1181494346357595, -10.231991619, 0.75);

        //delta = 11.747957867219615
        //v = 20.1181494346357595
        //phi = 1.43911562315
        //a = -10.231991619
        //tau = 0.75

        assertEquals(expected, actual, 0.0000001d);
    }

    @Test
    public void f_testTwo_returnsDouble() throws Exception {
        double expected = -19.26875089204392;
        double actual = calculator.f(1, 1655.18165406207357949, 2.01476187242, 4952.18257166890839, -9.92369025985364, 0.75);

        //delta = 1655.18165406207357949
        //v = 4952.18257166890839
        //phi = 2.01476187242
        //a = -9.92369025985364
        //tau = 0.75

        assertEquals(expected, actual, 0.0001d);
    }

    @Test
    public void f_testThree_returnsDouble() throws Exception {
        double expected = -19.0668560505;
        double actual = calculator.f(0.1, -2.368878, 2.87823, 5.6115836, -10.5966347, 0.75);

        //delta = -2.3688781399635
        //v = 5.61158364199695
        //phi = 2.87823124631
        //a = -10.59663473309607
        //tau = 0.75

        assertEquals(expected, actual, 0.1d);
    }

    @Test
    public void newSigma_testOne_returnsDouble() throws Exception {
        double expected = 0.06;
        double actual = calculator.newSigma(-2.3688781399635, 2.87823124631, 5.61158364199695, -5.62682, 0.75, 0.000001);

        //delta = -2.3688781399635
        //v = 5.61158364199695
        //phi = 2.87823124631
        //a = -10.231991619
        //tau = 0.75
        //convergence = 0.000001

        assertEquals(expected, actual, 0.0001d);
    }

    @Test
    public void newSigma_testTwo_returnsDouble() throws Exception {
        double expected = 0.06;
        double actual = calculator.newSigma(1655.18165406207357949, 2.01476187242, 4952.18257166890839, -5.62682, 0.75, 0.000001);

        //delta = 1655.18165406207357949
        //v = 4952.18257166890839
        //phi = 2.01476187242
        //a = -10.231991619
        //tau = 0.75
        //convergence = 0.000001

        assertEquals(expected, actual, 0.0001d);
    }

    @Test
    public void newSigma_testThree_returnsDouble() throws Exception {
        double expected = 0.05999;
        double actual = calculator.newSigma(-0.4834, 1.1513, 1.7785, -5.62682, 0.5, 0.000001);

        assertEquals(expected, actual, 0.00001d);
    }


}