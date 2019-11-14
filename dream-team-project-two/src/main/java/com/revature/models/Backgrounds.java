package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Backgrounds {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "background_id")
	private int id;
	
	private String background_name;
	
	@ManyToOne
	@JoinColumn(name = "prof_id")
	private Proficiencies proficiency1;
	
	@ManyToOne
	@JoinColumn(name = "prof_id")
	private Proficiencies proficiency2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBackground_name() {
		return background_name;
	}

	public void setBackground_name(String background_name) {
		this.background_name = background_name;
	}

	public Proficiencies getProficiency1() {
		return proficiency1;
	}

	public void setProficiency1(Proficiencies proficiency1) {
		this.proficiency1 = proficiency1;
	}

	public Proficiencies getProficiency2() {
		return proficiency2;
	}

	public void setProficiency2(Proficiencies proficiency2) {
		this.proficiency2 = proficiency2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((background_name == null) ? 0 : background_name.hashCode());
		result = prime * result + id;
		result = prime * result + ((proficiency1 == null) ? 0 : proficiency1.hashCode());
		result = prime * result + ((proficiency2 == null) ? 0 : proficiency2.hashCode());
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
		Backgrounds other = (Backgrounds) obj;
		if (background_name == null) {
			if (other.background_name != null)
				return false;
		} else if (!background_name.equals(other.background_name))
			return false;
		if (id != other.id)
			return false;
		if (proficiency1 == null) {
			if (other.proficiency1 != null)
				return false;
		} else if (!proficiency1.equals(other.proficiency1))
			return false;
		if (proficiency2 == null) {
			if (other.proficiency2 != null)
				return false;
		} else if (!proficiency2.equals(other.proficiency2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Backgrounds [id=" + id + ", background_name=" + background_name + ", proficiency1=" + proficiency1
				+ ", proficiency2=" + proficiency2 + "]";
	}

	public Backgrounds(int id, String background_name, Proficiencies proficiency1, Proficiencies proficiency2) {
		super();
		this.id = id;
		this.background_name = background_name;
		this.proficiency1 = proficiency1;
		this.proficiency2 = proficiency2;
	}

	public Backgrounds() {
		super();
	}

	
}
