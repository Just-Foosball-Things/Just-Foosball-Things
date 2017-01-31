package nl.jft.database.config.impl;

import nl.jft.database.config.DatabaseConfiguration;
import nl.jft.database.config.PropertiesLoader;

import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The {@code DatabaseConfigurationImpl} class loads database properties from an {@code InputStream}.
 *
 * @author Oscar de Leeuw
 */
public class DatabaseConfigurationImpl implements DatabaseConfiguration {

    private static final Logger logger = Logger.getLogger(DatabaseConfigurationImpl.class.getName());

    private static final String ERROR_MSG = "An error occurred while fetching the %TYPE%.";

    private final Properties properties;

    /**
     * Creates a new {@code }
     */
    public DatabaseConfigurationImpl(PropertiesLoader loader) {
        properties = loader.load();
    }

    @Override
    public final String getAddress() {
        try {
            return Objects.requireNonNull(properties.getProperty("address"));
        } catch (Exception e) {
            logger.log(Level.WARNING, ERROR_MSG.replace("%TYPE%", "database address"), e);
        }

        return "localhost";
    }

    @Override
    public final int getPort() {
        try {
            String port = Objects.requireNonNull(properties.getProperty("port"));
            return Integer.parseInt(port);
        } catch (Exception e) {
            logger.log(Level.WARNING, ERROR_MSG.replace("%TYPE%", "port number"), e);
        }

        return 9042;
    }

    @Override
    public final String getClusterName() {
        try {
            return Objects.requireNonNull(properties.getProperty("cluster_name"));
        } catch (Exception e) {
            logger.log(Level.WARNING, ERROR_MSG.replace("%TYPE%", "cluster name"), e);
        }

        return "jft_cluster";
    }

    @Override
    public final String getKeyspace() {
        try {
            return Objects.requireNonNull(properties.getProperty("keyspace"));
        } catch (Exception e) {
            logger.log(Level.WARNING, ERROR_MSG.replace("%TYPE%", "keyspace"), e);
        }

        return "jft";
    }

    @Override
    public final String getUsername() {
        try {
            return Objects.requireNonNull(properties.getProperty("username"));
        } catch (Exception e) {
            logger.log(Level.WARNING, ERROR_MSG.replace("%TYPE%", "username"), e);
        }

        return "ZouJeWelWillenWeten";
    }

    @Override
    public final String getPassword() {
        try {
            return Objects.requireNonNull(properties.getProperty("password"));
        } catch (Exception e) {
            logger.log(Level.WARNING, ERROR_MSG.replace("%TYPE%", "password"), e);
        }

        return "MaarKrijgJeNiet";
    }
}
