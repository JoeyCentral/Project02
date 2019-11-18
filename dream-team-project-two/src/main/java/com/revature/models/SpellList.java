package com.revature.models;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

public class SpellList {
	private String castingFocus;
	private int spellsLeft;
	private String component;
	
	public SpellList(String castingFocus, int spellsLeft, String component, Characters character, Spells knownSpells,
			Features features, Spells availableSpells) {
		super();
		this.castingFocus = castingFocus;
		this.spellsLeft = spellsLeft;
		this.component = component;
		this.character = character;
		this.knownSpells = knownSpells;
		this.features = features;
		this.availableSpells = availableSpells;
	}

	public SpellList() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String toString() {
		return "SpellList [castingFocus=" + castingFocus + ", spellsLeft=" + spellsLeft + ", component=" + component
				+ ", character=" + character + ", knownSpells=" + knownSpells + ", features=" + features
				+ ", availableSpells=" + availableSpells + "]";
	}

	@OneToOne
	@JoinColumn(name="character_id")
	private Characters character;
	
	@ManyToMany
	@JoinColumn(name="known_spells_id")
	private Spells knownSpells;
	
	@ManyToMany
	@JoinColumn(name="features_id")
	private Features features;
	
	@ManyToMany
	@JoinColumn(name="available_spells_id")
	private Spells availableSpells;

	public String getCastingFocus() {
		return castingFocus;
	}

	public void setCastingFocus(String castingFocus) {
		this.castingFocus = castingFocus;
	}

	public int getSpellsLeft() {
		return spellsLeft;
	}

	public void setSpellsLeft(int spellsLeft) {
		this.spellsLeft = spellsLeft;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public Characters getCharacter() {
		return character;
	}

	public void setCharacter(Characters character) {
		this.character = character;
	}

	public Spells getKnownSpells() {
		return knownSpells;
	}

	public void setKnownSpells(Spells knownSpells) {
		this.knownSpells = knownSpells;
	}

	public Features getFeatures() {
		return features;
	}

	public void setFeatures(Features features) {
		this.features = features;
	}

	public Spells getAvailableSpells() {
		return availableSpells;
	}

	public void setAvailableSpells(Spells availableSpells) {
		this.availableSpells = availableSpells;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availableSpells == null) ? 0 : availableSpells.hashCode());
		result = prime * result + ((castingFocus == null) ? 0 : castingFocus.hashCode());
		result = prime * result + ((character == null) ? 0 : character.hashCode());
		result = prime * result + ((component == null) ? 0 : component.hashCode());
		result = prime * result + ((features == null) ? 0 : features.hashCode());
		result = prime * result + ((knownSpells == null) ? 0 : knownSpells.hashCode());
		result = prime * result + spellsLeft;
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
		SpellList other = (SpellList) obj;
		if (availableSpells == null) {
			if (other.availableSpells != null)
				return false;
		} else if (!availableSpells.equals(other.availableSpells))
			return false;
		if (castingFocus == null) {
			if (other.castingFocus != null)
				return false;
		} else if (!castingFocus.equals(other.castingFocus))
			return false;
		if (character == null) {
			if (other.character != null)
				return false;
		} else if (!character.equals(other.character))
			return false;
		if (component == null) {
			if (other.component != null)
				return false;
		} else if (!component.equals(other.component))
			return false;
		if (features == null) {
			if (other.features != null)
				return false;
		} else if (!features.equals(other.features))
			return false;
		if (knownSpells == null) {
			if (other.knownSpells != null)
				return false;
		} else if (!knownSpells.equals(other.knownSpells))
			return false;
		if (spellsLeft != other.spellsLeft)
			return false;
		return true;
	}

	
	
}
