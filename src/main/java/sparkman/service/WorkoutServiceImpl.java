package sparkman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sparkman.domain.GymSession;
import sparkman.domain.User;
import sparkman.domain.repository.GymSessionRepository;
import sparkman.domain.repository.UserRepository;

import java.util.Date;

@Service
public class WorkoutServiceImpl implements WorkoutService {
	@Autowired private UserRepository userRepository;
	@Autowired private GymSessionRepository gymSessionRepository;

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
