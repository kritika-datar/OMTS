package com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "questionid")
	private int questionid;
	
	@Column(name = "question")
	private String question;
	
	@Column(name = "optiona")
	private String optiona;
	
	@Column(name = "optionb")
	private String optionb;
	
	@Column(name = "optionc")
	private String optionc;
	
	@Column(name = "optiond")
	private String optiond;
	
	@ManyToOne
	@JoinColumn(name = "examid")
	private Exam exam;
	
	@OneToOne
	@JoinColumn(name = "answerid")
	private Answer answer;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getOptiona() {
		return optiona;
	}

	public void setOptiona(String optiona) {
		this.optiona = optiona;
	}

	public String getOptionb() {
		return optionb;
	}

	public void setOptionb(String optionb) {
		this.optionb = optionb;
	}

	public String getOptionc() {
		return optionc;
	}

	public void setOptionc(String optionc) {
		this.optionc = optionc;
	}

	public String getOptiond() {
		return optiond;
	}

	public void setOptiond(String optiond) {
		this.optiond = optiond;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
}
