package com.mvc.brightideas.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mvc.brightideas.model.Password;
import com.mvc.brightideas.model.User;
import com.mvc.brightideas.restmanager.UserManager;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	UserManager userManager;

	@RequestMapping(name = "/", method = RequestMethod.GET)
	public String showLoginPage(Model model, HttpServletRequest request) {

		model.addAttribute("user", new User());

		return "login";
	}

	@RequestMapping(value = "/sessionUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> getSessionUser(HttpServletRequest request) {
		User activeUser = (User) request.getSession().getAttribute("user");
		if (activeUser != null) {
			return new ResponseEntity<User>(activeUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {

		request.getSession().invalidate();

		return "redirect:/landing";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String loginUserSubmit(@Valid @ModelAttribute("user") User user, BindingResult result, ModelMap model,
			HttpServletRequest request, RedirectAttributes redirect) {

		User currentUser = (User) request.getSession().getAttribute("user");
		if (currentUser != null) {
			return "redirect:/home";
		}

		if (result.hasErrors()) {
			return "error";
		}

		model.addAttribute("user", new User());
		model.addAttribute("email", user.getEmail());
		model.addAttribute("password", user.getPassword());

		User existingUser = userManager.findByEmail(user.getEmail());
		boolean userExists = (existingUser != null);

	    System.out.println("Existing User: " +  existingUser);
		boolean validAttempt = userExists && existingUser.getEmail().equals(user.getEmail())
				&& Password.check(user.getPassword(), existingUser.getPassword());

		if (userExists) {
			boolean passwordCorrect = Password.check(user.getPassword(), existingUser.getPassword()); // check the
																										// submitted
																										// password
																										// against what
																										// I have in the
																										// database
			// incorrect password:
			if (!passwordCorrect) {
				model.addAttribute("passwordIsIncorrect", true);
				model.addAttribute("user", user);
				return "login";
			}
		}

		if (!validAttempt) {
			System.out.println("not a valid attempt");
			model.addAttribute("errorMessage", true);
			model.addAttribute("user", user);
			return "login";
		} else {
			request.getSession().setAttribute("user", existingUser);
			redirect.addFlashAttribute("user", existingUser);
			model.clear();
			return "redirect:/home";
		}

	}

}
