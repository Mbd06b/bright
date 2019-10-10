package com.worscipe.bright.election.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.worscipe.bright.election.view.RestResourceEntity;

@Entity
public class CandidateImpl implements Candidate {
	
	@Id
	private Long id;
	
	/**
	 *  candidateLink references the resource on which the election is being performed
	 */
	@Column private String candidateResourceUrl;
	
	@Column private Long candidateResourceId;
	
	@Column private String candidateResourceLink;
	
	
	/**
	 *  Used in RCV elections
	 */
	
	@Column private Boolean isEliminated;

	@Column private Integer roundEliminated;
	
	@Column private Long electionVoteCount;
	
	@Column private Integer favoritedTotal; 
	
	@Column private Integer urgentVotes;
	
	@Column private Integer notUrgentVotes;
	
	@Column private Integer importantVotes;
	
	@Column private Integer notImportantVotes;

	
	public CandidateImpl(){}
	
	public CandidateImpl(RestResourceEntity entity){
		this.candidateResourceUrl = entity.getCandidateResourceUrl();
		this.candidateResourceId = entity.getCandidateResourceId();
		this.candidateResourceLink = this.candidateResourceLink + entity.getCandidateResourceId();
	}
		
	public void setId (Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getCandidateResourceLink() {
		return candidateResourceLink;
	}
	 	
	public String getCandidateResourceUrl() {
		return candidateResourceUrl;
	}
	
	public void setCandidateResourceUrl(String candidateResourceUrl) {
		this.candidateResourceUrl = candidateResourceUrl;
	}
	
	public Long getCandidateResourceId() {
		return candidateResourceId;
	}
	
	public void setCandidateResourceId(Long candidateResourceId) {
		this.candidateResourceId = candidateResourceId;
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

	@Override
	public void setCandidateResourceLink(String candidateResourceLink) {
		this.candidateResourceLink = candidateResourceLink;
		
	}



	
	
}
