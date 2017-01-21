package nl.jft.common.util.util.mocks;

import nl.jft.common.util.elo.EloCalculationStrategy;

/**
 * @author Oscar de Leeuw
 */
public class MockEloCalculationStrategy implements EloCalculationStrategy {

    public boolean hasBeenCalled;

    @Override
    public double calculateNewRating(double currentRating, int goalsScored, int goalsConceded, int maxGoals) {
        hasBeenCalled = true;
        return 0;
    }

}
