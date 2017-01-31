package nl.jft.database;

import com.datastax.driver.core.*;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Oscar de Leeuw
 */
public class Test {

    private final static Logger logger = Logger.getLogger(Test.class.getName());

    public static void main(String[] args) {
        Cluster cluster = null;

        try (InputStream isis = Test.class.getResourceAsStream("/database.config")) {
            DatabaseConfiguration config = new DatabaseConfigurationImpl(isis);

            cluster = Cluster.buildFrom(new JftInitializer(config));
            Session session = cluster.connect(config.getKeyspace());

            BoundStatement statement = session.prepare("SELECT * FROM my_table").bind();

            session.execute("INSERT INTO my_table (key, value) VALUES ('banaan', 5)");
            ResultSetFuture future = session.executeAsync(statement);

            Futures.addCallback(future, new FutureCallback<ResultSet>() {
                @Override
                public void onSuccess(ResultSet rows) {
                    System.out.println("Hoi ik ben uit de toekomst.");

                    for (Row row : rows) {
                        System.out.println(String.format("Key: %s | Value: %d", row.getString("key"), row.getInt("value")));
                    }
                }

                @Override
                public void onFailure(Throwable throwable) {
                    System.out.println("Ik ben een foutje geweest.");
                    System.out.println(throwable.toString());
                }
            });

            System.out.println("BIEM");
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.toString(), e);
        } finally {
            if (cluster != null) cluster.close();
        }
    }
}
