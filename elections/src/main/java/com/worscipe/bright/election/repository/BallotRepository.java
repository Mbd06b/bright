package com.worscipe.bright.election.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.worscipe.bright.election.model.Ballot;

@NoRepositoryBean
public interface BallotRepository extends JpaRepository<Ballot, Long> {

}
