package nl.jft.database;

import nl.jft.database.config.CassandraConfig;
import nl.jft.database.entity.Model;
import nl.jft.database.entity.User;
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

        ModelRepository modelRepository = context.getBean(ModelRepository.class);
        UserRepository userRepository = context.getBean(UserRepository.class);

        User user = new User(60, "Oscar", new Model(5, "Henk"));

        userRepository.save(user);
        /*User foundUser = userRepository.findOne(60L);
        System.out.println();
        System.out.println(modelRepository.findOne(5L).getValue());*/

        //Model modelletje = new Model(506, "kippetje");
        //repository.save(modelletje);
        //Iterable<Model> models = repository.findByValue("henk");

        /*for (Model model : models) {
            System.out.println("Id: " + model.getId() + " Value: " + model.getValue());
        }*/

        System.exit(0);
    }
}
