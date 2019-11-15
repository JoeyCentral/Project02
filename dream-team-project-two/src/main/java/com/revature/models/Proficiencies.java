package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proficiencies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prof_id")
	private int id;
	
	private String prof_name;
	
	private int ability;
	
	private String description;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ability;
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

	@Override
	public String toString() {
		return "Proficiencies [id=" + id + ", prof_name=" + prof_name + ", ability=" + ability + ", description="
				+ description + "]";
	}

	public Proficiencies(int id, String prof_name, int ability, String description) {
		super();
		this.id = id;
		this.prof_name = prof_name;
		this.ability = ability;
		this.description = description;
	}

	public Proficiencies() {
		super();
	}
	
}
