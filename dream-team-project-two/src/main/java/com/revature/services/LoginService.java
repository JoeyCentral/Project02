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

	// wei methods are below, method above are front end test from haroldo
	public int checkUser2(Users user) {
		String username = user.getUsername();
		String saltFromUser = userRepository.returnSaltIfUserExist(username);
		if (!saltFromUser.equals("0")) {
			System.out.println("Checking password...");
			// pw checking
			int userId = userRepository.verifyPassword(user, saltFromUser);
			return userId;
		}
		return 0;

	}

	public Users createUser(Users user) {
		if((user.getUsername().length() <= 25) && (user.getHashpass().length() >=6)) {
			System.out.println("User Created");
			return userRepository.createUser(user);
		}
		System.out.println("Username too long");
		
		return null;
	}

}
