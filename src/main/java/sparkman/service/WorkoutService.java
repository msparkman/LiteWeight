package sparkman.service;

import sparkman.domain.GymSession;
import sparkman.domain.User;

public interface WorkoutService {
    /**
     * Retrieves a user
     *
     * @param userId the ID of the user in the database
     * @return User from the database
     */
    User getUser(Long userId);

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
