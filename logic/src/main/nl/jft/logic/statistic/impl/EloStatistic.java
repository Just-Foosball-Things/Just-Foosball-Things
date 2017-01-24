package nl.jft.logic.statistic.impl;

import nl.jft.logic.participant.Elo;
import nl.jft.logic.statistic.AbstractStatistic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * An {@code EloStatistic} is a {@link nl.jft.logic.statistic.Statistic} which keeps track of {@link Elo elos}.
 *
 * @author Lesley
 */
public class EloStatistic extends AbstractStatistic<Elo> {

    private final List<Elo> elos = new ArrayList<>();

    /**
     * Adds an {@link Elo} to this {@code EloStatistic}.
     *
     * @param elo The {@code Elo} to add, should not be {@code null}.
     */
    public void addElo(Elo elo) {
        Objects.requireNonNull(elo);

        synchronized (elos) {
            elos.add(elo);
        }
    }

    /**
     * Removes an {@link Elo} from this {@code EloStatistic}, given that it was added in the first place.
     *
     * @param elo The {@code Elo} to remove, should not be {@code null}.
     */
    public void removeElo(Elo elo) {
        Objects.requireNonNull(elo);

        synchronized (elos) {
            elos.remove(elo);
        }
    }

    @Override
    public List<Elo> getValues() {
        List<Elo> list = new ArrayList<>();

        synchronized (elos) {
            list.addAll(elos);
        }

        return list;
    }

}
