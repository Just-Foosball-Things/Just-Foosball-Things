package nl.jft.database.util.builder;

import nl.jft.database.DatabaseConfiguration;
import nl.jft.database.JftInitializer;

import java.io.IOException;

/**
 * @author Oscar de Leeuw
 */
public class JftInitBuilder {

    private DatabaseConfiguration config;

    public JftInitBuilder() throws IOException {
        config = ObjectBuilder.databaseConfiguration().build();
    }

    public JftInitBuilder withConfig(DatabaseConfiguration config) {
        this.config = config;
        return this;
    }

    public JftInitializer build() {
        return new JftInitializer(config);
    }
}
