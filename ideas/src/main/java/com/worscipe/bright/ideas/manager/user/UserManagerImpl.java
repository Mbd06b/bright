package com.worscipe.bright.ideas.manager.user;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.reflect.TypeToken;
import com.worscipe.bright.ideas.auth.Password;
import com.worscipe.bright.ideas.auth.TokenManager;
import com.worscipe.bright.ideas.model.user.User;
import com.worscipe.bright.ideas.modelview.user.UserView;
import com.worscipe.bright.ideas.service.UserService;
import com.worscipe.bright.ideas.service.idea.IdeaService;



@Service("userManager")
public class UserManagerImpl implements UserManager {
	
	
	@Autowired
	private UserService userService; 
	
	@Autowired
	private IdeaService ideaService; 
	
	@Autowired
	private TokenManager tokenManager;
	
	private ModelMapper modelMapper = new ModelMapper(); 
	private Type userListType = new TypeToken<List<User>>() {}.getType();
	private Type userDtoListType = new TypeToken<List<UserView>>() {}.getType();
	
	@Override
	public UserView saveUser(UserView user) {
		
		if(user.getId() == null) {
			// new user! hash the password
			user.setPassword(Password.hash(user.getPassword()));
		};
		
		User userToPersist = new User(user);
		
		return new UserView(userService.saveUser(userToPersist));
		
	}	
	

	@Override
	public List<UserView> findAllUsers(){
		
		List<User> users = userService.findAllUsers(); 
		
		List<UserView> userDtoList = new ArrayList<UserView>(); 
		
		for(User user: users) {
		    userDtoList.add(new UserView(user));
		}
		return userDtoList; 
	}

	@Override
	public UserView findById(final Long id) {
	   
		User user = userService.findById(id);
	   
	   if(user != null) {
		   return new UserView(user); 
	   }
	   else {
	       return null;
	   }
	}
	

	public UserView findByEmail(final String email) {
		User user = userService.findByEmail(email);
		
	   if(user != null) {
		   return new UserView(user); 
	   }
	   else {
	       return null;
	   }
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
		
		if(userService.deleteUserById(id)) {
			return true;
		}
		else {
			return false;
		}
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
		return modelMapper.map(userView, User.class);
	}
	
	@Override
	public List<User> convertToModels(List<UserView> userViews) {
		
		List<User> users = modelMapper.map(userViews, userListType);
						
		return users;
	}
	
	
	@Override
	public UserView convertToView(User user){
		return modelMapper.map(user, UserView.class);
	}
	
	
	@Override
	public List<User> convertToViews(List<User> users){
		return modelMapper.map(users, userDtoListType);
	}
	
	

	
	
}
