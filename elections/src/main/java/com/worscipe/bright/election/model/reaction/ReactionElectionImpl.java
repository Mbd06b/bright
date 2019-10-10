package com.worscipe.bright.election.model.reaction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.worscipe.bright.election.model.AbstractElection;

@Entity
public class ReactionElectionImpl extends AbstractElection<ReactionBallot> implements ReactionElection {
	
	@Id
	private Long id;

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

	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Integer getFavoritedTotal() {
		return favoritedTotal;
	}

	public void setFavoritedTotal(Integer favoritedTotal) {
		this.favoritedTotal = favoritedTotal;
	}

	public Integer getUrgentVotes() {
		return urgentVotes;
	}

	public void setUrgentVotes(Integer urgentVotes) {
		this.urgentVotes = urgentVotes;
	}

	public Integer getNotUrgentVotes() {
		return notUrgentVotes;
	}

	public void setNotUrgentVotes(Integer notUrgentVotes) {
		this.notUrgentVotes = notUrgentVotes;
	}

	public Integer getImportantVotes() {
		return importantVotes;
	}

	public void setImportantVotes(Integer importantVotes) {
		this.importantVotes = importantVotes;
	}

	public Integer getNotImportantVotes() {
		return notImportantVotes;
	}

	public void setNotImportantVotes(Integer notImportantVotes) {
		this.notImportantVotes = notImportantVotes;
	}
}
