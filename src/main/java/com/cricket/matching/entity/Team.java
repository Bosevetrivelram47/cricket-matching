package com.cricket.matching.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "teams")
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "team_name", nullable = false)
	private String teamName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "captain_id", nullable = false)
	private Player captain;
	
	// for JPA to Hibernate reflection
	protected Team() { }
	
	public Team(String teamName, Player captain) {
		this.teamName = teamName;
		this.captain = captain;
	}

	public Integer getId() {
		return id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Player getCaptain() {
		return captain;
	}

	public void setCaptain(Player captain) {
		this.captain = captain;
	}
	
}
