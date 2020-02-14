package com.worscipe.bright.users.manager;

import java.util.List;

import com.worscipe.bright.users.model.UserImpl;
import com.worscipe.bright.users.modelview.UserView;

public interface UserManager{
	
	UserView findById(Long id);
	
	UserView findByEmail(String email); 
	
	List<UserView> findAllUsers(); 
	
	UserView saveUser(UserView user); 
	
	Boolean existsByEmail(String email); 
		
	Boolean deleteUserById(Long id); 
	
    //UserView authorizeUser(UserView user);

	Boolean existsById(Long id);

	UserImpl convertToModel(UserView userView);

	List<UserImpl> convertToModel(List<UserView> userViews);

	UserView convertToView(UserImpl userImpl);

	List<UserView> findContributorsByIdeaId(Long ideaId);

	List<UserView> convertToView(List<UserImpl> userImpls);

}
