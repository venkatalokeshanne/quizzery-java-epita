package www.quizzeryTests.www.session;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.quizzery.www.entity.Questions;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationcontext.xml")
public class SessionTest {
	
	@Inject
	SessionFactory sessionFactory;  
	
	
	@Test
	public void sessionTest(){
		
		String questionContent="Enter Your name";
		Questions question = new Questions(questionContent);
		
		Session session = sessionFactory.openSession();
		session.save(question);
		
		Questions retrievedQuestion = session.get(Questions.class, question.getId());
		Assert.assertEquals(questionContent,retrievedQuestion.getQuestionContent());
		
		
		
		
		
	}

}
