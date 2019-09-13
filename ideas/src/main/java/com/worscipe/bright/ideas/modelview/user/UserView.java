package com.worscipe.bright.ideas.modelview.user;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.worscipe.bright.ideas.model.user.Role;
import com.worscipe.bright.ideas.model.user.User;
import com.worscipe.bright.ideas.modelview.idea.IdeaLinkView;

//TODO from 1/9/2019 code review, research ViewModels
//This UserView (data transfer object) is used by the application front-end to communicate to the back.
//This is complementary to the User.java which handles object representation in the database. 

public class UserView implements Serializable{

	private static final long serialVersionUID = -4483441957532789807L;

		private Long id;
                             
		private String email;
		
		private String username;

		private String password;

		private String firstName;

		private String lastName;
		
		private String title;
		
		private String aboutMe;
		
		//JWT Token for user authentication in client
		private String token;
		
		private String userImgUrl;
		
		private String avatarUrl;
		
		@JsonProperty("role")
		private Role role = Role.NONE;

		// -------COMPOSITION RELATIONSHIPS----------------
		
		// https://www.baeldung.com/hibernate-many-to-many

		//Users have a set of ideas that they have contributed to.
		private List<IdeaLinkView> ideas;
		
		public List<IdeaLinkView> getIdeaIds(){
			return ideas;
		}
		
		public void setIdeaIds(List<IdeaLinkView> ideas) {
			this.ideas = ideas; 
		}
		
		
	//-----Constructors--------

		public UserView() {
		}

		
		public UserView(User user) {
			this.id = user.getId(); 
			this.email = user.getEmail(); 
			this.username = user.getUsername();
			this.password = user.getPassword(); 
			this.firstName = user.getFirstName();
			this.lastName = user.getLastName();
			this.title = user.getTitle();
			this.aboutMe = user.getAboutMe(); 
			this.userImgUrl =user.getUserImgUrl();
			this.avatarUrl = user.getAvatarUrl(); 
			this.role = user.getRole();
		}
				

	//----Methods--------------		


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
		
		public String getUsername() {
			return username;
		}
		
		public void setUsername(String username) {
			this.username = username; 
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
		
		public String getUserImgUrl() {
			return this.userImgUrl;
		}
		
		public void setUserImgUrl(String userImgUrl) {
			this.userImgUrl = userImgUrl; 
		}
		
		public String getAvatarUrl() {
			return this.avatarUrl;
		}
		
		public void setAvatarUrl(String avatarUrl) {
			this.avatarUrl = avatarUrl;
		}
		

		@Override
		public String toString() {
			return "[User:" + id + " Info] email: " + email + " firstName: " + firstName + " lastName: " + lastName;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}
		
		public Role getRole() {
			return role;
		}

		public void setRole(Role role) {
			this.role = role;
		}

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

		public List<IdeaLinkView> getIdeas() {
			return ideas;
		}

		public void setIdeas(List<IdeaLinkView> ideas) {
			this.ideas = ideas;
		}

	
	
}
