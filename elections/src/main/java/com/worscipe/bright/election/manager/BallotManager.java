package com.worscipe.bright.election.manager;

import java.util.List;

import com.worscipe.bright.election.model.Ballot;
import com.worscipe.bright.election.view.BallotView;
import com.worscipe.bright.election.view.ResultPage;

public interface BallotManager {


	List<BallotView> getAllBallots(Long electionId);

	BallotView getBallotById(Long electionId, Long id);

	ResultPage<BallotView> getBallotsPagedByCandidate(String candidateId, Integer pageNumber, Integer limit);

	BallotView castBallot(Long electionId, Ballot ballot);

	Boolean deleteBallot(Long electionId, Long id);

	BallotView updateBallot(Long id, Ballot ballot);

}
