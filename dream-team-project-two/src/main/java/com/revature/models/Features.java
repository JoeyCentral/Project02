package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Features {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feat_id")
	private int id;
	
	private String feat_name;
	
	private String field_modified;
	
	private int modifier;
	
	private String prereq;
	
	private int reqval;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFeat_name() {
		return feat_name;
	}

	public void setFeat_name(String feat_name) {
		this.feat_name = feat_name;
	}

	public String getField_modified() {
		return field_modified;
	}

	public void setField_modified(String field_modified) {
		this.field_modified = field_modified;
	}

	public int getModifier() {
		return modifier;
	}

	public void setModifier(int modifier) {
		this.modifier = modifier;
	}

	public String getPrereq() {
		return prereq;
	}

	public void setPrereq(String prereq) {
		this.prereq = prereq;
	}

	public int getReqval() {
		return reqval;
	}

	public void setReqval(int reqval) {
		this.reqval = reqval;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((feat_name == null) ? 0 : feat_name.hashCode());
		result = prime * result + ((field_modified == null) ? 0 : field_modified.hashCode());
		result = prime * result + id;
		result = prime * result + modifier;
		result = prime * result + ((prereq == null) ? 0 : prereq.hashCode());
		result = prime * result + reqval;
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
		Features other = (Features) obj;
		if (feat_name == null) {
			if (other.feat_name != null)
				return false;
		} else if (!feat_name.equals(other.feat_name))
			return false;
		if (field_modified == null) {
			if (other.field_modified != null)
				return false;
		} else if (!field_modified.equals(other.field_modified))
			return false;
		if (id != other.id)
			return false;
		if (modifier != other.modifier)
			return false;
		if (prereq == null) {
			if (other.prereq != null)
				return false;
		} else if (!prereq.equals(other.prereq))
			return false;
		if (reqval != other.reqval)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Features [id=" + id + ", feat_name=" + feat_name + ", field_modified=" + field_modified + ", modifier="
				+ modifier + ", prereq=" + prereq + ", reqval=" + reqval + "]";
	}

	public Features(int id, String feat_name, String field_modified, int modifier, String prereq, int reqval) {
		super();
		this.id = id;
		this.feat_name = feat_name;
		this.field_modified = field_modified;
		this.modifier = modifier;
		this.prereq = prereq;
		this.reqval = reqval;
	}

	public Features() {
		super();
	}
	
	
}
