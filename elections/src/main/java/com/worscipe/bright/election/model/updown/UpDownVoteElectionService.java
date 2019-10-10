package com.worscipe.bright.election.model.updown;

import java.util.Optional;

import com.worscipe.bright.election.service.ElectionService;

public interface UpDownVoteElectionService extends ElectionService {

	UpDownVoteElectionImpl createElection(UpDownVoteElectionImpl election);
	
	UpDownVoteElectionImpl updateElection(UpDownVoteElectionImpl election);
	
	UpDownVoteElectionImpl runElection(UpDownVoteElectionImpl election);
	
	Boolean deleteElection(UpDownVoteElectionImpl election);
	
	Boolean existsById(Long id);

	Optional<UpDownVoteElectionImpl> getElectionById(Long id);
}
