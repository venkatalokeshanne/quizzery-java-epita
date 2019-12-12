package fr.quizzery.www.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MCQChoices")
public class MCQChoice{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Integer optionId;
	
	@Column(name="questionRef")
	private Integer questionRef;
	
	@Column(name="choice")
	private String choice;
	
	@Column(name="valid")
	private Boolean valid;

	public Integer getOptionId() {
		return optionId;
	}

	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}

	public Integer getQuestionRef() {
		return questionRef;
	}

	public void setQuestionRef(Integer questionRef) {
		this.questionRef = questionRef;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public MCQChoice(Integer optionId, Integer questionRef, String choice, Boolean valid) {
		this.optionId = optionId;
		this.questionRef = questionRef;
		this.choice = choice;
		this.valid = valid;
	}

	public MCQChoice() {
		// TODO Auto-generated constructor stub
	}

	

	
	
	
	
	

}
