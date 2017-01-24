package nl.jft.common.util.elo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The {@code EloExpectationCalculator} calculates how a given {@link EloCalculationStrategy} would function with
 * a given test set of {@link EloExpectation EloExpectations}.
 *
 * @author Lesley
 * @author Oscar de Leeuw
 */
public class EloExpectationCalculator {

    private final EloExpectationLoader loader;
    private final EloCalculationStrategy strategy;

    /**
     * Creates a new {@code EloExpectationCalculator}.
     *
     * @param loader   The {@code EloExpectationLoader} that will be used to load {@code EloExpectations},
     *                 should not be {@code null}.
     * @param strategy The {@code EloCalculationStrategy} that will be used to tested with the {@code EloExpectations},
     *                 should not be {@code null}.
     */
    public EloExpectationCalculator(EloExpectationLoader loader, EloCalculationStrategy strategy) {
        this.loader = Objects.requireNonNull(loader);
        this.strategy = Objects.requireNonNull(strategy);
    }

    /**
     * Loads the {@link EloExpectation EloExpectations} with the injected {@link EloExpectationLoader} and runs them through the injected
     * {@link EloCalculationStrategy} in order to calculate the new Elo-ratings and returns them in a {@code List} of {@code EloExpectationResults}.
     *
     * @return A {@code List} of {@code EloExpectationResults}.
     */
    public List<EloExpectationResult> calculate() {
        List<EloExpectation> expectations = loader.load();
        List<EloExpectationResult> results = new ArrayList<>();

        for (EloExpectation exp : expectations) {
            double newRating1 = strategy.calculateNewRating(exp.getFirstElo(), exp.getSecondElo(), exp.getFirstGoalsScored(), exp.getSecondGoalsScored(), exp.getMaxGoals());
            double newRating2 = strategy.calculateNewRating(exp.getSecondElo(), exp.getFirstElo(), exp.getSecondGoalsScored(), exp.getFirstGoalsScored(), exp.getMaxGoals());

            double error1 = newRating1 - exp.getFirstElo() - exp.getFirstDelta();
            double error2 = newRating2 - exp.getSecondElo() - exp.getSecondDelta();

            results.add(new EloExpectationResult(exp, newRating1, newRating2, error1, error2));
        }

        return results;
    }

}
