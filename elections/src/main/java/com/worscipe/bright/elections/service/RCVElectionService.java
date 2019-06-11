package com.worscipe.bright.elections.service;

import java.util.Optional;

import com.worscipe.bright.elections.model.rcv.RCVElectionImpl;

public interface RCVElectionService {

	

	RCVElectionImpl createElection(RCVElectionImpl election);
	
	RCVElectionImpl updateElection(RCVElectionImpl election);
	
	RCVElectionImpl runElection(RCVElectionImpl election);
	
	Boolean deleteElection(RCVElectionImpl election);
	
	Boolean existsById(Long id);

	Optional<RCVElectionImpl> getElectionById(Long id);
	
	
	
	
	

}
