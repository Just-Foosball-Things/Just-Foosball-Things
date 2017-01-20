package nl.jft.common.util.elo;

import nl.jft.common.util.util.mocks.MockEloCalculationStrategy;
import nl.jft.common.util.util.mocks.MockEloExpectationLoader;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Oscar de Leeuw
 */
public class EloExpectationCalculatorTest {
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