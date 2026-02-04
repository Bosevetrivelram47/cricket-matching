package com.cricket.matching.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "team_players")
public class TeamPlayer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id", nullable = false)
	private Team team;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "player_id", nullable = false)
	private Player player;
	
	// for JPA to Hibernate reflection
	protected TeamPlayer() { }
	
	public TeamPlayer(Team team, Player player) {
		this.team = team;
		this.player = player;
	}

	public Integer getId() {
		return id;
	}
	
	public Team getTeam() {
		return team;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	// hashCode() and equals() must be worked together not independently
	// hashCode() is used first to determine the bucket
	// equals() is used next to check actual object equality
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof TeamPlayer)) return false;
		TeamPlayer that = (TeamPlayer) o;
		return team.equals(that.team) && player.equals(that.player);
	}
	
	// Returns hash value
	// Used by HashSet / HashMap to efficiently locate objects
	@Override
	public int hashCode() {
		return Objects.hash(team, player);
	}
	
}
