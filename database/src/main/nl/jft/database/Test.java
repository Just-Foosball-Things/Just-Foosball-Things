package nl.jft.database;

import com.datastax.driver.core.Cluster;
import nl.jft.database.config.CassandraConfig;
import nl.jft.database.converter.DefaultJsonConverter;
import nl.jft.database.entity.participant.User;
import nl.jft.database.repository.ModelRepository;
import nl.jft.database.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

/**
 * @author Oscar de Leeuw
 */
public class Test {

    private final static Logger logger = Logger.getLogger(Test.class.getName());

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CassandraConfig.class);

        Cluster cluster = context.getBean(Cluster.class);
        ModelRepository modelRepository = context.getBean(ModelRepository.class);
        UserRepository userRepository = context.getBean(UserRepository.class);

        String json = new DefaultJsonConverter<User>().to(new User("Henk", null));
        User kip = new DefaultJsonConverter<User>().from(json, User.class);

        /*User user = new User("Oscar", new Model(6, "Henk"));
        User user2 = new User("Oscar", new Model(7, "Piet"));
        //
        userRepository.save(user);
        userRepository.save(user2);
        Iterator<User> foundUsers = userRepository.findAllByUsername("Oscar").iterator();
        System.out.println("User : " + foundUsers.next().getModel().getId());
        System.out.println("Model : " + foundUsers.next().getModel().getId());*/

        System.exit(0);
    }
}
