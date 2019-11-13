package com.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "login")
public class Login implements java.io.Serializable
{	
	@Id
//	@GeneratedValue(generator = "assigned")
//	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "username", length = 45)
	private String username;
	
	@Column(name = "type", length = 45)
	private String type;
	
	@Column(name = "password", length = 45)
	private String password;
	
	@OneToMany(mappedBy = "login", fetch = FetchType.EAGER)
	private Set<Student> students;
	
	@OneToMany(mappedBy = "login", fetch = FetchType.EAGER)
	private Set<Teacher> teachers;
	
	@OneToMany(mappedBy = "login", fetch = FetchType.EAGER)
	private Set<Exam> exams;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(String username) {
		super();
		this.username = username;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Set<Exam> getExams() {
		return exams;
	}

	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}
}
