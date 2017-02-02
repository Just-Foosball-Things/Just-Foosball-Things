package nl.jft.database;

import nl.jft.database.config.CassandraConfig;
import nl.jft.database.entity.Model;
import nl.jft.database.repository.ModelRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Oscar de Leeuw
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CassandraConfig.class)
public class TestykelTest {

    @Autowired
    ModelRepository repository;
    Model model;

    @Before
    public void setUp() throws Exception {
        model = new Model(20, "lesley");

    }

    @org.junit.Test
    public void nameTest() throws Exception {
        model = repository.save(model);

        assertThat(repository.findOne(model.getId()).getValue(), is(model.getValue()));
    }
}