package com.worscipe.bright.elections.model.rcv;

import java.util.List;

import com.worscipe.bright.elections.model.CandidateImpl;
import com.worscipe.bright.elections.model.Election;

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
