package nl.jft.logic.participant.impl;

import nl.jft.common.rating.Rating;
import nl.jft.logic.LogicConstants;
import nl.jft.logic.util.LogicTestUtil;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * @author Lesley
 * @author Oscar de Leeuw
 */
public class TeamTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void construct_nullTeamName_throwsException() {
        expectedException.expect(NullPointerException.class);

        Team team = LogicTestUtil.makeTeam(LogicConstants.INTERNAL_ID, null, LogicTestUtil.makeDefaultUser(), LogicTestUtil.makeDefaultUser());
    }

    @Test
    public void construct_emptyTeamName_throwsException() {
        expectedException.expect(IllegalArgumentException.class);

        Team team = LogicTestUtil.makeTeam(LogicConstants.INTERNAL_ID, "", LogicTestUtil.makeDefaultUser(), LogicTestUtil.makeDefaultUser());
    }

    @Test
    public void construct_nullFirstUser_throwsException() {
        expectedException.expect(NullPointerException.class);

        Team team = LogicTestUtil.makeTeam("team", null, LogicTestUtil.makeDefaultUser());
    }

    @Test
    public void construct_nullSecondUser_throwsException() {
        expectedException.expect(NullPointerException.class);

        Team team = LogicTestUtil.makeTeam("team", LogicTestUtil.makeDefaultUser(), null);
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
        Team team1 = LogicTestUtil.makeDefaultTeam();
        Team team2 = LogicTestUtil.makeDefaultTeam();

        boolean result = team1.equals(team2);
        assertTrue(result);
    }

    @Test
    public void equals_otherInstance_returnsFalse() {
        Team team1 = LogicTestUtil.makeDefaultTeam();
        Team team2 = null;

        boolean result = team1.equals(team2);
        assertFalse(result);
    }

    @Test
    public void equals_differentIds_returnsFalse() {
        Team team1 = LogicTestUtil.makeTeam(1, "team", LogicTestUtil.makeDefaultUser(), LogicTestUtil.makeDefaultUser2());
        Team team2 = LogicTestUtil.makeTeam(2, "team", LogicTestUtil.makeDefaultUser(), LogicTestUtil.makeDefaultUser2());

        boolean result = team1.equals(team2);
        assertFalse(result);
    }

    @Test
    public void equals_differentTeamNames_returnsFalse() {
        Team team1 = LogicTestUtil.makeTeam(1, "team1", LogicTestUtil.makeDefaultUser(), LogicTestUtil.makeDefaultUser2());
        Team team2 = LogicTestUtil.makeTeam(1, "team2s", LogicTestUtil.makeDefaultUser(), LogicTestUtil.makeDefaultUser2());

        boolean result = team1.equals(team2);
        assertFalse(result);
    }

    @Test
    public void equals_differentFirstUser_returnsFalse() {
        Team team1 = LogicTestUtil.makeTeam(1, "team", LogicTestUtil.makeDefaultUser(), LogicTestUtil.makeDefaultUser3());
        Team team2 = LogicTestUtil.makeTeam(1, "team", LogicTestUtil.makeDefaultUser2(), LogicTestUtil.makeDefaultUser3());

        boolean result = team1.equals(team2);
        assertFalse(result);
    }

    @Test
    public void equals_differentSecondUser_returnsFalse() {
        Team team1 = LogicTestUtil.makeTeam(1, "team", LogicTestUtil.makeDefaultUser(), LogicTestUtil.makeDefaultUser2());
        Team team2 = LogicTestUtil.makeTeam(1, "team", LogicTestUtil.makeDefaultUser(), LogicTestUtil.makeDefaultUser3());

        boolean result = team1.equals(team2);
        assertFalse(result);
    }

    @Test
    public void hashCode_whenCalled_returnsHashCode() {
        Team team1 = LogicTestUtil.makeDefaultTeam();
        Team team2 = LogicTestUtil.makeDefaultTeam();

        boolean result = team1.hashCode() == team2.hashCode();
        assertTrue(result);
    }

    @Test
    public void getName_withDefaultName_returnsName() {
        Team team = LogicTestUtil.makeDefaultTeam(); // default name is "team".

        String expected = "team";
        String actual = team.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getId_withDefaultId_returnsId() {
        Team team = LogicTestUtil.makeDefaultTeam(); // default id is -1.

        int expected = LogicConstants.INTERNAL_ID;
        int actual = team.getId();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getElo_whenCalled_returnsElo() {
        Rating firstElo = LogicTestUtil.makeRating(1500);
        Rating secondElo = LogicTestUtil.makeRating(2000);

        User firstUser = LogicTestUtil.makeUser("user1", firstElo, LogicTestUtil.makeDefaultTitle());
        User secondUser = LogicTestUtil.makeUser("user2", secondElo, LogicTestUtil.makeDefaultTitle());
        Team team = LogicTestUtil.makeTeam("team", firstUser, secondUser);

        Rating expected = LogicTestUtil.makeRating(1750);
        Rating actual = team.getRating();

        assertEquals(expected, actual);
    }

}
