package sparkman.web;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sparkman.domain.GymSession;
import sparkman.domain.User;
import sparkman.service.WorkoutService;

@RestController
public class LiteWeightController {

	private WorkoutService workoutService;

	public LiteWeightController(WorkoutService workoutService) {
	    this.workoutService = workoutService;
    }

	@RequestMapping(value = "/")
	public String home() {
		return "cool";
	}

	@RequestMapping(value = "/gymSessions", method = RequestMethod.GET)
	public List<GymSession> getAllGymSessions() {
		return workoutService.getGymSessions();
	}

	@RequestMapping(value = "/workout/{userId}", method = RequestMethod.PUT)
	public GymSession saveWorkout(@PathVariable String userId, @RequestBody GymSession gymSession) {
		if (gymSession.getUser() == null) {
		    User user = new User();
		    user.setId(Long.valueOf(userId));
		    gymSession.setUser(user);
        }

	    return workoutService.saveWorkout(gymSession);
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public User getUser(@PathVariable String userId) {
		return workoutService.getUser(Long.valueOf(userId));
	}

	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public User saveUser(@RequestBody User user) {
		return workoutService.saveUser(user);
	}
}
