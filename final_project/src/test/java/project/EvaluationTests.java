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

import project.dao.EvaluationRepository;
import project.domain.Evaluation;
import project.service.EvaluationService;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@ComponentScan(basePackages = {"project"})
public class EvaluationTests {

	@Autowired
	EvaluationService evaluationService;
	
	@Autowired
	EvaluationRepository evaluationRepository;
	
	@BeforeEach
	void clear() {
		evaluationRepository.deleteAll();
	}
	
	@Test
	public void testAddEvaluations() {
		List<Evaluation> evaluations = evaluationRepository.findAll();
		assertThat(evaluations, hasSize(0));
		
		Evaluation evaluation = new Evaluation();
		evaluation.setFirstSubject(100);
		evaluation.setSecondSubject(100);
		evaluation.setThirdSubject(100);
		evaluation.setSumSchoolsCerticifate(100);
		evaluation.setTotalGrades(400);
		
		evaluationService.add(evaluation);
		
		evaluations = evaluationRepository.findAll();
		assertThat(evaluations, hasSize(1));
		
		Evaluation evaluationFromDB = evaluations.get(0);
		
		assertTrue(evaluation.getFirstSubject().equals(evaluationFromDB.getFirstSubject()));
		assertTrue(evaluation.getSecondSubject().equals(evaluationFromDB.getSecondSubject()));
		assertTrue(evaluation.getThirdSubject().equals(evaluationFromDB.getThirdSubject()));
		assertTrue(evaluation.getSumSchoolsCerticifate().equals(evaluationFromDB.getSumSchoolsCerticifate()));
		assertTrue(evaluation.getTotalGrades().equals(evaluationFromDB.getTotalGrades()));
	}
	
	@Test
	public void testDeleteSubjectsGrades() {
		List<Evaluation> evaluations = evaluationRepository.findAll();
		assertThat(evaluations, hasSize(0));
		
		Evaluation evaluation1 = new Evaluation();
		evaluation1.setFirstSubject(100);
		evaluation1.setSecondSubject(100);
		evaluation1.setThirdSubject(100);
		evaluation1.setSumSchoolsCerticifate(100);
		evaluation1.setTotalGrades(400);
		
		Evaluation evaluation2 = new Evaluation();
		evaluation2.setFirstSubject(75);
		evaluation2.setSecondSubject(75);
		evaluation2.setThirdSubject(75);
		evaluation2.setSumSchoolsCerticifate(75);
		evaluation2.setTotalGrades(300);
		
		evaluationService.add(evaluation1);
		evaluationService.add(evaluation2);
		
		evaluations = evaluationRepository.findAll();
		assertThat(evaluations, hasSize(2));
		
		evaluationService.delete(evaluation1);
		
		evaluations = evaluationRepository.findAll();
		assertThat(evaluations, hasSize(1));
		
		evaluation1 = evaluations.get(0);
		
		assertTrue(evaluation1.getFirstSubject().equals(evaluation2.getFirstSubject()));
		assertTrue(evaluation1.getSecondSubject().equals(evaluation2.getSecondSubject()));
		assertTrue(evaluation1.getThirdSubject().equals(evaluation2.getThirdSubject()));
		assertTrue(evaluation1.getSumSchoolsCerticifate().equals(evaluation2.getSumSchoolsCerticifate()));
	}
	
}