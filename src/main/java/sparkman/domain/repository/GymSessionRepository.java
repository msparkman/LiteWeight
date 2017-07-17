package sparkman.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sparkman.domain.GymSession;

@Repository
public interface GymSessionRepository extends CrudRepository<GymSession, Long> {
}