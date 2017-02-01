package nl.jft.database.query;

import nl.jft.logic.participant.impl.User;

/**
 * @author Oscar de Leeuw
 */
public abstract class UserQuery implements Query<User> {

    protected final String tableName = "players";
    protected final User user;

    protected UserQuery(User user) {
        this.user = user;
    }
}
