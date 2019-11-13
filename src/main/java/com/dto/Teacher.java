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
@Table(name = "teacher")
public class Teacher 
{	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "teacherid")
	private int teacherid;

	@Column(name = "teachname")
	private String teachname;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "subject")
	private String subject;
	
	@ManyToOne
	@JoinColumn(name = "username")
	private Login login;

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}

	public String getTeachname() {
		return teachname;
	}

	public void setTeachname(String teachname) {
		this.teachname = teachname;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
}