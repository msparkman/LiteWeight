package sparkman.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sparkman.service.WorkoutService;
import sparkman.domain.GymSession;
import sparkman.domain.User;

@RestController
public class LiteWeightController {

	private WorkoutService workoutService;

	public LiteWeightController(WorkoutService workoutService) {
	    this.workoutService = workoutService;
    }

	@RequestMapping("/")
	public String home() {
		return "cool";
	}

	@RequestMapping("/save")
	public GymSession saveWorkout(GymSession gymSession) {
		return new GymSession();
	}

	@RequestMapping("/user")
	public User saveUser(User user) {
		return workoutService.saveUser(user);
	}
}
