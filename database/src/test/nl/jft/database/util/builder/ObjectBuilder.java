package nl.jft.database.util.builder;

import java.io.IOException;

/**
 * @author Oscar de Leeuw
 */
public final class ObjectBuilder {

    private ObjectBuilder() {
        throw new UnsupportedOperationException("Should not be constructed.");
    }

    public static DatabaseConfigBuilder databaseConfiguration() {
        return new DatabaseConfigBuilder();
    }

    public static JftInitBuilder jftInitializer() throws IOException {
        return new JftInitBuilder();
    }

    public static <T> DefaultJsonBuilder<T> jsonConverter() {
        return new DefaultJsonBuilder<>();
    }
}
