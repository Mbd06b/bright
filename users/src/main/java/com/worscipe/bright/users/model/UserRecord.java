package com.worscipe.bright.users.model;

import com.worscipe.bright.common.Relational;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class UserRecord implements Relational<User>{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="USER_RECORD_ID", updatable = false, nullable = true)
	private Long id;
		
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user; 
		
	// the id of the entity interacting with the user (either an internal or external microservice)
	@Column(name="ENTITY_ID") 
	private Long entityId; 

	@Column(name="CREATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn = new Date();
	
	@Column(name="MODIFIED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate = new Date();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public Long getEntityId() {
		return entityId;
	}
	
	@Override
	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}
	
	@Override
	public Date getCreatedOn() {
		return createdOn;
	}
	
	@Override
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	@Override
	public Date getModifiedDate() {
		return modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public User getOwningEntity() {
		return user; 
	}

	@Override
	public void setOwningEntity(User user) {
		this.user = user; 
		
	} 
		
}
