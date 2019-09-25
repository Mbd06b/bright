package com.worscipe.bright.users.manager;

import java.util.List;

import com.worscipe.bright.users.model.User;
import com.worscipe.bright.users.modelview.UserView;

public interface UserManager{
	
	UserView findById(Long id);
	
	UserView findByEmail(String email); 
	
	List<UserView> findAllUsers(); 
	
	UserView saveUser(UserView user); 
	
	Boolean existsByEmail(String email); 
		
	Boolean deleteUserById(Long id); 
	
	UserView authorizeUser(UserView user);

	Boolean existsById(Long id);

	User convertToModel(UserView userView);

	List<User> convertToModels(List<UserView> userViews);

	UserView convertToView(User user);

	List<User> convertToViews(List<User> users);

}
