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

@Entity
public class Proficiencies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prof_id")
	private int id;
	
	private String prof_name;
	
	private int ability;
	
	private String description;

	@ManyToMany
	@JoinTable(name = "background_profs", joinColumns = { @JoinColumn(name = "prof_id") }, inverseJoinColumns = {
			@JoinColumn(name = "background_id") })
	private List<Backgrounds> background;
	
	@ManyToMany
	@JoinTable(name = "class_profs", joinColumns = { @JoinColumn(name = "prof_id") }, inverseJoinColumns = {
			@JoinColumn(name = "class_id") })
	private List<CharClass> charClass;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProf_name() {
		return prof_name;
	}

	public void setProf_name(String prof_name) {
		this.prof_name = prof_name;
	}

	public int getAbility() {
		return ability;
	}

	public void setAbility(int ability) {
		this.ability = ability;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public Proficiencies(int id, String prof_name, int ability, String description, List<Backgrounds> background,
			List<CharClass> charClass) {
		super();
		this.id = id;
		this.prof_name = prof_name;
		this.ability = ability;
		this.description = description;
		this.background = background;
		this.charClass = charClass;
	}

	@Override
	public String toString() {
		return "Proficiencies [id=" + id + ", prof_name=" + prof_name + ", ability=" + ability + ", description="
				+ description + ", background=" + background + ", charClass=" + charClass + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ability;
		result = prime * result + ((background == null) ? 0 : background.hashCode());
		result = prime * result + ((charClass == null) ? 0 : charClass.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((prof_name == null) ? 0 : prof_name.hashCode());
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
		Proficiencies other = (Proficiencies) obj;
		if (ability != other.ability)
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
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (prof_name == null) {
			if (other.prof_name != null)
				return false;
		} else if (!prof_name.equals(other.prof_name))
			return false;
		return true;
	}

	public List<Backgrounds> getBackground() {
		return background;
	}

	public void setBackground(List<Backgrounds> background) {
		this.background = background;
	}

	public List<CharClass> getCharClass() {
		return charClass;
	}

	public void setCharClass(List<CharClass> charClass) {
		this.charClass = charClass;
	}

	public Proficiencies() {
		super();
	}
	
}
