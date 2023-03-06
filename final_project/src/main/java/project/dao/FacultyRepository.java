package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.domain.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<FacultyRepository, Integer> {
	
	Faculty findByName(String name);
	
}