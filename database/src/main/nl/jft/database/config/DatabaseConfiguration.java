package nl.jft.database.config;

/**
 * //TODO add documentation
 *
 * @author Oscar de Leeuw
 */
public interface DatabaseConfiguration {
    /**
     * Gets the address of the database.
     *
     * @return a {@code String} that represents the address of the database.
     */
    String getAddress();

    /**
     * Gets the port number of the database.
     *
     * @return a {@code int} that represents the port of the database.
     */
    int getPort();

    /**
     * Gets the name of the Cassandra cluster.
     *
     * @return a {@code String} that represents the name of the Cassandra cluster.
     */
    String getClusterName();

    /**
     * Gets the value of the keyspace used within the cluster.
     *
     * @return a {@code String} that represents the keyspace.
     */
    String getKeyspace();

    /**
     * Gets the username for the database.
     *
     * @return a {@code String} that represents the username.
     */
    String getUsername();

    /**
     * Gets the password for the database.
     *
     * @return a {@code String} that represents the password.
     */
    String getPassword();
}
