package com.revature.test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

	// @Mock
	// private UserRepository mockUserRepository;

	@Mock
	private LoginService mockLoginService;

	@InjectMocks
	private LoginController loginController;

	@Autowired
	ObjectMapper om;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
	}

	@Test
	public void loginRouterTest() throws JsonProcessingException, Exception {
	
		Users user = new Users();
		user.setId(1);
		user.setUsername("Wei");
		user.setHashpass("PassWord");

		when(mockLoginService.checkUser(user)).thenReturn(user.getId());

		this.mockMvc
				.perform(post("/start/login").contentType(MediaType.APPLICATION_JSON)
						.content(om.writeValueAsString(user)))
				.andDo(print()).andExpect(status().is(HttpStatus.OK.value()))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().json(om.writeValueAsString(user.getId())));
	}

	@Test
	public void createRouterTest() throws JsonProcessingException, Exception {
		Users user = new Users();
		user.setId(1);
		user.setUsername("Weii");
		user.setHashpass("PassWord");
		String salt = "whatever";
		user.setSalt(salt);

		Users returnedUser = user;

		when(mockLoginService.createUser(user)).thenReturn(returnedUser.getId());

		this.mockMvc
				.perform(post("/start/create").contentType(MediaType.APPLICATION_JSON)
						.content(om.writeValueAsString(user)))
				.andDo(print()).andExpect(status().isCreated())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().json(om.writeValueAsString(returnedUser.getId())));
	}
}