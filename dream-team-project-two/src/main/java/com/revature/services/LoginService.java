package com.revature.services;

import org.springframework.stereotype.Service;

import com.revature.models.User;

@Service
public class LoginService {
 
	public User checkUser(User user) {
		return new User(2, "haroldo", "temp2");
	}
	
	public User newUser(User user) {
		return user;
	}
	
	
}
