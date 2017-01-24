package nl.jft.logic.participant;

import nl.jft.logic.LogicConstants;
import nl.jft.logic.participant.impl.Team;
import nl.jft.logic.participant.impl.User;
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
    public void construct_nullNameOnly_throwsException() {
        expectedException.expect(NullPointerException.class);

        Title title = LogicTestUtil.makeTitle(null);
    }

    @Test
    public void construct_emptyNameOnly_throwsException() {
        expectedException.expect(IllegalArgumentException.class);

        Title title = LogicTestUtil.makeTitle("");
    }

    @Test
    public void construct_nullName_throwsException() {
        expectedException.expect(NullPointerException.class);

        Title title = LogicTestUtil.makeTitle(LogicConstants.INTERNAL_ID, null);
    }

    @Test
    public void construct_emptyName_throwsException() {
        expectedException.expect(IllegalArgumentException.class);

        Title title = LogicTestUtil.makeTitle(LogicConstants.INTERNAL_ID, "");
    }

    @Test
    public void construct_sameUsers_throwsException() {
        expectedException.expect(IllegalArgumentException.class);

        User user1 = LogicTestUtil.makeDefaultUser();
        User user2 = LogicTestUtil.makeDefaultUser();

        Team team = LogicTestUtil.makeTeam("team", user1, user2);
    }

    @Test
    public void equals_sameObjects_returnsTrue() {
        Title title1 = LogicTestUtil.makeDefaultTitle();
        Title title2 = LogicTestUtil.makeDefaultTitle();

        boolean result = title1.equals(title2);
        assertTrue(result);
    }

    @Test
    public void equals_otherInstance_returnsFalse() {
        Title title1 = LogicTestUtil.makeDefaultTitle();
        Title title2 = null;

        boolean result = title1.equals(title2);
        assertFalse(result);
    }

    @Test
    public void equals_differentIds_returnsFalse() {
        Title title1 = LogicTestUtil.makeTitle(1, "title");
        Title title2 = LogicTestUtil.makeTitle(2, "title");

        boolean result = title1.equals(title2);
        assertFalse(result);
    }

    @Test
    public void equals_differentNames_returnsFalse() {
        Title title1 = LogicTestUtil.makeTitle(1, "title1");
        Title title2 = LogicTestUtil.makeTitle(1, "title2");

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

        int expected = LogicConstants.INTERNAL_ID;
        int actual = title.getId();

        assertEquals(expected, actual);
    }

    @Test
    public void getName_whenCalled_returnsName() {
        Title title = LogicTestUtil.makeDefaultTitle();

        String expected = "name";
        String actual = title.getName();

        assertEquals(expected, actual);
    }

}