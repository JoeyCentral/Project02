package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Users;
import com.revature.services.LoginService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("start")
public class LoginController {
	LoginService loginService;

	@PostMapping("/login")
	public int checkUser(@RequestBody Users user) {
		Users oldUser = loginService.checkUser(user);
		return oldUser.getId();
	}

	@PostMapping("/create")
	public int newUser(@RequestBody Users user) {
		Users newUser = loginService.create(user);
		return newUser.getId();
	}

	@Autowired
	public LoginController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}
}
