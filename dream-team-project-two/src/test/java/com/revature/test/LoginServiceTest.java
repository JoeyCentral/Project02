package com.revature.test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Users;
import com.revature.repositories.UserRepository;
import com.revature.services.LoginService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginServiceTest {

	@Mock
	private UserRepository mockUserRepository;

	@InjectMocks
	private LoginService loginService;
	@Autowired
	ObjectMapper om;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
    public void checkGoodUserTest() {
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
	public void createBadExistingUserTest() {
	Users user = new Users();
	user.setId(1);
	user.setUsername("Weii");
	user.setHashpass("PassWord");
	String salt = "whatever";
	when(mockUserRepository.returnSaltIfUserExist(user.getUsername())).thenReturn(salt);
	int returnedId = loginService.createUser(user);
    assertTrue(".createUser() should return a userId of 0 if user is already in database.",
            returnedId == 0);
	}
	@Test
	public void createBadLongUserTest() {
	Users user = new Users();
	user.setId(1);
	user.setUsername("Weiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
	user.setHashpass("PassWord");
	String salt = "0";
	when(mockUserRepository.returnSaltIfUserExist(user.getUsername())).thenReturn(salt);
	int returnedId = loginService.createUser(user);
	System.out.println(returnedId);
    assertTrue(".creatUser() should return a userId of -1 if username is too long.",
            returnedId == -1);
	}
	@Test
	public void createUserBadPassTest() {
	Users user = new Users();
	user.setId(1);
	user.setUsername("Weii");
	user.setHashpass("Pass");
	String salt = "0";
	when(mockUserRepository.returnSaltIfUserExist(user.getUsername())).thenReturn(salt);
	when(mockUserRepository.create(user)).thenReturn(user);
	int returnedId = loginService.createUser(user);
	System.out.println(returnedId);
    assertTrue(".creatUser() should return a userId of -2 if the password is too short.",
            returnedId == -2);
	}
	@Test
	public void createGoodUserTest() {
	Users user = new Users();
	user.setId(1);
	user.setUsername("Weii");
	user.setHashpass("PassWord");
	String salt = "0";
	when(mockUserRepository.returnSaltIfUserExist(user.getUsername())).thenReturn(salt);
	when(mockUserRepository.create(user)).thenReturn(user);
	int returnedId = loginService.createUser(user);
	System.out.println(returnedId);
    assertTrue(".creatUser() should return a  positive userId if user is created.",
            returnedId == 1);
	}
}
