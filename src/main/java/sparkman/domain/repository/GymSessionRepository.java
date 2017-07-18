package sparkman.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import sparkman.domain.GymSession;

@Transactional
public interface GymSessionRepository extends CrudRepository<GymSession, Long> {
}