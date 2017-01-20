package nl.jft.logic.participant;

import nl.jft.logic.util.LogicTestUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

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