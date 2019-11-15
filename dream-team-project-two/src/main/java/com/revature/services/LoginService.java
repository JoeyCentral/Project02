package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class LoginService {
	UserRepository userRepository;
	
	@Autowired
	public LoginService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public User checkUser(User user) {
		return new User(2, "haroldo", "temp2", "temp2");
	}
	
	public User newUser(User user) {
		return user;
	}
	
	public User create(User user) {
		return userRepository.create(user);
	}
	
	
}
