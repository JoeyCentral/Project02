package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Info {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "info_id")
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String image;
	private int age;
	private double height;
	private double weight;
	private String skin;
	private String hair;
	private String personality;
	private String flaws;
	private String bonds;
	private String ideals;
	private String symbol;
	private String alliance;
	private String backstory;
	
	public Info() {
		super();
	}


	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	public String getHair() {
		return hair;
	}

	public void setHair(String hair) {
		this.hair = hair;
	}

	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}

	public String getFlaws() {
		return flaws;
	}

	public void setFlaws(String flaws) {
		this.flaws = flaws;
	}

	public String getBonds() {
		return bonds;
	}

	public void setBonds(String bonds) {
		this.bonds = bonds;
	}

	public String getIdeals() {
		return ideals;
	}

	public void setIdeals(String ideals) {
		this.ideals = ideals;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getAlliance() {
		return alliance;
	}

	public void setAlliance(String alliance) {
		this.alliance = alliance;
	}

	public String getBackstory() {
		return backstory;
	}

	public void setBackstory(String backstory) {
		this.backstory = backstory;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((alliance == null) ? 0 : alliance.hashCode());
		result = prime * result + ((backstory == null) ? 0 : backstory.hashCode());
		result = prime * result + ((bonds == null) ? 0 : bonds.hashCode());
		result = prime * result + ((flaws == null) ? 0 : flaws.hashCode());
		result = prime * result + ((hair == null) ? 0 : hair.hashCode());
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((ideals == null) ? 0 : ideals.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((personality == null) ? 0 : personality.hashCode());
		result = prime * result + ((skin == null) ? 0 : skin.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Info other = (Info) obj;
		if (age != other.age)
			return false;
		if (alliance == null) {
			if (other.alliance != null)
				return false;
		} else if (!alliance.equals(other.alliance))
			return false;
		if (backstory == null) {
			if (other.backstory != null)
				return false;
		} else if (!backstory.equals(other.backstory))
			return false;
		if (bonds == null) {
			if (other.bonds != null)
				return false;
		} else if (!bonds.equals(other.bonds))
			return false;
		if (flaws == null) {
			if (other.flaws != null)
				return false;
		} else if (!flaws.equals(other.flaws))
			return false;
		if (hair == null) {
			if (other.hair != null)
				return false;
		} else if (!hair.equals(other.hair))
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (id != other.id)
			return false;
		if (ideals == null) {
			if (other.ideals != null)
				return false;
		} else if (!ideals.equals(other.ideals))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (personality == null) {
			if (other.personality != null)
				return false;
		} else if (!personality.equals(other.personality))
			return false;
		if (skin == null) {
			if (other.skin != null)
				return false;
		} else if (!skin.equals(other.skin))
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Info [id=" + id + ", image=" + image + ", age=" + age + ", height=" + height + ", weight=" + weight
				+ ", skin=" + skin + ", hair=" + hair + ", personality=" + personality + ", flaws=" + flaws + ", bonds="
				+ bonds + ", ideals=" + ideals + ", symbol=" + symbol + ", alliance=" + alliance + ", backstory="
				+ backstory + "]";
	}

	public Info(int id, String image, int age, double height, double weight, String skin, String hair,
			String personality, String flaws, String bonds, String ideals, String symbol, String alliance,
			String backstory) {
		super();
		this.id = id;
		this.image = image;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.skin = skin;
		this.hair = hair;
		this.personality = personality;
		this.flaws = flaws;
		this.bonds = bonds;
		this.ideals = ideals;
		this.symbol = symbol;
		this.alliance = alliance;
		this.backstory = backstory;
	}

	
	

}
