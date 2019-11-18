package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Characters;
import com.revature.models.Users;
import com.revature.services.CharacterService;

@RestController
@RequestMapping("character")
public class CharacterController {
	CharacterService characterService;
	int userId;
	@GetMapping("/view")					//Retrieves all characters belonging to a user
	public List<Character> getCharacters() {
		return characterService.getCharacters(userId);
	}
	@PostMapping("/save")
	public Characters saveCharacter() {
		return null;
	}
	@PostMapping("/copy")
	public Characters copyCharacter() {
		return null;
	}
	@PostMapping("/share")
	public Users shareCharacter() {
		return null;
	}
	@DeleteMapping("/delete")
	public Characters deleteCharacter() {
		return null;
	}
	
	
	@Autowired
	public CharacterController(CharacterService characterService) {
		super();
		this.characterService = characterService;
	}
}
