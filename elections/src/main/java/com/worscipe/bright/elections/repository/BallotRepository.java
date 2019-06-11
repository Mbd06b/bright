package com.worscipe.bright.elections.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.worscipe.bright.elections.model.Ballot;

@NoRepositoryBean
public interface BallotRepository extends JpaRepository<Ballot, Long> {

}
