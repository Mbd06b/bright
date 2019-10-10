package com.worscipe.bright.election.model.rcv;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.worscipe.bright.election.model.AbstractBallot;
import com.worscipe.bright.election.model.Ballot;
import com.worscipe.bright.election.model.CandidateImpl;


@Entity
public class RCVBallot extends AbstractBallot<RCVElectionImpl> implements Ballot {	
	/**
	 * 
	 *		
					+-------------+-------------+-----------+--------------------------------------------------------------------------------------+
					| id          | timestamp   | voter     |                                      rankedCandidates                                     |
					+-------------+-------------+-----------+--------------------------------------------------------------------------------------+
		ballot-->	| [unique_id] | [timestamp] | [user_id] | (choice1) [unique_idea_id], (choice2) [unique_idea_id], (choice-n), [unique_idea_id] |
					+-------------+-------------+-----------+--------------------------------------------------------------------------------------+
					| ...         |             | ...       | ...                                                                                  |
					+-------------+-------------+-----------+--------------------------------------------------------------------------------------+
	 * 	
	 * 
	 * 
	 */
	
	@OneToMany
	private List<CandidateImpl> rankedCandidates = new ArrayList<>();

	

	public CandidateImpl getCandidateVotedFor() {
		for(CandidateImpl canididate: this.getCandidates()) {
			if(!canididate.isEliminated()){
				return canididate;
			}
		}
		return null;
	}
	
	
	public List<CandidateImpl> getRankedCandidates() {
		return rankedCandidates;
	}

    public void setRankedIdeas(List<CandidateImpl> rankedCandidates) {
    	this.rankedCandidates = rankedCandidates;
    }
    

	@Override
	public String getBallotLink() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setBallotLink(String ballotLink) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCandidates(Set<CandidateImpl> candidates) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Set<CandidateImpl> getCandidates(){
		// TODO Auto-generated method stub
		return null;
	}
	
}
