package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import project.domain.ApplicationForm;

public interface ApplicationFormRepository extends JpaRepository<ApplicationForm, Integer> {

}