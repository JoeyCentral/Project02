package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(name = "prof_id")
	private Proficiencies saveprof1;
	
	@ManyToOne
	@JoinColumn(name = "prof_id", insertable = false, updatable = false)
	private Proficiencies saveprof2;
	
	private int spellprog;
	
	private int cantrips;

	public int getId() {
		return id;
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

	public Proficiencies getSaveprof1() {
		return saveprof1;
	}

	public void setSaveprof1(Proficiencies saveprof1) {
		this.saveprof1 = saveprof1;
	}

	public Proficiencies getSaveprof2() {
		return saveprof2;
	}

	public void setSaveprof2(Proficiencies saveprof2) {
		this.saveprof2 = saveprof2;
	}

	public int getSpellprog() {
		return spellprog;
	}

	public void setSpellprog(int spellprog) {
		this.spellprog = spellprog;
	}

	public int getCantrips() {
		return cantrips;
	}

	public void setCantrips(int cantrips) {
		this.cantrips = cantrips;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantrips;
		result = prime * result + ((classname == null) ? 0 : classname.hashCode());
		result = prime * result + hit_die;
		result = prime * result + id;
		result = prime * result + ((saveprof1 == null) ? 0 : saveprof1.hashCode());
		result = prime * result + ((saveprof2 == null) ? 0 : saveprof2.hashCode());
		result = prime * result + spellprog;
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
		CharClass other = (CharClass) obj;
		if (cantrips != other.cantrips)
			return false;
		if (classname == null) {
			if (other.classname != null)
				return false;
		} else if (!classname.equals(other.classname))
			return false;
		if (hit_die != other.hit_die)
			return false;
		if (id != other.id)
			return false;
		if (saveprof1 == null) {
			if (other.saveprof1 != null)
				return false;
		} else if (!saveprof1.equals(other.saveprof1))
			return false;
		if (saveprof2 == null) {
			if (other.saveprof2 != null)
				return false;
		} else if (!saveprof2.equals(other.saveprof2))
			return false;
		if (spellprog != other.spellprog)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CharClass [id=" + id + ", classname=" + classname + ", hit_die=" + hit_die + ", saveprof1=" + saveprof1
				+ ", saveprof2=" + saveprof2 + ", spellprog=" + spellprog + ", cantrips=" + cantrips + "]";
	}

	public CharClass(int id, String classname, int hit_die, Proficiencies saveprof1, Proficiencies saveprof2,
			int spellprog, int cantrips) {
		super();
		this.id = id;
		this.classname = classname;
		this.hit_die = hit_die;
		this.saveprof1 = saveprof1;
		this.saveprof2 = saveprof2;
		this.spellprog = spellprog;
		this.cantrips = cantrips;
	}

	public CharClass() {
		super();
	}
	
}
