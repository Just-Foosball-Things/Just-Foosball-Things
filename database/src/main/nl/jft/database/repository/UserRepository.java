package nl.jft.database.repository;

import nl.jft.database.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Oscar de Leeuw
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
