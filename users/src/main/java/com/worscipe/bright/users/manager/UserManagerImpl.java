package com.worscipe.bright.users.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worscipe.bright.users.auth.Password;
import com.worscipe.bright.users.auth.TokenManager;
import com.worscipe.bright.users.model.User;
import com.worscipe.bright.users.modelview.UserView;
import com.worscipe.bright.users.service.RecordService;
import com.worscipe.bright.users.service.UserService;



@Service
public class UserManagerImpl implements UserManager {
	
	
	@Autowired
	private UserService userService; 
	
	@Autowired
	private TokenManager tokenManager;

	
	@Override
	public UserView saveUser(UserView user) {
		
		if(user.getId() == null) {
			// new user! hash the password
			user.setPassword(Password.hash(user.getPassword()));
		}		
		
		User userToPersist = convertToModel(user) ;
		
		return new UserView(userService.saveUser(userToPersist));
		
	}	
	

	@Override
	public List<UserView> findAllUsers(){
		return convertToView(userService.findAllUsers()); 
	}

	@Override
	public UserView findById(final Long id) {
		return convertToView(userService.findById(id));
	}
	

	@Override
	public UserView findByEmail(final String email) {
		return convertToView(userService.findByEmail(email));
	}

	@Override
	public Boolean existsByEmail(String email) {
		return userService.existsByEmail(email);
	}
	
	@Override
	public Boolean existsById(Long id) {
		return userService.existsById(id);
	}
	
	@Override
	public Boolean deleteUserById(Long id) {
		return userService.deleteUserById(id); 
	}

	/** 
	 * This method returns a vaild JWT token for the user passed in.  
	 * @author matthew.b.dowell
	 * @param UserView of user to validate;
	 * @return String a jwt token
	 * 
	 * 
	 */
	
	@Override
	public UserView authorizeUser(UserView user) {
		 
		String token = tokenManager.generateToken(user);
		 user.setToken(token); 
		 return user;
	}
	
	
	@Override
	public User convertToModel(UserView userView) {
		
		User user = new User();
		user.setAboutMe(userView.getAboutMe());
		user.setAvatarUrl(userView.getAvatarUrl());
		user.setEmail(userView.getEmail());
		user.setFirstName(userView.getFirstName());
		user.setId(userView.getId());
		user.setLastName(userView.getLastName());
		user.setPassword(userView.getPassword());
		user.setRole(userView.getRole());
		user.setTitle(userView.getTitle());
		user.setUsername(userView.getUsername());
		
		return user;
	}
	
	@Override
	public List<User> convertToModel(List<UserView> userViews) {
		
		List<User> users = new ArrayList<>();
		for(UserView u : userViews) {
			users.add(convertToModel(u)); 
		}
		return users;
	}
	
	
	@Override
	public UserView convertToView(User user){
		
		UserView userView = new UserView(); 
		userView.setAboutMe(user.getAboutMe());
		userView.setAvatarUrl(user.getAvatarUrl());
		userView.setEmail(user.getEmail());
		userView.setFirstName(user.getFirstName());
		userView.setLastName(user.getLastName());
		userView.setId(user.getId());
		userView.setPassword(user.getPassword());
		userView.setRole(user.getRole());
		userView.setTitle(user.getTitle());
		userView.setUsername(user.getUsername());
		
		return userView; 
	}
	
	
	@Override
	public List<UserView> convertToView(List<User> users){
		List<UserView> userViews = new ArrayList<>(); 
		for(User u : users) {
			userViews.add(convertToView(u)); 
		}
		return userViews;
	}


	@Override
	public List<UserView> findContributorsByIdeaId(Long ideaId) {
		List<User> users = userService.findByIdea(ideaId);
		return convertToView(users); 
	}
	
}
