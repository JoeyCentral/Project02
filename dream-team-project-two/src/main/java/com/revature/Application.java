package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.revature.services.UserServices;

@SpringBootApplication
public class Application {
	static public void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}
}