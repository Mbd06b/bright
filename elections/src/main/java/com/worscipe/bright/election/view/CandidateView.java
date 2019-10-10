package com.worscipe.bright.election.view;

import com.worscipe.bright.election.model.Candidate;

public class CandidateView implements Candidate {
	
	private String candidateResourceLink;
	private Long electionVoteCount;
	private Boolean isEliminated;

	@Override
	public void setCandidateResourceLink(String candidateResourceLink) {
		this.candidateResourceLink = candidateResourceLink;	
	}

	@Override
	public String getCandidateResourceLink() {
		return candidateResourceLink;
	}

	@Override
	public void setElectionVoteCount(Long electionVoteCount) {
		this.electionVoteCount = electionVoteCount;
	}

	@Override
	public Long getElectionVoteCount(Long num) {
		return electionVoteCount; 
	}

	@Override
	public void isEliminated(Boolean isEliminated) {
		this.isEliminated = isEliminated;
	}

	@Override
	public Boolean isEliminated() {
		return isEliminated;
	}

}
