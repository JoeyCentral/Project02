package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.LoginService;

@RestController
@RequestMapping("start")
public class LoginController {
	LoginService loginService;
	@PostMapping("/login")
	public User checkUser(@RequestBody User user) {
		return loginService.checkUser(user);
	}
	@PostMapping("/create")
	public User newUser(@RequestBody User user) {
		return loginService.newUser(user);
	}
	@Autowired
	public LoginController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}
}






