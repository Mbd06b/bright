package com.worscipe.bright.election.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worscipe.bright.election.model.Ballot;
import com.worscipe.bright.election.service.BallotService;
import com.worscipe.bright.election.view.BallotView;
import com.worscipe.bright.election.view.ResultPage;

@Service
public class BallotManagerImpl implements BallotManager {
	
	@Autowired
	private BallotService ballotService;
	

	@Override
	public List<BallotView> getAllBallots(Long electionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BallotView getBallotById(Long electionId, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultPage<BallotView> getBallotsPagedByCandidate(String candidateId, Integer pageNumber, Integer limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BallotView castBallot(Long electionId, Ballot ballot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteBallot(Long electionId, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BallotView updateBallot(Long id, Ballot ballot) {
		// TODO Auto-generated method stub
		return null;
	}

}
