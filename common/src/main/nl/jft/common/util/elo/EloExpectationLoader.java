package nl.jft.common.util.elo;

import java.util.List;

/**
 * The {@code EloExpectationLoader} is an interface that is used by the {@link EloExpectationCalculator} in order to load
 * a data-set of {@link EloExpectation EloExpectations}.
 *
 * @author Lesley
 * @author Oscar de Leeuw
 */
@FunctionalInterface
public interface EloExpectationLoader {

    /**
     * Loads a {@code List} of {@code EloExpectations}.
     *
     * @return A {@code List} of {@code EloExpectations}.
     */
    List<EloExpectation> load();

}
