package com.worscipe.bright.ideas.model.idea;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.worscipe.bright.ideas.model.user.User;

@Entity(name="IDEA_AUDIT_TABLE")
public class IdeaAudit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="IDEA_AUDIT_ID", updatable = false, nullable = true)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="IDEA_ID")
	private IdeaImpl ideaImpl; 
	
	@OneToOne
	private User user; 
	
	@Enumerated(EnumType.STRING) 
	@Column(name="ACTION")
	private IdeaAction ideaAction;


	@Column(name="CREATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn = new Date();


	public IdeaAudit() {
		super(); 
	} 
	
	public IdeaAudit(User actingUser, IdeaAction action) {
		this.user = actingUser;
		this.ideaAction = action; 
	}
	
	
	public Date getCreatedOn() {
		return createdOn;
	}
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id; 
	}

	public IdeaImpl getIdea() {
		return this.ideaImpl;
	}


	public IdeaAction getIdeaAction() {
		return ideaAction;
	}


	public User getUser() {
		return user;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}



	public void setIdea(IdeaImpl ideaImpl) {
		this.ideaImpl = ideaImpl;
	}


	public void setIdeaAction(IdeaAction ideaAction) {
		this.ideaAction = ideaAction;
	}
	
	public void setUser(User user) {
		this.user = user;
	}



}
