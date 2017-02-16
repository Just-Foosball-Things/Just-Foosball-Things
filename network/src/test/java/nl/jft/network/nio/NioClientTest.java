package nl.jft.network.nio;

import nl.jft.network.ClientTest;
import nl.jft.network.message.MessageHandlerChainSet;
import org.nustaq.serialization.FSTConfiguration;

/**
 * @author Lesley
 */
public class NioClientTest extends ClientTest<NioClient> {

    @Override
    public NioClient makeEndPoint() {
        return new NioClient();
    }

    @Override
    public NioClient makeEndPoint(FSTConfiguration serializer, MessageHandlerChainSet chainSet) {
        return new NioClient(serializer, chainSet);
    }
}