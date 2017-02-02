package nl.jft.network;

/**
 * An {@code EndPoint} is either a {@link Client} or {@link Server} and so takes care of connecting
 * to another {@code EndPoint}, or accepting {@code connections} from another {@code EndPoint}.
 *
 * @author Lesley
 */
public interface EndPoint {

    /**
     * Closes this {@code EndPoint} so that all {@code connections} are closed.
     */
    void close();

}
