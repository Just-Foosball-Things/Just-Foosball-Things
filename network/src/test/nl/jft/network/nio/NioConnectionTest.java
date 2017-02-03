package nl.jft.network.nio;

import io.netty.channel.Channel;
import nl.jft.network.ConnectionTest;
import org.junit.Test;

import static org.mockito.Mockito.mock;

/**
 * @author Lesley
 */
public class NioConnectionTest extends ConnectionTest<NioConnection> {

    @Override
    public NioConnection makeConnection() {
        Channel mockChannel = mock(Channel.class);
        return new NioConnection(mockChannel);
    }

    @Test
    public void construct_nullChannel_throwsException() {
        expectedException.expect(NullPointerException.class);

        NioConnection connection = new NioConnection(null);
    }
}