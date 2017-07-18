package sparkman.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import sparkman.domain.User;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
}