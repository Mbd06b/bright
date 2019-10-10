package com.worscipe.bright.election.model.rcv;

import java.util.List;

import com.worscipe.bright.election.model.CandidateImpl;
import com.worscipe.bright.election.model.Election;

/**
 * 
 * @author matthew.b.dowell

 */
public interface RCVElection extends Election{
	
	public Integer getStackRankRounds();

	public void setStackRankRounds(Integer stackRankRounds);
	
	List<CandidateImpl> getRankedCandidates();
	
	void setRankedCandidates(List<CandidateImpl> rankedCandidates);
}
