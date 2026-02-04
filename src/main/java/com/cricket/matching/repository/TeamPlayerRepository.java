package com.cricket.matching.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cricket.matching.entity.TeamPlayer;

public interface TeamPlayerRepository extends JpaRepository<TeamPlayer, Integer>{

}
