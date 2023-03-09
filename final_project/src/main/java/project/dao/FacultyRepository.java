package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.domain.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
	
	Faculty findByName(String name);
	
}