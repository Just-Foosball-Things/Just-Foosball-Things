package nl.jft.logic.participant.impl;

import nl.jft.logic.util.LogicTestUtil;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Lesley
 * @author Oscar de Leeuw
 */
public class TeamTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void construct_nullTeamname_throwsException() throws Exception {
        expectedException.expect(NullPointerException.class);

        Team team = new Team(-1, null);
    }

    @Test
    public void construct_emptyTeamname_throwsException() throws Exception {
        expectedException.expect(IllegalArgumentException.class);

        Team team = new Team(-1, "");
    }

    @Test
    public void equals_sameObjects_returnsTrue() {
        Team team1 = LogicTestUtil.makeDefaultTeam();
        Team team2 = LogicTestUtil.makeDefaultTeam();

        boolean result = team1.equals(team2);
        assertTrue(result);
    }

    @Test
    public void equals_otherTeam_returnsFalse() throws Exception {
        Team team1 = LogicTestUtil.makeDefaultTeam();
        Team team2 = LogicTestUtil.makeTeam(-1, "Henk");

        boolean result = team1.equals(team2);
        assertFalse(result);
    }

    @Test
    public void equals_otherObject_returnsFalse() {
        Team team1 = LogicTestUtil.makeDefaultTeam();
        String team2 = "user2";

        boolean result = team1.equals(team2);
        assertFalse(result);
    }

    @Test
    public void equals_nullObject_returnsFalse() {
        Team team1 = LogicTestUtil.makeDefaultTeam();
        Team team2 = null;

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
    public void getName_withDefaultName_returnsName() throws Exception {
        Team team = LogicTestUtil.makeDefaultTeam(); // default name is "team".

        String expected = "team";
        String actual = team.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getId_withDefaultId_returnsId() throws Exception {
        Team team = LogicTestUtil.makeDefaultTeam(); // default id is -1.

        int expected = -1;
        int actual = team.getId();

        Assert.assertEquals(expected, actual);
    }
}