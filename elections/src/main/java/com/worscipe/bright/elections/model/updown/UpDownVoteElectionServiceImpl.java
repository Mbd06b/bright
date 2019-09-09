package com.worscipe.bright.elections.model.updown;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worscipe.bright.elections.repository.updown.UpDownVoteBallotRepository;
import com.worscipe.bright.elections.repository.updown.UpDownVoteElectionRepository;

@Service
public class UpDownVoteElectionServiceImpl implements UpDownVoteElectionService{
	
	@Autowired
	private UpDownVoteElectionRepository upDownVoteElectionRepository;
	
	@Autowired
	private UpDownVoteBallotRepository upDownBallotRepository;
	
	
	public List<UpDownVoteElectionImpl> getAllElections(){
		List<UpDownVoteElectionImpl> elections = upDownVoteElectionRepository.findAll();
		return elections; 
	}
	
	
	  public List<UpDownVoteBallot> getAllBallots(){
		    List<UpDownVoteBallot> ballots = upDownBallotRepository.findAll();
		  return ballots;
	  }


	@Override
	public Optional<?> getElection(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UpDownVoteElectionImpl createElection(UpDownVoteElectionImpl election) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UpDownVoteElectionImpl updateElection(UpDownVoteElectionImpl election) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UpDownVoteElectionImpl runElection(UpDownVoteElectionImpl election) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Boolean deleteElection(UpDownVoteElectionImpl election) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Optional<UpDownVoteElectionImpl> getElectionById(Long id) {
		// TODO Auto-generated method stub
		return null;
	};
	  
	  
	
	
}
