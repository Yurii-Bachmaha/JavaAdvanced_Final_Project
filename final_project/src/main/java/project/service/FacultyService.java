package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dao.FacultyRepository;
import project.domain.Faculty;

@Service
public class FacultyService {
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	public void save(Faculty faculty) {
		facultyRepository.save(faculty);
	}
	
	public Faculty getFacultyByName(String name) {
		return facultyRepository.findByName(name);
	}
	
	public Faculty getFacultyById(Integer id) {
		return facultyRepository.getReferenceById(id);
	}
	
	public List<Faculty> getAll(){
		return facultyRepository.findAll();
	}

}