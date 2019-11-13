package com.dto;

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
	
	@Column(name = "answer")
	private String answer;
	
	@ManyToOne
	@JoinColumn(name = "studentid")
	private Student student;

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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
