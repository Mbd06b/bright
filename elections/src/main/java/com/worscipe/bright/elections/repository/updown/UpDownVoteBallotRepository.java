package com.worscipe.bright.elections.repository.updown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.worscipe.bright.elections.model.updown.UpDownVoteBallot;

@Repository
public interface UpDownVoteBallotRepository extends JpaRepository<UpDownVoteBallot, Long>{

}
