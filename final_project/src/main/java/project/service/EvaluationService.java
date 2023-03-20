package project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dao.EvaluationRepository;
import project.domain.Evaluation;

@Service
public class EvaluationService {
	
	private Logger logger = LoggerFactory.getLogger(EvaluationService.class);

	@Autowired
	EvaluationRepository evaluationRepository;
	
	public List<Evaluation> findAll() {
		logger.info("All evaluations received");
		return  evaluationRepository.findAll();
	}
	
	public Evaluation add(Evaluation evaluation) {
		logger.info("Added new evaluations: "+ evaluation);
		return evaluationRepository.save(evaluation);
	}
	
	public Evaluation update(Evaluation evaluation,Integer firstSubject, Integer secondSubject, Integer thirdSubject, Integer sumSchoolsCerticifate) {
		Evaluation subjectDB = evaluationRepository.getReferenceById(evaluation.getId());
		subjectDB.setFirstSubject(firstSubject);
		subjectDB.setSecondSubject(secondSubject);
		subjectDB.setThirdSubject(thirdSubject);
		subjectDB.setSumSchoolsCerticifate(sumSchoolsCerticifate);
		subjectDB.setTotalGrades(firstSubject + secondSubject + thirdSubject + sumSchoolsCerticifate);
		logger.info("Updated evaluation items: " + evaluation + " to :" + subjectDB);
		
		return evaluationRepository.save(subjectDB);
	}
	
	public void delete(Evaluation evaluation) {
		logger.info("Evaluations "+ evaluation + " was successfully removed");
		evaluationRepository.delete(evaluation);
	}
	
}