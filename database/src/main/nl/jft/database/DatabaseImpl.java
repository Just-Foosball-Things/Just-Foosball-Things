package nl.jft.database;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import nl.jft.database.config.DatabaseConfiguration;

import java.util.Objects;
import java.util.logging.Logger;

/**
 * //TODO add documentation.
 *
 * @author Oscar de Leeuw
 */
public class DatabaseImpl implements Database {

    private final static Logger logger = Logger.getLogger(DatabaseImpl.class.getName());

    private final DatabaseConfiguration config;
    private final Cluster.Initializer initializer;

    private Cluster cluster;
    private Session session;

    public DatabaseImpl(DatabaseConfiguration config, Cluster.Initializer initializer) {
        this.config = Objects.requireNonNull(config);
        this.initializer = Objects.requireNonNull(initializer);
    }

    @Override
    public void connect() {
        logger.info("Establishing connection...");

        logger.info("Connecting to cluster...");
        cluster = Cluster.buildFrom(initializer);
        logger.info(String.format("Connected to cluster %s", cluster.getClusterName()));

        logger.info("Establishing session...");
        session = cluster.connect(config.getKeyspace());
        logger.info(String.format("Established sessions under keyspace %s", session.getLoggedKeyspace()));

        logger.info("Connection established.");
    }

    @Override
    public void disconnect() {
        logger.info("Disconnecting...");

        if (session != null) {
            logger.info("Closing session...");
            session.close();
            logger.info("Closed session.");
        }

        if (cluster != null) {
            logger.info("Closing cluster connection...");
            cluster.close();
            logger.info("Closed cluster connection.");
        }

        logger.info("Disconnected.");
    }

    private void reconnect() {
        disconnect();
        connect();
    }

    @Override
    public boolean isConnected() {
        return !(session == null || cluster == null) && !session.isClosed() && !cluster.isClosed();
    }

    @Override
    public <T> boolean save(T object) {
        return false;
    }

    @Override
    public <T> T getRepository(Class kip) {
        return null;
    }

    private void checkHealth() {
        if (session == null || cluster == null || session.isClosed() || cluster.isClosed()) {
            logger.finer("Found an issue in session or cluster connectivity. Reconnecting...");
            reconnect();
        }

        if (!session.getLoggedKeyspace().equals(config.getKeyspace())) {
            logger.finer("Found an issue in the session keyspace. Reconnecting...");
            reconnect();
        }
    }
}
