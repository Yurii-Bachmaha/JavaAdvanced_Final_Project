package project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dao.UserRepository;
import project.domain.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void save(User user) {
		userRepository.save(user);
	}
		
	public User getByEmail(String email) {
		User user = null;
    	Optional<User> findByEmail = userRepository.findByEmail(email);
    	if(findByEmail.isPresent()) {
    		user = findByEmail.get();
    	}
    	return user;
	}
	
	public boolean findByEmail(String email) {
    	return userRepository.findByEmail(email).isPresent();
    }

}