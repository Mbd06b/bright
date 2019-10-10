package com.worscipe.bright.election.model;

import java.util.Date;

public interface Election {
	
	public Long getId();
	public void setId(Long id);
	
	public Long getPopulation();
	public void setPopulation(Long population);
	
	public String getElectionLink();
	public void setElectionLink(String string);

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
	
	public ElectionType getElectionType();
	public void setElectionType(ElectionType electionType); 
		
}
