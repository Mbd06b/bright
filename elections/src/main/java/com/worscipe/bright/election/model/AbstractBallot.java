package com.worscipe.bright.election.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

/**
 * 
 * @author matthew.b.dowell
 * 
 */

@MappedSuperclass
public abstract class AbstractBallot<E extends AbstractElection<?>>{
	
	   @Id
	   private Long id;
	   	   
	   @Column
	   private String voterLink;
	   
	   @ManyToOne
	   private E election; 
	   
	   @OneToMany
	   private Set<CandidateImpl> candidates;
	   
	   @Column
	   private Date dateSubmittedOn;
	 
	   public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public E getElection() {
			return this.election;
		}
		
		public void setElection(E election) {
			this.election = election; 
		}
				
		public String getVoterLink() {
			return voterLink;
		}

		public void setVoterLink(String voterLink) {
			this.voterLink = voterLink;
		}

		public Set<CandidateImpl> getCandidates() {
			return candidates;
		}

		public void setCandidates(Set<CandidateImpl> candidates) {
			this.candidates = candidates;
		}

		public Date getDateSubmittedOn() {
			return dateSubmittedOn;
		}

		public void setDateSubmittedOn(Date dateSubmittedOn) {
			this.dateSubmittedOn = dateSubmittedOn;
		}

	    
	
	
}
