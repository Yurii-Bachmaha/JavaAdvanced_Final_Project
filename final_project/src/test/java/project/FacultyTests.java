package project;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import project.dao.FacultyRepository;
import project.domain.Faculty;
import project.service.FacultyService;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@ComponentScan(basePackages = {"project"})
public class FacultyTests {
	
	@Autowired
	private FacultyService facultyService;
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	@BeforeEach
	void clear() {
		facultyRepository.deleteAll();
	}

	@Test
	public void testSaveFaculty() {
		List<Faculty> faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(0));

		Faculty faculty = createFaculty();

		facultyService.save(faculty);
		
		faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(1));

		Faculty facultyDB = faculties.get(0);
		assertTrue(faculty.getName().equals(facultyDB.getName()));
		assertTrue(faculty.getNumberOfStudents().equals(facultyDB.getNumberOfStudents()));
		assertTrue(faculty.getMinimumPassingScore().equals(facultyDB.getMinimumPassingScore()));
	}
	
	@Test
	public void testGetFacultyByName() {
		List<Faculty> faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(0));

		Faculty faculty = createFaculty();

		facultyService.save(faculty);
		
		faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(1));

		Faculty facultyDB = facultyService.getFacultyByName(faculty.getName());
		assertTrue(faculty.getId().equals(facultyDB.getId()));
		assertTrue(faculty.getName().equals(facultyDB.getName()));
		assertTrue(faculty.getNumberOfStudents().equals(facultyDB.getNumberOfStudents()));
		assertTrue(faculty.getMinimumPassingScore().equals(facultyDB.getMinimumPassingScore()));	
	}
	
	@Test
	public void testGetFacultyById() {
		List<Faculty> faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(0));

		Faculty faculty = createFaculty();

		facultyService.save(faculty);
		
		faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(1));

		Faculty facultyDB = facultyService.getFacultyById(faculty.getId());
		assertTrue(faculty.getId().equals(facultyDB.getId()));
		assertTrue(faculty.getName().equals(facultyDB.getName()));
		assertTrue(faculty.getNumberOfStudents().equals(facultyDB.getNumberOfStudents()));
		assertTrue(faculty.getMinimumPassingScore().equals(facultyDB.getMinimumPassingScore()));
	}
	
	Faculty createFaculty() {
		Faculty faculty = new Faculty();
		faculty.setName("Mathematics");
		faculty.setNumberOfStudents(1500);
		faculty.setMinimumPassingScore(150);
		
		return faculty;
	}
	
}