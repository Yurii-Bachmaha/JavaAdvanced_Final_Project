package project.service;

import project.domain.Evaluation;

public class EvaluationDTO {

	public static Evaluation createEvaluation(Integer firstSubject,Integer secondSubject,Integer thirdSubject,Integer sumSchoolsCerticifate) {
		
		Evaluation evaluation = new Evaluation();
		
		evaluation.setFirstSubject(firstSubject);
		evaluation.setSecondSubject(secondSubject);
		evaluation.setThirdSubject(thirdSubject);
		evaluation.setSumSchoolsCerticifate(sumSchoolsCerticifate);
		evaluation.setTotalGrades(firstSubject+secondSubject+thirdSubject+sumSchoolsCerticifate);
		
		return evaluation;
	}
	
}