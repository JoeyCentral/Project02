package com.revature.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Characters;
import com.revature.repositories.CharacterRepository;
import com.revature.repositories.UserRepository;
@Service
public class CharacterService {
	CharacterRepository characterRepository;
	UserRepository userRepository;
	@Autowired
	public CharacterService(CharacterRepository characterRepository, UserRepository userRepository) {
		super();
		this.characterRepository = characterRepository;
		this.userRepository=userRepository;
	}
	
	
	public List<Characters> getCharacters(int userId) {
		return characterRepository.getCharactersByUserId(userId);
	}
	public Characters getMyCharacter(int charId) {
		return characterRepository.getCharacterByCharId(charId);
	}
	public int saveCharacter(Characters myCharacter) {
		return characterRepository.save(myCharacter);
	}
	public int copyCharacter(Characters copyChar) {
		copyChar.setCharacter_name(copyChar.getCharacter_name()+"(copy)");
		copyChar.setId(0);
		return characterRepository.save(copyChar);
	}
	public int shareCharacter(Characters shareChar) {
		shareChar.setPlayer(userRepository.getUserByName(shareChar.getPlayername()));
		shareChar.setId(0);
		return characterRepository.save(shareChar);
	}
	public int deleteCharacter(int charId) {
		characterRepository.delete(charId);
		return 0;
	}
	
}
