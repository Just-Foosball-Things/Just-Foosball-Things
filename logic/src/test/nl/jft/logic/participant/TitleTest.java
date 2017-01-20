package nl.jft.logic.participant;

import nl.jft.logic.util.LogicTestUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * @author Lesley
 */
public class TitleTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void construct_nullDescription_throwsException() {
        expectedException.expect(NullPointerException.class);

        Title title = LogicTestUtil.makeTitle(-1, null);
    }

    @Test
    public void construct_emptyDescription_throwsException() {
        expectedException.expect(IllegalArgumentException.class);

        Title title = LogicTestUtil.makeTitle(-1, "");
    }

    @Test
    public void equals_sameObjects_returnsTrue() {
        Title title1 = LogicTestUtil.makeDefaultTitle();
        Title title2 = LogicTestUtil.makeDefaultTitle();

        boolean result = title1.equals(title2);
        assertTrue(result);
    }

    @Test
    public void equals_otherTitle_returnsFalse() throws Exception {
        Title title1 = LogicTestUtil.makeDefaultTitle();
        Title title2 = LogicTestUtil.makeTitle(-1, "othertitle");

        boolean result = title1.equals(title2);
        assertFalse(result);
    }

    @Test
    public void equals_otherObject_returnsFalse() {
        Title title1 = LogicTestUtil.makeDefaultTitle();
        String title2 = "title2";

        boolean result = title1.equals(title2);
        assertFalse(result);
    }

    @Test
    public void equals_nullObject_returnsFalse() {
        Title title1 = LogicTestUtil.makeDefaultTitle();
        Title title2 = null;

        boolean result = title1.equals(title2);
        assertFalse(result);
    }

    @Test
    public void hashCode_whenCalled_returnsHashCode() {
        Title title1 = LogicTestUtil.makeDefaultTitle();
        Title title2 = LogicTestUtil.makeDefaultTitle();

        boolean result = title1.hashCode() == title2.hashCode();
        assertTrue(result);
    }

    @Test
    public void getId_whenCalled_returnsId() {
        Title title = LogicTestUtil.makeDefaultTitle();

        int expected = -1;
        int actual = title.getId();

        assertEquals(expected, actual);
    }

    @Test
    public void getDescription_whenCalled_returnsDescription() {
        Title title = LogicTestUtil.makeDefaultTitle();

        String expected = "description";
        String actual = title.getDescription();

        assertEquals(expected, actual);
    }

}