package com.revature.test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.revature.models.Characters;
import com.revature.repositories.CharacterRepository;
import com.revature.repositories.UserRepository;
import com.revature.services.CharacterService;

public class CharacterServiceTest {

	@Mock
	private CharacterRepository mockCharacterRepository;

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private CharacterService characterService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getCharacterByCharacterIdTest() {

//		Characters character1 = new Characters();
//		character1.setCharacter_name("Fred");
//		character1.setId(1);
//		character1.setPlayername("Critesk");

		Characters character = new Characters();

		int characterId = 1000;

		when(mockCharacterRepository.getCharacterByCharId(characterId)).thenReturn(character);

//		System.out.println("Character ID: " + character.getId());

		Characters returnedCharacter = characterService.getMyCharacter(characterId);

//		System.out.println("returnedCharacter ID: " + returnedCharacter.getId());

		assertSame("Expecting character to be same as returnedCharacter...", character, returnedCharacter);

		// System.out.println("getCharacterByUserId test passed!");

	}

	@Test
	public void getCharactersByUserIdTest() {
		List<Characters> characters = new ArrayList<>();

		int userId = 50;

		when(mockCharacterRepository.getCharactersByUserId(userId)).thenReturn(characters);

		List<Characters> actualCharacters = characterService.getCharacters(userId);

		assertSame("Expecting a list of two characters to be the same...", characters, actualCharacters);

		// System.out.println("getCharactersByUserId test passed!");
	}

	@Test
	public void saveCharacterTest() {
		Characters character = new Characters();
		
		character.setId(1);
		
		Integer id = 1;
		
		when(mockCharacterRepository.save(character)).thenReturn(id);
		
		assertSame("Expecting character.getId() to be equivalent to Integer value id...", character.getId(), id);
		
	}
	
	
	@Test
	public void copyCharacterTest() {
		// Pulls character name, slaps copy, sets ID to 0, then saves new result
		Characters character = new Characters();
		
		character.setId(1);
		character.setCharacter_name("Dark Magician");
		
		Integer copyCharacterId = characterService.copyCharacter(character);
		
//		System.out.println(copyCharacterId);
//		System.out.println(character.getId());
		
		assertTrue("Dark Magician ID is set to 1 and its copy's ID is set to 0", copyCharacterId == 0 && 
				character.getId() == 0);
		
	}
	
	@Test
	public void shareCharacterTest() {
		// Pulls player name, user object from database that matches player name, replaces player object assoc.
		// w/ character and sets id to 0, and saves
		
		Characters character = new Characters();
		
		character.setId(1);
		
		// Asserts that the original ID of character is 1
		
		assertTrue("Original ID of character is equal to 1", character.getId() == 1);
		
		character.setCharacter_name("Dark Magician Girl");
		character.setPlayername("Yami Yugi");
		
		Integer sharedCharacterId = characterService.shareCharacter(character);
		
		// Now character has been shared, the copy character ID should be of value 0 and the new id value of 
		// character is also 0
		
		assertTrue("The value of sharedCharacterId is equal to 0 and the value of character's ID is now also"
				+ "equal to 0", sharedCharacterId == 0 && character.getId() == 0);
	}
	

}
