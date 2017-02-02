package nl.jft.database;

/**
 * //TODO add documentation.
 *
 * @author Oscar de Leeuw
 */
public interface Database {
    void connect();

    void disconnect();

    boolean isConnected();

    <T> boolean save(T object);

    <T extends Object> T getRepository(Class kip);
}
