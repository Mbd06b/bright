package com.worscipe.bright.elections.model.rcv;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.worscipe.bright.elections.model.AbstractElection;
import com.worscipe.bright.elections.model.CandidateImpl;
import com.worscipe.bright.elections.model.ElectionType;

/**
 * 
 * @author matthew.b.dowell
 *
 */
@Entity
public class RCVElectionImpl extends AbstractElection<RCVBallot> implements RCVElection {
	
    @OneToMany
	private List<CandidateImpl> rankedCandidates;
	
    @Column
	private Integer stackRankRounds;
	
	public RCVElectionImpl() { 
		super();
		this.setElectionType(ElectionType.SINGLE_TRANSFERABLE_VOTE);
	}
	
	public RCVElectionImpl(Set<CandidateImpl> candidates) {
		super(candidates);
		this.rankedCandidates = new ArrayList<>(candidates);
		this.setElectionType(ElectionType.SINGLE_TRANSFERABLE_VOTE);
	}
	
	
	public Integer getStackRankRounds() {
	  return stackRankRounds;
	}
	
	public void setStackRankRounds(Integer stackRankRounds) {
	   this.stackRankRounds = stackRankRounds;
	}

	@Override
	public List<RCVBallot> getBallots() {
		return getBallots();
	}

	@Override
	public void setBallots(List<RCVBallot> ballots) {
	      this.setBallots(ballots);
	}

	public List<CandidateImpl> getRankedCandidates() {
		return rankedCandidates;
	}

	public void setRankedCandidates(List<CandidateImpl> rankedCandidates) {
		this.rankedCandidates = rankedCandidates;
	}



}
