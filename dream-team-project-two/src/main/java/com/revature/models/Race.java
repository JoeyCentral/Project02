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
public class Race {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "race_id")
	private int id;
	
	private String racename;
	
	private String description;
	@ManyToMany
	@JoinTable(name = "racial_feats", joinColumns = { @JoinColumn(name = "race_id") }, inverseJoinColumns = {
			@JoinColumn(name = "feat_id") })
	private List<Features> features;
	
	@ManyToMany
	@JoinTable(name = "racial_spells", joinColumns = { @JoinColumn(name = "race_id") }, inverseJoinColumns = { 
			@JoinColumn(name = "spells_id") })
	private List<Spells> spells;
	
	public Race() {
		super();
	}
	
	public Race(int id, String racename, String description, List<Features> features) {
		super();
		this.id = id;
		this.racename = racename;
		this.description = description;
		this.features = features;
	}
	

	public Race(int id, String racename, String description, List<Features> features, List<Spells> spells) {
		super();
		this.id = id;
		this.racename = racename;
		this.description = description;
		this.features = features;
		this.spells = spells;
	}
	
	
	public List<Spells> getSpells() {
		return spells;
	}

	public void setSpells(List<Spells> spells) {
		this.spells = spells;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRacename() {
		return racename;
	}

	public void setRacename(String racename) {
		this.racename = racename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((features == null) ? 0 : features.hashCode());
		result = prime * result + id;
		result = prime * result + ((racename == null) ? 0 : racename.hashCode());
		result = prime * result + ((spells == null) ? 0 : spells.hashCode());
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
		Race other = (Race) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (features == null) {
			if (other.features != null)
				return false;
		} else if (!features.equals(other.features))
			return false;
		if (id != other.id)
			return false;
		if (racename == null) {
			if (other.racename != null)
				return false;
		} else if (!racename.equals(other.racename))
			return false;
		if (spells == null) {
			if (other.spells != null)
				return false;
		} else if (!spells.equals(other.spells))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Race [id=" + id + ", racename=" + racename + ", description=" + description + ", features=" + features
				+ ", spells=" + spells + "]";
	}



}
