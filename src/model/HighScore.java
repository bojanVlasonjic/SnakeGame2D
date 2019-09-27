package model;

import java.io.Serializable;
import java.util.Date;

public class HighScore implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private Long score;
	private Difficulty difficulty;
	private Date date;
	
	public HighScore() {
		
	}

	public HighScore(String userName, Long score, Difficulty difficulty, Date date) {
		
		this.userName = userName;
		this.score = score;
		this.difficulty = difficulty;
		this.date = date;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		
		return this.userName + "; " + this.score + "; " + this.date + "; " + this.difficulty;
	}
	

}
