package nl.jft.logic.statistic.impl;

import nl.jft.logic.match.MatchResult;
import nl.jft.logic.statistic.Statistic;
import nl.jft.logic.util.LogicTestUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Lesley
 */
public class MatchStatisticTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void getType_whenCalled_returnsSameClass() {
        MatchStatistic statistic = LogicTestUtil.makeDefaultMatchStatistic();

        Class<? extends Statistic> expected = MatchStatistic.class;
        Class<? extends Statistic> actual = statistic.getType();

        assertEquals(expected, actual);
    }

    @Test
    public void addMatchResult_nullMatchResult_throwsException() {
        expectedException.expect(NullPointerException.class);

        MatchStatistic statistic = LogicTestUtil.makeDefaultMatchStatistic();
        statistic.addMatchResult(null);
    }

    @Test
    public void addMatchResult_whenCalled_addsMatchResult() {
        MatchStatistic statistic = LogicTestUtil.makeDefaultMatchStatistic();
        MatchResult result = LogicTestUtil.makeDefaultMatchResult();

        statistic.addMatchResult(result);

        List<MatchResult> expected = new ArrayList<MatchResult>() {{
            add(LogicTestUtil.makeDefaultMatchResult());
        }};
        List<MatchResult> actual = statistic.getValues();

        assertEquals(expected, actual);
    }

    @Test
    public void removeMatchResult_nullMatchResult_throwsException() {
        expectedException.expect(NullPointerException.class);

        MatchStatistic statistic = LogicTestUtil.makeDefaultMatchStatistic();
        statistic.removeMatchResult(null);
    }

    @Test
    public void removeMatchResult_whenCalled_removesMatchResult() {
        MatchStatistic statistic = LogicTestUtil.makeDefaultMatchStatistic();
        MatchResult result = LogicTestUtil.makeDefaultMatchResult();

        statistic.addMatchResult(result);
        statistic.removeMatchResult(result);

        List<MatchResult> expected = new ArrayList<>();
        List<MatchResult> actual = statistic.getValues();

        assertEquals(expected, actual);
    }

    @Test
    public void getValues_byDefault_returnsEmptyList() {
        MatchStatistic statistic = LogicTestUtil.makeDefaultMatchStatistic();

        List<MatchResult> expected = new ArrayList<>();
        List<MatchResult> actual = statistic.getValues();

        assertEquals(expected, actual);
    }

}