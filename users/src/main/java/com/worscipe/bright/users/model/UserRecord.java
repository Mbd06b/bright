package com.worscipe.bright.users.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.worscipe.bright.common.Relational;

@Entity
@Table( name = "USER_RECORD")
public class UserRecord implements Relational, Serializable{

	private static final long serialVersionUID = -4968053881888933127L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="USER_RECORD_ID", updatable = false, nullable = true)
	private Long id;

//  Default is uni-directional mapping. By adding the below @ManyToOne annotation
//	we would be creating a bi-directional mapping, allowing access to the owning entity through the record 
//  like so, userRecord.getUser(); 
//  This often adds unnecessary complexity when persisting objects with these relationships 
//  requiring both objects to refer to eachother as they are saved.
//	@ManyToOne
//	@JoinColumn(name="USER_ID")
//	private User user; 
		
	// the id of the entity interacting with the user (either an internal or external microservice)
	@Column(name="ENTITY_ID") 
	private Long entityId; 

	@Column(name="CREATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn = new Date();
	
	@Column(name="MODIFIED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate = new Date();

	public UserRecord() {}

	public UserRecord(Long entityId) {
		this.entityId = entityId;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		
}
