package project;

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

import project.dao.UserRepository;
import project.domain.User;
import project.domain.UserRole;
import project.service.UserService;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@ComponentScan(basePackages = {"project"})
class UserTests {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@BeforeEach
	void clear() {
		userRepository.deleteAll();
	}

	@Test
	void testSaveUser() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		User user = createUser();

		userService.save(user);;
		
		users = userRepository.findAll();
		assertThat(users, hasSize(1));

		User userFromDb = users.get(0);
		assertTrue(userFromDb.getFirstName().equals(user.getFirstName()));
		assertTrue(userFromDb.getLastName().equals(user.getLastName()));
		assertTrue(userFromDb.getAge().equals(user.getAge()));
		assertTrue(userFromDb.getEmail().equals(user.getEmail()));
		assertTrue(userFromDb.getRole().equals(user.getRole()));
	}
	
	@Test
	public void testGetByEmailUser() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		User user = createUser();

		userRepository.save(user);

		users = userRepository.findAll();
		assertThat(users, hasSize(1));

		User getByEmail = userService.getByEmail(user.getEmail());

		
		assertTrue(getByEmail.getFirstName().equals(user.getFirstName()));
		assertTrue(getByEmail.getLastName().equals(user.getLastName()));
		assertTrue(getByEmail.getAge().equals(user.getAge()));
		assertTrue(getByEmail.getEmail().equals(user.getEmail()));
		assertTrue(getByEmail.getRole().equals(user.getRole()));
	}
	
	@Test
	public void testGetByIdUser() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		User user = createUser();

		userRepository.save(user);

		users = userRepository.findAll();
		assertThat(users, hasSize(1));

		User getById = userService.getById(user.getId());

		assertTrue(getById.getFirstName().equals(user.getFirstName()));
		assertTrue(getById.getLastName().equals(user.getLastName()));
		assertTrue(getById.getAge().equals(user.getAge()));
		assertTrue(getById.getEmail().equals(user.getEmail()));
		assertTrue(getById.getRole().equals(user.getRole()));
	}
	
	@Test
	public void testFindByEmailUser() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		User user = createUser();

		userRepository.save(user);

		users = userRepository.findAll();
		assertThat(users, hasSize(1));

		assertTrue(userService.findByEmail(user.getEmail()));
	}
	
	User createUser() {
		User user = new User();
		user.setFirstName("1");
		user.setLastName("1");
		user.setAge(1);
		user.setEmail("1@gmail.com");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setRole(UserRole.ROLE_APPLICANT);
		
		return user;
	}

}