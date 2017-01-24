package nl.jft.logic.statistic.impl;

import nl.jft.logic.match.MatchResult;
import nl.jft.logic.statistic.AbstractStatistic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * A {@code MatchStatistic} is a {@link nl.jft.logic.statistic.Statistic} which keeps track of {@link MatchResult MatchResults}.
 *
 * @author Lesley
 */
public class MatchStatistic extends AbstractStatistic<MatchResult> {

    private final List<MatchResult> results = new ArrayList<>();

    /**
     * Adds a {@link MatchResult} to this {@code MatchStatistic}.
     *
     * @param result The {@code MatchResults} to add, should not be {@code null}.
     */
    public void addMatchResult(MatchResult result) {
        Objects.requireNonNull(result);

        synchronized (results) {
            results.add(result);
        }
    }

    /**
     * Removes a {@link nl.jft.logic.match.MatchResult} from this {@code MatchStatistic}, given that it was added in the first place.
     *
     * @param result The {@code MatchResult} to remove, should not be {@code null}.
     */
    public void removeMatchResult(MatchResult result) {
        Objects.requireNonNull(result);

        synchronized (results) {
            results.remove(result);
        }
    }

    @Override
    public List<MatchResult> getValues() {
        synchronized (results) {
            return Collections.unmodifiableList(results);
        }
    }

}
