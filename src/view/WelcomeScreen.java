package view;


import javax.swing.JFrame;

@SuppressWarnings("serial")
public class WelcomeScreen extends JFrame {
	
	
	private int windowWidth = 300;
	private int windowHeight = 250;
	
	public WelcomeScreen() {
		
		this.setSize(windowWidth, windowHeight);
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		WelcomePanel welcomePanel = new WelcomePanel();
		this.add(welcomePanel);
		
		
		this.setVisible(true);
		
	}
	
	public void hideScreen() {
		this.setVisible(false);
	}
	

}
