package nl.jft.database;

import nl.jft.database.query.Query;

import java.util.Collection;

/**
 * //TODO add documentation.
 *
 * @author Oscar de Leeuw
 */
public interface Database {
    void connect();

    void disconnect();

    boolean isConnected();

    <T> void executeAsyncQuery(Query<T> query);

    <T> Collection<T> executeQuery(Query<T> query);
}
