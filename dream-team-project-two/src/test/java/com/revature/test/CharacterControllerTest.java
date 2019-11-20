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
	public void createUserTest() throws JsonProcessingException, Exception {
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


		this.mockMvc
				.perform(
						get("/select/" + existingCharacter.getId()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsString(character)))
				.andDo(print()).andExpect(status().isCreated())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().json(om.writeValueAsString(existingCharacter)));

	}

}