package nl.jft.database;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import nl.jft.database.config.DatabaseConfiguration;
import nl.jft.database.config.impl.DatabaseConfigurationImpl;
import nl.jft.database.config.impl.FilePropertiesLoader;
import nl.jft.database.config.impl.JftInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import java.util.logging.Logger;

/**
 * @author Oscar de Leeuw
 */
public class Test {

    private final static Logger logger = Logger.getLogger(Test.class.getName());

    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        DatabaseConfiguration config = new DatabaseConfigurationImpl(new FilePropertiesLoader());

        Cluster cluster = Cluster.buildFrom(new JftInitializer(config));
        Session session = cluster.connect(config.getKeyspace());

        CassandraOperations ops = new CassandraTemplate(session);

        Select selectStatement = QueryBuilder.select().from("model");
        selectStatement.where(QueryBuilder.eq("id", 1));

        ops.queryForObject(selectStatement, Model.class);


        /*try (InputStream isis = Test.class.getResourceAsStream("/database.config")) {


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
        }*/
    }
}
