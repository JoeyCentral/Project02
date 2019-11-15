package com.revature.repositories;


import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Users;



@Repository
public class UserRepository {

	@Autowired(required = true)
	EntityManager em;
	
	
	public Users createUser(Users user) {
		Session session = em.unwrap(Session.class);
		session.save(user);
		return user;
	}
	
	
}
