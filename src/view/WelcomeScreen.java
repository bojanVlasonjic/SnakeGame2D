package view;


import java.io.IOException;

import javax.swing.JFrame;
import io.HighScoreIO;

@SuppressWarnings("serial")
public class WelcomeScreen extends JFrame {
	
	
	private int windowWidth = 300;
	private int windowHeight = 250;
	
	
	public WelcomeScreen() {
		
		readHighScores();
		
		this.setSize(windowWidth, windowHeight);
		this.setTitle("Snake game home");
		
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
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("Error loading high scores");
		}
		
	}
	

}
