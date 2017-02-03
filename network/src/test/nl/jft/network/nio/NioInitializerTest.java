package nl.jft.network.nio;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import org.junit.Test;

/**
 * @author Lesley
 */
public abstract class NioInitializerTest<I extends ChannelInitializer<SocketChannel>> {

    @Test
    public abstract void construct_nullEndPoint_throwsException() throws Exception;

    @Test
    public abstract void construct_nullSslContext_throwsException() throws Exception;

    @Test
    public abstract void initChannel_whenCalled_initializesChannel() throws Exception;


    protected abstract I makeChannelInitializer() throws Exception;

}