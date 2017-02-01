package nl.jft.database.query;

import com.datastax.driver.core.Statement;

/**
 * @author Oscar de Leeuw
 */
public interface Query<T> {

    /**
     * @return
     */
    Statement getStatement();
}
