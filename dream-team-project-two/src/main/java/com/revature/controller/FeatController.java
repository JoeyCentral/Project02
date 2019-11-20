package com.revature.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Features;

@RestController
@RequestMapping("feature")
public class FeatController {
	@PostMapping("/save")
	public int saveFeature() {
		return 0;
	}
	@GetMapping("/load/{featId}")
	public Features loadFeature(@PathVariable int featId) {
		return null;
	}
}
