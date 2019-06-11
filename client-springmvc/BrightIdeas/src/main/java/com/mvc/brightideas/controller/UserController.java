package com.mvc.brightideas.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.mvc.brightideas.model.Password;
import com.mvc.brightideas.model.User;
import com.mvc.brightideas.restmanager.UserManager;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private	UserManager userManager; 
	
	
	//-------------Spring Form Register User, see createUser() method for angular below. 
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String addUserSubmit(@Valid @ModelAttribute("user")  User user, BindingResult result, ModelMap model, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "error"; 
		}
		
		model.addAttribute("email", user.getEmail());
		model.addAttribute("password", user.getPassword());
		model.addAttribute("firstName", user.getFirstName());
		model.addAttribute("lastName", user.getLastName());
		

        User existingEmail = userManager.findByEmail(user.getEmail());
        if (existingEmail != null) {
        	System.out.println("Email in Use");
            result.rejectValue("email", "user.email", "Email is already used.");
        }else {
        	userManager.createUser(user); 
        	System.out.println("New User Created!");
        }
	
		model.clear(); 
		
		//redirect loads the home page "/" 
	    return "redirect:/";
	}
	
	
	
	
	@RequestMapping(value="/users", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<User>> listAllUsers(){
		List<User> users = userManager.getUsers(); 
		if(users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}else{
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User>  getUser(@PathVariable("id") Long id){
		System.out.println("Fetching User with id: " + id);
		
		User user = userManager.getUserById(id); 
		
		if(user == null) {
			System.out.println("User with id: " + id + "not fund ");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND); 
		}
		else {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(value ="/", method = RequestMethod.POST)
	public ResponseEntity<User>createUser(@RequestBody User user){
		System.out.println("Creating User: " +  user.getEmail()); 
		
		User newUser = userManager.createUser(user); 
		
		return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
		
	}
	
	
	@RequestMapping(value="/", method = RequestMethod.PUT)
	public ResponseEntity<User>updateUser(@RequestBody User user){
		
		User updatedUser = userManager.updateUser(user);
		
		if(updatedUser != null) {
			return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable("id") Long id){
		System.out.println("Fetching and Deleteing User with id: " + id);
		
		if(userManager.deleteUser(id)) {
			return new ResponseEntity<User>(HttpStatus.OK);
		}
		else {
			System.out.println("Unable to delete. User with id: " + id);
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		
		
	}
	

	
	
}
