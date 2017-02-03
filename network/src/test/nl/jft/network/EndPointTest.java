package nl.jft.network;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Lesley
 */
public abstract class EndPointTest<E extends EndPoint> {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    public abstract E makeEndPoint();

    @Test
    public final void addListener_nullListener_throwsException() {
        expectedException.expect(NullPointerException.class);

        E endPoint = makeEndPoint();
        endPoint.addListener(null);
    }

    @Test
    public final void removeListener_nullListener_throwsException() {
        expectedException.expect(NullPointerException.class);

        E endPoint = makeEndPoint();
        endPoint.removeListener(null);
    }

}
