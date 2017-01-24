package nl.jft.logic.statistic.impl;

import nl.jft.logic.participant.Title;
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
public class TitleStatisticTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void getType_whenCalled_returnsSameClass() {
        TitleStatistic statistic = LogicTestUtil.makeDefaultTitleStatistic();

        Class<? extends Statistic> expected = TitleStatistic.class;
        Class<? extends Statistic> actual = statistic.getType();

        assertEquals(expected, actual);
    }

    @Test
    public void addTitle_nullTitle_throwsException() {
        expectedException.expect(NullPointerException.class);

        TitleStatistic statistic = LogicTestUtil.makeDefaultTitleStatistic();
        statistic.addTitle(null);
    }

    @Test
    public void addTitle_whenCalled_addsTitle() {
        TitleStatistic statistic = LogicTestUtil.makeDefaultTitleStatistic();
        Title title = LogicTestUtil.makeDefaultTitle();

        statistic.addTitle(title);

        List<Title> expected = new ArrayList<Title>() {{
            add(title);
        }};
        List<Title> actual = statistic.getValues();

        assertEquals(expected, actual);
    }

    @Test
    public void removeTitle_nullTitle_throwsException() {
        expectedException.expect(NullPointerException.class);

        TitleStatistic statistic = LogicTestUtil.makeDefaultTitleStatistic();
        statistic.removeTitle(null);
    }

    @Test
    public void removeTitle_whenCalled_removesTitle() {
        TitleStatistic statistic = LogicTestUtil.makeDefaultTitleStatistic();
        Title title = LogicTestUtil.makeDefaultTitle();

        statistic.addTitle(title);
        statistic.removeTitle(title);

        List<Title> expected = new ArrayList<>();
        List<Title> actual = statistic.getValues();

        assertEquals(expected, actual);
    }

    @Test
    public void getValues_byDefault_returnsEmptyList() {
        TitleStatistic statistic = LogicTestUtil.makeDefaultTitleStatistic();

        List<Title> expected = new ArrayList<>();
        List<Title> actual = statistic.getValues();

        assertEquals(expected, actual);
    }

}