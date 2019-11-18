package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="profile")
public class Profile {
	private List<String> abilityScores;
	private String inspiration;
	private String alignment;
	private Integer experience;
	private int maximumHealth;
	private String ac;
	private String deathsaves;
	private String hitDice;
	private Integer currentHealth;
	private List<String> inventory;
	private List<String> languages;
	
	public Profile(List<String> abilityScores, String inspiration, String alignment, Integer experience,
			int maximumHealth, String ac, String deathsaves, String hitDice, Integer currentHealth,
			List<String> inventory, List<String> languages, Race race, Character character, Proficiencies prof,
			Backgrounds background, Features feature, CharClass charClass) {
		super();
		this.abilityScores = abilityScores;
		this.inspiration = inspiration;
		this.alignment = alignment;
		this.experience = experience;
		this.maximumHealth = maximumHealth;
		this.ac = ac;
		this.deathsaves = deathsaves;
		this.hitDice = hitDice;
		this.currentHealth = currentHealth;
		this.inventory = inventory;
		this.languages = languages;
		this.race = race;
		this.character = character;
		this.prof = prof;
		this.background = background;
		this.feature = feature;
		this.charClass = charClass;
	}
	
	@ManyToOne
	@JoinColumn(name="race_id")
	private Race race;
	
	@OneToOne
	@JoinColumn(name="character_id")
	private Character character;
	
	@ManyToMany
	@JoinColumn(name="prof_id")
	private Proficiencies prof;
	
	@ManyToOne
	@JoinColumn(name="background_id")
	private Backgrounds background;
	
	@ManyToMany
	@JoinColumn(name="feature_id")
	private Features feature;
	
	@ManyToMany
	@JoinColumn(name="class_id")
	private CharClass charClass;

	public List<String> getAbilityScores() {
		return abilityScores;
	}

	public void setAbilityScores(List<String> abilityScores) {
		this.abilityScores = abilityScores;
	}

	public String getInspiration() {
		return inspiration;
	}

	public void setInspiration(String inspiration) {
		this.inspiration = inspiration;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public int getMaximumHealth() {
		return maximumHealth;
	}

	public void setMaximumHealth(int maximumHealth) {
		this.maximumHealth = maximumHealth;
	}

	public String getAc() {
		return ac;
	}

	public void setAc(String ac) {
		this.ac = ac;
	}

	public String getDeathsaves() {
		return deathsaves;
	}

	public void setDeathsaves(String deathsaves) {
		this.deathsaves = deathsaves;
	}

	public String getHitDice() {
		return hitDice;
	}

	public void setHitDice(String hitDice) {
		this.hitDice = hitDice;
	}

	public Integer getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(Integer currentHealth) {
		this.currentHealth = currentHealth;
	}

	public List<String> getInventory() {
		return inventory;
	}

	public void setInventory(List<String> inventory) {
		this.inventory = inventory;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public Proficiencies getProf() {
		return prof;
	}

	public void setProf(Proficiencies prof) {
		this.prof = prof;
	}

	public Backgrounds getBackground() {
		return background;
	}

	public void setBackground(Backgrounds background) {
		this.background = background;
	}

	public Features getFeature() {
		return feature;
	}

	public void setFeature(Features feature) {
		this.feature = feature;
	}

	public CharClass getCharClass() {
		return charClass;
	}

	public void setCharClass(CharClass charClass) {
		this.charClass = charClass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abilityScores == null) ? 0 : abilityScores.hashCode());
		result = prime * result + ((ac == null) ? 0 : ac.hashCode());
		result = prime * result + ((alignment == null) ? 0 : alignment.hashCode());
		result = prime * result + ((background == null) ? 0 : background.hashCode());
		result = prime * result + ((charClass == null) ? 0 : charClass.hashCode());
		result = prime * result + ((character == null) ? 0 : character.hashCode());
		result = prime * result + ((currentHealth == null) ? 0 : currentHealth.hashCode());
		result = prime * result + ((deathsaves == null) ? 0 : deathsaves.hashCode());
		result = prime * result + ((experience == null) ? 0 : experience.hashCode());
		result = prime * result + ((feature == null) ? 0 : feature.hashCode());
		result = prime * result + ((hitDice == null) ? 0 : hitDice.hashCode());
		result = prime * result + ((inspiration == null) ? 0 : inspiration.hashCode());
		result = prime * result + ((inventory == null) ? 0 : inventory.hashCode());
		result = prime * result + ((languages == null) ? 0 : languages.hashCode());
		result = prime * result + maximumHealth;
		result = prime * result + ((prof == null) ? 0 : prof.hashCode());
		result = prime * result + ((race == null) ? 0 : race.hashCode());
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
		Profile other = (Profile) obj;
		if (abilityScores == null) {
			if (other.abilityScores != null)
				return false;
		} else if (!abilityScores.equals(other.abilityScores))
			return false;
		if (ac == null) {
			if (other.ac != null)
				return false;
		} else if (!ac.equals(other.ac))
			return false;
		if (alignment == null) {
			if (other.alignment != null)
				return false;
		} else if (!alignment.equals(other.alignment))
			return false;
		if (background == null) {
			if (other.background != null)
				return false;
		} else if (!background.equals(other.background))
			return false;
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
		if (currentHealth == null) {
			if (other.currentHealth != null)
				return false;
		} else if (!currentHealth.equals(other.currentHealth))
			return false;
		if (deathsaves == null) {
			if (other.deathsaves != null)
				return false;
		} else if (!deathsaves.equals(other.deathsaves))
			return false;
		if (experience == null) {
			if (other.experience != null)
				return false;
		} else if (!experience.equals(other.experience))
			return false;
		if (feature == null) {
			if (other.feature != null)
				return false;
		} else if (!feature.equals(other.feature))
			return false;
		if (hitDice == null) {
			if (other.hitDice != null)
				return false;
		} else if (!hitDice.equals(other.hitDice))
			return false;
		if (inspiration == null) {
			if (other.inspiration != null)
				return false;
		} else if (!inspiration.equals(other.inspiration))
			return false;
		if (inventory == null) {
			if (other.inventory != null)
				return false;
		} else if (!inventory.equals(other.inventory))
			return false;
		if (languages == null) {
			if (other.languages != null)
				return false;
		} else if (!languages.equals(other.languages))
			return false;
		if (maximumHealth != other.maximumHealth)
			return false;
		if (prof == null) {
			if (other.prof != null)
				return false;
		} else if (!prof.equals(other.prof))
			return false;
		if (race == null) {
			if (other.race != null)
				return false;
		} else if (!race.equals(other.race))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Profile [abilityScores=" + abilityScores + ", inspiration=" + inspiration + ", alignment=" + alignment
				+ ", experience=" + experience + ", maximumHealth=" + maximumHealth + ", ac=" + ac + ", deathsaves="
				+ deathsaves + ", hitDice=" + hitDice + ", currentHealth=" + currentHealth + ", inventory=" + inventory
				+ ", languages=" + languages + ", race=" + race + ", character=" + character + ", prof=" + prof
				+ ", background=" + background + ", feature=" + feature + ", charClass=" + charClass + "]";
	}


	
	
	
	
}
