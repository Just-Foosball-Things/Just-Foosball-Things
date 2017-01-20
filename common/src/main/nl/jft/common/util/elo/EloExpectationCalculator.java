package nl.jft.common.util.elo;

import java.util.ArrayList;
import java.util.List;

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
     * @param loader   The {@code EloExpectationLoader} that will be used to load {@code EloExpectations}.
     * @param strategy The {@code EloCalculationStrategy} that will be used to tested with the {@code EloExpectations}.
     */
    public EloExpectationCalculator(EloExpectationLoader loader, EloCalculationStrategy strategy) {
        this.loader = loader;
        this.strategy = strategy;
    }

    /**
     * Loads the {@code EloExpectations} with the injected {@code EloExpectationLoader} and runs them through the injected
     * {@code EloCalculationStrategy} in order to calculate the new Elo-ratings and returns them in a list of {@code EloExpectationResults}.
     *
     * @return A list of {@code EloExpectationResults}.
     */
    public List<EloExpectationResult> calculate() {
        List<EloExpectation> expectations = loader.load();
        List<EloExpectationResult> results = new ArrayList<>();

        for (EloExpectation exp : expectations) {
            double newRating1 = strategy.calculateNewRating(exp.getElo1(), exp.getGoals1(), exp.getGoals2(), exp.getMaxGoals());
            double newRating2 = strategy.calculateNewRating(exp.getElo2(), exp.getGoals2(), exp.getGoals1(), exp.getMaxGoals());

            double error1 = Math.abs(newRating1 - exp.getDelta1());
            double error2 = Math.abs(newRating2 - exp.getDelta2());

            results.add(new EloExpectationResult(exp, newRating1, newRating2, error1, error2));
        }

        return results;
    }

}
