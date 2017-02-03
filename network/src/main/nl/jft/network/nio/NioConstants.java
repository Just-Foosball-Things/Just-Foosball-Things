package nl.jft.network.nio;

import io.netty.util.AttributeKey;
import nl.jft.network.Connection;

/**
 * @author Lesley
 */
public final class NioConstants {

    public static final AttributeKey<Connection> ATTRIBUTE_CONNECTION = AttributeKey.valueOf("connection");

    private NioConstants() {
        throw new UnsupportedOperationException("Should not be called.");
    }

}
