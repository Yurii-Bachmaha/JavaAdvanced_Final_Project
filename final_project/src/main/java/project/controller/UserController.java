package project.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import project.service.UserDTO;
import project.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView viewPageRegistration() {
		ModelAndView map = new ModelAndView("registration");
		return map;
	}

	@RequestMapping(value = { "/", "/registration" }, method = RequestMethod.POST)
	public ModelAndView registration(
			@RequestParam String firstName,
			@RequestParam String lastName,
			@RequestParam String email,
			@RequestParam Integer age,
			@RequestParam String password,
			@RequestParam String passwordConfirm,
			@RequestParam MultipartFile encodedImage)throws IOException {
		
		if(!userService.findByEmail(email)) {
			userService.save(UserDTO.createUser(firstName, lastName, email, age, password, passwordConfirm, encodedImage));
		}
	
		return new ModelAndView("authentication");
	}

	@RequestMapping(value = { "/", "/authentication" }, method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {

		if (error != null)
			model.addAttribute("error", "Your username or password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "authentication";
	}

}