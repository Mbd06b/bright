package com.worscipe.bright.elections.service;

import java.util.List;

public interface BallotService {
	
	<B> B getBallot(Long electionId, Long ballotId);
	
	<B> List<B> getBallots(Long electionId); 
	
	<B> B castBallot(B ballot);
	
	<B> B updateBallot(B ballot);
	
	boolean deleteBallot(Long electionId, Long ballotId);
	

}
