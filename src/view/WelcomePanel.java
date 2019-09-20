package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Difficulty;

@SuppressWarnings("serial")
public class WelcomePanel extends JPanel {
	
	
	private Font defaultFont;
	private Font headerFont;
	
	
	public WelcomePanel() {
		
		this.defaultFont = new Font("Tahoma", Font.PLAIN, 12);
		this.headerFont = new Font("Tahoma", Font.BOLD, 16);
		
		this.setBackground(Color.black);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(Box.createRigidArea(new Dimension(0, 15))); //setting spacing
		
		//Creating header
		JLabel headerLabel = createLabel("Snake Game 2D", headerFont);
		this.add(headerLabel);
		this.add(Box.createRigidArea(new Dimension(0, 15))); //setting spacing
		
		//Creating start game button
		JButton startGameBtn = createButton("Start game");
		
		this.add(startGameBtn);
		this.add(Box.createRigidArea(new Dimension(0, 15))); //setting spacing
		
		//Creating difficulty combobox
		JComboBox<Difficulty> difficultyBox = initDifficulty();
		this.add(difficultyBox);
		
		addStartListener(startGameBtn, difficultyBox); //adding start game event
		
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
		button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
		
		return button;
		
		
	}
	
	public void addStartListener(JButton startGameBtn, JComboBox<Difficulty> difficultyBox) {
		
		startGameBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new GameScreen((Difficulty) difficultyBox.getSelectedItem());
				
			}
		});
	}
	
	public JComboBox<Difficulty> initDifficulty() {
		
		this.add(createLabel("Select difficulty", defaultFont));
		
		JComboBox<Difficulty> difficultyBox = new JComboBox<Difficulty>(Difficulty.values());
		difficultyBox.setSelectedItem(Difficulty.MEDIUM);
		
		difficultyBox.setAlignmentX(CENTER_ALIGNMENT);
		difficultyBox.setBackground(Color.BLACK);
		difficultyBox.setForeground(Color.WHITE);
		difficultyBox.setMaximumSize(new Dimension(100, 25));
		difficultyBox.setFocusable(false);
		
		this.add(difficultyBox);
		
		return difficultyBox;
		
		
	}
	
}
