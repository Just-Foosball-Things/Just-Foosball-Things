package nl.jft.database.entity.participant;

import nl.jft.database.converter.DefaultJsonConverter;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;
//import org.springframework.data.cassandra.mapping.

/**
 * @author Oscar de Leeuw
 */
@Table(value = "users")
public class User {

    private static DefaultJsonConverter<Rating> ratingConverter = new DefaultJsonConverter<>();

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private String username;

    public User(String username, Rating rating) {
        this.username = username;
    }

    private User() {

    }

    public String getUsername() {
        return username;
    }
}
