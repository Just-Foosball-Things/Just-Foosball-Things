package nl.jft.network.nio;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.ssl.SslContext;

/**
 * A {@code NioClientInitializer} sets up the pipeline for a {@link NioClient} according to the Netty specification.
 *
 * @author Lesley
 */
final class NioClientInitializer extends ChannelInitializer<SocketChannel> {

    private final NioClient client;
    private final SslContext context;

    NioClientInitializer(NioClient client, SslContext context) {
        this.client = client;
        this.context = context;
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(context.newHandler(ch.alloc()));
        pipeline.addLast(new MessageCodec(client));
        pipeline.addLast(new NioHandler(client));
    }

}
