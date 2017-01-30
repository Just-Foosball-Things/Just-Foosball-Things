package nl.jft.logic.util;

import nl.jft.common.rating.Rating;
import nl.jft.logic.LogicConstants;
import nl.jft.logic.participant.impl.Team;
import nl.jft.logic.participant.impl.User;

/**
 * @author Lesley
 */
public final class TeamBuilder {

    private int id;
    private String teamName;
    private Rating rating;
    private User firstUser;
    private User secondUser;

    public TeamBuilder() {
        id = LogicConstants.INTERNAL_ID;
        teamName = "name";
        rating = LogicTestUtil.makeDefaultRating();
        firstUser = LogicTestUtil.makeDefaultUser();
        secondUser = LogicTestUtil.makeDefaultUser2();
    }

    public TeamBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public TeamBuilder withTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    public TeamBuilder withRating(Rating rating) {
        this.rating = rating;
        return this;
    }

    public TeamBuilder withFirstUser(User firstUser) {
        this.firstUser = firstUser;
        return this;
    }

    public TeamBuilder withSecondUser(User secondUser) {
        this.secondUser = secondUser;
        return this;
    }

    public Team build() {
        return new Team(id, teamName, rating, firstUser, secondUser);
    }

}
