package sparkman.service;

import org.springframework.stereotype.Service;
import sparkman.domain.GymSession;
import sparkman.domain.User;

public interface WorkoutService {
    /**
     * Saves a new user
     *
     * @param user the user information
     * @return User containing all the saved information
     */
    User saveUser(User user);

    /**
     * Saves a user's workout
     *
     * @param gymSession contains teh workout information
     * @return GymSession containing all the saved information
     */
    GymSession saveWorkout(GymSession gymSession);
}
