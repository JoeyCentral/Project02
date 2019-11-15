package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Spells {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "spell_id")
	private int id;
	
	private String spellname;
	
	private int spelllevel;
	
	private int school;
	
	private String casttime;
	
	private int spellrange;
	
	private String components;
	
	private String duration;
	
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpellname() {
		return spellname;
	}

	public void setSpellname(String spellname) {
		this.spellname = spellname;
	}

	public int getSpelllevel() {
		return spelllevel;
	}

	public void setSpelllevel(int spelllevel) {
		this.spelllevel = spelllevel;
	}

	public int getSchool() {
		return school;
	}

	public void setSchool(int school) {
		this.school = school;
	}

	public String getCasttime() {
		return casttime;
	}

	public void setCasttime(String casttime) {
		this.casttime = casttime;
	}

	public int getSpellrange() {
		return spellrange;
	}

	public void setSpellrange(int spellrange) {
		this.spellrange = spellrange;
	}

	public String getComponents() {
		return components;
	}

	public void setComponents(String components) {
		this.components = components;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
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
		result = prime * result + ((casttime == null) ? 0 : casttime.hashCode());
		result = prime * result + ((components == null) ? 0 : components.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + id;
		result = prime * result + school;
		result = prime * result + spelllevel;
		result = prime * result + ((spellname == null) ? 0 : spellname.hashCode());
		result = prime * result + spellrange;
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
		Spells other = (Spells) obj;
		if (casttime == null) {
			if (other.casttime != null)
				return false;
		} else if (!casttime.equals(other.casttime))
			return false;
		if (components == null) {
			if (other.components != null)
				return false;
		} else if (!components.equals(other.components))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (id != other.id)
			return false;
		if (school != other.school)
			return false;
		if (spelllevel != other.spelllevel)
			return false;
		if (spellname == null) {
			if (other.spellname != null)
				return false;
		} else if (!spellname.equals(other.spellname))
			return false;
		if (spellrange != other.spellrange)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Spells [id=" + id + ", spellname=" + spellname + ", spelllevel=" + spelllevel + ", school=" + school
				+ ", casttime=" + casttime + ", spellrange=" + spellrange + ", components=" + components + ", duration="
				+ duration + ", description=" + description + "]";
	}

	public Spells(int id, String spellname, int spelllevel, int school, String casttime, int spellrange,
			String components, String duration, String description) {
		super();
		this.id = id;
		this.spellname = spellname;
		this.spelllevel = spelllevel;
		this.school = school;
		this.casttime = casttime;
		this.spellrange = spellrange;
		this.components = components;
		this.duration = duration;
		this.description = description;
	}

	public Spells() {
		super();
	}
	
	
}
