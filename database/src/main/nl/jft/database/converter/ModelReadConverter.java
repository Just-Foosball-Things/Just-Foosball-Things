package nl.jft.database.converter;

import nl.jft.database.entity.Model;
import nl.jft.database.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 * @author Oscar de Leeuw
 */
public class ModelReadConverter implements Converter<Long, Model> {

    @Autowired
    ModelRepository repository;

    @Override
    public Model convert(Long aLong) {
        System.out.println("Ik ben een modelletje aan het ophalen.");
        return repository.findOne(aLong);
    }
}