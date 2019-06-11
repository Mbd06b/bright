package com.worscipe.bright.elections.model.rcv;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.worscipe.bright.elections.model.AbstractBallot;
import com.worscipe.bright.elections.model.AbstractElection;
import com.worscipe.bright.elections.model.Ballot;
import com.worscipe.bright.elections.model.CandidateImpl;


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

	@ManyToOne
	private RCVElectionImpl rcvElection; 
		

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
	public RCVElectionImpl getElection() {
		return rcvElection;
	}

	@Override
	public void setElection(RCVElectionImpl rcvElection) {
		this.rcvElection = rcvElection;
	}
	
}
