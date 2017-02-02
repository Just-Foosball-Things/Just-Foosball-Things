package nl.jft.network.util.mocks;

import nl.jft.network.message.MessageHandler;

/**
 * @author Lesley
 */
public class FakeMessageHandler extends MessageHandler<FakeMessage> {

    public FakeMessage lastHandleFakeMessage;
    public int terminateMessageAfter = -1;

    private int currentTerminateCount = 0;

    @Override
    public void handle(FakeMessage message) {
        lastHandleFakeMessage = message;

        if (terminateMessageAfter != -1 && ++currentTerminateCount >= terminateMessageAfter) {
            message.terminate();
            currentTerminateCount = 0;
        }
    }

    @Override
    public Class<FakeMessage> getType() {
        return FakeMessage.class;
    }

}
