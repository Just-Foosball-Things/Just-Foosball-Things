package nl.jft.database.repository;

import nl.jft.database.entity.participant.User;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author Oscar de Leeuw
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {

    @Query
    Collection<User> findAllByUsername(String username);
}
