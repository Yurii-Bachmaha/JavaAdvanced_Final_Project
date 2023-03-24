package project.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import project.domain.User;
import project.domain.UserRole;

public class UserDTO {

	public static User createUser( String firstName, String lastName, String email,Integer age, String password, String passwordConfirm, MultipartFile encodedImage) throws IOException {
		User user = new User();
		PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAge(age);
		user.setEmail(email);
		user.setPassword(bCryptPasswordEncoder.encode(password));
		user.setPasswordConfirm(bCryptPasswordEncoder.encode(passwordConfirm));
		user.setEncodedImage(Base64.getEncoder().encodeToString(encodedImage.getBytes()));
		user.setRole(UserRole.ROLE_APPLICANT);
		
		return user;
	}
	
}