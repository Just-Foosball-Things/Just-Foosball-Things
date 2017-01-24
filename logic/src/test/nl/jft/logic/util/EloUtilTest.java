package nl.jft.logic.util;

import nl.jft.logic.participant.Elo;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertEquals;

/**
 * @author Lesley
 */
public class EloUtilTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void construct_whenCalled_throwsException() throws Throwable {
        expectedException.expect(UnsupportedOperationException.class);

        try {
            Constructor<EloUtil> constructor = EloUtil.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException e) {
            throw e;
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }
    }

    @Test
    public void calculateCombinedElo_nullFirstElo_throwsException() {
        expectedException.expect(NullPointerException.class);

        EloUtil.calculateCombinedElo(null, LogicTestUtil.makeDefaultElo());
    }

    @Test
    public void calculateCombinedElo_nullSecondElo_throwsException() {
        expectedException.expect(NullPointerException.class);

        EloUtil.calculateCombinedElo(LogicTestUtil.makeDefaultElo(), null);
    }

    @Test
    public void calculateCombinedElo_twoThousandAndFifteenHundred_returnsAverage() {
        Elo firstElo = LogicTestUtil.makeElo(2000);
        Elo secondElo = LogicTestUtil.makeElo(1500);

        Elo expected = LogicTestUtil.makeElo(1750);
        Elo actual = EloUtil.calculateCombinedElo(firstElo, secondElo);

        assertEquals(expected, actual);
    }

}