package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name= "my_characters")
public class Characters {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "char_id")
	private int id;
	
	@Value("")
	private String character_name;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users player;
	
	@Value("")
	private String playername;
	
    @OneToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
	
    @OneToOne
    @JoinColumn(name = "info_id")
    private Info info;
    
    @OneToOne
    @JoinColumn(name = "spellList_id")
    private SpellList spellList;
	
	public String getCharacter_name() {
		return character_name;
	}
	public void setCharacter_name(String character_name) {
		this.character_name = character_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Users getPlayer() {
		return player;
	}
	public void setPlayer(Users player) {
		this.player = player;
	}
	public String getPlayername() {
		return playername;
	}
	public void setPlayername(String playername) {
		this.playername = playername;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((character_name == null) ? 0 : character_name.hashCode());
		result = prime * result + id;
		result = prime * result + ((info == null) ? 0 : info.hashCode());
		result = prime * result + ((player == null) ? 0 : player.hashCode());
		result = prime * result + ((playername == null) ? 0 : playername.hashCode());
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
		result = prime * result + ((spellList == null) ? 0 : spellList.hashCode());
		return result;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	public SpellList getSpellList() {
		return spellList;
	}
	public void setSpellList(SpellList spellList) {
		this.spellList = spellList;
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
		if (character_name == null) {
			if (other.character_name != null)
				return false;
		} else if (!character_name.equals(other.character_name))
			return false;
		if (id != other.id)
			return false;
		if (info == null) {
			if (other.info != null)
				return false;
		} else if (!info.equals(other.info))
			return false;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		if (playername == null) {
			if (other.playername != null)
				return false;
		} else if (!playername.equals(other.playername))
			return false;
		if (profile == null) {
			if (other.profile != null)
				return false;
		} else if (!profile.equals(other.profile))
			return false;
		if (spellList == null) {
			if (other.spellList != null)
				return false;
		} else if (!spellList.equals(other.spellList))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Characters [id=" + id + ", character_name=" + character_name + ", player=" + player + ", playername="
				+ playername + ", profile=" + profile + ", info=" + info + ", spellList=" + spellList + "]";
	}

	public Characters(int id, String character_name, Users player, String playername, Profile profile, Info info,
			SpellList spellList) {
		super();
		this.id = id;
		this.character_name = character_name;
		this.player = player;
		this.playername = playername;
		this.profile = profile;
		this.info = info;
		this.spellList = spellList;
	}
	public Characters() {
		super();
	}

}
