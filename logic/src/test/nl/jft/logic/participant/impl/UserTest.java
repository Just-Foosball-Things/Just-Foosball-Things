package nl.jft.logic.participant.impl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
    public void getUsername_whenCalled_returnsUsername() {
        User user = makeUser(); // Default username = "username".

        String expected = "username";
        String actual = user.getUsername();

        assertEquals(expected, actual);
    }

    private User makeUser() {
        return new User("username");
    }

}
