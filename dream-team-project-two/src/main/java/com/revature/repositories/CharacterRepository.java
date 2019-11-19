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

	public Characters getCharacterByCharId(int char_id) {
		Session session = em.unwrap(Session.class);
		String hql = "from Characters where char_id is :char_id";
		Characters myCharacter = session
				.createQuery(hql, Characters.class)
				.setParameter("char_id", char_id)
				.getSingleResult();
		return myCharacter;
	}

	public int save(Characters myCharacter) {
		if (myCharacter.getId()==0) {
			System.out.println(myCharacter);
		Session session = em.unwrap(Session.class);
		Characters character = session.get(Characters.class, userId);
		
		if (character == null) 
			return Optional.empty();
		return null;

	}
}
