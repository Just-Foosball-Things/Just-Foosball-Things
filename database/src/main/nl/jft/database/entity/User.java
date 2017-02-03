package nl.jft.database.entity;

import nl.jft.database.converter.ModelConverter;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;
//import org.springframework.data.cassandra.mapping.

/**
 * @author Oscar de Leeuw
 */
@Table(value = "users")
public class User {

    private static ModelConverter modelConverter = new ModelConverter();

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private String username;
    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED)
    private String model;

    public User(String username, Model model) {
        this.username = username;
        this.model = modelConverter.convertToJson(model);
    }

    private User() {

    }

    public String getUsername() {
        return username;
    }

    public Model getModel() {
        return modelConverter.convertFromJson(model);
    }
}
