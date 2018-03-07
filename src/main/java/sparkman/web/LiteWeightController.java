package sparkman.web;

import org.springframework.web.bind.annotation.*;
import sparkman.service.WorkoutService;
import sparkman.domain.GymSession;
import sparkman.domain.User;

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
