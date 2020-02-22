package com.worscipe.bright.users.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worscipe.bright.common.auth.Password;
import com.worscipe.bright.users.model.UserImpl;
import com.worscipe.bright.users.modelview.UserView;
import com.worscipe.bright.users.service.UserService;



@Service
public class UserManagerImpl implements UserManager {
	
	
	@Autowired
	private UserService userService; 
	
//	@Autowired
//	private TokenManager tokenManager;

	
	@Override
	public UserView saveUser(UserView user) {
		
		if(user.getId() == null) {
			// new user! hash the password
			user.setPassword(Password.hash(user.getPassword()));
		}		
		
		UserImpl userToPersist = convertToModel(user) ;
		
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
	
//	@Override
//	public UserView authorizeUser(UserView user) {
//		 
//		String token = tokenManager.generateToken(user);
//		 user.setToken(token); 
//		 return user;
//	}
//	
	
	@Override
	public UserImpl convertToModel(UserView userView) {
		
		UserImpl userImpl = new UserImpl();
		userImpl.setAboutMe(userView.getAboutMe());
		userImpl.setAvatarUrl(userView.getAvatarUrl());
		userImpl.setEmail(userView.getEmail());
		userImpl.setFirstName(userView.getFirstName());
		userImpl.setId(userView.getId());
		userImpl.setLastName(userView.getLastName());
		userImpl.setPassword(userView.getPassword());
		userImpl.setRole(userView.getRole());
		userImpl.setTitle(userView.getTitle());
		userImpl.setUsername(userView.getUsername());
		
		return userImpl;
	}
	
	@Override
	public List<UserImpl> convertToModel(List<UserView> userViews) {
		
		List<UserImpl> userImpls = new ArrayList<>();
		for(UserView u : userViews) {
			userImpls.add(convertToModel(u)); 
		}
		return userImpls;
	}
	
	
	@Override
	public UserView convertToView(UserImpl userImpl){
		
		UserView userView = new UserView(); 
		userView.setAboutMe(userImpl.getAboutMe());
		userView.setAvatarUrl(userImpl.getAvatarUrl());
		userView.setEmail(userImpl.getEmail());
		userView.setFirstName(userImpl.getFirstName());
		userView.setLastName(userImpl.getLastName());
		userView.setId(userImpl.getId());
		userView.setPassword(userImpl.getPassword());
		userView.setRole(userImpl.getRole());
		userView.setTitle(userImpl.getTitle());
		userView.setUsername(userImpl.getUsername());
		
		return userView; 
	}
	
	
	@Override
	public List<UserView> convertToView(List<UserImpl> userImpls){
		List<UserView> userViews = new ArrayList<>(); 
		for(UserImpl u : userImpls) {
			userViews.add(convertToView(u)); 
		}
		return userViews;
	}


	@Override
	public List<UserView> findContributorsByIdeaId(Long ideaId) {
		List<UserImpl> userImpls = userService.findByIdea(ideaId);
		return convertToView(userImpls); 
	}
	
}
