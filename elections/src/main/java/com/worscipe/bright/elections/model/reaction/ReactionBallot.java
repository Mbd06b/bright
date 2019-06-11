package com.worscipe.bright.elections.model.reaction;

import java.util.Set;

import javax.persistence.OneToMany;

import com.worscipe.bright.elections.model.AbstractBallot;
import com.worscipe.bright.elections.model.Ballot;

public class ReactionBallot  extends AbstractBallot<ReactionElectionImpl> implements Ballot {
	
	
	@OneToMany
	private Set<Reaction> reactions;

	public Set<Reaction> getReactions() {
		return reactions;
	}

	public void setReactions(Set<Reaction> reactions) {
		this.reactions = reactions;
	} 
	
}
