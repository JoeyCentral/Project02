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
	public void getCharactersByUserIdTest() {

//		Characters character1 = new Characters();
//		character1.setCharacter_name("Fred");
//		character1.setId(1);
//		character1.setPlayername("Critesk");
		
		Characters character = new Characters();
		
		when(mockCharacterRepository.getCharacterByCharId(0)).thenReturn(character);
		
		Characters returnedCharacter = characterService.getMyCharacter(character.getId());
		
		assertSame("Expecting character to be same as returnedCharacter...", character, returnedCharacter);
		
		System.out.println("getCharacterByUserId test passed!");
		

	}

}
