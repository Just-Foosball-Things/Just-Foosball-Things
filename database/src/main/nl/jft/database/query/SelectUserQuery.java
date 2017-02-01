package nl.jft.database.query;

import com.datastax.driver.core.Statement;
import nl.jft.logic.participant.impl.User;

/**
 * @author Oscar de Leeuw
 */
public class SelectUserQuery extends UserQuery {


    public SelectUserQuery(User user) {
        super(user);
    }

    @Override
    public Statement getStatement() {

        String query = "SELECT %SELECT_CLAUSE% FROM %TABLE_NAME%";

        return null;
    }
}
