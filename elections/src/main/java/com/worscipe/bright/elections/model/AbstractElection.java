package com.worscipe.bright.elections.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * 
 * @author matthew.b.dowell
 */

@MappedSuperclass
public abstract class AbstractElection<B extends AbstractBallot> {
	
	@Id
    private Long id; 
    
	@OneToMany
    private Set<CandidateImpl> candidates; 
	
	@Transient
	private List<B> ballots;
    
	@Column
    private Long population; 
	
	@Column
    private Long numBallotsCast;
	
	@Column
    private Date createdDate;
	
	@Column
    private Date startDate;
	
	@Column
    private Date duration;
    
	@Enumerated(EnumType.STRING)
    private ElectionPhase electionPhase;   
    
    public AbstractElection() { super(); }
    
    public AbstractElection(Set<CandidateImpl> candidates) {
    	this.candidates = candidates;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id; 
	}
	
	public Long getPopulation() {
		return population;
	}
	public void setPopulation(Long population) {
		this.population = population;
	}

	public Long getNumBallotsCast() {
		return numBallotsCast;
	}
	public void setNumBallotsCast(Long numBallotsCast) {
		this.numBallotsCast = numBallotsCast;
	}

	public Date getCreatedDate() {
	  return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate){
		this.startDate = startDate;
	}
	public Date getDuration() {
		return duration;
	}
	public void setDuration(Date duration) {
		this.duration = duration; 
	}

	public ElectionPhase getElectionPhase() {
		return electionPhase;
	}
	public void setElectionPhase(ElectionPhase electionPhase) {
		this.electionPhase = electionPhase;
	}
	
	public Set<CandidateImpl> getCandidates(){
		return candidates;
	}
	
	public void setCandidates(Set<CandidateImpl> candidates) {
		this.candidates = candidates;
	}
	
	
	public void addCandidate(CandidateImpl candidate) {
		this.candidates.add(candidate);
	}
	
	public  List<B> getBallots(){
	  return ballots;
	}
	
	public  void setBallots(List<B> ballots) {
		this.ballots = ballots;
	}
	
}
