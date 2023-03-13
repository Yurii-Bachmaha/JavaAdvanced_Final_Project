package project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import project.domain.ApplicationForm;

@Repository
public interface ApplicationFormRepository extends JpaRepository<ApplicationForm, Integer> {

	@Query("SELECT s FROM ApplicationForm s WHERE s.faculty.id =:id")
	List<ApplicationForm> getAllByFacultyId(Integer id);
	
	@Query("SELECT s FROM ApplicationForm s WHERE s.user.id =:id")
	List<ApplicationForm> getAllByUserId(Integer id);
	
}