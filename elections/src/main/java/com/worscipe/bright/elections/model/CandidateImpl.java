package com.worscipe.bright.elections.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CandidateImpl implements Candidate {
	
	@Id
	private Long id;
	
	/**
	 *  candidateLink references the resource on which the election is being performed
	 */
	@Column
	private String candidateLink;
	
	@Column
	private Boolean isEliminated;
	
	@Column
	private Integer roundEliminated;
	
	@Column
	private Long electionVoteCount;
	
	
	@Column
	private Integer favoritedTotal; 
	
	@Column
	private Integer urgentVotes;
	
	@Column
	private Integer notUrgentVotes;
	
	@Column
	private Integer importantVotes;
	
	@Column
	private Integer notImportantVotes;
	
	public CandidateImpl(){}
	
	public CandidateImpl(String candidateLink){
		this.candidateLink = candidateLink;
	}
		
	public void setId (Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getCandidateLink() {
		return candidateLink;
	}
	
	public void setCandidateLink(String candidateLink) {
		this.candidateLink = candidateLink;
	}
	
	
	public void setElectionVoteCount(Long num) {
	  this.electionVoteCount = num;
	}
	
	public Long getElectionVoteCount(Long num) {
		return electionVoteCount;
	}
	
	public void isEliminated(Boolean isEliminated) {
		this.isEliminated = isEliminated;
	}
	
	public Boolean isEliminated() {
		return isEliminated;
	}

	public Integer getRoundEliminated() {
		return roundEliminated;
	}

	public void setRoundEliminated(Integer roundEliminated) {
		this.roundEliminated = roundEliminated;
	}



	
	
}
