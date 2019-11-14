package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Race {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "race_id")
	private int id;
	
	private String racename;
	
	private int abilitymod;
	
	private int base_speed;

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

	public int getAbilitymod() {
		return abilitymod;
	}

	public void setAbilitymod(int abilitymod) {
		this.abilitymod = abilitymod;
	}

	public int getBase_speed() {
		return base_speed;
	}

	public void setBase_speed(int base_speed) {
		this.base_speed = base_speed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + abilitymod;
		result = prime * result + base_speed;
		result = prime * result + id;
		result = prime * result + ((racename == null) ? 0 : racename.hashCode());
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
		if (abilitymod != other.abilitymod)
			return false;
		if (base_speed != other.base_speed)
			return false;
		if (id != other.id)
			return false;
		if (racename == null) {
			if (other.racename != null)
				return false;
		} else if (!racename.equals(other.racename))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Race [id=" + id + ", racename=" + racename + ", abilitymod=" + abilitymod + ", base_speed=" + base_speed
				+ "]";
	}

	public Race(int id, String racename, int abilitymod, int base_speed) {
		super();
		this.id = id;
		this.racename = racename;
		this.abilitymod = abilitymod;
		this.base_speed = base_speed;
	}

	public Race() {
		super();
	}
	
}
