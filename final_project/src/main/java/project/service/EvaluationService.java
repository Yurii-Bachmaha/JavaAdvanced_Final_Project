package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dao.EvaluationRepository;
import project.domain.Evaluation;

@Service
public class EvaluationService {

	@Autowired
	EvaluationRepository evaluationRepository;
	
	public List<Evaluation> findAll() {
		return  evaluationRepository.findAll();
	}
	
	public Evaluation add(Evaluation evaluation) {
		return evaluationRepository.save(evaluation);
	}
	
	public Evaluation update(Evaluation evaluation,Integer firstSubject, Integer secondSubject, Integer thirdSubject, Integer sumSchoolsCerticifate) {
		Evaluation subjectDB = evaluationRepository.getReferenceById(evaluation.getId());
		subjectDB.setFirstSubject(firstSubject);
		subjectDB.setSecondSubject(secondSubject);
		subjectDB.setThirdSubject(thirdSubject);
		subjectDB.setSumSchoolsCerticifate(sumSchoolsCerticifate);
		subjectDB.setTotalGrades(firstSubject + secondSubject + thirdSubject + sumSchoolsCerticifate);
		
		return evaluationRepository.save(subjectDB);
	}
	
	public void delete(Evaluation evaluation) {
		evaluationRepository.delete(evaluation);
	}
	
}