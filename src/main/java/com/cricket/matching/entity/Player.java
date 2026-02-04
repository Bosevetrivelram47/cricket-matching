package com.cricket.matching.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "players")
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "player_name", nullable = false)
	private String playerName;
	
	@Column(name = "mobile_number", nullable = false, unique = true)
	private String mobileNumber;
	
	// for JPA to Hibernate reflection
	protected Player() { }

	public Player(String playerName, String mobileNumber) {
		this.playerName = playerName;
		this.mobileNumber = mobileNumber;
	}

	public Integer getId() {
		return id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	
}
