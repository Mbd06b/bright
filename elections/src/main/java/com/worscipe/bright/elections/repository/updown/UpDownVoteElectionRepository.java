package com.worscipe.bright.elections.repository.updown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.worscipe.bright.elections.model.updown.UpDownVoteElection;

@Repository
public interface UpDownVoteElectionRepository extends JpaRepository<UpDownVoteElection,Long> {

}
