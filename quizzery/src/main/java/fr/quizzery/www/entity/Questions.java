package fr.quizzery.www.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Questions")
public class Questions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Integer id;
	
	@Column(name="content")
	private String questionContent;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}


	public Questions(String questionContent) {
		
	}

	public Questions() {
	}

}
