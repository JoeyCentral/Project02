package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Spellsources {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "source_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "spell_id")
	private Spells spell;
	
	@ManyToOne
	@JoinColumn(name = "class_id")
	private CharClass class_id;
	
	@ManyToOne
	@JoinColumn(name = "race_id")
	private Race race;
	
	@ManyToOne
	@JoinColumn(name = "feature_id")
	private Features feature;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Spells getSpell() {
		return spell;
	}

	public void setSpell(Spells spell) {
		this.spell = spell;
	}

	public CharClass getClass_id() {
		return class_id;
	}

	public void setClass_id(CharClass class_id) {
		this.class_id = class_id;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Features getFeature() {
		return feature;
	}

	public void setFeature(Features feature) {
		this.feature = feature;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((class_id == null) ? 0 : class_id.hashCode());
		result = prime * result + ((feature == null) ? 0 : feature.hashCode());
		result = prime * result + id;
		result = prime * result + ((race == null) ? 0 : race.hashCode());
		result = prime * result + ((spell == null) ? 0 : spell.hashCode());
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
		Spellsources other = (Spellsources) obj;
		if (class_id == null) {
			if (other.class_id != null)
				return false;
		} else if (!class_id.equals(other.class_id))
			return false;
		if (feature == null) {
			if (other.feature != null)
				return false;
		} else if (!feature.equals(other.feature))
			return false;
		if (id != other.id)
			return false;
		if (race == null) {
			if (other.race != null)
				return false;
		} else if (!race.equals(other.race))
			return false;
		if (spell == null) {
			if (other.spell != null)
				return false;
		} else if (!spell.equals(other.spell))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Spellsources [id=" + id + ", spell=" + spell + ", class_id=" + class_id + ", race=" + race
				+ ", feature=" + feature + "]";
	}

	public Spellsources(int id, Spells spell, CharClass class_id, Race race, Features feature) {
		super();
		this.id = id;
		this.spell = spell;
		this.class_id = class_id;
		this.race = race;
		this.feature = feature;
	}

	public Spellsources() {
		super();
	}
	
}
