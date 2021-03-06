package view;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;

import auxiliary.Constants;
import model.Difficulty;
import model.Food;
import model.GrownSnake;
import model.SnakeComponent;


@SuppressWarnings("serial")
public class GameScreen extends JFrame {
	 
	
	private Map<Difficulty, Long> difficultySpeeds; //contains repaint time rate depending on the difficulty
	private Long repaintTimeRate;
	
	public static int windowHeight = 400;
	public static int windowWidth = 400;
	
	public static ScheduledThreadPoolExecutor executor; //executes the repainting of the screen
	
	public static Color backgroundColor = new Color(39, 41, 44);
	
	public static JLabel headerLabel;
	
	
	public GameScreen(Difficulty selectedDifficulty) {
		
		//setting the speed of the snake based on difficulty
		initDifficultyMap();
		repaintTimeRate = difficultySpeeds.get(selectedDifficulty);
		
		this.setSize(windowWidth+6, windowHeight+29);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		GamePanel panel = new GamePanel();
		panel = initPanelComponents(panel);
		this.add(panel);
		
		panel.setSelectedDifficulty(selectedDifficulty); //memorize the selected difficulty to use in the score
		
		addListeners(panel); //adding purpose to arrow keys for movement
		
		//repainting window every 60ms
		executor = new ScheduledThreadPoolExecutor(5);
		executor.scheduleAtFixedRate(new RepaintScreen(this), 0L, repaintTimeRate, TimeUnit.MILLISECONDS);

		// adding window on close event
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
	            executor.shutdown();
	            WelcomePanel.gameStarted = false;
	        }
		});
		
		this.setVisible(true);
	}
	
	
	public void initDifficultyMap() {
		
		this.difficultySpeeds = new HashMap<Difficulty, Long>();
		difficultySpeeds.put(Difficulty.EASY, 70L);
		difficultySpeeds.put(Difficulty.MEDIUM, 50L);
		difficultySpeeds.put(Difficulty.HARD, 30L);
		
	}
	
	
	public GamePanel initPanelComponents(GamePanel panel) {
		
		SnakeComponent snakeHead = new SnakeComponent(60, 60,
				Constants.componentLength, Constants.componentLength);
		
		panel.setFood(Food.getInstance());
		panel.getFood().setDefaultPosition(); //food is in center by default
		
		panel.setGrownSnake(new GrownSnake(snakeHead));
		
		headerLabel = new JLabel(Constants.SCORE_STR + 0);
		headerLabel.setForeground(Color.WHITE);
		panel.add(headerLabel);
		
		return panel;
		
	}
	
	public void addListeners(GamePanel panel) {
		
		/* ADDING MOVEMENT TO SNAKE */
		
		this.addKeyListener(new KeyListener() {
			
			private Long lastPressProcessed = 0L;

			@Override
			public void keyPressed(KeyEvent e) {
				
				// preventing the user from spamming buttons
				if(System.currentTimeMillis() - lastPressProcessed < repaintTimeRate-10L) {
					return;
				}
				
				switch(e.getKeyCode()) {
				
				case KeyEvent.VK_UP: { //Key code for UP: 38
					panel.setPrevKeyNum(panel.getKeyPressedNum()); //memorizing previous position
					panel.setKeyPressedNum(38); //the direction snake is headed in
					break;
				}
				
				case KeyEvent.VK_DOWN: { //Key code for DOWN: 40
					panel.setPrevKeyNum(panel.getKeyPressedNum());
					panel.setKeyPressedNum(40); 
					break;
				}
				
				case KeyEvent.VK_LEFT: { //Key code for LEFT: 37
					panel.setPrevKeyNum(panel.getKeyPressedNum());
					panel.setKeyPressedNum(37);
					break;
				}
				
				case KeyEvent.VK_RIGHT: { //Key code for RIGHT: 39
					panel.setPrevKeyNum(panel.getKeyPressedNum());
					panel.setKeyPressedNum(39);
					break;
				}
				
				}
				
				lastPressProcessed = System.currentTimeMillis();
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			
		});
	}
	
	

}
