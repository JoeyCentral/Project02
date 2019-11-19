package com.revature.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
	public ArrayList<Character> getCharacters(int userId) {
		return null;
	}
	
}
