package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.domain.Certificate;
import project.domain.Evaluation;
import project.domain.User;
import project.service.CertificateService;
import project.service.EvaluationDTO;
import project.service.EvaluationService;
import project.service.UserService;

@Controller
public class CertificateController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CertificateService certificateService;
	
	@Autowired
	private EvaluationService evaluationService;
	
	public User getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userService.findByEmail(auth.getName());
	}
	
	@RequestMapping(value = "/addCertificate", method = RequestMethod.GET)
    public String registration(Model model) {

        return "addCertificate";
    }
	
	@RequestMapping(value = "/addCertificate", method = RequestMethod.POST)
	public String addCandidate(
			@RequestParam Integer firstSubject,
			@RequestParam Integer secondSubject,
			@RequestParam Integer thirdSubject,
			@RequestParam Integer sumSchoolsCerticifate) {

		Certificate certificate = new Certificate();
		Certificate certificateDB = certificateService.getByUserId(getCurrentUser().getId());
		Evaluation evaluation = EvaluationDTO.createEvaluation(firstSubject, secondSubject, thirdSubject, sumSchoolsCerticifate);
		
		if(certificateDB == null || certificateService.getAll().isEmpty()) {
			evaluationService.add(evaluation);
			certificate.setUser(getCurrentUser());
			certificate.setEvaluation(evaluation);
			certificateService.add(certificate);
		}else {
			Evaluation evaluationGet = certificateDB.getEvaluation();
			evaluationService.update(evaluationGet,firstSubject, secondSubject, thirdSubject, sumSchoolsCerticifate);
		}
		
		return "redirect:/home";
	}
	
}