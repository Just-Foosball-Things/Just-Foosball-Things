package nl.jft.network.message;

/**
 * A {@code MessageHandler} handles a {@link Message} received by an {@link nl.jft.network.EndPoint}.
 *
 * @author Lesley
 */
public abstract class MessageHandler<M extends Message> {

    /**
     * Handles a {@link Message} received by an {@link nl.jft.network.EndPoint}.
     *
     * @param message The {@code Message} received by an {@code EndPoint}.
     */
    public abstract void handle(M message);

    /**
     * Gets the {@link Class} of the underlying {@link Message} that this {@code MessageHandler} handles.
     *
     * @return The {@code Class} of the underlying {@code Message} that this {@code MessageHandler} handles.
     */
    public abstract Class<M> getType();

}
