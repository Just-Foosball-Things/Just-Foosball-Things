package nl.jft.logic.statistic.impl;

import nl.jft.logic.participant.Elo;
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
public class EloStatisticTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void getType_whenCalled_returnsSameClass() {
        EloStatistic statistic = LogicTestUtil.makeDefaultEloStatistic();

        Class<? extends Statistic> expected = EloStatistic.class;
        Class<? extends Statistic> actual = statistic.getType();

        assertEquals(expected, actual);
    }

    @Test
    public void addMatchResult_nullMatchResult_throwsException() {
        expectedException.expect(NullPointerException.class);

        EloStatistic statistic = LogicTestUtil.makeDefaultEloStatistic();
        statistic.addElo(null);
    }

    @Test
    public void addMatchResult_whenCalled_addsMatchResult() {
        EloStatistic statistic = LogicTestUtil.makeDefaultEloStatistic();
        Elo elo = LogicTestUtil.makeDefaultElo();

        statistic.addElo(elo);

        List<Elo> expected = new ArrayList<Elo>() {{
            add(elo);
        }};
        List<Elo> actual = statistic.getValues();

        assertEquals(expected, actual);
    }

    @Test
    public void removeMatchResult_nullMatchResult_throwsException() {
        expectedException.expect(NullPointerException.class);

        EloStatistic statistic = LogicTestUtil.makeDefaultEloStatistic();
        statistic.removeElo(null);
    }

    @Test
    public void removeMatchResult_whenCalled_removesMatchResult() {
        EloStatistic statistic = LogicTestUtil.makeDefaultEloStatistic();
        Elo elo = LogicTestUtil.makeDefaultElo();

        statistic.addElo(elo);
        statistic.removeElo(elo);

        List<Elo> expected = new ArrayList<>();
        List<Elo> actual = statistic.getValues();

        assertEquals(expected, actual);
    }

    @Test
    public void getValues_byDefault_returnsEmptyList() {
        EloStatistic statistic = LogicTestUtil.makeDefaultEloStatistic();

        List<Elo> expected = new ArrayList<>();
        List<Elo> actual = statistic.getValues();

        assertEquals(expected, actual);
    }

}