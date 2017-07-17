package sparkman.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sparkman.domain.Routine;

@Repository
public interface RoutineRepository extends CrudRepository<Routine, Long> {
}