package nl.jft.network.nio;

import nl.jft.network.ServerTest;
import nl.jft.network.message.MessageHandlerChainSet;
import org.nustaq.serialization.FSTConfiguration;

/**
 * @author Lesley
 */
public class NioServerTest extends ServerTest<NioServer> {

    @Override
    public NioServer makeEndPoint() {
        return new NioServer();
    }

    @Override
    public NioServer makeEndPoint(FSTConfiguration serializer, MessageHandlerChainSet chainSet) {
        return new NioServer(serializer, chainSet);
    }
}