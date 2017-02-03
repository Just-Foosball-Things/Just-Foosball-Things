package nl.jft.network.nio;

import io.netty.channel.Channel;
import nl.jft.network.Connection;
import nl.jft.network.message.Message;

import java.net.SocketAddress;
import java.util.Objects;

/**
 * @author Lesley
 */
public final class NioConnection implements Connection {

    private final Channel channel;

    NioConnection(Channel channel) {
        this.channel = Objects.requireNonNull(channel);
    }

    @Override
    public void write(Message message) {
        Objects.requireNonNull(message);

        channel.writeAndFlush(message);
    }

    @Override
    public void close() {
        channel.close();
    }

    @Override
    public SocketAddress getLocalAddress() {
        return channel.localAddress();
    }

    @Override
    public SocketAddress getRemoteAddress() {
        return channel.remoteAddress();
    }

    @Override
    public boolean isActive() {
        return channel.isActive();
    }

}
