package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Backgrounds {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "background_id")
	private int id;
	
	private String background_name;
	
	private String description;

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
		result = prime * result + ((background_name == null) ? 0 : background_name.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
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
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Backgrounds [id=" + id + ", background_name=" + background_name + ", description=" + description + "]";
	}

	public Backgrounds(int id, String background_name, String description) {
		super();
		this.id = id;
		this.background_name = background_name;
		this.description = description;
	}

	public Backgrounds() {
		super();
	}

	
}
