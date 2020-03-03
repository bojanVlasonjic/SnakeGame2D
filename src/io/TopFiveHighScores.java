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
	
	
	public boolean isHighScore(Long score) {

		if(this.highScores.size() < Constants.HIGH_SCORES_NUM ||
				score > this.highScores.get(this.highScores.size()-1).getScore()) {
			return true;
		}

		return false;

	}


	public void addNewScore(Long score, Difficulty selectedDifficulty) {

		// the number of high scores is filled up
		if(this.highScores.size() >= Constants.HIGH_SCORES_NUM) {
			this.highScores.remove(this.highScores.size()-1);
		} 
		
		this.highScores.add(new HighScore("unknown", score, selectedDifficulty, new Date()));
		Collections.sort(this.highScores, sorter);

	}


	public List<HighScore> getHighScores() {
		return highScores;
	}

	public void setHighScores(List<HighScore> highScores) {
		this.highScores = highScores;
	}



}
