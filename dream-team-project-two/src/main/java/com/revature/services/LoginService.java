package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Users;
import com.revature.repositories.UserRepository;

@Service
public class LoginService {
	UserRepository userRepository;
	
	@Autowired
	public LoginService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public Users checkUser(Users user) {
		System.out.println("Checking");
		return new Users(2, "haroldo", "temp2", "temp2");
	}
	
	public Users newUser(Users user) {
		return user;
	}
	
	public Users createUser(Users user) {
		return userRepository.createUser(user);
	}
	
	
}
