package sparkman.service;

import org.springframework.stereotype.Service;
import sparkman.domain.GymSession;
import sparkman.domain.User;

@Service
public class WorkoutServiceImpl implements WorkoutService {
    public User saveUser(User user) {
        return new User();
    }

    public GymSession saveWorkout(GymSession gymSession) {
        return new GymSession();
    }
}
