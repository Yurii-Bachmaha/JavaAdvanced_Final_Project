package project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dao.ApplicationFormRepository;
import project.domain.ApplicationForm;

@Service
public class ApplicationFormService {
	
	private Logger logger = LoggerFactory.getLogger(ApplicationFormService.class);

	@Autowired
	ApplicationFormRepository applicationFormRepository;
	
	public List<ApplicationForm> getAll(){
		logger.info("All application forms received");
		return applicationFormRepository.findAll();
	}
	
	public List<ApplicationForm> getAllByFacultyId(Integer facultyId){
		logger.info("All faculties were received by field ID: "+ facultyId);
		return applicationFormRepository.getAllByFacultyId(facultyId);
	}
		
	public List<ApplicationForm> getAllByUserId(Integer userId){
		logger.info("Got all users by ID field: "+ userId);
		return applicationFormRepository.getAllByUserId(userId);
	}
	
	public ApplicationForm add(ApplicationForm applicationForm) {
		logger.info("A new application form has been created: "+ applicationForm);
		return applicationFormRepository.save(applicationForm);
	}
	
	public void deleteByUserId(Integer id) {
		logger.info("User "+ id + " was successfully removed");
		ApplicationForm applicationForm = applicationFormRepository.findAll().stream().filter(x-> x.getUser().getId()==id).findFirst().get();
		applicationFormRepository.delete(applicationForm);
	}
	
}