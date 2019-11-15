package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "my_spells")
public class JoinSpells {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "char_id")
	private Characters char_id;
	
	@ManyToOne
	@JoinColumn(name = "spell_id")
	private Spells spell_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Characters getChar_id() {
		return char_id;
	}

	public void setChar_id(Characters char_id) {
		this.char_id = char_id;
	}

	public Spells getSpell_id() {
		return spell_id;
	}

	public void setSpell_id(Spells spell_id) {
		this.spell_id = spell_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((char_id == null) ? 0 : char_id.hashCode());
		result = prime * result + id;
		result = prime * result + ((spell_id == null) ? 0 : spell_id.hashCode());
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
		JoinSpells other = (JoinSpells) obj;
		if (char_id == null) {
			if (other.char_id != null)
				return false;
		} else if (!char_id.equals(other.char_id))
			return false;
		if (id != other.id)
			return false;
		if (spell_id == null) {
			if (other.spell_id != null)
				return false;
		} else if (!spell_id.equals(other.spell_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JoinSpells [id=" + id + ", char_id=" + char_id + ", spell_id=" + spell_id + "]";
	}

	public JoinSpells(int id, Characters char_id, Spells spell_id) {
		super();
		this.id = id;
		this.char_id = char_id;
		this.spell_id = spell_id;
	}

	public JoinSpells() {
		super();
	}
	
	
}
