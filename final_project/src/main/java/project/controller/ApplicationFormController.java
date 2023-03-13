package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.domain.ApplicationForm;
import project.domain.Certificate;
import project.domain.Faculty;
import project.domain.User;
import project.service.ApplicationFormService;
import project.service.CertificateService;
import project.service.FacultyService;
import project.service.UserService;

@Controller
public class ApplicationFormController {

	@Autowired
	UserService userService;
	
	@Autowired
	CertificateService certificateService;

	@Autowired
	ApplicationFormService applicationFormService;
	
	@Autowired
	FacultyService facultyService;
	
	public User getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userService.findByEmail(auth.getName());
	}
	
	@RequestMapping(value = "/applyToFaculty", method = RequestMethod.GET)
	private ModelAndView getFaculty() {
		ModelAndView map = new ModelAndView("applyToFaculty");
		map.addObject("faculties", facultyService.getAll());
		return map;
	}

	@RequestMapping(value = "/applyToFaculty", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView addCandidate(@RequestParam Integer facultyId) {

		ApplicationForm applicationForm = new ApplicationForm();
		User user =  getCurrentUser();
		Faculty faculty = facultyService.getFacultyById(facultyId);
		Certificate certificate = certificateService.getByUserId(user.getId());
		
		boolean findCreateStatmentForUser = applicationFormService.getAllByUserId(user.getId()).stream().filter(x->x.getFaculty().getId().equals(faculty.getId())).findFirst().isEmpty();
		
		applicationForm.setFaculty(faculty);
		applicationForm.setUser(user);
		applicationFormService.add(applicationForm);

		return new ModelAndView("redirect:/applyToFaculty");
		
	}
	
}