package nl.jft.database.repository;

import nl.jft.database.entity.Model;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Oscar de Leeuw
 */
@Repository
public interface ModelRepository extends CrudRepository<Model, Long> {

    @Query
    Iterable<Model> findByValue(String value);
}
