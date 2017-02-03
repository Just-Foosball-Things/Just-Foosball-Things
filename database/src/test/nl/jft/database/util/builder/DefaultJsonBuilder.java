package nl.jft.database.util.builder;

import nl.jft.database.converter.DefaultJsonConverter;

/**
 * @author Oscar de Leeuw
 */
public class DefaultJsonBuilder<T> {

    public DefaultJsonConverter<T> build() {
        return new DefaultJsonConverter<>();
    }

}
