package nl.jft.database.converter;

import nl.jft.database.entity.Model;
import org.springframework.core.convert.converter.Converter;

/**
 * @author Oscar de Leeuw
 */
public class ModelWriteConverter implements Converter<Model, Long> {
    @Override
    public Long convert(Model model) {
        System.out.println("Ik ben een model aan het wolololoen");
        return model.getId();
    }
}
