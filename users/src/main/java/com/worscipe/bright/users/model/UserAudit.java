package com.worscipe.bright.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserAudit {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="user_audit_id")
	private Long id;
	
	
	
}
