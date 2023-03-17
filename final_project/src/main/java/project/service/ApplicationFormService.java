package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dao.ApplicationFormRepository;
import project.domain.ApplicationForm;

@Service
public class ApplicationFormService {

	@Autowired
	ApplicationFormRepository applicationFormRepository;
	
	public List<ApplicationForm> getAll(){
		return applicationFormRepository.findAll();
	}
	
	public List<ApplicationForm> getAllByFacultyId(Integer facultyId){
		return applicationFormRepository.getAllByFacultyId(facultyId);
	}
		
	public List<ApplicationForm> getAllByUserId(Integer userId){
		return applicationFormRepository.getAllByUserId(userId);
	}
	
	public ApplicationForm add(ApplicationForm applicationForm) {
		return applicationFormRepository.save(applicationForm);
	}
	
	public void deleteByUserId(Integer id) {
		ApplicationForm applicationForm = applicationFormRepository.findAll().stream().filter(x-> x.getUser().getId()==id).findFirst().get();
		applicationFormRepository.delete(applicationForm);
	}
	
}