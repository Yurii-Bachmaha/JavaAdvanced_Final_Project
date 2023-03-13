package project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dao.CertificateRepository;
import project.domain.Certificate;

@Service
public class CertificateService {

	@Autowired
	CertificateRepository certificateRepository;
	
	public List<Certificate> getAll(){
		return certificateRepository.findAll();
	}
	
	public Certificate add(Certificate certificate) {
		return certificateRepository.save(certificate);
	}
	
	public Certificate getByUserId(Integer userId) {
		List<Certificate> certificates = certificateRepository.findAll();
		Certificate certificate = null;
	
		Optional<Certificate> certificateOpt = certificates.stream().filter(x->x.getUser().getId().equals(userId)).findFirst();
		if(certificateOpt.isPresent()) {
			certificate = certificateOpt.get();
		}
		
		return  certificate ;
	}
	
}