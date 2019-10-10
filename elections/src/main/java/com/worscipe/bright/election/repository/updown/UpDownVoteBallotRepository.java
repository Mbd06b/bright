package com.worscipe.bright.election.repository.updown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.worscipe.bright.election.model.updown.UpDownVoteBallot;

@Repository
public interface UpDownVoteBallotRepository extends JpaRepository<UpDownVoteBallot, Long>{

}
