package nl.jft.network;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Lesley
 */
public abstract class ServerTest<T extends Server> {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    protected abstract T makeServer();

    @Test
    public final void bind_nullAddress_throwsException() throws Exception {
        expectedException.expect(NullPointerException.class);

        T server = makeServer();
        server.bind(null);
    }

}