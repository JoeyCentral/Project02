package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repositories.CharacterRepository;
@Service
public class CharacterService {
	CharacterRepository characterRepository;
	@Autowired
	public CharacterService(CharacterRepository characterRepository) {
		super();
		this.characterRepository = characterRepository;
	}
}
