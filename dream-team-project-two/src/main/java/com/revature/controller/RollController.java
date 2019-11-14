package com.revature.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.CustomRolls;

@RestController
@RequestMapping("roll")
public class RollController {
	@PostMapping("/save")
	public CustomRolls saveRoll() {
		return null;
	}
}
