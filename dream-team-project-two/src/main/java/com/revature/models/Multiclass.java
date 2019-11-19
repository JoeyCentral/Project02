package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Multiclass {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "multiclass_id")
	private int id;
	
	private int level;
	
	@ManyToOne
	@JoinColumn(name="class_id")
	private CharClass charClass;
	
	@ManyToOne
	@JoinColumn(name="character_id")
	private Characters character;
	
	public Multiclass(int id, int level, CharClass charClass, Characters character) {
		super();
		this.id = id;
		this.level = level;
		this.charClass = charClass;
		this.character = character;
	}

	public Multiclass() {
		super();
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public CharClass getCharClass() {
		return charClass;
	}

	public void setCharClass(CharClass charClass) {
		this.charClass = charClass;
	}

	public Characters getCharacter() {
		return character;
	}

	public void setCharacter(Characters character) {
		this.character = character;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((charClass == null) ? 0 : charClass.hashCode());
		result = prime * result + ((character == null) ? 0 : character.hashCode());
		result = prime * result + id;
		result = prime * result + level;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Multiclass other = (Multiclass) obj;
		if (charClass == null) {
			if (other.charClass != null)
				return false;
		} else if (!charClass.equals(other.charClass))
			return false;
		if (character == null) {
			if (other.character != null)
				return false;
		} else if (!character.equals(other.character))
			return false;
		if (id != other.id)
			return false;
		if (level != other.level)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Multiclass [id=" + id + ", level=" + level + ", charClass=" + charClass + ", character=" + character
				+ "]";
	}


	
	

}
