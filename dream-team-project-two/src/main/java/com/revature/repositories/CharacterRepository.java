package com.revature.repositories;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Characters;

@Repository
public class CharacterRepository {
	@Autowired(required = true)
	EntityManager em;
	
	public Characters create(Characters character) {
		Session session = em.unwrap(Session.class);
		session.save(character);
		return character;
	}
}
