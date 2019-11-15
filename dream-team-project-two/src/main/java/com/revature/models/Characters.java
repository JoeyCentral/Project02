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
@Table(name= "my_characters")
public class Characters {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "char_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User player;
	
	@ManyToOne
	@JoinColumn(name = "class_id")
	private CharClass my_class;
	
	@ManyToOne
	@JoinColumn(name = "race_id")
	private Race my_race;
	
	@ManyToOne
	@JoinColumn(name = "prof_id")
	private Proficiencies class_prof1;
	
	@ManyToOne
	@JoinColumn(name = "prof_id", insertable = false, updatable = false)
	private Proficiencies class_prof2;
	
	@ManyToOne
	@JoinColumn(name = "background_id")
	private Backgrounds background;
	
	private String gear;
	
	private int equiped_ac;
	
	private String personality;
	private String ideals;
	private String bonds;
	private String flaws;
	private String appearance;
	private String allies;
	private String backstory;
	private int tempdata;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getPlayer() {
		return player;
	}
	public void setPlayer(User player) {
		this.player = player;
	}
	public CharClass getMy_class() {
		return my_class;
	}
	public void setMy_class(CharClass my_class) {
		this.my_class = my_class;
	}
	public Race getMy_race() {
		return my_race;
	}
	public void setMy_race(Race my_race) {
		this.my_race = my_race;
	}
	public Proficiencies getClass_prof1() {
		return class_prof1;
	}
	public void setClass_prof1(Proficiencies class_prof1) {
		this.class_prof1 = class_prof1;
	}
	public Proficiencies getClass_prof2() {
		return class_prof2;
	}
	public void setClass_prof2(Proficiencies class_prof2) {
		this.class_prof2 = class_prof2;
	}
	public Backgrounds getBackground() {
		return background;
	}
	public void setBackground(Backgrounds background) {
		this.background = background;
	}
	public String getGear() {
		return gear;
	}
	public void setGear(String gear) {
		this.gear = gear;
	}
	public int getEquiped_ac() {
		return equiped_ac;
	}
	public void setEquiped_ac(int equiped_ac) {
		this.equiped_ac = equiped_ac;
	}
	public String getPersonality() {
		return personality;
	}
	public void setPersonality(String personality) {
		this.personality = personality;
	}
	public String getIdeals() {
		return ideals;
	}
	public void setIdeals(String ideals) {
		this.ideals = ideals;
	}
	public String getBonds() {
		return bonds;
	}
	public void setBonds(String bonds) {
		this.bonds = bonds;
	}
	public String getFlaws() {
		return flaws;
	}
	public void setFlaws(String flaws) {
		this.flaws = flaws;
	}
	public String getAppearance() {
		return appearance;
	}
	public void setAppearance(String appearance) {
		this.appearance = appearance;
	}
	public String getAllies() {
		return allies;
	}
	public void setAllies(String allies) {
		this.allies = allies;
	}
	public String getBackstory() {
		return backstory;
	}
	public void setBackstory(String backstory) {
		this.backstory = backstory;
	}
	public int getTempdata() {
		return tempdata;
	}
	public void setTempdata(int tempdata) {
		this.tempdata = tempdata;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allies == null) ? 0 : allies.hashCode());
		result = prime * result + ((appearance == null) ? 0 : appearance.hashCode());
		result = prime * result + ((background == null) ? 0 : background.hashCode());
		result = prime * result + ((backstory == null) ? 0 : backstory.hashCode());
		result = prime * result + ((bonds == null) ? 0 : bonds.hashCode());
		result = prime * result + ((class_prof1 == null) ? 0 : class_prof1.hashCode());
		result = prime * result + ((class_prof2 == null) ? 0 : class_prof2.hashCode());
		result = prime * result + equiped_ac;
		result = prime * result + ((flaws == null) ? 0 : flaws.hashCode());
		result = prime * result + ((gear == null) ? 0 : gear.hashCode());
		result = prime * result + id;
		result = prime * result + ((ideals == null) ? 0 : ideals.hashCode());
		result = prime * result + ((my_class == null) ? 0 : my_class.hashCode());
		result = prime * result + ((my_race == null) ? 0 : my_race.hashCode());
		result = prime * result + ((personality == null) ? 0 : personality.hashCode());
		result = prime * result + ((player == null) ? 0 : player.hashCode());
		result = prime * result + tempdata;
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
		Characters other = (Characters) obj;
		if (allies == null) {
			if (other.allies != null)
				return false;
		} else if (!allies.equals(other.allies))
			return false;
		if (appearance == null) {
			if (other.appearance != null)
				return false;
		} else if (!appearance.equals(other.appearance))
			return false;
		if (background == null) {
			if (other.background != null)
				return false;
		} else if (!background.equals(other.background))
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
		if (class_prof1 == null) {
			if (other.class_prof1 != null)
				return false;
		} else if (!class_prof1.equals(other.class_prof1))
			return false;
		if (class_prof2 == null) {
			if (other.class_prof2 != null)
				return false;
		} else if (!class_prof2.equals(other.class_prof2))
			return false;
		if (equiped_ac != other.equiped_ac)
			return false;
		if (flaws == null) {
			if (other.flaws != null)
				return false;
		} else if (!flaws.equals(other.flaws))
			return false;
		if (gear == null) {
			if (other.gear != null)
				return false;
		} else if (!gear.equals(other.gear))
			return false;
		if (id != other.id)
			return false;
		if (ideals == null) {
			if (other.ideals != null)
				return false;
		} else if (!ideals.equals(other.ideals))
			return false;
		if (my_class == null) {
			if (other.my_class != null)
				return false;
		} else if (!my_class.equals(other.my_class))
			return false;
		if (my_race == null) {
			if (other.my_race != null)
				return false;
		} else if (!my_race.equals(other.my_race))
			return false;
		if (personality == null) {
			if (other.personality != null)
				return false;
		} else if (!personality.equals(other.personality))
			return false;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		if (tempdata != other.tempdata)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Characters [id=" + id + ", player=" + player + ", my_class=" + my_class + ", my_race=" + my_race
				+ ", class_prof1=" + class_prof1 + ", class_prof2=" + class_prof2 + ", background=" + background
				+ ", gear=" + gear + ", equiped_ac=" + equiped_ac + ", personality=" + personality + ", ideals="
				+ ideals + ", bonds=" + bonds + ", flaws=" + flaws + ", appearance=" + appearance + ", allies=" + allies
				+ ", backstory=" + backstory + ", tempdata=" + tempdata + "]";
	}
	public Characters(int id, User player, CharClass my_class, Race my_race, Proficiencies class_prof1,
			Proficiencies class_prof2, Backgrounds background, String gear, int equiped_ac, String personality,
			String ideals, String bonds, String flaws, String appearance, String allies, String backstory,
			int tempdata) {
		super();
		this.id = id;
		this.player = player;
		this.my_class = my_class;
		this.my_race = my_race;
		this.class_prof1 = class_prof1;
		this.class_prof2 = class_prof2;
		this.background = background;
		this.gear = gear;
		this.equiped_ac = equiped_ac;
		this.personality = personality;
		this.ideals = ideals;
		this.bonds = bonds;
		this.flaws = flaws;
		this.appearance = appearance;
		this.allies = allies;
		this.backstory = backstory;
		this.tempdata = tempdata;
	}
	public Characters() {
		super();
	}
	
	
}
