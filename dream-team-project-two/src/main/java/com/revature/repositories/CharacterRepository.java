package com.revature.repositories;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Characters;
import com.revature.models.Info;
import com.revature.models.Multiclass;
import com.revature.models.Profile;
import com.revature.models.SpellList;


@NamedQuery(name = "updateInfo", 
query = "Update info set age=:age, alliance=:alliance, backstory=:backstory, "
		+ "bonds=:bonds, flaws=:flaws, hair=:hair, height=:height, ideals=:ideals, "
		+ "image=:image, personality=:personality, skin=:skin, symbol=:symbol, "
		+ "weight=:weight where info_id= :id")



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
			System.out.println(myCharacter);
		Session session = em.unwrap(Session.class);
		Profile myProfile = myCharacter.getProfile();
		Info myInfo = myCharacter.getInfo();
		SpellList mySpells = myCharacter.getSpellList();
		List<Multiclass> myClasses = myCharacter.getMulticlass();
		session.save(myProfile);
		session.save(myInfo);
		session.save(mySpells);
		session.save(myCharacter);
		for (Multiclass x:myClasses) {
			session.save(x);
		}
		} else {
			Session session = em.unwrap(Session.class);
			Transaction tx=session.beginTransaction();
			Profile myProfile = myCharacter.getProfile();
			Info myInfo = myCharacter.getInfo();
			SpellList mySpells = myCharacter.getSpellList();
			List<Multiclass> myClasses = myCharacter.getMulticlass();
			session.saveOrUpdate(myProfile);
			session.saveOrUpdate(myInfo);
			session.saveOrUpdate(mySpells);
			session.saveOrUpdate(myCharacter);
			for (Multiclass x:myClasses) {
				session.saveOrUpdate(x);
			}
			tx.commit();
		}
		return myCharacter.getId();
	}

	
	public void delete(int char_id) {
		Session session = em.unwrap(Session.class);
		String hql = "from Characters where char_id is :char_id";
		Characters myCharacter = session
				.createQuery(hql, Characters.class)
				.setParameter("char_id", char_id)
				.getSingleResult();
		Profile myProfile = myCharacter.getProfile();
		Info myInfo = myCharacter.getInfo();
		SpellList mySpells = myCharacter.getSpellList();
		session.delete(myProfile);
		session.delete(myInfo);
		session.delete(mySpells);
		session.delete(myCharacter);
	}
}
