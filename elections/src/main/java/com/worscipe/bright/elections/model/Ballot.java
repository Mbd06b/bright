package com.worscipe.bright.elections.model;

import java.util.Date;
import java.util.List;

public interface Ballot {
	
	 public Long getId();

		public void setId(Long id);
		
		public String getVoterLink();
		public void setVoterLink(String voterLink);

		public List<CandidateImpl> getCandidates();
		public void setCandidates(List<CandidateImpl> candidates);

		public Date getDateSubmittedOn();
		public void setDateSubmittedOn(Date dateSubmittedOn);

}
