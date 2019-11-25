package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Value;

@Entity
public class CustomRolls {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roll_id")
	private int id;
	@Value("")
	private String roll_name;
	
	@Value("0")
	private int ability;
	
	@Value("0")
	private int modifier;
	
	@Value("0")
	private int damage_amount;
	@Value("")
	private String damage_type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoll_name() {
		return roll_name;
	}

	public void setRoll_name(String roll_name) {
		this.roll_name = roll_name;
	}

	public int getAbility() {
		return ability;
	}

	public void setAbility(int ability) {
		this.ability = ability;
	}

	public int getModifier() {
		return modifier;
	}

	public void setModifier(int modifier) {
		this.modifier = modifier;
	}

	public int getDamage_amount() {
		return damage_amount;
	}

	public void setDamage_amount(int damage_amount) {
		this.damage_amount = damage_amount;
	}

	public String getDamage_type() {
		return damage_type;
	}

	public void setDamage_type(String damage_type) {
		this.damage_type = damage_type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ability;
		result = prime * result + damage_amount;
		result = prime * result + ((damage_type == null) ? 0 : damage_type.hashCode());
		result = prime * result + id;
		result = prime * result + modifier;
		result = prime * result + ((roll_name == null) ? 0 : roll_name.hashCode());
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
		CustomRolls other = (CustomRolls) obj;
		if (ability != other.ability)
			return false;
		if (damage_amount != other.damage_amount)
			return false;
		if (damage_type == null) {
			if (other.damage_type != null)
				return false;
		} else if (!damage_type.equals(other.damage_type))
			return false;
		if (id != other.id)
			return false;
		if (modifier != other.modifier)
			return false;
		if (roll_name == null) {
			if (other.roll_name != null)
				return false;
		} else if (!roll_name.equals(other.roll_name))
			return false;
		return true;
	}

	public CustomRolls(int id, String roll_name, int ability, int modifier, int damage_amount, String damage_type,
			Profile profile_id) {
		super();
		this.id = id;
		this.roll_name = roll_name;
		this.ability = ability;
		this.modifier = modifier;
		this.damage_amount = damage_amount;
		this.damage_type = damage_type;
	}

	@Override
	public String toString() {
		return "CustomRolls [id=" + id + ", roll_name=" + roll_name + ", ability=" + ability + ", modifier=" + modifier
				+ ", damage_amount=" + damage_amount + ", damage_type=" + damage_type + "]";
	}

	public CustomRolls() {
		super();
	}



}
