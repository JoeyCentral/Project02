package com.revature.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Characters;
import com.revature.models.Users;

@Repository
public class CharacterRepository {
	@Autowired(required = true)
	EntityManager em;
	
	public Characters create(Characters character) {
		Session session = em.unwrap(Session.class);
		session.save(character);
		return character;
	}
	
<<<<<<< HEAD
//	public Optional<List<Characters>> getCharactersByUserId(int userId) {
//		Session session = em.unwrap(Session.class);
//		Characters character = session.get(Characters.class, userId);
//		
//		if (character == null) 
//			return Optional.empty();
//		
////		List<Characters> characters = character.getBooks();
////		Hibernate.initialize(books);
////		return Optional.of(books);
//
//	}
=======
	public Optional<List<Characters>> getCharactersByUserId(int userId) {
		Session session = em.unwrap(Session.class);
		Characters character = session.get(Characters.class, userId);
		
		if (character == null) 
			return Optional.empty();
		return null;

	}
>>>>>>> a5a4d8b2ae52f226249194cee5cfd8e12e7e35ac
}
