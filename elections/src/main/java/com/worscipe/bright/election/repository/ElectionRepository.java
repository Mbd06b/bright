package com.worscipe.bright.election.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.worscipe.bright.election.model.Election;

@NoRepositoryBean
public interface ElectionRepository extends JpaRepository<Election,Long> {

}
