package nl.jft.database.entity;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
//import org.springframework.data.cassandra.mapping.

/**
 * @author Oscar de Leeuw
 */
@Table(value = "users")
public class User {

    @PrimaryKey
    private int id;
    @Column
    private String username;
    @Column
    private Model model;

    public User(int id, String username, Model model) {
        this.id = id;
        this.username = username;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Model getModel() {
        return model;
    }
}
