package project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dao.FacultyRepository;
import project.domain.Faculty;

@Service
public class FacultyService {
	
	private Logger logger = LoggerFactory.getLogger(FacultyService.class);
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	public void save(Faculty faculty) {
		logger.info("Added faculty: " + faculty);
		facultyRepository.save(faculty);
	}
	
	public Faculty getFacultyByName(String name) {
		logger.info("Received faculty of " + name + " by field name");
		return facultyRepository.findByName(name);
	}
	
	public Faculty getFacultyById(Integer id) {
		logger.info("Received faculty of " + id + " by field ID");
		return facultyRepository.getReferenceById(id);
	}
	
	public List<Faculty> getAll(){
		logger.info("All faculties received");
		return facultyRepository.findAll();
	}
	
}