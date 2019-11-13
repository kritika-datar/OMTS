package com.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student 
{	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="studentid")
	private int studentid;
	
	@Column(name = "eno")
	private String eno;
	
	@Column(name = "rollno")
	private String rollno;

	@Column(name = "studname")
	private String studname;
		
	@Column(name = "course")
	private String course;
	
	@Column(name = "semester")
	private int semester;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
	private Set<Answer> answers;
	
	@OneToMany(mappedBy = "student",fetch = FetchType.EAGER)
	private Set<Report> reports;
	
	@ManyToOne
	@JoinColumn(name = "username")
	private Login login;
	
	public Student() {
		super();
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public String getEno() {
		return eno;
	}

	public void setEno(String eno) {
		this.eno = eno;
	}

	public Set<Report> getReports() {
		return reports;
	}

	public void setReports(Set<Report> reports) {
		this.reports = reports;
	}

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getStudname() {
		return studname;
	}

	public void setStudname(String studname) {
		this.studname = studname;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
}