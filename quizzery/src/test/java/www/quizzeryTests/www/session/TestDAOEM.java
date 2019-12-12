package www.quizzeryTests.www.session;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.quizzery.www.entity.Questions;
import fr.quizzery.www.services.QuestionDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationcontext.xml")
public class TestDAOEM {
	
	@Inject
	QuestionDAO questionDAO;
	
	@PersistenceContext
	EntityManager em;
	
	@Test
	public void save() {
		
		Questions question = new Questions("How are you");
		
		questionDAO.create(question);
		System.out.println("ID::"+question.getId());
		
		Assert.assertNotNull(em.find(Questions.class, question.getId()));
		
	}

}
