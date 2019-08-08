package com.worscipe.bright.elections.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.worscipe.bright.elections.model.CandidateImpl;
import com.worscipe.bright.elections.model.ElectionPhase;
import com.worscipe.bright.elections.model.rcv.RCVBallot;
import com.worscipe.bright.elections.model.rcv.RCVElectionImpl;
import com.worscipe.bright.elections.repository.rcv.RCVElectionRepository;

@Service
@Transactional
public class RCVElectionServiceImpl implements RCVElectionService{
		
	private static final Logger logger = LogManager.getLogger(RCVElectionServiceImpl.class);

	
	@Autowired
	RCVElectionRepository rcvElectionRepository;
	
	
	
	public RCVElectionImpl createElection(CandidateImpl ... candidates) {
		
		Set<CandidateImpl> candidateSet = new HashSet<>(Arrays.asList(candidates));
		
		RCVElectionImpl election = new RCVElectionImpl(candidateSet); 
	    	
		return rcvElectionRepository.save(election);
		
	}
	
	
	public RCVElectionImpl createElection(RCVElectionImpl election) {
		return rcvElectionRepository.save(election);
	}
	
	public RCVElectionImpl updateElection(RCVElectionImpl election) {
		return rcvElectionRepository.save(election);
	}
	
	
	@Override
	public Optional<RCVElectionImpl> getElectionById(Long id) {
		return rcvElectionRepository.findById(id);
	}
	
	@Override
	public Boolean deleteElection(RCVElectionImpl election) {
		
		if(existsById(election.getId())){
			rcvElectionRepository.delete(election);
			return true;
		}
		return false;
	}
	
	@Override
	public Boolean existsById(Long id) {
		Optional<RCVElectionImpl> election = getElectionById(id); 
	 return (Boolean) election.isPresent();
	}
	
	/**
	 *  rankElection(Election election) returns 
	 *  a winning bracket from winner to loser or sets the bracket to an error state.
	 *  
	 */
	@Override
	public RCVElectionImpl runElection(RCVElectionImpl election) {
		 
		List<CandidateImpl> sortedList = new ArrayList<>();
		
			
			//Retrieve variables for ranking
			List<RCVBallot> ballots = election.getBallots();
			List<CandidateImpl> candidates = new ArrayList<>(election.getCandidates()); 
			Integer round = 1; 
			Integer totalVotes = election.getBallots().size();
			Integer votesNeededToWin = (int) Math.floor(totalVotes / 2 + 1);
			boolean winner = false; 
			
			
			while(!winner) {
				
				//accumulate votes
				Multiset<CandidateImpl> votesThisRound = HashMultiset.create();
				for(RCVBallot ballot: ballots) {
					CandidateImpl ideaVotedFor = ballot.getCandidateVotedFor();
					
					// voter has the option to vote or not for any or all the candidates
					if(ideaVotedFor != null) {
						votesThisRound.add(ideaVotedFor);
					}
				}
				
				
				
				Long maxVotes = -1L;
				CandidateImpl topCandidate = null;
				Long minVotes = Long.MAX_VALUE;
				CandidateImpl lowCandidate = null;
				
				
				//log vote counts		
				for(CandidateImpl candidate: candidates) {
					
					if(candidate.isEliminated()){
						continue;
					}
					
					logger.info("\t" + candidate + " "+votesThisRound.count(candidate));
					
					if(votesThisRound.count(candidate) > maxVotes) {
						maxVotes = (long) votesThisRound.count(candidate);
						topCandidate = candidate;
					}
					
					if(votesThisRound.count(candidate) < minVotes){
						minVotes = (long) votesThisRound.count(candidate);
						lowCandidate = candidate;
					}
					
				}
				
				//check for winner
				if(topCandidate != null) {
					if(maxVotes >= votesNeededToWin){
						logger.info("***************  Winner Found! ***************");
						logger.info("*************** " + topCandidate.getCandidateResourceLink() + "***************");
						winner = true; 
						sortedList.add(topCandidate);
						topCandidate.setElectionVoteCount(maxVotes);
						election.setElectionPhase(ElectionPhase.FINAL);
						election.setStackRankRounds(round);
					}
				}
				else{
					logger.error("Error calculating votes - no top candidate found");
					election.setElectionPhase(ElectionPhase.ERROR);
					winner = false;
				} 

				//eliminate lowest ranked candidate
				if(lowCandidate != null) {
					lowCandidate.isEliminated(true);
					logger.info("Lowest vote candidate eliminated: " + lowCandidate + " with " + minVotes + " votes");
					lowCandidate.setElectionVoteCount(minVotes);
					sortedList.add(lowCandidate);					
				}
				else{
					
					logger.error("Error calculating votes - no lowest candidate found");
					election.setElectionPhase(ElectionPhase.ERROR);
					winner = false;
					
				}
				
				round++;
				
			}
				
		
		//since we add ideas to the end of sort list as they are eliminated, we just reverse the list to get the position.
		Collections.reverse(sortedList);	
		election.setRankedCandidates(sortedList);
		
		return rcvElectionRepository.save(election);
	}


	@Override
	public List<RCVElectionImpl> getAllElections() {
		return rcvElectionRepository.findAll(); 
	}


	@Override
	public Optional<RCVElectionImpl> getElection(Long id) {
		return rcvElectionRepository.findById(id);
	}


	@Override
	public Boolean deleteById(Long id) {
		rcvElectionRepository.deleteById(id);
		return null;
	}


}
