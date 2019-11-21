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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
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

	@InjectMocks
	private CharacterController characterController;

	@Mock
	private CharacterService characterService;

	@Autowired
	ObjectMapper om;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(characterController)
				.setControllerAdvice().build();	
		}
	
	@Test
	public void getCharactersTest() throws JsonProcessingException, Exception {
		int characterId = 1;
		
		List<Characters> characters = new ArrayList<>();
		
		when(mockCharacterRepository.getCharactersByUserId(1)).thenReturn(characters);
		
		/*
		 * 	this.mockMvc.perform(get("/authors/" + id))
			.andExpect(content().contentTypeCompatibleWith("application/json"))
			.andExpect(content().json(om.writeValueAsString(author)))
			.andExpect(status().is(HttpStatus.OK.value()));
		 */
		
//		System.out.println("Character ID: " + characterId);
		
		this.mockMvc.perform(get("/character/view/" + characterId))
		.andExpect(content().contentTypeCompatibleWith("application/json"))
		.andExpect(content().json(om.writeValueAsString(characters)))
		.andExpect(status().is(HttpStatus.OK.value()));
		
	}
	
	@Test
	public void saveCharacterTest() throws JsonProcessingException, Exception {
		int characterId = 1;
		
		Characters character = new Characters();
		
		int newCharacterId = 0;
		
		when(mockCharacterRepository.save(character)).thenReturn(newCharacterId);
		
		/*
		 * 		this.mockMvc.perform(post("/authors/")
				// Include the request data
				.contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(author)))
			.andDo(print())
			.andExpect(status().isCreated())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(content().json(om.writeValueAsString(returnedAuthor)));

.contentType(MediaType.APPLICATION_JSON)
						.content(om.writeValueAsString(user)))
				.andDo(print()).andExpect(status().is(HttpStatus.OK.value()))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().json(om.writeValueAsString(user.getId())));
		 */
		
		
		this.mockMvc.perform(post("/character/save").contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(character)))
		.andDo(print()).andExpect(status().is(HttpStatus.OK.value()))
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(content().json(om.writeValueAsString(newCharacterId)));

	}
	
	@Test
	public void deleteCharacterTest() throws JsonProcessingException, Exception {
	//to be done when we have time
		// problem: return void
	}
	
	

}