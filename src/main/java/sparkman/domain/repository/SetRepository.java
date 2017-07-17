package sparkman.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sparkman.domain.Set;

@Repository
public interface SetRepository extends CrudRepository<Set, Long> {
}