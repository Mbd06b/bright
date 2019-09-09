package com.worscipe.bright.elections.model.rcv;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.worscipe.bright.elections.model.AbstractElection;
import com.worscipe.bright.elections.model.CandidateImpl;

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
	}
	
	public RCVElectionImpl(Set<CandidateImpl> candidates) {
		super(candidates);
		this.rankedCandidates = new ArrayList<>(candidates);
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

	@Override
	public String getElectionLink() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setElectionLink(String string) {
		// TODO Auto-generated method stub
		
	}



}
