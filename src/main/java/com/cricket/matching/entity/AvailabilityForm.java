package com.cricket.matching.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "availability_form")
public class AvailabilityForm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id", nullable = false)
	private Team team;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "submitted_by", nullable = false)
	private Player submittedBy;
	
	@Column(nullable = false)
	private String location;
	
	@Column(name = "available_date", nullable = false)
	private LocalDate availableDate;
	
	@Column(name = "available_time", nullable = false)
	private LocalTime availableTime;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private AvailabilityStatus status;
	
	@Column(name = "created_at", insertable = false, updatable = false)
	private LocalDateTime createdAt;
	
	protected AvailabilityForm() { }

	public AvailabilityForm(Team team, Player submittedBy, String location, LocalDate availableDate, LocalTime availableTime, AvailabilityStatus status) {
		this.team = team;
		this.submittedBy = submittedBy;
		this.location = location;
		this.availableDate = availableDate;
		this.availableTime = availableTime;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public Team getTeam() {
		return team;
	}

	public Player getSubmittedBy() {
		return submittedBy;
	}

	public String getLocation() {
		return location;
	}

	public LocalDate getAvailableDate() {
		return availableDate;
	}

	public LocalTime getAvailableTime() {
		return availableTime;
	}


	public AvailabilityStatus getStatus() {
		return status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
}
