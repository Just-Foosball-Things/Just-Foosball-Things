package nl.jft.database;

import nl.jft.database.util.builder.ObjectBuilder;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Oscar de Leeuw
 */
public class DatabaseConfigurationImplTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    DatabaseConfigurationImpl config;

    @Before
    public void setUp() throws Exception {
        config = ObjectBuilder.databaseConfiguration().build();

    }

    @org.junit.Test
    public void constructor_withNullStream_throwsException() throws Exception {
        expectedException.expect(NullPointerException.class);

        DatabaseConfigurationImpl config = ObjectBuilder.databaseConfiguration().withStream(null).build();
    }

    @Test
    public void constructor_withMockStream_shouldPass() throws Exception {
        assertNotNull(config);
    }

    @Test
    public void getAddress_withMockStream_shouldReturnDefault() throws Exception {
        String expected = "localhost";
        String actual = config.getAddress();

        assertEquals(expected, actual);
    }

    @Test
    public void getPort_withMockStream_shouldReturnDefault() throws Exception {
        int expected = 9042;
        int actual = config.getPort();

        assertEquals(expected, actual);
    }

    @Test
    public void getClusterName_withMockStream_shouldReturnDefault() throws Exception {
        String expected = "jft_cluster";
        String actual = config.getClusterName();

        assertEquals(expected, actual);
    }

    @Test
    public void getKeyspace_withMockStream_shouldReturnDefault() throws Exception {
        String expected = "jft";
        String actual = config.getKeyspace();

        assertEquals(expected, actual);
    }

    @Test
    public void getUsername_withMockStream_shouldReturnDefault() throws Exception {
        String expected = "ZouJeWelWillenWeten";
        String actual = config.getUsername();

        assertEquals(expected, actual);
    }

    @Test
    public void getPassword_withMockStream_shouldReturnDefault() throws Exception {
        String expected = "MaarKrijgJeNiet";
        String actual = config.getPassword();

        assertEquals(expected, actual);
    }
}