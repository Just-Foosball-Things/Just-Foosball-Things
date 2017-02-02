package nl.jft.network;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Lesley
 */
public abstract class ClientTest<T extends Client> {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    protected abstract T makeClient();

    @Test
    public final void bind_nullAddress_throwsException() throws Exception {
        expectedException.expect(NullPointerException.class);

        T client = makeClient();
        client.connect(null);
    }


}