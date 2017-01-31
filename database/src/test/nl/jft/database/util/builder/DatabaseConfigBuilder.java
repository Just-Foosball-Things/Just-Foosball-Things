package nl.jft.database.util.builder;

import nl.jft.database.config.DatabaseConfigurationImpl;
import nl.jft.database.config.PropertiesLoader;

import java.io.IOException;

import static org.mockito.Mockito.mock;

/**
 * @author Oscar de Leeuw
 */
public class DatabaseConfigBuilder {

    private PropertiesLoader loader;

    public DatabaseConfigBuilder() {
        loader = mock(PropertiesLoader.class);
    }

    public DatabaseConfigBuilder withStream(PropertiesLoader loader) {
        this.loader = loader;
        return this;
    }

    public DatabaseConfigurationImpl build() throws IOException {
        return new DatabaseConfigurationImpl(loader);
    }
}
