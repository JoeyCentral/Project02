package com.revature.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Features;

@RestController
@RequestMapping("feature")
public class FeatController {
	@PostMapping("/save")
	public Features saveFeature() {
		return null;
	}
}
