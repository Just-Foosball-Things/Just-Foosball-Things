package nl.jft.network.message;

import nl.jft.network.Connection;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * A {@code MessageHandlerChainSet} keeps track of all {@link MessageHandlerChain chains} by discriminating them based
 * on the {@link MessageHandler} (and thus the {@link Message} they handle) they keep track of.
 *
 * @author Lesley
 */
public final class MessageHandlerChainSet {

    private final Map<Class<? extends Message>, MessageHandlerChain<? extends Message>> chains = new HashMap<>();

    /**
     * Adds a {@link MessageHandler} to this chain-set.
     *
     * @param handler The actual {@code MessageHandler} to add to this chain-set, should not be {@code null}.
     * @param <M>     The {@code Message}-type.
     * @throws NullPointerException If the given {@code handler} is {@code null}.
     */
    public <M extends Message> void addHandler(MessageHandler<M> handler) {
        Objects.requireNonNull(handler);

        synchronized (chains) {
            MessageHandlerChain<M> chain = (MessageHandlerChain<M>) chains.computeIfAbsent(handler.getType(), MessageHandlerChain::new);
            chain.addMessageHandler(handler);
        }
    }

    /**
     * Removes a {@link MessageHandler} from this chain-set.
     *
     * @param handler The actual {@code MessageHandler} to add to this chain-set, should not be {@code null}.
     * @param <M>     The {@code Message}-type.
     * @throws NullPointerException If the given {@code handler} is {@code null}.
     */
    public <M extends Message> void removeHandler(MessageHandler<M> handler) {
        Objects.requireNonNull(handler);

        synchronized (chains) {
            MessageHandlerChain<M> chain = (MessageHandlerChain<M>) chains.computeIfAbsent(handler.getType(), MessageHandlerChain::new);
            chain.removeMessageHandler(handler);
        }
    }

    /**
     * Notifies a tracked {@link MessageHandlerChain} of a received {@link Message}
     * by invoking the {@link MessageHandlerChain#notify(Connection, Message)} method. That method, in turn, will notify
     * all tracked {@link MessageHandler handlers}.
     *
     * @param connection The {@link Connection} that received the given {@code Message}, should not be {@code null}.
     * @param message    The {@code Message} that was received by an {@link nl.jft.network.EndPoint}, should not be {@code null}.
     * @param <M>        The {@code Message}-type.
     * @throws NullPointerException If the given {@code connection} is {@code null}.
     * @throws NullPointerException If the given {@code Message} is {@code null}.
     */
    public <M extends Message> void notify(Connection connection, M message) {
        Objects.requireNonNull(connection);
        Objects.requireNonNull(message);

        synchronized (chains) {
            MessageHandlerChain<M> chain = (MessageHandlerChain<M>) chains.computeIfAbsent(message.getClass(), MessageHandlerChain::new);
            chain.notify(connection, message);
        }
    }

}
