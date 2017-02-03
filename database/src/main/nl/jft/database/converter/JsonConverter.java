package nl.jft.database.converter;

/**
 * @author Oscar de Leeuw
 */
public interface JsonConverter<T> {
    String convertToJson(T object);

    T convertFromJson(String s);
}
