package nl.jft.logic.participant.impl;

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

        User user = LogicTestUtil.makeUser(-1, null);
    }

    @Test
    public void construct_emptyUsername_throwsException() {
        expectedException.expect(IllegalArgumentException.class);

        User user = LogicTestUtil.makeUser(-1, "");
    }

    @Test
    public void equals_sameObjects_returnsTrue() {
        User user1 = LogicTestUtil.makeDefaultUser();
        User user2 = LogicTestUtil.makeDefaultUser();

        assertTrue(user1.equals(user2));
    }

    @Test
    public void equals_otherUser_returnsFalse() throws Exception {
        User user1 = LogicTestUtil.makeDefaultUser();
        User user2 = LogicTestUtil.makeUser(-1, "Henk");

        assertFalse(user1.equals(user2));
    }

    @Test
    public void equals_otherObject_returnsFalse() {
        User user1 = LogicTestUtil.makeDefaultUser();
        String user2 = "user2";

        assertFalse(user1.equals(user2));
    }

    @Test
    public void equals_nullObject_returnsFalse() {
        User user1 = LogicTestUtil.makeDefaultUser();
        User user2 = null;

        assertFalse(user1.equals(user2));
    }

    @Test
    public void hashCode_whenCalled_returnsHashCode() {
        User user1 = LogicTestUtil.makeDefaultUser();
        User user2 = LogicTestUtil.makeDefaultUser();

        boolean result = user1.hashCode() == user2.hashCode();
        assertTrue(result);
    }

    @Test
    public void getUsername_whenCalled_returnsUsername() {
        User user = LogicTestUtil.makeDefaultUser(); // Default username = "username".

        String expected = "username";
        String actual = user.getName();

        assertEquals(expected, actual);
    }

    @Test
    public void getId_whenCalled_returnsId() throws Exception {
        User user = LogicTestUtil.makeDefaultUser(); //Default id = -1.

        int expected = -1;
        int actual = user.getId();

        assertEquals(expected, actual);
    }
}
