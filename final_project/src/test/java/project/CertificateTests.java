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

import project.dao.CertificateRepository;
import project.dao.EvaluationRepository;
import project.dao.UserRepository;
import project.domain.Certificate;
import project.domain.Evaluation;
import project.domain.User;
import project.domain.UserRole;
import project.service.CertificateService;
import project.service.EvaluationService;
import project.service.UserService;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@ComponentScan(basePackages = {"project"})
public class CertificateTests {
	
	@Autowired
	private CertificateService certificateService;
	
	@Autowired
	private CertificateRepository certificateRepository;
	
	@Autowired
	private EvaluationService evaluationService;
	
	@Autowired
	private EvaluationRepository evaluationRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@BeforeEach
	void clear() {
		userRepository.deleteAll();
		certificateRepository.deleteAll();
		evaluationRepository.deleteAll();
	}
	
	@Test
	public void testAddCertificate() {
		List<Certificate> certificates = certificateRepository.findAll();
		assertThat(certificates, hasSize(0));
		
		Evaluation evaluation = createEvaluation1();
		
		evaluationService.add(evaluation);
		
		User user = createUser1();
		
		userService.save(user);
		
		Certificate certificate = new Certificate();
		
		certificate.setEvaluation(evaluation);
		certificate.setUser(user);
		
		certificateService.add(certificate);
		
		certificates = certificateRepository.findAll();
		assertThat(certificates, hasSize(1));
		
		Certificate certificateDB = certificates.get(0);
		
		assertTrue(certificate.getUser().equals(certificateDB.getUser()));
		assertTrue(certificate.getEvaluation().equals(certificateDB.getEvaluation()));
	}
	
	@Test
	public void testGetByUserId() {
		List<Certificate> certificates = certificateRepository.findAll();
		assertThat(certificates, hasSize(0));
		
		Evaluation evaluation = createEvaluation1();
		
		evaluationService.add(evaluation);
		
		User user = createUser1();
		
		userService.save(user);
		
		Certificate certificate = new Certificate();
		
		certificate.setEvaluation(evaluation);
		certificate.setUser(user);
		
		certificateService.add(certificate);
		
		certificates = certificateRepository.findAll();
		assertThat(certificates, hasSize(1));
		
		Certificate certificateDB = certificateService.getByUserId(user.getId());
		
		assertTrue(certificate.getUser().equals(certificateDB.getUser()));
		assertTrue(certificate.getEvaluation().equals(certificateDB.getEvaluation()));
	}
	
	@Test
	public void testDeleteCertificate() {
		List<Certificate> certificates = certificateRepository.findAll();
		assertThat(certificates, hasSize(0));
		
		Evaluation evaluation1 = createEvaluation1();
		
		Evaluation evaluation2 = createEvaluation2();
		
		evaluationService.add(evaluation1);
		evaluationService.add(evaluation2);
		
		User user1 = createUser1();
		
		User user2 = createUser2();
		
		userService.save(user1);
		userService.save(user2);
		
		Certificate certificate1 = new Certificate();
		Certificate certificate2 = new Certificate();
		
		certificate1.setEvaluation(evaluation1);
		certificate1.setUser(user1);
		
		certificate2.setEvaluation(evaluation2);
		certificate2.setUser(user2);
		
		certificateService.add(certificate1);
		certificateService.add(certificate2);
		
		certificates = certificateRepository.findAll();
		assertThat(certificates, hasSize(2));
		
		certificateService.delete(certificate2);
		
		certificates = certificateRepository.findAll();
		assertThat(certificates, hasSize(1));
		
		Certificate certificateDB = certificates.get(0);
		
		assertTrue(certificate1.getUser().equals(certificateDB.getUser()));
		assertTrue(certificate1.getEvaluation().equals(certificateDB.getEvaluation()));
	}
	
	Evaluation createEvaluation1() {
		Evaluation evaluation1 = new Evaluation();
		evaluation1.setFirstSubject(100);
		evaluation1.setSecondSubject(100);
		evaluation1.setThirdSubject(100);
		evaluation1.setSumSchoolsCerticifate(100);
		evaluation1.setTotalGrades(400);
		
		return evaluation1;
	}
	
	Evaluation createEvaluation2() {
		Evaluation evaluation2 = new Evaluation();
		evaluation2.setFirstSubject(50);
		evaluation2.setSecondSubject(50);
		evaluation2.setThirdSubject(50);
		evaluation2.setSumSchoolsCerticifate(50);
		evaluation2.setTotalGrades(200);
		
		return evaluation2;
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

}