package project.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dao.UserRepository;
import project.domain.User;

@Service
public class UserService {
	
	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	public void save(User user) {
		logger.info("User " + user + " successfully added");
		userRepository.save(user);
	}
		
	public User getByEmail(String email) {
		logger.info("User received by email: " + email);
		User user = null;
    	Optional<User> findByEmail = userRepository.findByEmail(email);
    	if(findByEmail.isPresent()) {
    		user = findByEmail.get();
    	}
    	return user;
	}
	
	public boolean findByEmail(String email) {
		logger.info("Found user by email field: " + email);
    	return userRepository.findByEmail(email).isPresent();
    }
	
	public User getById(Integer userId) {
    	return userRepository.getReferenceById(userId);
    }

}