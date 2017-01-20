package nl.jft.common.util.elo;

import java.util.List;

/**
 * @author Lesley
 */
public class EloCalculator {

    public void loadExpectations(EloExpectationLoader loader) {
        List<EloExpectation> expectations = loader.load();

        // Make formula
    }

}
