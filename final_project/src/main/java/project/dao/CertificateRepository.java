package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.domain.Certificate;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer> {

}