package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Characters;
import com.revature.services.CharacterService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("character")
public class CharacterController {
	CharacterService characterService;
	int userId;
	@GetMapping("/view/{userId}")					//Retrieves all characters belonging to a user
													//Tested successfully with Postman
	public List<Characters> getCharacters(@PathVariable int userId) {
		return characterService.getCharacters(userId);
	}
	@GetMapping("/select/{charId}")					//Retrieves all data for one character
													//Tested successfully with Postman
	public Characters getMyCharacter(@PathVariable int charId) {
		return characterService.getMyCharacter(charId);
	}
	@PostMapping("/save")
	public int saveCharacter(@RequestBody Characters myCharacter) {
		int result = characterService.saveCharacter(myCharacter);
		return result;
	}
	@PostMapping("/copy")
	public int copyCharacter(@RequestBody Characters copyChar) {
		int result = characterService.copyCharacter(copyChar);
		return result;
	}
	@PostMapping("/share")
	public int shareCharacter(@RequestBody Characters shareChar) {
		int result = characterService.shareCharacter(shareChar);
		return result;
	}
	@DeleteMapping("/delete/{charId}")
	public int deleteCharacter(@PathVariable int charId) {
		int result = characterService.deleteCharacter(charId);
		return result;
	}
	
	
	@Autowired
	public CharacterController(CharacterService characterService) {
		super();
		this.characterService = characterService;
	}
}
