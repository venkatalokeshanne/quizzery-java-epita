package fr.quizzery.www.services;

import java.util.Map;

import org.springframework.stereotype.Repository;

import fr.quizzery.www.entity.MCQChoice;


public class MCQChoicesDAO extends GenericDAO<MCQChoice>{

	@Override
	protected void getParametersChoice(Map<Integer, Object> parameters, MCQChoice criteria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void getParameters(Map<String, Object> parameters, MCQChoice criteria) {
		// TODO Auto-generated method stub
		
		parameters.put("question", criteria.getQuestionRef());
		
	}

	@Override
	protected String getQueryString() {
		// TODO Auto-generated method stub
		System.out.println();
		return "from MCQChoice where questionRef = :question";
	}

	@Override
	protected String getQuestionQueryString() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
