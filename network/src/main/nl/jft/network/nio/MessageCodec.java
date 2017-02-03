package nl.jft.network.nio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;
import nl.jft.network.EndPoint;
import nl.jft.network.message.Message;

import java.util.List;

/**
 * @author Lesley
 */
final class MessageCodec extends ByteToMessageCodec<Message> {

    private final EndPoint endPoint;

    MessageCodec(EndPoint endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, Message message, ByteBuf buf) throws Exception {
        byte[] data = endPoint.getFstConfiguration().asByteArray(message);
        int length = data.length;

        buf.writeInt(length);
        buf.writeBytes(data, 0, length);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf buf, List<Object> list) throws Exception {
        if (buf.readableBytes() < 4) {
            return;
        }

        buf.markReaderIndex();
        int length = buf.readInt();

        if (buf.readableBytes() < length) {
            buf.resetReaderIndex();
            return;
        }

        byte[] data = new byte[length];
        buf.readBytes(data, 0, length);

        Message message = (Message) endPoint.getFstConfiguration().asObject(data);
        list.add(message);
    }

}
