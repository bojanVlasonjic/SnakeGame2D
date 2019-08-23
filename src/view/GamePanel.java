package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import model.Food;
import model.GrownSnake;
import model.SnakeComponent;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	
	private SnakeComponent snakeHead; //head of the snake
	private Food food;
	private GrownSnake grownSnake = new GrownSnake(snakeHead); //whole snake
	
	private int keyPressedNum = 0; //initially no keys were pressed
	private int prevKeyNum = 0; //initially no previous was pressed
	
	protected void paintComponent(Graphics g) {
		
		Graphics2D graphicSettings = (Graphics2D)g;
		
		//coloring background
		graphicSettings.setColor(Color.BLACK);
		graphicSettings.fillRect(0,0, GameScreen.windowWidth, GameScreen.windowHeight);
		
		//coloring and drawing Snake's head
		graphicSettings.setPaint(Color.WHITE);
		graphicSettings.fill(snakeHead);
		
		//coloring and drawing Food
		graphicSettings.setPaint(Color.RED);
		graphicSettings.fill(food);
		
		//if the player tried to move the snake in the opposite direction
		if(this.keyPressedNum + GameScreen.movementSpeed == this.prevKeyNum ||
				this.keyPressedNum - GameScreen.movementSpeed == this.prevKeyNum) {
			
			this.keyPressedNum = this.prevKeyNum; //the snake will remain on the current direction
		}
		
		moveSnake();
		
		
		
	
		//detecting collision between snake and food
		if(snakeHead.getBounds().intersects(food.getBounds())) {
			food.changePosition(); //food position changes every time the snake eats it
			
			//TODO: increase snake size
			//SnakeComponent body = new SnakeComponent();
			//grownSnake.increaseLength(body, keyHeldNum);
			
		}
		
	}
	
	public void moveSnake() {
		
		//adding movement to snake
		switch(keyPressedNum) {
			case 40: { //DOWN
				snakeHead.increaseYPos();
				break;
			}
		
			case 38: { //UP
				snakeHead.decreaseYPos();
				break;
			}
		
			case 39: { //RIGHT
				snakeHead.increaseXPos();
				break;
			}
		
			case 37: { //LEFT
				snakeHead.decreaseXPos();
				break;
			}
		}
		
	}
	
	
	/* GETTERS AND SETTERS */


	public SnakeComponent getSnakeHead() {
		return snakeHead;
	}

	public void setSnakeHead(SnakeComponent snakeHead) {
		this.snakeHead = snakeHead;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public GrownSnake getGrownSnake() {
		return grownSnake;
	}

	public void setGrownSnake(GrownSnake grownSnake) {
		this.grownSnake = grownSnake;
	}

	public int getKeyPressedNum() {
		return keyPressedNum;
	}

	public void setKeyPressedNum(int keyPressedNum) {
		this.keyPressedNum = keyPressedNum;
	}

	public int getPrevKeyNum() {
		return prevKeyNum;
	}

	public void setPrevKeyNum(int prevKeyNum) {
		this.prevKeyNum = prevKeyNum;
	}


}
