package com.worscipe.bright.users.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.worscipe.bright.common.auth.Role;

//Hibernate Annotation Table_Per_Class Strategy Reference
//https://thoughts-on-java.org/complete-guide-inheritance-strategies-jpa-hibernate/

@Entity
@Table( name = "user")
public class UserImpl implements User, Serializable {

	
	private static final long serialVersionUID = 4466915115029408551L;

	//Recommended GenerationType value for MySQL backend is IDENTITY  - https://thoughts-on-java.org/5-things-you-need-to-know-when-using-hibernate-with-mysql/ 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	// used as login
	@Column(name = "email", unique = true)                                 
	private String email;

	@Column(name = "username")
	private String username; 
	
	@Column(name = "password")
	private String password;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "about_me")
	private String aboutMe;
	
	@Column(name = "user_img_url")
	private String userImgUrl;
	
	@Column(name = "avatar_url")
	private String avatarUrl;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private Role role = Role.NONE; 
	
	@Column(name="created_on")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn = new Date();
	
	@Column(name="modified_on")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedOn = new Date(); 
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<UserRecord> elections; 
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<UserRecord> ideas; 
	
//----Methods--------------		
	
	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long userId) {
		this.id = userId;
	}
	
	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public Role getRole() {
		return role;
	}

	@Override
	public Date getModifiedOn() {
		return modifiedOn;
	}

	@Override
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	@Override
	public void setRole(Role role) {
		this.role = role;
	}
	
	@Override
	public String getUserImgUrl() {
		return userImgUrl;
	}

	@Override
	public void setUserImgUrl(String userImgUrl) {
		this.userImgUrl = userImgUrl;
	}
	
	@Override
	public String getAvatarUrl() {
		return avatarUrl;
	}
	
	@Override
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
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
	public String toString() {
		return "[User:" + id + " Info] email: " + email + " firstName: " + firstName + " lastName: " + lastName + " role: " + role;
	}

	@Override
	public Set<UserRecord> getElections() {
		return elections;
	}

	@Override
	public void setElections(Set<UserRecord> elections) {
		this.elections = elections;
	}
	
	@Override
	public void addElection(UserRecord election) {
		this.elections.add(election); 
	}

	@Override
	public Set<UserRecord> getIdeas() {
		return ideas;
	}

	@Override
	public void setIdeas(Set<UserRecord> ideas) {
		this.ideas = ideas;
	}
	
	@Override
	public void addIdea(UserRecord idea) {
		this.ideas.add(idea); 
	}
	
	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String getAboutMe() {
		return aboutMe;
	}

	@Override
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

}
