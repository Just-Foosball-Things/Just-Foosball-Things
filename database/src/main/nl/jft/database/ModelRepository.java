package nl.jft.database;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Oscar de Leeuw
 */
@Repository
public interface ModelRepository extends CassandraRepository<Model> {

    @Query
    Iterable<Model> findByValue(String value);
}
