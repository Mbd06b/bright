package com.worscipe.bright.users.modelview;

import java.io.Serializable;

import com.worscipe.bright.users.model.User;

public class UserLinkView implements Serializable {
	
	private static final long serialVersionUID = -2107658234994887400L;

	private Long id;
    
	private String email;

	private String firstName;

	private String lastName;
	
	private String title;
	
	private String userImgUrl;
	
	private String avatarUrl; 
	
	UserLinkView(){}
	
	public UserLinkView(User user){
		this.id = user.getId();
		this.email = user.getEmail();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.setTitle(user.getTitle());
		this.userImgUrl = user.getUserImgUrl();
		this.avatarUrl = user.getAvatarUrl();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


}
