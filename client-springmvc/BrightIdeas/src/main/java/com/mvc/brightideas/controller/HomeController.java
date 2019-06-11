package com.mvc.brightideas.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.brightideas.model.User;



@Controller
public class HomeController {
		
	
	@RequestMapping(value= {"/", "/index", "index", "/home", "home" }, method=RequestMethod.GET)
	public ModelAndView showHome(@RequestParam(required=false, defaultValue="Login") String name, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("home");
		
		User currentUser = (User) request.getSession().getAttribute("user");
		if(currentUser != null) {
			mav.addObject("name", currentUser.getFirstName());
		}else {
		// Adds an object to be used in home.jsp
		mav.addObject("name", name);
		}
		
		return mav;
	}
	
	
	@RequestMapping(value="/landing")
	public String getLanding(@RequestParam(required=false, defaultValue="Login") String name, HttpServletRequest request) {
			ModelAndView mav = new ModelAndView();
			
			User currentUser = (User) request.getSession().getAttribute("user");
			if(currentUser != null) {
				mav.addObject("name", currentUser.getFirstName());
			}else {
			// Adds an object to be used in home.jsp
			mav.addObject("name", name);
			}
		return "landing"; 
	}
	
	@RequestMapping(value="/admin")
	public String getAdmin(@RequestParam(required=false, defaultValue="Login") String name, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView(); 
		User currentUser = (User) request.getSession().getAttribute("user"); 
		if(currentUser != null) {
			mav.addObject("name", currentUser.getFirstName()); 
			return "admin"; 
		}else {
			mav.addObject("name", name); 
			return "redirect:/login"; 
		}	
	}
	
}



