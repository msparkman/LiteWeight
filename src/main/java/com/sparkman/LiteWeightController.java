package com.sparkman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LiteWeightController {

	@RequestMapping("/")
	public String home() {
		return "cool";
	}
}
