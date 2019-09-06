package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import model.Food;
import model.GrownSnake;
import model.SnakeComponent;


@SuppressWarnings("serial")
public class GameScreen extends JFrame {
	
	
	public static final Long repaintTimeRate = 60L;
	
	public static int windowHeight = 400;
	public static int windowWidth = 400;
	
	public static int componentLength = 10; //food and snake size
	
	public static ScheduledThreadPoolExecutor executor;
	
	
	public GameScreen() {
		
		this.setSize(windowWidth, windowHeight);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		GamePanel panel = new GamePanel();
		panel = initPanelComponents(panel);
		this.add(panel);
		
		addListeners(panel); //adding purpose to arrow keys for movement
		
		//repainting window every 60ms
		executor = new ScheduledThreadPoolExecutor(5);
		executor.scheduleAtFixedRate(new RepaintScreen(this), 0L, repaintTimeRate, TimeUnit.MILLISECONDS);

		this.setVisible(true);
	}
	
	
	public GamePanel initPanelComponents(GamePanel panel) {
		
		SnakeComponent snakeHead = new SnakeComponent(60, 60, componentLength, componentLength);
		
		panel.setFood(Food.getInstance());
		panel.setGrownSnake(new GrownSnake(snakeHead));
		
		return panel;
		
	}
	
	public void addListeners(GamePanel panel) {
		
		/* ADDING MOVEMENT TO SNAKE */
		
		this.addKeyListener(new KeyListener() {
			
			private Long lastPressProcessed = 0L;

			@Override
			public void keyPressed(KeyEvent e) {
				
				//preventing the user from spamming buttons
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
