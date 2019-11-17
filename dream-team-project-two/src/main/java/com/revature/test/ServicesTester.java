package com.revature.test;


import org.junit.Assert;
import org.junit.Test;

import com.revature.models.Users;
import com.revature.repositories.UserRepository;
import com.revature.services.*;

public class ServicesTester {

	@Test
	public void easyTest() {
		Assert.assertEquals("This test should give me 3 ", 3, 3);
	}

	@Test
	public void createUserTest() {
		Users user = new Users();
		user.setUsername("non-existing-user");
		user.setHashpass("password");
		Assert.assertEquals("If user doesn't exist: ", 0, LoginService.checkUser2(user));
	}
}
