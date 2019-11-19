package com.revature.repositories;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Characters;

@Repository
public class CharacterRepository {
	@Autowired(required = true)
	EntityManager em;
		
	public List<Characters> getCharactersByUserId(int user_id) {
		Session session = em.unwrap(Session.class);
				String hql = "from Characters where user_id is :user_id";
				List<Characters> myCharacters = session
						.createQuery(hql, Characters.class)
						.setParameter("user_id", user_id)
						.getResultList();
				return myCharacters;
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
		Session session = em.unwrap(Session.class);
		session.save(myCharacter);
		return myCharacter.getId();
	}

	public int copy(Characters copyChar) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int share(Characters shareChar) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(int charId) {
		// TODO Auto-generated method stub
		
	}
}
