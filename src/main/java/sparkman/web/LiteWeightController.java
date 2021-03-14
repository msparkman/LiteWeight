package sparkman.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping(value = "/")
	public String home() {
		return "cool";
	}

	@GetMapping(value = "/gymSessions")
	public List<GymSession> getAllGymSessions() {
		return workoutService.getGymSessions();
	}

	@PutMapping(value = "/workout/{userId}")
	public GymSession saveWorkout(@PathVariable String userId, @RequestBody GymSession gymSession) {
		if (gymSession.getUser() == null) {
		    User user = new User();
		    user.setId(Long.valueOf(userId));
		    gymSession.setUser(user);
        }

	    return workoutService.saveWorkout(gymSession);
	}

	@GetMapping(value = "/user/{userId}")
	public User getUser(@PathVariable String userId) {
		return workoutService.getUser(Long.valueOf(userId));
	}

	@PutMapping(value = "/user")
	public User saveUser(@RequestBody User user) {
		return workoutService.saveUser(user);
	}
}
