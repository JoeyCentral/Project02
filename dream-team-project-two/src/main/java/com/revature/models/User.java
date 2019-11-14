package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	@Column(nullable = false, length = 25, unique = true)
	private String username;

	private String hashpass;

	private int salt;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int id, String username, String hashpass, int salt) {
		super();
		this.id = id;
		this.username = username;
		this.hashpass = hashpass;
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", hashpass=" + hashpass + ", salt=" + salt + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHashpass() {
		return hashpass;
	}

	public void setHashpass(String hashpass) {
		this.hashpass = hashpass;
	}

	public int getSalt() {
		return salt;
	}

	public void setSalt(int salt) {
		this.salt = salt;
	}


}
