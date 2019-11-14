package com.revature.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Spells;

@RestController
@RequestMapping("spell")
public class SpellController {
	@PostMapping("/save")
	public Spells saveSpell() {
		return null;
	}
}
