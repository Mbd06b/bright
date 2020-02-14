package com.worscipe.bright.users.model;

import java.util.Date;
import java.util.Set;

import com.worscipe.bright.common.auth.Role;

public interface User {
	
	Long getId();
	void setId(Long id);
	
	String getEmail();
	void setEmail(String email);
	
	String getUsername();
	void setUsername(String username);
	
	String getFirstName();
	void setFirstName(String firstName);
	
	String getLastName();
	void setLastName(String lastName);
	
	String getTitle();
	void setTitle(String title);
	
	Role getRole();
	void setRole(Role role);
	
	String getPassword();
	void setPassword(String password); 
	
	String getAboutMe();
	void setAboutMe(String aboutMe);
	
	String getUserImgUrl();
	void setUserImgUrl(String userImgUrl);
	
	String getAvatarUrl();
	void setAvatarUrl(String avatarUrl);
	
	Date getCreatedOn();
	void setCreatedOn(Date createdOn); 
	
	Date getModifiedOn();
	void setModifiedOn(Date modifiedOn);
	
	Set<UserRecord> getElections();
	void setElections(Set<UserRecord> elections);
	
	Set<UserRecord> getIdeas();
	void setIdeas(Set<UserRecord> ideas);
	
	void addElection(UserRecord election);
	void addIdea(UserRecord idea); 
	
}
