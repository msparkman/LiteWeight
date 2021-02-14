package sparkman.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import sparkman.domain.RoutineSet;

@Transactional
public interface RoutineSetRepository extends CrudRepository<RoutineSet, Long> {
}