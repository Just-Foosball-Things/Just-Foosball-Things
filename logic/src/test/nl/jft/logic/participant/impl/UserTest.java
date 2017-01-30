package nl.jft.logic.participant.impl;

import nl.jft.common.rating.Rating;
import nl.jft.logic.LogicConstants;
import nl.jft.logic.participant.Title;
import nl.jft.logic.util.LogicTestUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * @author Lesley
 */
public class UserTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void construct_nullUsername_throwsException() {
        expectedException.expect(NullPointerException.class);

        User user = LogicTestUtil.makeUser(LogicConstants.INTERNAL_ID, null, LogicTestUtil.makeDefaultRating(), LogicTestUtil.makeDefaultTitle());
    }

    @Test
    public void construct_emptyUsername_throwsException() {
        expectedException.expect(IllegalArgumentException.class);

        User user = LogicTestUtil.makeUser(LogicConstants.INTERNAL_ID, "", LogicTestUtil.makeDefaultRating(), LogicTestUtil.makeDefaultTitle());
    }

    @Test
    public void construct_nullRating_throwsException() {
        expectedException.expect(NullPointerException.class);

        User user = LogicTestUtil.makeUser(LogicConstants.INTERNAL_ID, "username", null, LogicTestUtil.makeDefaultTitle());
    }

    @Test
    public void construct_nullTitle_throwsException() {
        expectedException.expect(NullPointerException.class);

        User user = LogicTestUtil.makeUser(LogicConstants.INTERNAL_ID, "username", LogicTestUtil.makeDefaultRating(), null);
    }

    @Test
    public void equals_sameObjects_returnsTrue() {
        User user1 = LogicTestUtil.makeDefaultUser();
        User user2 = LogicTestUtil.makeDefaultUser();

        boolean result = user1.equals(user2);
        assertTrue(result);
    }

    @Test
    public void equals_otherUser_returnsFalse() throws Exception {
        User user1 = LogicTestUtil.makeDefaultUser();
        User user2 = LogicTestUtil.makeUser(LogicConstants.INTERNAL_ID, "Henk", LogicTestUtil.makeDefaultRating(), LogicTestUtil.makeDefaultTitle());

        boolean result = user1.equals(user2);
        assertFalse(result);
    }

    @Test
    public void equals_otherObject_returnsFalse() {
        User user1 = LogicTestUtil.makeDefaultUser();
        String user2 = "user2";

        boolean result = user1.equals(user2);
        assertFalse(result);
    }

    @Test
    public void equals_nullObject_returnsFalse() {
        User user1 = LogicTestUtil.makeDefaultUser();
        User user2 = null;

        boolean result = user1.equals(user2);
        assertFalse(result);
    }

    @Test
    public void hashCode_whenCalled_returnsHashCode() {
        User user1 = LogicTestUtil.makeDefaultUser();
        User user2 = LogicTestUtil.makeDefaultUser();

        boolean result = user1.hashCode() == user2.hashCode();
        assertTrue(result);
    }

    @Test
    public void getId_whenCalled_returnsId() throws Exception {
        User user = LogicTestUtil.makeDefaultUser(); //Default id = -1.

        int expected = LogicConstants.INTERNAL_ID;
        int actual = user.getId();

        assertEquals(expected, actual);
    }

    @Test
    public void getUsername_whenCalled_returnsUsername() {
        User user = LogicTestUtil.makeDefaultUser(); // Default username = "username".

        String expected = "username";
        String actual = user.getName();

        assertEquals(expected, actual);
    }

    @Test
    public void getRating_whenCalled_returnsRating() {
        User user = LogicTestUtil.makeDefaultUser();

        Rating expected = LogicTestUtil.makeDefaultRating();
        Rating actual = user.getRating();

        assertEquals(expected, actual);
    }

    @Test
    public void getTitle_whenCalled_returnsTitle() {
        User user = LogicTestUtil.makeDefaultUser();

        Title expected = LogicTestUtil.makeDefaultTitle();
        Title actual = user.getActiveTitle();

        assertEquals(expected, actual);
    }
}
