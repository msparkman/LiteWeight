package sparkman.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import sparkman.domain.Set;

@Transactional
public interface SetRepository extends CrudRepository<Set, Long> {
}