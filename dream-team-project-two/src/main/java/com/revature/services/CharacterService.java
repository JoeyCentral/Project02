package com.revature.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repositories.CharacterRepository;
@Service
public class CharacterService {
	CharacterRepository characterRepository;
	@Autowired
	public CharacterService(CharacterRepository characterRepository) {
		super();
		this.characterRepository = characterRepository;
	}
	
	public List<Character> getCharacters(int userId) {
		String sql = "SELECT * FROM Character WHERE user_id = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		
		statement.setInt(1, character.getPlayer.getId());
		
		ResultSet rs = statement.executeQuery();
		List<Character> userCharacters = new LinkedList<>();
		
		while (rs.next()) {
			userCharacters.add(extractCharacter(rs));
		}
		
		return userCharacters;
		
	}
}
