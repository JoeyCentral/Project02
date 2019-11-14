package com.revature.services;

import com.revature.daos.UserDao;
import com.revature.models.User;

public class UserServices {
	 UserDao userDao = new UserDao();

	public  User getUserById(int id) {
		User users = userDao.getUserById(id);
		System.out.println(users);
	
		return users;
	}
}
