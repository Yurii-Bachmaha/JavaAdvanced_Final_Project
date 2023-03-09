package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.domain.ApplicationForm;

@Repository
public interface ApplicationFormRepository extends JpaRepository<ApplicationForm, Integer> {

}