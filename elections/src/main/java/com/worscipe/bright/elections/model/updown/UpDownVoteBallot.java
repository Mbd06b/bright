package com.worscipe.bright.elections.model.updown;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.worscipe.bright.elections.model.AbstractBallot;

@Entity
public class UpDownVoteBallot extends AbstractBallot<UpDownVoteElectionImpl> {
	
	public enum BallotSelection {NULL_VOTE, UP_VOTE, DOWN_VOTE};
	
	@Enumerated(EnumType.STRING)
	private BallotSelection ballotSelection;
	
    public BallotSelection getBallotSelection () {
		return this.ballotSelection;
	} 
    
    public void setBallotSelection(BallotSelection ballotSelection) {
    	this.ballotSelection = ballotSelection;
	}
    
}
	
	

