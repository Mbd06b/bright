package com.worscipe.bright.elections.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BallotServiceImpl implements BallotService {

	@Override
	public <B> B getBallot(Long electionId, Long ballotId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <B> List<B> getBallots(Long electionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <B> B castBallot(B ballot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <B> B updateBallot(B ballot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteBallot(Long electionId, Long ballotId) {
		// TODO Auto-generated method stub
		return false;
	}

}
