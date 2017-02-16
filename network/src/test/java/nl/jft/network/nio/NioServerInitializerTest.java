package nl.jft.network.nio;

import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.mockito.ArgumentMatchers;

import static org.mockito.Mockito.*;

/**
 * @author Lesley
 */
public class NioServerInitializerTest extends NioInitializerTest<NioServerInitializer> {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Override
    public void construct_nullEndPoint_throwsException() throws Exception {
        expectedException.expect(NullPointerException.class);

        NioServerInitializer initializer = new NioServerInitializer(null, makeSslContext());
    }

    @Override
    public void construct_nullSslContext_throwsException() {
        expectedException.expect(NullPointerException.class);

        NioServerInitializer initializer = new NioServerInitializer(new NioServer(), null);
    }

    @Override
    public void initChannel_whenCalled_initializesChannel() throws Exception {
        NioServerInitializer initializer = makeChannelInitializer();

        ChannelPipeline mockPipeline = mock(ChannelPipeline.class);
        SocketChannel stubChannel = mock(SocketChannel.class);
        when(stubChannel.pipeline()).thenReturn(mockPipeline);

        initializer.initChannel(stubChannel);

        verify(mockPipeline, times(3)).addLast(ArgumentMatchers.any());
    }

    private SslContext makeSslContext() throws Exception {
        return SslContextBuilder.forClient().build();
    }

    @Override
    protected NioServerInitializer makeChannelInitializer() throws Exception {
        return new NioServerInitializer(new NioServer(), makeSslContext());
    }

}