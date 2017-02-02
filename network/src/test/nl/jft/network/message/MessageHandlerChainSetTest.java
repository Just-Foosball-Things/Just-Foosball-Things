package nl.jft.network.message;

import nl.jft.network.util.mocks.FakeMessage;
import nl.jft.network.util.mocks.FakeMessageHandler;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * @author Lesley
 */
public class MessageHandlerChainSetTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();


    @Test
    public void addHandler_nullHandler_throwsException() {
        expectedException.expect(NullPointerException.class);

        MessageHandlerChainSet chainSet = makeChainSet();

        chainSet.addHandler(null);
    }

    @Test
    public void removeHandler_nullHandler_throwsException() {
        expectedException.expect(NullPointerException.class);

        MessageHandlerChainSet chainSet = makeChainSet();

        chainSet.removeHandler(null);
    }

    @Test
    public void notify_nullMessage_throwsException() {
        expectedException.expect(NullPointerException.class);

        MessageHandlerChainSet chainSet = makeChainSet();

        chainSet.notify(null);
    }

    @Test
    public void notify_whenCalled_notifiesHandler() {
        MessageHandlerChainSet chainSet = makeChainSet();

        Message stubMessage = new FakeMessage();
        FakeMessageHandler mockMessageHandler = new FakeMessageHandler();

        chainSet.addHandler(mockMessageHandler);
        chainSet.notify(stubMessage);

        Message expected = stubMessage;
        Message actual = mockMessageHandler.lastHandleFakeMessage;

        assertEquals(expected, actual);
    }

    @Test
    public void notify_whenCalledOnRemovedHandler_doesNotNotify() {
        MessageHandlerChainSet chainSet = makeChainSet();

        Message stubMessage = new FakeMessage();
        FakeMessageHandler mockMessageHandler = new FakeMessageHandler();

        chainSet.addHandler(mockMessageHandler);
        chainSet.removeHandler(mockMessageHandler);
        chainSet.notify(stubMessage);

        Message expected = null;
        Message actual = mockMessageHandler.lastHandleFakeMessage;

        assertEquals(expected, actual);
    }

    private MessageHandlerChainSet makeChainSet() {
        return new MessageHandlerChainSet();
    }

}