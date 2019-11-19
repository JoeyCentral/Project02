package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "profile_id")
	private int id;
	
	@Column(nullable=false, columnDefinition = "int default 0")
	private int abilityScores;
	
	@Column(nullable=false, columnDefinition = "int default 0")
	private int inspiration;
	private String alignment;
	
	@Column(nullable=false, columnDefinition = "int default 0")
	private int experience;
	
	@Column(nullable=false, columnDefinition = "int default 0")
	private int maximumHealth;
	
	@Column(nullable=false, columnDefinition = "int default 0")
	private int ac;
	
	@Column(nullable=false, columnDefinition = "int default 0")
	private int deathsaves;
	
	@Column(nullable=false, columnDefinition = "int default 0")
	private int hitDice;
	
	@Column(nullable=false, columnDefinition = "int default 0")
	private int currentHealth;
	private String inventory;
	private String languages;
	
	@ManyToOne
	@JoinColumn(name = "race_id")
	private Race race;
	
	@ManyToOne
	@JoinColumn(name = "background_id")
	private Backgrounds background;
	
	@ManyToMany
	@JoinTable(name = "my_Profs", joinColumns = { @JoinColumn(name = "profile_id") }, inverseJoinColumns = {
			@JoinColumn(name = "prof_id") })
	private List<Proficiencies> proficiencies;
	
	@ManyToMany
	@JoinTable(name = "my_Feats", joinColumns = { @JoinColumn(name = "profile_id") }, inverseJoinColumns = {
			@JoinColumn(name = "feat_id") })
	private List<Features> features;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAbilityScores() {
		return abilityScores;
	}

	public void setAbilityScores(int abilityScores) {
		this.abilityScores = abilityScores;
	}

	public int getInspiration() {
		return inspiration;
	}

	public void setInspiration(int inspiration) {
		this.inspiration = inspiration;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getMaximumHealth() {
		return maximumHealth;
	}

	public void setMaximumHealth(int maximumHealth) {
		this.maximumHealth = maximumHealth;
	}

	public int getAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}

	public int getDeathsaves() {
		return deathsaves;
	}

	public void setDeathsaves(int deathsaves) {
		this.deathsaves = deathsaves;
	}

	public int getHitDice() {
		return hitDice;
	}

	public void setHitDice(int hitDice) {
		this.hitDice = hitDice;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public String getInventory() {
		return inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Backgrounds getBackground() {
		return background;
	}

	public void setBackground(Backgrounds background) {
		this.background = background;
	}

	public List<Proficiencies> getProficiencies() {
		return proficiencies;
	}

	public void setProficiencies(List<Proficiencies> proficiencies) {
		this.proficiencies = proficiencies;
	}

	public List<Features> getFeatures() {
		return features;
	}

	public void setFeatures(List<Features> features) {
		this.features = features;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + abilityScores;
		result = prime * result + ac;
		result = prime * result + ((alignment == null) ? 0 : alignment.hashCode());
		result = prime * result + ((background == null) ? 0 : background.hashCode());
		result = prime * result + currentHealth;
		result = prime * result + deathsaves;
		result = prime * result + experience;
		result = prime * result + ((features == null) ? 0 : features.hashCode());
		result = prime * result + hitDice;
		result = prime * result + id;
		result = prime * result + inspiration;
		result = prime * result + ((inventory == null) ? 0 : inventory.hashCode());
		result = prime * result + ((languages == null) ? 0 : languages.hashCode());
		result = prime * result + maximumHealth;
		result = prime * result + ((proficiencies == null) ? 0 : proficiencies.hashCode());
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
		if (abilityScores != other.abilityScores)
			return false;
		if (ac != other.ac)
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
		if (currentHealth != other.currentHealth)
			return false;
		if (deathsaves != other.deathsaves)
			return false;
		if (experience != other.experience)
			return false;
		if (features == null) {
			if (other.features != null)
				return false;
		} else if (!features.equals(other.features))
			return false;
		if (hitDice != other.hitDice)
			return false;
		if (id != other.id)
			return false;
		if (inspiration != other.inspiration)
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
		if (proficiencies == null) {
			if (other.proficiencies != null)
				return false;
		} else if (!proficiencies.equals(other.proficiencies))
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
		return "Profile [id=" + id + ", abilityScores=" + abilityScores + ", inspiration=" + inspiration
				+ ", alignment=" + alignment + ", experience=" + experience + ", maximumHealth=" + maximumHealth
				+ ", ac=" + ac + ", deathsaves=" + deathsaves + ", hitDice=" + hitDice + ", currentHealth="
				+ currentHealth + ", inventory=" + inventory + ", languages=" + languages + ", race=" + race
				+ ", background=" + background + ", proficiencies=" + proficiencies + ", features=" + features + "]";
	}

	public Profile(int id, int abilityScores, int inspiration, String alignment, int experience,
			int maximumHealth, int ac, int deathsaves, int hitDice, int currentHealth, String inventory,
			String languages, Race race, Backgrounds background, List<Proficiencies> proficiencies,
			List<Features> features) {
		super();
		this.id = id;
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
		this.background = background;
		this.proficiencies = proficiencies;
		this.features = features;
	}

	public Profile() {
		super();
	}
	
}
