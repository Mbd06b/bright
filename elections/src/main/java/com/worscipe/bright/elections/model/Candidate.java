package com.worscipe.bright.elections.model;

// a generic allows any object to be a candidate, 
// with added properties and methods to facilitate an election service

public interface Candidate{

	
	public String getCandidateLink();
	
	public void setCandidateLink(String candidateLink);
	
	public void setElectionVoteCount(Long num);
	
	public Long getElectionVoteCount(Long num);
	
	public void isEliminated(Boolean isEliminated);
	
	public Boolean isEliminated();
	
}
