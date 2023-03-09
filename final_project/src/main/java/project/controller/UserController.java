package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.domain.User;
import project.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = { "/", "/authentication" }, method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "authentication";
		}
		userService.save(userForm);
		
		return "redirect:/home";
	}

	@RequestMapping(value = { "/", "/authentication" }, method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		model.addAttribute("userForm", new User());

		if (error != null)
			model.addAttribute("error", "Your username or password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "authentication";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String welcome(Model model) {
		return "home";
	}

}