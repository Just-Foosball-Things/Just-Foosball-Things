package nl.jft.database.util.builder;

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
}
