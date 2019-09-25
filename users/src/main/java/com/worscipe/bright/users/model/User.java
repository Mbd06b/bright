package com.worscipe.bright.users.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//Hibernate Annotation Table_Per_Class Strategy Reference
//https://thoughts-on-java.org/complete-guide-inheritance-strategies-jpa-hibernate/

@Entity
@Table(name = "users")
public class User {


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
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
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
	
//----Methods--------------		

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long userId) {
		this.id = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public String getUserImgUrl() {
		return userImgUrl;
	}

	public void setUserImgUrl(String userImgUrl) {
		this.userImgUrl = userImgUrl;
	}
	
	public String getAvatarUrl() {
		return avatarUrl;
	}
	
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	
	@Override
	public String toString() {
		return "[User:" + id + " Info] email: " + email + " firstName: " + firstName + " lastName: " + lastName + " role: " + role;
	}

}
