package sparkman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sparkman.entity.GymSession;

@RestController
public class LiteWeightController {

	@RequestMapping("/")
	public String home() {
		return "cool";
	}

	@RequestMapping("/save")
	public GymSession saveWorkout() {
		return new GymSession();
	}
}
