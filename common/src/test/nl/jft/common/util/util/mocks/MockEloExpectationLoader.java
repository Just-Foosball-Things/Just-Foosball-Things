package nl.jft.common.util.util.mocks;

import nl.jft.common.util.elo.EloExpectation;
import nl.jft.common.util.elo.EloExpectationLoader;
import nl.jft.common.util.util.CommonTestUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oscar de Leeuw
 */
public class MockEloExpectationLoader implements EloExpectationLoader {

    public boolean hasBeenCalled;

    @Override
    public List<EloExpectation> load() {
        hasBeenCalled = true;
        return new ArrayList<EloExpectation>() {{
            add(CommonTestUtil.getDefaultExpectation());
        }};
    }

}
