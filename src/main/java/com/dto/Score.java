package com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "score")
public class Score 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "scoreid")
	private int scoreid;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "examid")
	private int examid;
	
	@Column(name = "score")
	private int score;

	public Score() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getScoreid() {
		return scoreid;
	}

	public void setScoreid(int scoreid) {
		this.scoreid = scoreid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getExamid() {
		return examid;
	}

	public void setExamid(int examid) {
		this.examid = examid;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
