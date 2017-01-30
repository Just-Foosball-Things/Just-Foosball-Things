package nl.jft.logic.util.builder;

import nl.jft.common.rating.Rating;
import nl.jft.logic.participant.Title;
import nl.jft.logic.participant.impl.User;

/**
 * @author Lesley
 */
public final class UserBuilder {

    private int id;
    private String username;
    private Rating rating;
    private Title title;

    public UserBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public UserBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder withRating(Rating rating) {
        this.rating = rating;
        return this;
    }

    public UserBuilder withTitle(Title title) {
        this.title = title;
        return this;
    }

    public User build() {
        return new User(id, username, rating, title);
    }

}
