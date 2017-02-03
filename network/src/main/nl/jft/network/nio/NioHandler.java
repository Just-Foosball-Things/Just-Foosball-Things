package nl.jft.network.nio;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.ssl.NotSslRecordException;
import io.netty.handler.ssl.SslHandler;
import nl.jft.network.Connection;
import nl.jft.network.EndPoint;
import nl.jft.network.message.Message;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Lesley
 */
final class NioHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = Logger.getLogger(NioHandler.class.getSimpleName());

    private final EndPoint endPoint;

    NioHandler(EndPoint endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        SslHandler handler = ctx.pipeline().get(SslHandler.class);
        handler.handshakeFuture().addListener(f -> {
            if (!f.isSuccess()) {
                return;
            }

            Channel channel = ctx.channel();
            Connection connection = new NioConnection(channel);

            channel.attr(NioConstants.ATTRIBUTE_CONNECTION).set(connection);
            endPoint.getListeners().forEach(l -> l.connectionActive(connection));

            String suite = handler.engine().getSession().getCipherSuite();
            logger.log(Level.INFO, String.format("[%s] Connection (%s) active (Protected by %s).", getEndPointIdentifier(), channel, suite));
        });
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        Connection connection = channel.attr(NioConstants.ATTRIBUTE_CONNECTION).getAndSet(null);

        if (connection != null) {
            connection.close();

            endPoint.getListeners().forEach(l -> l.connectionInactive(connection));
        }

        logger.log(Level.INFO, String.format("[%s] Connection (%s) inactive.", getEndPointIdentifier(), channel));
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object object) throws Exception {
        if (!(object instanceof Message)) {
            throw new IllegalArgumentException(String.format("Received incorrect object (%s).", object));
        }

        Message message = (Message) object;
        endPoint.getMessageHandlers().notify(null, message);

        logger.log(Level.INFO, String.format("[%s] Connection (%s) received message (%s).", getEndPointIdentifier(), ctx.channel(), message));
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object object) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();

        if (cause instanceof NotSslRecordException) {
            return; // Suppress this message to avoid spam (it's not important anyways, we deal with it accordingly).
        }

        logger.log(Level.INFO, String.format("[%s] An exception occurred on a connection (%s).", getEndPointIdentifier(), ctx.channel()), cause);
    }

    private String getEndPointIdentifier() {
        return endPoint.getClass().getSimpleName();
    }
}
