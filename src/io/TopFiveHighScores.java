package io;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import auxiliary.Constants;
import auxiliary.HighScoreSorter;
import model.Difficulty;
import model.HighScore;

public class TopFiveHighScores {
	
	
	private List<HighScore> highScores;
	private static TopFiveHighScores instance = null; //singleton
	
	private HighScoreSorter sorter;
	
	
	private TopFiveHighScores() {
		
		this.highScores = new ArrayList<HighScore>();
		sorter = new HighScoreSorter();
		
	}
	
	/* SINGLETON */
	public static TopFiveHighScores getInstance() {
		
		if(instance == null) {
			instance = new TopFiveHighScores();
		}
		
		return instance;
		
	}
	
	
	public void addNewScore(Long score, Difficulty selectedDifficulty) {
		
		//if there are already five high scores
		if(this.highScores.size() >= Constants.HIGH_SCORES_NUM) {
			
			//see if the new one beats the last ranking one
			if(score > this.highScores.get(this.highScores.size()-1).getScore()) {
				this.highScores.remove(this.highScores.size()-1);
				this.highScores.add(new HighScore("unknown", score, selectedDifficulty, new Date()));
			}
		
		} else {
			this.highScores.add(new HighScore("unknown", score, selectedDifficulty, new Date()));
		}
		
		Collections.sort(this.highScores, sorter);
		
	}

	public List<HighScore> getHighScores() {
		return highScores;
	}

	public void setHighScores(List<HighScore> highScores) {
		this.highScores = highScores;
	}



}
