package nl.jft.database.util.builder;

import nl.jft.database.DatabaseConfiguration;

import java.io.IOException;
import java.io.InputStream;

import static org.mockito.Mockito.mock;

/**
 * @author Oscar de Leeuw
 */
public class DatabaseConfigBuilder {

    private InputStream stream;

    public DatabaseConfigBuilder() {
        stream = mock(InputStream.class);
    }

    public DatabaseConfigBuilder withStream(InputStream stream) {
        this.stream = stream;
        return this;
    }

    public DatabaseConfiguration build() throws IOException {
        return new DatabaseConfiguration(stream);
    }
}
