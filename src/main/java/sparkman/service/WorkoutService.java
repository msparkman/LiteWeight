package sparkman.service;

import sparkman.domain.GymSession;
import sparkman.domain.Routine;
import sparkman.domain.RoutineSet;
import sparkman.domain.User;

public interface WorkoutService {

	/**
	 * Retrieves the gym session
	 *
	 * @param gymSessionId the ID of the gym session in the database
	 * @return GymSession from the database
	 */
	GymSession getGymSession(Long gymSessionId);

	/**
	 * Saves a new gym session
	 *
	 * @param gymSession the gym session information
	 * @return GymSession containing the saved information
	 */
	GymSession saveGymSession(GymSession gymSession);

	/**
	 * Retrieves the routine
	 *
	 * @param routineId the ID of the routine in the database
	 * @return Routine from the database
	 */
	Routine getRoutine(Long routineId);

	/**
	 * Saves a new routine
	 *
	 * @param routine the routine information
	 * @return Routine containing the saved information
	 */
	Routine saveRoutine(Routine routine);

	/**
	 * Retrieves the routine set
	 *
	 * @param setId the ID of the set in the database
	 * @return RoutineSet from the database
	 */
	RoutineSet getRoutineSet(Long routineSetId);

	/**
	 * Saves a new routineSet
	 *
	 * @param routineSet the set information
	 * @return RoutineSet containing the saved information
	 */
	RoutineSet saveRoutineSet(RoutineSet routineSet);

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
