package nl.jft.database.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.jft.database.entity.Model;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * @author Oscar de Leeuw
 */
public class ModelConverter implements JsonConverter<Model> {

    private static ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToJson(Model object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Model convertFromJson(String s) {
        if (StringUtils.hasText(s)) {
            try {
                return mapper.readValue(s, Model.class);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        return null;
    }
}
