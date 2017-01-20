package nl.jft.logic.participant.impl;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
    public void getName_withDefaultName_returnsName() throws Exception {
        Team team = makeTeam(); //default name is "team".

        String expected = "team";
        String actual = team.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getId_withDefaultId_returnsId() throws Exception {
        Team team = makeTeam(); //default id is 1.

        int expected = 1;
        int actual = team.getId();

        Assert.assertEquals(expected, actual);
    }

    private Team makeTeam() {
        return new Team(1, "team");
    }
}