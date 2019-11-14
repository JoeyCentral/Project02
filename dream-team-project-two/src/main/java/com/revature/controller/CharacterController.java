package com.revature.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.CharacterService;

@RestController
@RequestMapping("character")
public class CharacterController {
	CharacterService characterService;
	@GetMapping("/view")					//Retrieves all characters belonging to a user
	public ArrayList<Character> getCharacters() {
		return null;
	}
	@PostMapping("/save")
	public Character saveCharacter() {
		return null;
	}
	@PostMapping("/copy")
	public Character copyCharacter() {
		return null;
	}
	@PostMapping("/share")
	public User shareCharacter() {
		return null;
	}
	@DeleteMapping("/delete")
	public Character deleteCharacter() {
		return null;
	}
	
	
	@Autowired
	public CharacterController(CharacterService characterService) {
		super();
		this.characterService = characterService;
	}
}
