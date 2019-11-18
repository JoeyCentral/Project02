package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "my_feats")
public class JoinFeats {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "char_id")
	private Characters char_id;
	
	@ManyToOne
	@JoinColumn(name = "feat_id")
	private Features feat_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Characters getChar_id() {
		return char_id;
	}

	public void setChar_id(Characters char_id) {
		this.char_id = char_id;
	}

	public Features getFeat_id() {
		return feat_id;
	}

	public void setFeat_id(Features feat_id) {
		this.feat_id = feat_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((char_id == null) ? 0 : char_id.hashCode());
		result = prime * result + ((feat_id == null) ? 0 : feat_id.hashCode());
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
		JoinFeats other = (JoinFeats) obj;
		if (char_id == null) {
			if (other.char_id != null)
				return false;
		} else if (!char_id.equals(other.char_id))
			return false;
		if (feat_id == null) {
			if (other.feat_id != null)
				return false;
		} else if (!feat_id.equals(other.feat_id))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JoinFeats [id=" + id + ", char_id=" + char_id + ", feat_id=" + feat_id + "]";
	}

	public JoinFeats(int id, Characters char_id, Features feat_id) {
		super();
		this.id = id;
		this.char_id = char_id;
		this.feat_id = feat_id;
	}

	public JoinFeats() {
		super();
	}
	
	
}
