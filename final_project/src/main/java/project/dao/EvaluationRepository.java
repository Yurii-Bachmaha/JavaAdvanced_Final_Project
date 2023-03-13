package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.domain.Evaluation;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Integer>{

}