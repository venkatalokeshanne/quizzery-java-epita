package fr.quizzery.www.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import fr.quizzery.www.entity.Questions;

@Repository
public class QuestionDAO extends GenericDAO<Questions>{

	@Override
	protected void getParameters(Map<String, Object> parameters, Questions question) {
		// TODO Auto-generated method stub
		parameters.put("pContent", question.getQuestionContent());
	}

	@Override
	protected String getQueryString() {
		// TODO Auto-generated method stub
		return "from Questions q where q.questionContent like :pContent";
	}

	@Override
	protected String getQuestionQueryString() {
		// TODO Auto-generated method stub
		return "from Questions ";
	}

	@Override
	protected void getParametersChoice(Map<Integer, Object> parameters, Questions criteria) {
		// TODO Auto-generated method stub
		
	}

	

}
