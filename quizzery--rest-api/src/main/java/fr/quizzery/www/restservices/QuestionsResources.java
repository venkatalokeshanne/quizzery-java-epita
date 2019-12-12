package fr.quizzery.www.restservices;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.quizzery.www.entity.MCQChoice;
import fr.quizzery.www.entity.Questions;
import fr.quizzery.www.services.MCQChoicesDAO;
import fr.quizzery.www.services.QuestionDAO;


@Path("/questions/")
public class QuestionsResources {
	
	@Inject
	QuestionDAO questionDAO;
	
	@Inject
	MCQChoicesDAO mcqDAO;
	
	@POST
	@Path("/addQuestion")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createQuestion(@RequestBody Questions question) throws URISyntaxException {
		//create a question 
		questionDAO.create(question);
		return Response.ok(question).build();
	}
	
	
	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchQuestions(@QueryParam("qContent") String questionContent) {
		Questions questions = new Questions();
		questions.setQuestionContent(questionContent);
		//create a question 
		List<Questions> searchList = questionDAO.search(questions);
		System.out.println("searchList::"+searchList);
		return Response.ok(searchList).build();
	}	
	
	@POST
	@Path("/mcq")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMCQOptions(@RequestBody MCQChoice mcqChoices) throws URISyntaxException {
		System.out.println("mcqChoices::"+mcqChoices);
		mcqDAO.create(mcqChoices);
		return Response.ok(mcqChoices).build();
	}
	
	@DELETE
	  @Path("delete/{id}")
	  public Response deleteOrderById(@PathParam("id") int id) {
		System.out.println(id);
		Questions question = new Questions();
		question.setId(id); 
		questionDAO.delete(question);
	    return Response.ok().build();
	  }
	
	@GET
	@Path("/questionList")
	@Produces(MediaType.APPLICATION_JSON)
	public Response questionList() {
		Questions questions = new Questions();
		List<Questions> questionList= questionDAO.getQuestionList();
		return Response.ok(questionList).build();
		
	}
	
	@GET
	@Path("/getChoices")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchQuestions(@QueryParam("questionRef") Integer questionRef) {
		MCQChoice mcq = new MCQChoice();
		mcq.setQuestionRef(questionRef);
		//create a question 
		System.out.println("questionRef::"+questionRef);
		List<MCQChoice> searchList = mcqDAO.search(mcq);
		
		return Response.ok(searchList).build();
	}

}