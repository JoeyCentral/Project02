package com.revature.test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controller.CharacterController;
import com.revature.controller.LoginController;
import com.revature.models.*;
import com.revature.repositories.CharacterRepository;
import com.revature.repositories.UserRepository;
import com.revature.services.CharacterService;
import com.revature.services.LoginService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CharacterControllerTest {
	
	private MockMvc mockMvc;
	@Mock
	private CharacterRepository mockCharacterRepository;

	@Mock
	private CharacterController characterController;

	@Mock
	private CharacterService characterService;

	@Autowired
	ObjectMapper om;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(characterController).setControllerAdvice().build();
	}
	
	@Test
	public void getCharacterByIdTest() throws JsonProcessingException, Exception {
		Characters character = new Characters();
		character.setCharacter_name("Fred");
		character.setId(1);
		character.setPlayername("Critesk");
		
		
		Info testInfo = new Info();
		testInfo.setId(1);
		Users testUser = new Users();
		testUser.setId(1);
		SpellList testSpelllist = new SpellList();
		testSpelllist.setId(1);
		Profile testProfile = new Profile();
		testProfile.setId(1);
		
		character.setInfo(testInfo);
		character.setPlayer(testUser);
		character.setProfile(testProfile);
		character.setSpellList(testSpelllist);
		
		
		

		Characters existingCharacter = new Characters();
		existingCharacter.setCharacter_name(character.getCharacter_name());
		existingCharacter.setPlayername(character.getPlayername());

		when(mockCharacterRepository.getCharacterByCharId(character.getId())).thenReturn(existingCharacter);


		// I just want to compare the character IDs and names. I dont want to compare the rest of the information obtained from the JSON calls.
		
		this.mockMvc
				.perform(
						get("character/select/1").contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsString(character)))
				.andDo(print()).andExpect(status().isCreated())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().json(om.writeValueAsString(existingCharacter)));

	}
	
	@Test
	public void getCharactersByUserIdTest() throws JsonProcessingException, Exception {
		Users existingUser = new Users();
		existingUser.setUsername("Critesk");
		existingUser.setId(1);
		existingUser.setSalt("[B@2346885b");
		existingUser.setHashpass("f3b144e788f008d568b2be2cc19c2692fe640ca01c1a5c0c89acf8edfd043a01ba631da6d324f1061a9812c9f290999e8907fda37b5563bcb2edabcf9b147269");
		
		List<Characters> expectedCharacters = new ArrayList<>();
		
		Characters character1 = new Characters();
		Characters character2 = new Characters();
		
		character1.setId(1);
		character2.setId(3);
		
		character1.setPlayername("Critesk");
		character2.setPlayername("Critesk");
		
		character1.setCharacter_name("Fred");
		character2.setCharacter_name("Fred");
		
		expectedCharacters.add(character1);
		expectedCharacters.add(character2);
		
		List<Characters> actualCharacters = new ArrayList<>();
		
		when(mockCharacterRepository.getCharactersByUserId(existingUser.getId())).thenReturn(actualCharacters);
		
		// I just want to compare the character IDs and names. I dont want to compare the rest of the information obtained from the JSON calls.
		
		this.mockMvc
		.perform(
				get("character/view/" + existingUser.getId()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsString(expectedCharacters)))
		.andDo(print()).andExpect(status().isCreated())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(content().json(om.writeValueAsString(actualCharacters)));
		
	}
	
	

}