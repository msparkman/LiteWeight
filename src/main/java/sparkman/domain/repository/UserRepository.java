package sparkman.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sparkman.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}