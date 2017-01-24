package nl.jft.logic.statistic;

import nl.jft.logic.statistic.impl.EloStatistic;
import nl.jft.logic.util.LogicTestUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * @author Lesley
 */
public class StatisticCollectionTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void addStatistic_nullStatistic_throwsException() {
        expectedException.expect(NullPointerException.class);

        StatisticCollection collection = LogicTestUtil.makeDefaultStatisticCollection();
        collection.addStatistic(null);
    }

    @Test
    public void addStatistic_whenCalled_addsStatistic() {
        StatisticCollection collection = LogicTestUtil.makeDefaultStatisticCollection();
        EloStatistic statistic = LogicTestUtil.makeDefaultEloStatistic();

        collection.addStatistic(statistic);

        EloStatistic expected = statistic;
        EloStatistic actual = collection.getStatistic(EloStatistic.class);

        assertEquals(expected, actual);
    }

    @Test
    public void addStatistic_duplicateStatistic_throwsException() {
        expectedException.expect(IllegalArgumentException.class);

        StatisticCollection collection = LogicTestUtil.makeDefaultStatisticCollection();

        collection.addStatistic(LogicTestUtil.makeDefaultEloStatistic());
        collection.addStatistic(LogicTestUtil.makeDefaultEloStatistic());
    }

    @Test
    public void getStatistic_nullType_throwsException() {
        expectedException.expect(NullPointerException.class);

        StatisticCollection collection = LogicTestUtil.makeDefaultStatisticCollection();
        collection.getStatistic(null);
    }

    @Test
    public void getStatistic_nonExistentStatistic_throwsException() {
        expectedException.expect(IllegalArgumentException.class);

        StatisticCollection collection = LogicTestUtil.makeDefaultStatisticCollection();
        collection.getStatistic(EloStatistic.class);
    }

}