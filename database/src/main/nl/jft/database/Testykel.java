package nl.jft.database;

import nl.jft.database.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Oscar de Leeuw
 */
@Component
public class Testykel {
    @Autowired
    private ModelRepository repository;

    public ModelRepository getRepository() {
        return repository;
    }
}
