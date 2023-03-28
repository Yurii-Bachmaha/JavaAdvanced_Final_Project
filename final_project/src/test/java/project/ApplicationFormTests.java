package project;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import project.dao.ApplicationFormRepository;
import project.dao.FacultyRepository;
import project.dao.UserRepository;
import project.domain.ApplicationForm;
import project.domain.Faculty;
import project.domain.User;
import project.domain.UserRole;
import project.service.ApplicationFormService;
import project.service.FacultyService;
import project.service.UserService;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@ComponentScan(basePackages = {"project"})
public class ApplicationFormTests {
	
	@Autowired
	ApplicationFormService applicationFormService;
	
	@Autowired
	ApplicationFormRepository applicationFormRepository;
	
	@Autowired
	FacultyService facultyService;
	
	@Autowired
	FacultyRepository facultyRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@BeforeEach
	void clear() {
		applicationFormRepository.deleteAll();
		facultyRepository.deleteAll();
		userRepository.deleteAll();
	}

	@Test
	public void testAddStatment() {
		List<ApplicationForm> applicationForms = applicationFormRepository.findAll();
		assertThat(applicationForms, hasSize(0));
		
		Faculty faculty = createFaculty1();	

		facultyService.save(faculty);
		
		User user1 = createUser1();
		
		userService.save(user1);
		
		ApplicationForm applicationForm = new ApplicationForm();
		
		applicationForm.setFaculty(faculty);
		applicationForm.setUser(user1);
		
		applicationFormService.add(applicationForm);
		
		applicationForms = applicationFormRepository.findAll();
		assertThat(applicationForms, hasSize(1));
		
		ApplicationForm applicationFormDB = applicationForms.get(0);
		
		assertTrue(applicationForm.getUser().equals(applicationFormDB.getUser()));
		assertTrue(applicationForm.getFaculty().equals(applicationFormDB.getFaculty()));
	}
	
	@Test
	public void testGetAllByFacultyId() {
		List<ApplicationForm> applicationForms = applicationFormRepository.findAll();
		assertThat(applicationForms, hasSize(0));
		
		Faculty faculty1 = createFaculty1();

		facultyService.save(faculty1);
		
		Faculty faculty2 = createFaculty2();

		facultyService.save(faculty2);
		
		User user1 = createUser1();
		
		userService.save(user1);
		
		User user2 = createUser2();
		
		userService.save(user2);
		
		ApplicationForm applicationForm1 = new ApplicationForm();
		ApplicationForm applicationForm2 = new ApplicationForm();
		
		applicationForm1.setFaculty(faculty1);
		applicationForm1.setUser(user1);
		
		applicationForm2.setFaculty(faculty2);
		applicationForm2.setUser(user2);
		
		applicationFormService.add(applicationForm1);
		applicationFormService.add(applicationForm2);
		
		applicationForms = applicationFormRepository.findAll();
		assertThat(applicationForms, hasSize(2));
		
		applicationForms = applicationFormService.getAllByFacultyId(faculty1.getId());
		assertThat(applicationForms, hasSize(1));
		
		ApplicationForm applicationFromDB = applicationForms.get(0);
		
		assertTrue(applicationForm1.getUser().equals(applicationFromDB.getUser()));
		assertTrue(applicationForm1.getFaculty().equals(applicationFromDB.getFaculty()));
	}
	
	@Test
	public void testGetAllByUserId() {
		List<ApplicationForm> applicationForms = applicationFormRepository.findAll();
		assertThat(applicationForms, hasSize(0));
		
		Faculty faculty1 = createFaculty1();

		facultyService.save(faculty1);
		
		Faculty faculty2 = createFaculty2();

		facultyService.save(faculty2);
		
		User user1 = createUser1();
		
		userService.save(user1);
		
		User user2 = createUser2();
		
		userService.save(user2);
		
		ApplicationForm applicationForm1 = new ApplicationForm();
		ApplicationForm applicationForm2 = new ApplicationForm();
		
		applicationForm1.setFaculty(faculty1);
		applicationForm1.setUser(user1);
		
		applicationForm2.setFaculty(faculty2);
		applicationForm2.setUser(user2);
		
		applicationFormService.add(applicationForm1);
		applicationFormService.add(applicationForm2);
		
		applicationForms = applicationFormRepository.findAll();
		assertThat(applicationForms, hasSize(2));
		
		applicationForms = applicationFormService.getAllByUserId(user1.getId());
		assertThat(applicationForms, hasSize(1));
		
		ApplicationForm applicationFormDB = applicationForms.get(0);
		
		assertTrue(applicationForm1.getUser().equals(applicationFormDB.getUser()));
		assertTrue(applicationForm1.getFaculty().equals(applicationFormDB.getFaculty()));
	}
	
	@Test
	public void testDeleteByUserId() {
		List<ApplicationForm> applicationForms = applicationFormRepository.findAll();
		assertThat(applicationForms, hasSize(0));
		
		Faculty faculty1 = createFaculty1();

		facultyService.save(faculty1);
		
		Faculty faculty2 = createFaculty2();

		facultyService.save(faculty2);
		
		User user1 = createUser1();
		
		userService.save(user1);
		
		User user2 = createUser2();
		
		userService.save(user2);
		
		ApplicationForm applicationForm1 = new ApplicationForm();
		ApplicationForm applicationForm2 = new ApplicationForm();
		
		applicationForm1.setFaculty(faculty1);
		applicationForm1.setUser(user1);
		
		applicationForm2.setFaculty(faculty2);
		applicationForm2.setUser(user2);
		
		applicationFormService.add(applicationForm1);
		applicationFormService.add(applicationForm2);
		
		applicationForms = applicationFormRepository.findAll();
		assertThat(applicationForms, hasSize(2));
		
		applicationFormService.deleteByUserId(user2.getId());
		
		applicationForms = applicationFormRepository.findAll();
		assertThat(applicationForms, hasSize(1));
		
		ApplicationForm applicationFormDB = applicationForms.get(0);
		
		assertTrue(applicationForm1.getUser().equals(applicationFormDB.getUser()));
		assertTrue(applicationForm1.getFaculty().equals(applicationFormDB.getFaculty()));
	}
	
	@Test
	public void testGetUsersByFacultyId() {
		List<ApplicationForm> applicationForms = applicationFormRepository.findAll();
		List<User> users = new ArrayList<>();
		assertThat(applicationForms, hasSize(0));
		
		Faculty faculty1 = createFaculty1();

		facultyService.save(faculty1);
		
		Faculty faculty2 = createFaculty2();

		facultyService.save(faculty2);
		
		User user1 = createUser1();
		
		userService.save(user1);
		
		User user2 = createUser2();
		
		userService.save(user2);
		
		users.add(user1);
		
		ApplicationForm applicationForm1 = new ApplicationForm();
		ApplicationForm applicationForm2 = new ApplicationForm();
		
		applicationForm1.setFaculty(faculty1);
		applicationForm1.setUser(user1);
		
		applicationForm2.setFaculty(faculty2);
		applicationForm2.setUser(user2);
		
		applicationFormService.add(applicationForm1);
		applicationFormService.add(applicationForm2);
		
		applicationForms = applicationFormRepository.findAll();
		assertThat(applicationForms, hasSize(2));
		
		List<User> usersByFacultyId = applicationFormService.getUsersByFacultyId(faculty1.getId());
		
		assertTrue(usersByFacultyId.get(0).equals(users.get(0)));
	}
	
	User createUser1() {
		User user1 = new User();
		user1.setFirstName("1");
		user1.setLastName("1");
		user1.setAge(1);
		user1.setEmail("1@gmail.com");
		user1.setPassword("1");
		user1.setPasswordConfirm("1");
		user1.setRole(UserRole.ROLE_APPLICANT);
		
		return user1;
	}
	
	User createUser2() {
		User user2 = new User();
		user2.setFirstName("2");
		user2.setLastName("2");
		user2.setAge(2);
		user2.setEmail("2@gmail.com");
		user2.setPassword("2");
		user2.setPasswordConfirm("2");
		user2.setRole(UserRole.ROLE_APPLICANT);
		
		return user2;
	}
	
	Faculty createFaculty1() {
		Faculty faculty1 = new Faculty();
		faculty1.setName("Mathematics");
		faculty1.setNumberOfStudents(1500);
		faculty1.setMinimumPassingScore(150);
		
		return faculty1;
	}
	
	Faculty createFaculty2() {
		Faculty faculty2 = new Faculty();
		faculty2.setName("Physics");
		faculty2.setNumberOfStudents(2000);
		faculty2.setMinimumPassingScore(200);
		
		return faculty2;
	}
	
}