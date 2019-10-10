package com.worscipe.bright.election.model.reaction;

import java.util.Set;

import javax.persistence.OneToMany;

import com.worscipe.bright.election.model.AbstractBallot;
import com.worscipe.bright.election.model.Ballot;
import com.worscipe.bright.election.model.CandidateImpl;

public class ReactionBallot  extends AbstractBallot<ReactionElectionImpl> implements Ballot {
	
	
	@OneToMany
	private Set<Reaction> reactions;

	public Set<Reaction> getReactions() {
		return reactions;
	}

	public void setReactions(Set<Reaction> reactions) {
		this.reactions = reactions;
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
	public Set<CandidateImpl> getCandidates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCandidates(Set<CandidateImpl> candidates) {
		// TODO Auto-generated method stub
		
	} 
	
}
