package www.quizzeryTests.www.session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.quizzery.www.entity.Questions;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationcontext.xml")
public class TestJPAEM {

	@PersistenceContext
	EntityManager em;
	
	
	@Test
	@Transactional
	public void testEM() {
		String questionContent = "What is Dependency Injection ?";
		Questions question = new Questions(questionContent);

		persistQuestion(question);
		
		Questions retrievedQuestion = em.find(Questions.class, question.getId());
		
		Assert.assertNotNull(retrievedQuestion);
		Assert.assertEquals(questionContent, retrievedQuestion.getQuestionContent());
		
		
		
	}


	@Transactional(value=Transactional.TxType.REQUIRES_NEW)
	private void persistQuestion(Questions question) {
		em.persist(question);
	}
	
}