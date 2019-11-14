package com.revature.daos;

import org.hibernate.Session;

import com.revature.models.User;
import com.revature.util.HibernateUtil;

public class UserDao {
	public User getUserById(int id) {
		try (Session session = HibernateUtil.sessionFactory.openSession()) {
			User user = session.get(User.class, id);
			System.out.println(user);
			return user;
		} 
		
		
	}
}
