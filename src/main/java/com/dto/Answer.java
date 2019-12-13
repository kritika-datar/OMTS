package com.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class Answer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "answerid")
	private int answerid;
	
	@Column(name = "recordedanswer")
	private String recordedanswer;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "username")
	private Login login;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "questionid")
	private Question question;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "examid")
	private Exam exam;

	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAnswerid() {
		return answerid;
	}

	public void setAnswerid(int answerid) {
		this.answerid = answerid;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public String getRecordedanswer() {
		return recordedanswer;
	}

	public void setRecordedanswer(String recordedanswer) {
		this.recordedanswer = recordedanswer;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
}
