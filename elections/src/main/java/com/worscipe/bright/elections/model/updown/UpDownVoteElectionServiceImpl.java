package com.worscipe.bright.elections.model.updown;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worscipe.bright.elections.repository.updown.UpDownVoteBallotRepository;
import com.worscipe.bright.elections.repository.updown.UpDownVoteElectionRepository;

@Service
public class UpDownVoteElectionServiceImpl {
	
	@Autowired
	private UpDownVoteElectionRepository upDownVoteElectionRepository;
	
	@Autowired
	private UpDownVoteBallotRepository upDownBallotRepository;
	
	
	public List<UpDownVoteElection> getAllElections(){
		List<UpDownVoteElection> elections = upDownVoteElectionRepository.findAll();
		return elections; 
	}
	
	
	  public List<UpDownVoteBallot> getAllBallots(){
		    List<UpDownVoteBallot> ballots = upDownBallotRepository.findAll();
		  return ballots;
	  };
	  
	  
	
	
}
