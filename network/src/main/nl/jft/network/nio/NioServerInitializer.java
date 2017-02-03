package nl.jft.network.nio;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.ssl.SslContext;

/**
 * A {@code NioServerInitializer} sets up the pipeline for a {@link NioServer} according to the Netty specification.
 *
 * @author Lesley
 */
final class NioServerInitializer extends ChannelInitializer<SocketChannel> {

    private final NioServer server;
    private final SslContext context;

    NioServerInitializer(NioServer server, SslContext context) {
        this.server = server;
        this.context = context;
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(context.newHandler(ch.alloc()));
        pipeline.addLast(new MessageCodec(server));
        pipeline.addLast(new NioHandler(server));
    }


}
