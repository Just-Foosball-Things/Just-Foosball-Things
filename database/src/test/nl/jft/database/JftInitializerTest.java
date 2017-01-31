package nl.jft.database;

import com.datastax.driver.core.Configuration;
import com.datastax.driver.core.PlainTextAuthProvider;
import nl.jft.database.config.impl.JftInitializer;
import nl.jft.database.util.builder.ObjectBuilder;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Oscar de Leeuw
 */
public class JftInitializerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private JftInitializer initializer;

    @Before
    public void setUp() throws Exception {
        initializer = ObjectBuilder.jftInitializer().build();
    }

    @Test
    public void constructor_withNullConfig_throwsException() throws Exception {
        expectedException.expect(NullPointerException.class);

        initializer = ObjectBuilder.jftInitializer().withConfig(null).build();
    }

    @Test
    public void getClusterName_withTestConfig_returnsString() throws Exception {
        String expected = "jft_cluster";
        String actual = initializer.getClusterName();

        assertEquals(expected, actual);
    }

    @Test
    public void getContactPoints_withTestConfig_returnsList() throws Exception {
        List<InetSocketAddress> expected = new ArrayList<>();
        expected.add(new InetSocketAddress("localhost", 9042));

        List<InetSocketAddress> actual = initializer.getContactPoints();

        assertEquals(expected, actual);
    }

    @Test
    public void getConfiguration_withTestConfig_returnsConfiguration() throws Exception {
        Configuration config = initializer.getConfiguration();

        assertNotNull(config);
        assertTrue(config.getProtocolOptions().getAuthProvider() instanceof PlainTextAuthProvider);
    }

    @Test
    public void getInitialListeners_withTestConfig_returnsEmptyCollection() throws Exception {
        Collection expected = Collections.EMPTY_LIST;
        Collection actual = initializer.getInitialListeners();

        assertEquals(expected, actual);
    }
}