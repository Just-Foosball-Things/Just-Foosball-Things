package nl.jft.common.util.elo;

import java.util.List;

/**
 * The {@code EloExpectationLoader} is an interface that is used by the {@link EloExpectationCalculator} in order to load
 * a dataset of {@link EloExpectation EloExpectations}.
 *
 * @author Lesley
 * @author Oscar de Leeuw
 */
@FunctionalInterface
public interface EloExpectationLoader {

    /**
     * Loads a list of {@code EloExpectations}.
     *
     * @return A List of {@code EloExpectations}.
     */
    List<EloExpectation> load();

}
