package nl.jft.network.message;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Lesley
 */
public final class MessageHandlerChain<M extends Message> {

    private final List<MessageHandler<M>> handlers = new ArrayList<>();

    private final Class<M> type;

    public MessageHandlerChain(Class<M> type) {
        this.type = Objects.requireNonNull(type);
    }

    /**
     * Adds a {@link MessageHandler} to this {@code MessageHandlerChain}.
     *
     * @param handler The {@code MessageHandler} to add, should not be {@code null}.
     * @throws NullPointerException If the given {@code handler} is {@code null}.
     */
    public void addMessageHandler(MessageHandler<M> handler) {
        Objects.requireNonNull(handler);

        synchronized (handlers) {
            handlers.add(handler);
        }
    }

    /**
     * Removes a {@link MessageHandler} from this {@code MessageHandlerChain}.
     *
     * @param handler The {@code MessageHandler} to remove, should not be {@code null}.
     * @throws NullPointerException If the given {@code handler} is {@code null}.
     */
    public void removeMessageHandler(MessageHandler<M> handler) {
        Objects.requireNonNull(handler);

        synchronized (handlers) {
            handlers.remove(handler);
        }
    }

    /**
     * Notifies all {@link MessageHandler handlers} that a {@link Message}
     * has been received by an {@link nl.jft.network.EndPoint},and invokes the {@link MessageHandler#handle(Message)}
     * method on all {@code MessageHandlers}.
     *
     * @param message The {@code Message} that was received by an {@code EndPoint}, should not be {@code null}.
     */
    public void notify(M message) {
        Objects.requireNonNull(message);

        synchronized (handlers) {
            for (MessageHandler<M> handler : handlers) {
                if (message.isTerminated()) {
                    break;
                }

                handler.handle(message);
            }
        }
    }

    public Class<M> getType() {
        return type;
    }

}
