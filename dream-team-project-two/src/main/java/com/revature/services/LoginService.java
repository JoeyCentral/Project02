package com.revature.services;


import java.security.SecureRandom;
import java.util.Random;

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
		String username = user.getUsername();
		String password = user.getHashpass();
		if (username.length() <= 25) {
			if (password.length() >= 6) {
				
				//generate salt if user and pass follows rules
				Random r = new SecureRandom();
				byte[] salt = new byte[20];
				r.nextBytes(salt);
				user.setSalt(salt.toString());
				
				//hash password to be stored in db
				String passwordHashed = UserRepository.passwordHasher(password, salt.toString());
				user.setHashpass(passwordHashed);
				
				System.out.println("User Created");
				return userRepository.createUser(user);
			}
			System.out.println("Password too short");
			return null;
		}
		System.out.println("Username too long");

		return null;
	}

}
