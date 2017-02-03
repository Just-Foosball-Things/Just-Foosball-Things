package nl.jft.database.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Objects;

/**
 * This is the default implementation of the {@code JsonConverter} interface.
 * It uses the {@link ObjectMapper} class to convert from and to JSON.
 *
 * @param <T> The type of the {@code Object} that should be converted to JSON.
 * @author Oscar de Leeuw
 */
public class DefaultJsonConverter<T> implements JsonConverter<T> {

    private static ObjectMapper mapper = new ObjectMapper();

    @Override
    public String to(T object) {
        Objects.requireNonNull(object);
        try {
            return mapper.writeValueAsString(object);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public T from(String s, Class<T> type) {
        if (StringUtils.hasText(s)) {
            try {
                return mapper.readValue(s, type);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        return null;
    }
}
