package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import model.Difficulty;

@SuppressWarnings("serial")
public class WelcomePanel extends JPanel {
	
	
	private Font defaultFont;
	private Font headerFont;
	
	public static boolean gameStarted = false;
	public static boolean scoresShown = false;
	
	
	public WelcomePanel() {
		
		this.defaultFont = new Font("Tahoma", Font.PLAIN, 12);
		this.headerFont = new Font("Tahoma", Font.BOLD, 16);
		
		this.setBackground(GameScreen.backgroundColor);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(Box.createRigidArea(new Dimension(0, 15))); //setting spacing
		
		//Creating header
		JLabel headerLabel = createLabel("Snake Game 2D", headerFont);
		this.add(headerLabel);
		this.add(Box.createRigidArea(new Dimension(0, 15))); //setting spacing
		
		//Creating start game button
		JButton startGameBtn = createButton("START GAME");
		
		this.add(startGameBtn);
		this.add(Box.createRigidArea(new Dimension(0, 15))); //setting spacing
		
		//Creating difficulty combobox
		JComboBox<Difficulty> difficultyBox = initDifficulty();
		this.add(difficultyBox);
		this.add(Box.createRigidArea(new Dimension(0, 15))); //setting spacing
		
		addStartListener(startGameBtn, difficultyBox); //adding start game event
		
		//Creating high score button
		JButton highScoresBtn = createButton("HIGH SCORES");
		this.add(highScoresBtn);
		
		addHighScoreListener(highScoresBtn);
		
	}
	
	
	public JLabel createLabel(String title, Font font) {
		
		JLabel label = new JLabel(title);
		
		label.setFont(font);
		label.setForeground(Color.white);
		label.setAlignmentX(CENTER_ALIGNMENT);
		
		return label;
		
	}
	
	
	public JButton createButton(String text) {
		
		JButton button = new JButton(text);
		
		button.setFont(defaultFont);
		button.setAlignmentX(CENTER_ALIGNMENT);
		button.setBackground(GameScreen.backgroundColor);
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
		
		return button;
		
		
	}
	
	public void addStartListener(JButton startGameBtn, JComboBox<Difficulty> difficultyBox) {
		
		startGameBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!WelcomePanel.gameStarted) {
					new GameScreen((Difficulty) difficultyBox.getSelectedItem());
					gameStarted = true;
				} else {
					JOptionPane.showMessageDialog(null, 
							"There is already a game instance running. Please close it to proceed.");
				}
				
				
			}
		});
	}
	
	public void addHighScoreListener(JButton highScoreBtn) {
		
		highScoreBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!scoresShown) {
					new HighScoreScreen();
					scoresShown = true;
				} else {
					JOptionPane.showMessageDialog(null,
							"The scores have already been displayed.");
				}
				
			}
			
		});
		
	}
	
	public JComboBox<Difficulty> initDifficulty() {
		
		JComboBox<Difficulty> difficultyBox = new JComboBox<Difficulty>(Difficulty.values());
		difficultyBox.setSelectedItem(Difficulty.MEDIUM);
		
		//adding a titled border
		TitledBorder title = BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), "Select difficulty");
		title.setTitleColor(Color.WHITE);
		title.setTitleFont(defaultFont);
		title.setTitleJustification(TitledBorder.CENTER);
		
		difficultyBox.setBorder(title);
		difficultyBox.setBackground(GameScreen.backgroundColor);
		difficultyBox.setForeground(Color.WHITE);
		difficultyBox.setMaximumSize(new Dimension(120, 50));
		difficultyBox.setFocusable(false);
		
		this.add(difficultyBox);
		
		return difficultyBox;
		
		
	}
	
}
