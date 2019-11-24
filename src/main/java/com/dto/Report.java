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
@Table(name = "report")
public class Report 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "reportid")
	private int reportid;
	
	@Column(name = "score")
	private int score;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "examid")
	private Exam exam;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "studentid")
	private Student student;

	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public int getReportid() {
		return reportid;
	}

	public void setReportid(int reportid) {
		this.reportid = reportid;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
