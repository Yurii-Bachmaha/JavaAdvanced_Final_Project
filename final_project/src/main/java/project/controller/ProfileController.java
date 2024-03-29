package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import project.domain.User;
import project.service.CertificateService;
import project.service.UserService;

@Controller
public class ProfileController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CertificateService certificateService;
	
	public User getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userService.getByEmail(auth.getName());
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView viewProfile() {
		ModelAndView map = new ModelAndView("home");
		map.addObject("userViewer",  getCurrentUser());
		
		if(certificateService.getByUserId(getCurrentUser().getId()) != null) {
			map.addObject("subjectsViewer", certificateService.getByUserId(getCurrentUser().getId()));
		}

		return map;
	}
	
}