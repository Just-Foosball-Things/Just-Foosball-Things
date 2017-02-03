package nl.jft.database.converter;

import nl.jft.database.util.builder.ObjectBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Oscar de Leeuw
 */
public class DefaultJsonConverterTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private DefaultJsonConverter<TestData> converter;

    @Before
    public void setUp() throws Exception {
        converter = ObjectBuilder.<TestData>jsonConverter().build();
    }

    @Test
    public void to_withNullObject_throwsException() throws Exception {
        expectedException.expect(NullPointerException.class);

        converter.to(null);
    }

    @Test
    public void to_withObject_returnsString() throws Exception {
        String actual = converter.to(new TestData(1, "lol"));
        String expected = "{\"id\":1,\"data\":\"lol\"}";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void from_withString_returnsObject() throws Exception {
        String json = "{\"id\":1,\"data\":\"lol\"}";

        TestData expected = converter.from(json, TestData.class);
        TestData actual = new TestData(1, "lol");

        Assert.assertEquals(expected.id, actual.id);
        Assert.assertEquals(expected.data, actual.data);
    }

    @Test
    public void from_withEmptyString_returnsNull() throws Exception {
        String json = "";

        TestData actual = converter.from(json, TestData.class);

        Assert.assertNull(actual);
    }

    @Test
    public void from_withNullString_returnsNull() throws Exception {
        String json = null;

        TestData actual = converter.from(json, TestData.class);

        Assert.assertNull(actual);
    }

    @Test
    public void from_withBogusString_throwsException() throws Exception {
        expectedException.expect(IllegalStateException.class);
        String json = "bogus";

        converter.from(json, TestData.class);
    }

    public static class TestData {
        public int id;
        public String data;

        private TestData() {

        }

        public TestData(int id, String data) {
            this.id = id;
            this.data = data;
        }
    }
}