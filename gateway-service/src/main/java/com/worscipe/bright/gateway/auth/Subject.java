package com.worscipe.bright.gateway.auth;

import com.worscipe.bright.common.auth.Role;

public class Subject {
	
	private Long id;
	private String firstName;
	private Role role;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

}
