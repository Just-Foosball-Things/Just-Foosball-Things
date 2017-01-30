package nl.jft.logic.statistic.impl;

import nl.jft.common.rating.Rating;
import nl.jft.logic.statistic.Statistic;
import nl.jft.logic.util.LogicTestUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Lesley
 */
public class RatingStatisticTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void getType_whenCalled_returnsSameClass() {
        RatingStatistic statistic = LogicTestUtil.makeDefaultRatingStatistic();

        Class<? extends Statistic> expected = RatingStatistic.class;
        Class<? extends Statistic> actual = statistic.getType();

        assertEquals(expected, actual);
    }

    @Test
    public void addMatchResult_nullMatchResult_throwsException() {
        expectedException.expect(NullPointerException.class);

        RatingStatistic statistic = LogicTestUtil.makeDefaultRatingStatistic();
        statistic.addRating(null);
    }

    @Test
    public void addMatchResult_whenCalled_addsMatchResult() {
        RatingStatistic statistic = LogicTestUtil.makeDefaultRatingStatistic();
        Rating rating = LogicTestUtil.makeDefaultRating();

        statistic.addRating(rating);

        List<Rating> expected = Arrays.asList(LogicTestUtil.makeDefaultRating());
        List<Rating> actual = statistic.getValues();

        assertEquals(expected, actual);
    }

    @Test
    public void removeMatchResult_nullMatchResult_throwsException() {
        expectedException.expect(NullPointerException.class);

        RatingStatistic statistic = LogicTestUtil.makeDefaultRatingStatistic();
        statistic.removeRating(null);
    }

    @Test
    public void removeMatchResult_whenCalled_removesMatchResult() {
        RatingStatistic statistic = LogicTestUtil.makeDefaultRatingStatistic();
        Rating rating = LogicTestUtil.makeDefaultRating();

        statistic.addRating(rating);
        statistic.removeRating(rating);

        List<Rating> expected = new ArrayList<>();
        List<Rating> actual = statistic.getValues();

        assertEquals(expected, actual);
    }

    @Test
    public void getValues_byDefault_returnsEmptyList() {
        RatingStatistic statistic = LogicTestUtil.makeDefaultRatingStatistic();

        List<Rating> expected = new ArrayList<>();
        List<Rating> actual = statistic.getValues();

        assertEquals(expected, actual);
    }

}