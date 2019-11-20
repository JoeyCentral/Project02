package com.revature.test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
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

	@Mock
	private UserRepository mockUserRepository;

	@InjectMocks
	private LoginService loginService;
	@Autowired
	LoginService mockLoginService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(loginService).build();
	}
	
	@Test
    public void checkUserTest() {
        Users user = new Users();
        user.setUsername("Wei");
        user.setHashpass("PassWord");

        String saltString = "";
        when(mockUserRepository.returnSaltIfUserExist(user.getUsername())).thenReturn(saltString);

        Integer id= 1;
        when(mockUserRepository.verifyPassword(user, saltString)).thenReturn(id);
        
        int returnedId = loginService.checkUser(user);
        System.out.println(returnedId);
        assertTrue(".checkUser() should return a userId with one inside the database (with user_id of 1).",
                returnedId != 0);

    }

	@Test
    public void checkBadUserTest() {
        Users user = new Users();
        user.setUsername("Wei");
        user.setHashpass("PassWord");

        when(mockUserRepository.returnSaltIfUserExist(user.getUsername())).thenReturn("");

        
        int returnedId = loginService.checkUser(user);
        System.out.println(returnedId);
        assertTrue(".checkUser() should return a userId of 0 if user is not in database.",
                returnedId == 0);

    }
	@Test
	public void createUserTest() throws JsonProcessingException, Exception {
		Users user = new Users();
		user.setId(1);
		user.setUsername("Weii");
		user.setHashpass("PassWord");
		String salt = "whatever";
		when(mockUserRepository.returnSaltIfUserExist(user.getUsername())).thenReturn(salt);
		when(mockUserRepository.create(user)).thenReturn(user);
		this.mockMvc
				.perform(post("/start/create").contentType(MediaType.APPLICATION_JSON)
						.content(om.writeValueAsString(user))).andDo(print())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().json(om.writeValueAsString(user.getId())))
				.andExpect(status().is(HttpStatus.CREATED.value()));
	}
}