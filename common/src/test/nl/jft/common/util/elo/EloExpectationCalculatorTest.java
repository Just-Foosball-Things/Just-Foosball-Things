package nl.jft.common.util.elo;

import nl.jft.common.util.util.mocks.MockEloCalculationStrategy;
import nl.jft.common.util.util.mocks.MockEloExpectationLoader;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Oscar de Leeuw
 */
public class EloExpectationCalculatorTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    private MockEloExpectationLoader loader;
    private MockEloCalculationStrategy strategy;
    private EloExpectationCalculator calculator;

    @Before
    public void setUp() throws Exception {
        loader = new MockEloExpectationLoader();
        strategy = new MockEloCalculationStrategy();

        calculator = new EloExpectationCalculator(loader, strategy);
    }

    @Test
    public void construct_nullLoader_throwsException() {
        expectedException.expect(NullPointerException.class);

        EloExpectationCalculator calculator = new EloExpectationCalculator(null, strategy);
    }

    @Test
    public void construct_nullStrategy_throwsException() {
        expectedException.expect(NullPointerException.class);

        EloExpectationCalculator calculator = new EloExpectationCalculator(loader, null);
    }

    @Test
    public void calculate_whenCalled_checksLoader() throws Exception {
        calculator.calculate();

        assertTrue(loader.hasBeenCalled);
    }

    @Test
    public void calculate_whenCalled_checksStrategy() throws Exception {
        calculator.calculate();

        assertTrue(strategy.hasBeenCalled);
    }

    @Test
    public void calculate_whenCalled_returnsNonEmptyList() throws Exception {
        List<EloExpectationResult> results = calculator.calculate();

        assertNotNull(results);
    }

}