package com.worscipe.bright.elections.model;

import java.util.Date;
import java.util.Set;

public interface Ballot {
	
	public Long getId();
	public void setId(Long id);
	
	public String getVoterLink();
	public void setVoterLink(String voterLink);
	
	public String getBallotLink();
	public void setBallotLink(String ballotLink);

	public Set<CandidateImpl> getCandidates();
	public void setCandidates(Set<CandidateImpl> candidates);

	public Date getDateSubmittedOn();
	public void setDateSubmittedOn(Date dateSubmittedOn);

}
