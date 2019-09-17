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
<<<<<<< HEAD
=======
import javax.persistence.OneToOne;
>>>>>>> refs/remotes/origin/master
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.domain.Auditable;

@Entity(name="IDEA_AUDIT_TABLE")
public class IdeaAudit{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="IDEA_AUDIT_ID", updatable = false, nullable = true)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="IDEA_ID")
	private IdeaImpl ideaImpl; 
	
	// the id of the entity interacting with the idea (either an internal or external microservice)
	@Column(name="ENTITY_ID") 
	private Long entityId; 
	
	// entity link is whatever is interacting with the idea (an election, a user comment, ecetera..) 
	@Column(name="ENTITY_TYPE")
	private String entityType; 
	
	@Enumerated(EnumType.STRING) 
	@Column(name="ACTION")
	private IdeaAction ideaAction;


	@Column(name="CREATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn = new Date();


	public IdeaAudit() {
		super(); 
	} 
	
	public IdeaAudit(Long entityId, String entityType, IdeaAction action) {
		this.entityId = entityId;
		this.entityType = entityType;
		this.ideaAction = action; 
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id; 
	}
	
	public Date getCreatedOn() {
		return createdOn;
	}
	
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	public void setIdea(IdeaImpl ideaImpl) {
		this.ideaImpl = ideaImpl;
	}
	
	public IdeaImpl getIdea() {
		return this.ideaImpl;
	}

	public void setIdeaAction(IdeaAction ideaAction) {
		this.ideaAction = ideaAction;
	}
	
	public IdeaAction getIdeaAction() {
		return ideaAction;
	}
	
	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}
	
	public Long getEntityId() {
	    return this.entityId;
	}
	
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	
	public String getEntityType() {
		return entityType;
	}
	
}
