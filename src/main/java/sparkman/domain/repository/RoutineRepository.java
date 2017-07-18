package sparkman.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import sparkman.domain.Routine;

@Transactional
public interface RoutineRepository extends CrudRepository<Routine, Long> {
}