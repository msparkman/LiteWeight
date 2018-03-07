package sparkman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sparkman.domain.GymSession;
import sparkman.domain.Routine;
import sparkman.domain.Set;
import sparkman.domain.User;
import sparkman.domain.repository.GymSessionRepository;
import sparkman.domain.repository.RoutineRepository;
import sparkman.domain.repository.SetRepository;
import sparkman.domain.repository.UserRepository;

import java.util.Date;

@Service
public class WorkoutServiceImpl implements WorkoutService {
	@Autowired private GymSessionRepository gymSessionRepository;
	@Autowired private RoutineRepository routineRepository;
	@Autowired private SetRepository setRepository;
	@Autowired private UserRepository userRepository;

	public GymSession getGymSession(Long gymSessionId) {
		return gymSessionRepository.findOne(gymSessionId);
	}

	public GymSession saveGymSession(GymSession gymSession) {
		if (gymSession.getDate() == null) {
			gymSession.setDate(new Date());
		}

		return gymSessionRepository.save(gymSession);
	}

	public Routine getRoutine(Long routineId) {
    	return routineRepository.findOne(routineId);
	}

	public Routine saveRoutine(Routine routine) {
    	return routineRepository.save(routine);
	}

	public Set getSet(Long setId) {
    	return setRepository.findOne(setId);
	}

	public Set saveSet(Set set) {
    	return setRepository.save(set);
	}

	public User getUser(Long userId) {
		return userRepository.findOne(userId);
	}

	public User saveUser(User user) {
		if (user.getDateCreated() == null) {
			user.setDateCreated(new Date());
		}

		return userRepository.save(user);
	}

    public GymSession saveWorkout(GymSession gymSession) {
        if (gymSession.getDate() == null) {
            gymSession.setDate(new Date());
        }

        User user = gymSession.getUser();
        if (user.getUsername() == null) {
            user = getUser(user.getId());
            gymSession.setUser(user);
        }

		return gymSessionRepository.save(gymSession);
    }
}
