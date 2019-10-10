package com.worscipe.bright.election.service;

import java.util.Optional;

import com.worscipe.bright.election.model.rcv.RCVElectionImpl;

public interface RCVElectionService extends ElectionService{

	

	RCVElectionImpl createElection(RCVElectionImpl election);
	
	RCVElectionImpl updateElection(RCVElectionImpl election);
	
	RCVElectionImpl runElection(RCVElectionImpl election);
	
	Boolean deleteElection(RCVElectionImpl election);
	
	Boolean existsById(Long id);

	Optional<RCVElectionImpl> getElectionById(Long id);
	
	
	
	
	

}
