package nl.jft.database;

import com.datastax.driver.core.*;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * The {@code JftInitializer} is the Just-Football-Things implementation of the {@code Initializer} of the DataStax driver.
 *
 * @author Oscar de Leeuw
 */
public class JftInitializer implements Cluster.Initializer {

    private final DatabaseConfiguration config;

    /**
     * Creates a new {@code JftInitializer}.
     *
     * @param config The {@code DatabaseConfiguration} from which properties can be queried.
     */
    public JftInitializer(DatabaseConfiguration config) {
        this.config = config;
    }

    @Override
    public String getClusterName() {
        return config.getClusterName();
    }

    @Override
    public List<InetSocketAddress> getContactPoints() {
        List<InetSocketAddress> ret = new ArrayList<>();

        String address = config.getAddress();
        int port = config.getPort();

        ret.add(new InetSocketAddress(address, port));

        return ret;
    }

    @Override
    public Configuration getConfiguration() {
        ProtocolOptions options = new ProtocolOptions(config.getPort(), ProtocolVersion.NEWEST_SUPPORTED, 10, null, new PlainTextAuthProvider(config.getUsername(), config.getPassword()));

        return Configuration.builder().withProtocolOptions(options).build();
    }

    @Override
    public Collection<Host.StateListener> getInitialListeners() {
        return Collections.EMPTY_LIST;
    }
}
