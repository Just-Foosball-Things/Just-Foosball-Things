package nl.jft.database;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The {@code DatabaseConfiguration} class loads database properties from an {@code InputStream}.
 *
 * @author Oscar de Leeuw
 */
public class DatabaseConfiguration {

    private static final Logger logger = Logger.getLogger(DatabaseConfiguration.class.getName());

    private static final String ERROR_MSG = "An error occurred while fetching the %TYPE%.";

    private final Properties properties;

    /**
     * Creates a new DatabaseConfiguration.
     *
     * @param is An {@code InputStream} from which the properties can be read.
     * @throws IOException When the properties cannot be loaded from the {@code InputStream}.
     */
    public DatabaseConfiguration(InputStream is) throws IOException {
        properties = new Properties();
        properties.load(is);
    }

    /**
     * Gets the address of the database.
     *
     * @return a {@code String} that represents the address of the database.
     */
    public String getAddress() {
        try {
            return Objects.requireNonNull(properties.getProperty("address"));
        } catch (Exception e) {
            logger.log(Level.WARNING, ERROR_MSG.replace("%TYPE%", "database address"), e);
        }

        return "localhost";
    }

    /**
     * Gets the port number of the database.
     *
     * @return a {@code int} that represents the port of the database.
     */
    public int getPort() {
        try {
            String port = properties.getProperty("port");
            return Integer.parseInt(port);
        } catch (Exception e) {
            logger.log(Level.WARNING, ERROR_MSG.replace("%TYPE%", "port number"), e);
        }

        return 9042;
    }

    /**
     * Gets the name of the Cassandra cluster.
     *
     * @return a {@code String} that represents the name of the Cassandra cluster.
     */
    public String getClusterName() {
        try {
            return Objects.requireNonNull(properties.getProperty("cluster_name"));
        } catch (Exception e) {
            logger.log(Level.WARNING, ERROR_MSG.replace("%TYPE%", "cluster name"), e);
        }

        return "jft_cluster";
    }

    /**
     * Gets the value of the keyspace used within the cluster.
     *
     * @return a {@code String} that represents the keyspace.
     */
    public String getKeyspace() {
        try {
            return Objects.requireNonNull(properties.getProperty("keyspace"));
        } catch (Exception e) {
            logger.log(Level.WARNING, ERROR_MSG.replace("%TYPE%", "keyspace"), e);
        }

        return "jft";
    }

    /**
     * Gets the username for the database.
     *
     * @return a {@code String} that represents the username.
     */
    public String getUsername() {
        try {
            return Objects.requireNonNull(properties.getProperty("username"));
        } catch (Exception e) {
            logger.log(Level.WARNING, ERROR_MSG.replace("%TYPE%", "username"), e);
        }

        return "ZouJeWelWillenWeten";
    }

    /**
     * Gets the password for the database.
     *
     * @return a {@code String} that represents the password.
     */
    public String getPassword() {
        try {
            return Objects.requireNonNull(properties.getProperty("password"));
        } catch (Exception e) {
            logger.log(Level.WARNING, ERROR_MSG.replace("%TYPE%", "password"), e);
        }

        return "MaarKrijgJeNiet";
    }
}
