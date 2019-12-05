package com.worscipe.bright.ideas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.worscipe.bright.common.Relational;

@Entity
public class IdeaRecord implements Relational {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="IDEA_AUDIT_ID", updatable = false, nullable = true)
	private Long id;
		
	// the id of the entity interacting with the idea (either an internal or external microservice)
	@Column(name="ENTITY_ID") 
	private Long entityId; 

	@Column(name="CREATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn = new Date();
	
	@Column(name="MODIFIED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate = new Date(); 
	
	@Enumerated(EnumType.STRING) 
	@Column(name="ACTION")
	private IdeaAction ideaAction;

	public IdeaRecord() {
		super(); 
	} 
		
	public IdeaRecord(Long entityId, IdeaAction action) {
		this.entityId = entityId;
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
	
	public void setIdeaAction(IdeaAction ideaAction) {
		this.ideaAction = ideaAction;
	}
	
	public IdeaAction getIdeaAction() {
		return ideaAction;
	}
	
	@Override
	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}
	
	@Override
	public Long getEntityId() {
	    return this.entityId;
	}

	@Override
	public Date getModifiedDate() {
		return modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate; 
	}	
}
