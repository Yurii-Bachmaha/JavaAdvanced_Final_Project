package project.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dao.CertificateRepository;
import project.domain.Certificate;

@Service
public class CertificateService {
	
	private Logger logger = LoggerFactory.getLogger(CertificateService.class);

	@Autowired
	CertificateRepository certificateRepository;
	
	public List<Certificate> getAll(){
		logger.info("All certificates received");
		return certificateRepository.findAll();
	}
	
	public Certificate add(Certificate certificate) {
		logger.info("A new certificate has been created: "+ certificate);
		return certificateRepository.save(certificate);
	}
	
	public Certificate getByUserId(Integer userId) {
		List<Certificate> certificates = certificateRepository.findAll();
		Certificate certificate = null;
	
		Optional<Certificate> certificateOpt = certificates.stream().filter(x->x.getUser().getId().equals(userId)).findFirst();
		if(certificateOpt.isPresent()) {
			certificate = certificateOpt.get();
		}
		
		return  certificate;
	}
	
	public void delete(Certificate certificate) {
		logger.info("Certificate "+ certificate + " was successfully removed");
		certificateRepository.delete(certificate);
	}
	
}