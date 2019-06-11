package com.worscipe.bright.elections.model.updown;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.worscipe.bright.elections.model.AbstractElection;

@Entity
public class UpDownElection extends AbstractElection<UpDownBallot> {
	
	@Id
	private Long id;
	
	@Column
	private Long upVoteCount;
	
	@Column
	private Long downVoteCount;
	
	@OneToMany
	private List<UpDownBallot> ballots;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUpVoteCount() {
		return upVoteCount;
	}

	public void setUpVoteCount(Long upVoteCount) {
		this.upVoteCount = upVoteCount;
	}

	public Long getDownVoteCount() {
		return downVoteCount;
	}
	
	public void setDownVoteCount(Long downVoteCount) {
		this.downVoteCount = downVoteCount;
	}

	public List<UpDownBallot> getBallots() {
		return ballots;
	}

	public void setBallots(List<UpDownBallot> ballots) {
		this.ballots = ballots;
	}

	
	
}
