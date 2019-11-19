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

import org.springframework.beans.factory.annotation.Value;
@Entity
public class SpellList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "spell_list_id")
	private int id;
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	@Value("")
	private String castingFocus;
	
	@Value("0")
	private int spellsLeft;
	@Value("")
	private String component;
	
	@ManyToMany
	@JoinTable(name = "spells_known", joinColumns = { @JoinColumn(name = "spell_list_id") }, inverseJoinColumns = {
			@JoinColumn(name = "spell_id") })
	private List<Spells> spellsknown;
	
	@ManyToMany
	@JoinTable(name = "spellsavailable", joinColumns = { @JoinColumn(name = "spell_list_id") }, inverseJoinColumns = {
			@JoinColumn(name = "spell_id") })
	private List<Spells> spellsavailable;
	
	@ManyToMany
	@JoinTable(name = "spell_features", joinColumns = { @JoinColumn(name = "spell_list_id") }, inverseJoinColumns = {
			@JoinColumn(name = "feat_id") })
	private List<Features> features;
	

	public SpellList(int id, String castingFocus, int spellsLeft, String component, List<Spells> spellsknown,
			List<Spells> spellsavailable, List<Features> features) {
		super();
		this.id = id;
		this.castingFocus = castingFocus;
		this.spellsLeft = spellsLeft;
		this.component = component;
		this.spellsknown = spellsknown;
		this.spellsavailable = spellsavailable;
		this.features = features;
	}


	public List<Features> getFeatures() {
		return features;
	}


	public void setFeatures(List<Features> features) {
		this.features = features;
	}


	@Override
	public String toString() {
		return "SpellList [id=" + id + ", castingFocus=" + castingFocus + ", spellsLeft=" + spellsLeft + ", component="
				+ component + ", spellsknown=" + spellsknown + ", spellsavailable=" + spellsavailable + ", features="
				+ features + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((castingFocus == null) ? 0 : castingFocus.hashCode());
		result = prime * result + ((component == null) ? 0 : component.hashCode());
		result = prime * result + ((features == null) ? 0 : features.hashCode());
		result = prime * result + id;
		result = prime * result + spellsLeft;
		result = prime * result + ((spellsavailable == null) ? 0 : spellsavailable.hashCode());
		result = prime * result + ((spellsknown == null) ? 0 : spellsknown.hashCode());
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
		SpellList other = (SpellList) obj;
		if (castingFocus == null) {
			if (other.castingFocus != null)
				return false;
		} else if (!castingFocus.equals(other.castingFocus))
			return false;
		if (component == null) {
			if (other.component != null)
				return false;
		} else if (!component.equals(other.component))
			return false;
		if (features == null) {
			if (other.features != null)
				return false;
		} else if (!features.equals(other.features))
			return false;
		if (id != other.id)
			return false;
		if (spellsLeft != other.spellsLeft)
			return false;
		if (spellsavailable == null) {
			if (other.spellsavailable != null)
				return false;
		} else if (!spellsavailable.equals(other.spellsavailable))
			return false;
		if (spellsknown == null) {
			if (other.spellsknown != null)
				return false;
		} else if (!spellsknown.equals(other.spellsknown))
			return false;
		return true;
	}


	public List<Spells> getSpellsknown() {
		return spellsknown;
	}


	public void setSpellsknown(List<Spells> spellsknown) {
		this.spellsknown = spellsknown;
	}


	public List<Spells> getSpellsavailable() {
		return spellsavailable;
	}


	public void setSpellsavailable(List<Spells> spellsavailable) {
		this.spellsavailable = spellsavailable;
	}


	public SpellList() {
		super();
	}


	public String getCastingFocus() {
		return castingFocus;
	}

	public void setCastingFocus(String castingFocus) {
		this.castingFocus = castingFocus;
	}

	public int getSpellsLeft() {
		return spellsLeft;
	}

	public void setSpellsLeft(int spellsLeft) {
		this.spellsLeft = spellsLeft;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

}
