package com.worscipe.bright.election.view;

import java.util.Date;
import java.util.Set;

import com.worscipe.bright.election.model.Election;
import com.worscipe.bright.election.model.ElectionPhase;
import com.worscipe.bright.election.model.ElectionType;

/** 
 * Election view should contain properties common to all elections
 * @author matthew.b.dowell
 *
 */
public class ElectionView implements Election {
	
	private Long id;
	private Long population;
	private Long numBallotsCast;
	private Date createdDate;
	private Date startDate;
	private Date duration;
	private Set<String> candidates;
	private ElectionPhase electionPhase;
	private ElectionType electionType;
	private String electionLink; 
	
	

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getPopulation() {
		return population;
	}

	@Override
	public void setPopulation(Long population) {
		this.population = population;
	}

	@Override
	public Long getNumBallotsCast() {
		return numBallotsCast;
	}

	@Override
	public void setNumBallotsCast(Long numBallotsCast) {
		this.numBallotsCast = numBallotsCast;
		
	}

	@Override
	public Date getCreatedDate() {
		return createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public Date getStartDate() {
		return startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public Date getDuration() {
		return duration;
	}

	@Override
	public void setDuration(Date duration) {
		this.duration = duration;
	}

	@Override
	public ElectionPhase getElectionPhase() {
		return electionPhase;
	}

	@Override
	public void setElectionPhase(ElectionPhase electionPhase) {
		this.electionPhase = electionPhase;
	}

	public Set<String> getCandidates() {
		return candidates;
	}

	public void setCandidates(Set<String> candidates) {
		this.candidates = candidates;
	}

	public ElectionType getElectionType() {
		return electionType;
	}

	public void setElectionType(ElectionType electionType) {
		this.electionType = electionType;
	}

	@Override
	public String getElectionLink() {
		return electionLink;
	}

	@Override
	public void setElectionLink(String electionLink) {
		this.electionLink = electionLink;
	}

}
