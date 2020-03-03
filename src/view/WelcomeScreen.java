package view;


import java.io.IOException;

import javax.swing.JFrame;

import io.HighScoreIO;
import io.TopFiveHighScores;
import model.HighScore;

@SuppressWarnings("serial")
public class WelcomeScreen extends JFrame {
	
	
	private int windowWidth = 300;
	private int windowHeight = 250;
	
	public WelcomeScreen() {
		
		readHighScores();
		
		this.setSize(windowWidth, windowHeight);
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		WelcomePanel welcomePanel = new WelcomePanel();
		this.add(welcomePanel);
		
		
		this.setVisible(true);
		
	}
	
	public void readHighScores() {
		
		try {
			HighScoreIO.readHighScores();
			System.out.println("High scores loaded");
			printHighScores();
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("Error loading high scores");
		}
		
	}
	
	public void printHighScores() {
		
		for (HighScore score : TopFiveHighScores.getInstance().getHighScores()) {
			System.out.println(score.toString());
		}
		
	}

}
