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
import javax.persistence.Table;

@Entity
@Table(name= "character_class")
public class CharClass {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "class_id")
	private int id;
	
	private String classname;
	
	private int hit_die;
	
	@ManyToMany
	@JoinTable(name = "class_feats", joinColumns = { @JoinColumn(name = "class_id") }, inverseJoinColumns = {
			@JoinColumn(name = "feat_id") })
	private List<Features> features;

	public int getId() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CharClass other = (CharClass) obj;
		if (classname == null) {
			if (other.classname != null)
				return false;
		} else if (!classname.equals(other.classname))
			return false;
		if (features == null) {
			if (other.features != null)
				return false;
		} else if (!features.equals(other.features))
			return false;
		if (hit_die != other.hit_die)
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	public List<Features> getFeatures() {
		return features;
	}

	public void setFeatures(List<Features> features) {
		this.features = features;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public int getHit_die() {
		return hit_die;
	}

	public void setHit_die(int hit_die) {
		this.hit_die = hit_die;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classname == null) ? 0 : classname.hashCode());
		result = prime * result + ((features == null) ? 0 : features.hashCode());
		result = prime * result + hit_die;
		result = prime * result + id;
		return result;
	}





	public CharClass(int id, String classname, int hit_die, List<Features> features) {
		super();
		this.id = id;
		this.classname = classname;
		this.hit_die = hit_die;
		this.features = features;
	}

	@Override
	public String toString() {
		return "CharClass [id=" + id + ", classname=" + classname + ", hit_die=" + hit_die + ", features=" + features
				+ "]";
	}

	public CharClass() {
		super();
	}
	
}
