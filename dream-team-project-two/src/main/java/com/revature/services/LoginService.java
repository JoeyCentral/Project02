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

	public int checkUser(Users user) {
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


	public int createUser(Users user) {
		String username = user.getUsername();
		String password = user.getHashpass();
		String saltFromUser = userRepository.returnSaltIfUserExist(username);
		if (saltFromUser.equals("0")) {
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
				Users newUser = userRepository.create(user);
				return newUser.getId();
			}
			
			System.out.println("Password too short");
			// returns -2 if password is too short
			return -2;
		}
		System.out.println("Username too long");
		// returns -1 if username is too long
		return -1;
	}	// returns 0 if username already exists
		return 0;
	}

}
