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
import com.revature.controller.LoginController;
import com.revature.models.Users;
import com.revature.repositories.UserRepository;
import com.revature.services.LoginService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {

	private MockMvc mockMvc;
	@Mock
	private UserRepository mockUserRepository;

	@Mock
	private LoginController loginController;

	@Mock
	private LoginService loginService;

	@Autowired
	ObjectMapper om;

	@Test
	public void easyTest() {
		Assert.assertSame("This test should give me 3 ", 3, 3);
	}

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(loginController).setControllerAdvice().build();
	}

	@Test
	public void createUserTest() throws JsonProcessingException, Exception {
		Users user = new Users();
		user.setUsername("weitesttest");
		user.setHashpass("password");

		Users returnedUser = new Users();
		returnedUser.setUsername(user.getUsername());
		when(mockUserRepository.create(user)).thenReturn(returnedUser);

		this.mockMvc
				.perform(
						post("/create").contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsString(user)))
				.andDo(print()).andExpect(status().isCreated())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().json(om.writeValueAsString(returnedUser)));

	}


	@Test
	public void createUserTest2() throws JsonProcessingException, Exception {
		Users user = new Users();
		user.setUsername("weitest");
		String username = user.getUsername();
		String salt = mockUserRepository.returnSaltIfUserExist("weitest");
		user.setSalt(salt);
		assertSame("Expect 0 if user doesn't exist", 0, salt);

	}

	@Test
	public void checkUserTest() {
		Users user = new Users();
		user.setUsername("weitest");
		String username = user.getUsername();

		user.setHashpass("password");

		String salt = mockUserRepository.returnSaltIfUserExist(username);
		user.setSalt(salt);

		int userid = loginService.checkUser(user);
		assertSame("If user doesn't exist: ", 6, userid);

	}

}
