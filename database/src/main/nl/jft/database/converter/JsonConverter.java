package nl.jft.database.converter;

/**
 * The {@code JsonConverter} interface described the necessary behaviour that is needed to convert an {@code Object}
 * to and from JSON.
 *
 * @author Oscar de Leeuw
 * @param <T> The type of the {@code Object} that should be converted to JSON.
 */
public interface JsonConverter<T> {
    /**
     * Converts an {@code Object} to a {@code JSON String}.
     *
     * @param object The {@code Object} that should be converted to a {@code String}.
     * @return A {@code JSON String}.
     */
    String to(T object);

    /**
     * Converts a {@code JSON String} to an {@code Object} of the given type.
     *
     * @param s    The {@code JSON String} that should be converted.
     * @param type The {@code Class} the {@code Object} should be converted too.
     * @return An {@code Object} of the given {@code Class}.
     */
    T from(String s, Class<T> type);
}
