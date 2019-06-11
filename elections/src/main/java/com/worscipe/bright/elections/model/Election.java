package com.worscipe.bright.elections.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface Election {
	
	public Long getId();

	public void setId(Long id);
	
	public Long getPopulation();
	public void setPopulation(Long population);

	public Long getNumBallotsCast();
	public void setNumBallotsCast(Long numBallotsCast);

	public Date getCreatedDate();
	public void setCreatedDate(Date createdDate);

	public Date getStartDate();
	public void setStartDate(Date startDate);
	
	public Date getDuration();
	public void setDuration(Date duration);

	public ElectionPhase getElectionPhase();
	public void setElectionPhase(ElectionPhase electionPhase);
	
	public Set<CandidateImpl> getCandidates();
	public void setCandidates(Set<CandidateImpl> candidates); 
	
	public void addCandidate(CandidateImpl candidate);

}
