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

        EloCalculationStrategy strategy = mock(EloCalculationStrategy.class);

        EloExpectationCalculator calculator = new EloExpectationCalculator(null, strategy);
    }

    @Test
    public void construct_nullStrategy_throwsException() {
        expectedException.expect(NullPointerException.class);

        EloExpectationLoader loader = mock(EloExpectationLoader.class);

        EloExpectationCalculator calculator = new EloExpectationCalculator(loader, null);
    }

    @Test
    public void calculate_whenCalled_checksLoader() throws Exception {
        EloExpectationLoader loader = mock(EloExpectationLoader.class);
        EloCalculationStrategy strategy = mock(EloCalculationStrategy.class);
        EloExpectationCalculator calculator = new EloExpectationCalculator(loader, strategy);

        calculator.calculate();

        verify(loader).load();
    }

    @Test
    public void calculate_whenCalled_checksStrategy() throws Exception {
        EloExpectationLoader loader = mock(EloExpectationLoader.class);
        EloCalculationStrategy strategy = mock(EloCalculationStrategy.class);
        EloExpectationCalculator calculator = new EloExpectationCalculator(loader, strategy);

        when(loader.load()).thenReturn(new ArrayList<EloExpectation>() {{
            add(CommonTestUtil.getDefaultExpectation());
        }});

        calculator.calculate();

        verify(strategy, times(2)).calculateNewRating(anyDouble(), anyDouble(), anyInt(), anyInt(), anyInt());
    }

    @Test
    public void calculate_whenCalled_returnsNonEmptyList() throws Exception {
        EloExpectationLoader loader = mock(EloExpectationLoader.class);
        EloCalculationStrategy strategy = mock(EloCalculationStrategy.class);
        EloExpectationCalculator calculator = new EloExpectationCalculator(loader, strategy);

        List<EloExpectationResult> results = calculator.calculate();

        assertNotNull(results);
    }

}