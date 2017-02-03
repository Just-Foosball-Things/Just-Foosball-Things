package nl.jft.network;

import nl.jft.network.listener.ConnectionListener;
import nl.jft.network.nio.NioClient;
import nl.jft.network.nio.NioServer;

import java.net.InetSocketAddress;

/**
 * @author Lesley
 */
public final class Main {

    private Main() {
        throw new UnsupportedOperationException("Should not be called.");
    }

    public static void main(String[] args) throws Exception {
        Server server = new NioServer();
        server.addListener(new ConnectionListener() {
            @Override
            public void connectionActive(Connection connection) {
                System.out.println("[s]ACTIVE NOW" + connection.isActive());
            }

            @Override
            public void connectionInactive(Connection connection) {
                System.out.println("[s]INACTIVE NOW" + connection.isActive());
            }
        });
        server.bind(new InetSocketAddress(4044));

        Client client = new NioClient();
        client.addListener(new ConnectionListener() {
            @Override
            public void connectionActive(Connection connection) {
                System.out.println("[c]ACTIVE NOW" + connection.isActive());
            }

            @Override
            public void connectionInactive(Connection connection) {
                System.out.println("[c]INACTIVE NOW" + connection.isActive());
            }
        });
        client.connect(new InetSocketAddress("localhost", 4044));
    }

}
