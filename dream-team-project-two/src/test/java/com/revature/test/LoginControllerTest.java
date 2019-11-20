package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
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
import com.revature.controller.LoginController;
import com.revature.models.Users;
import com.revature.repositories.UserRepository;
import com.revature.services.LoginService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {

	private MockMvc mockMvc;
//
//	@Mock
//	private UserRepository mockUserRepository;
//
//	@InjectMocks
//	private LoginController mockLoginController;
//
//	@Mock
//	private LoginService mockLoginService;
//	@Autowired
	ObjectMapper om;
	
	@Autowired
	LoginService mockLoginService;


	@Test
	public void easyTest() {
		Assert.assertSame("This test should give me 3 ", 3, 3);
	}

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(mockLoginService).build();
	}
	
	@Test
	public void checkUserTest() {
		Users user = new Users();
		user.setUsername("Weii");
		user.setHashpass("PassWord");
		
		int returnedId = mockLoginService.checkUser(user);
System.out.println(returnedId);
		assertTrue(".checkUser() should return a userId with one inside the database (with user_id of 2).", returnedId != 0);
		
	}



	// fail, needs work
	@Test
	public void createUserTest() throws JsonProcessingException, Exception {
		Users user = new Users();
		user.setUsername("Weii");
		user.setHashpass("PassWord");
		user.setSalt("asdf");

		when(mockLoginService.createUser(user)).thenReturn(user.getId());
		System.out.println(user.getId());
		this.mockMvc
				.perform(post("/start/create").contentType(MediaType.APPLICATION_JSON)
						.content(om.writeValueAsString(user)))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().json(om.writeValueAsString(user)))
				.andExpect(status().is(HttpStatus.CREATED.value()));

	}

}