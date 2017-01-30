package nl.jft.common.util.elo;

import nl.jft.common.util.util.CommonTestUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * @author Oscar de Leeuw
 */
public class EloExpectationCalculatorTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void construct_nullLoader_throwsException() {
        expectedException.expect(NullPointerException.class);

        EloCalculationStrategy stubStrategy = mock(EloCalculationStrategy.class);

        EloExpectationCalculator calculator = new EloExpectationCalculator(null, stubStrategy);
    }

    @Test
    public void construct_nullStrategy_throwsException() {
        expectedException.expect(NullPointerException.class);

        EloExpectationLoader stubLoader = mock(EloExpectationLoader.class);

        EloExpectationCalculator calculator = new EloExpectationCalculator(stubLoader, null);
    }

    @Test
    public void calculate_whenCalled_checksLoader() throws Exception {
        EloExpectationLoader mockLoader = mock(EloExpectationLoader.class);
        EloCalculationStrategy stubStrategy = mock(EloCalculationStrategy.class);
        EloExpectationCalculator calculator = new EloExpectationCalculator(mockLoader, stubStrategy);

        calculator.calculate();

        verify(mockLoader).load();
    }

    @Test
    public void calculate_whenCalled_checksStrategy() throws Exception {
        EloExpectationLoader stubLoader = mock(EloExpectationLoader.class);
        EloCalculationStrategy mockStrategy = mock(EloCalculationStrategy.class);
        EloExpectationCalculator calculator = new EloExpectationCalculator(stubLoader, mockStrategy);

        when(stubLoader.load()).thenReturn(new ArrayList<EloExpectation>() {{
            add(CommonTestUtil.getDefaultExpectation());
        }});

        calculator.calculate();

        verify(mockStrategy, times(2)).calculateNewRating(anyDouble(), anyDouble(), anyInt(), anyInt(), anyInt());
    }

    @Test
    public void calculate_whenCalled_returnsNonEmptyList() throws Exception {
        EloExpectationLoader stubLoader = mock(EloExpectationLoader.class);
        EloCalculationStrategy stubStrategy = mock(EloCalculationStrategy.class);
        EloExpectationCalculator calculator = new EloExpectationCalculator(stubLoader, stubStrategy);

        List<EloExpectationResult> results = calculator.calculate();

        assertNotNull(results);
    }

}