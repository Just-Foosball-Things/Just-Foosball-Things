package nl.jft.logic.participant.impl;

import nl.jft.logic.util.LogicTestUtil;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Lesley
 */
public class UserTest {

    @Test(expected = NullPointerException.class)
    public void construct_nullUsername_throwsException() {
        User user = new User(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construct_emptyUsername_throwsException() {
        User user = new User("");
    }

    @Test
    public void equals_sameObjects_returnsTrue() {
        User user1 = LogicTestUtil.makeDefaultUser();
        User user2 = LogicTestUtil.makeDefaultUser();

        assertTrue(user1.equals(user2));
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

}
