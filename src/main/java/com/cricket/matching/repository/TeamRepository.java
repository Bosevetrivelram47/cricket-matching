package com.cricket.matching.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cricket.matching.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Integer>{

}
