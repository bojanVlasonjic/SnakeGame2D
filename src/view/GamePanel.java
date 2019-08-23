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
	private int prevKeyNum = 0; //initially no previous keys were pressed
	
	//last positions of the snake's head before it took a turn
	private int headXPos;
	private int headYPos;
	
	
	
	protected void paintComponent(Graphics g) {
		
		Graphics2D graphicSettings = (Graphics2D)g;
		
		//coloring background
		graphicSettings.setColor(Color.BLACK);
		graphicSettings.fillRect(0,0, GameScreen.windowWidth, GameScreen.windowHeight);
		
		drawSnake(graphicSettings);
		
		drawFood(graphicSettings);
		
		//if the player tried to move the snake in the opposite direction
		if(this.keyPressedNum + GameScreen.movementSpeed == this.prevKeyNum ||
				this.keyPressedNum - GameScreen.movementSpeed == this.prevKeyNum) {
			
			this.keyPressedNum = this.prevKeyNum; //the snake will remain on the current direction
		}
		
		moveSnake();
		
		detectCollision(graphicSettings);
		
		
	}
	
	
	public void drawSnake(Graphics2D graphicSettings) {
		
		//coloring and drawing the Snake
		for(int i = 0; i < grownSnake.getSnakeList().size(); i++) {
			graphicSettings.setPaint(Color.WHITE);
			
			if(i == 0) {
				graphicSettings.fill(grownSnake.getSnakeList().get(i)); //head is colored
			} else {
				graphicSettings.draw(grownSnake.getSnakeList().get(i)); //body is not
			}
			
			graphicSettings.draw(grownSnake.getSnakeList().get(i));
		}		
		
	}
	
	public void drawFood(Graphics2D graphicSettings) {
		
		//coloring and drawing Food
		graphicSettings.setPaint(Color.RED);
		graphicSettings.fill(food);
		
	}
	
	
	public void detectCollision(Graphics2D graphicSettings) {
		
		//detecting collision between snake and food
		if(snakeHead.getBounds().intersects(food.getBounds())) {
			
			food.changePosition(); //food position changes every time the snake eats it
			
			//increasing snake length
			SnakeComponent newComponent = new SnakeComponent();
			grownSnake.increaseLength(newComponent, keyPressedNum);
			
		}
		
	}
	
	public void moveSnake() {
		
		//adding movement to snake
		switch(keyPressedNum) {
			case 40: { //DOWN
				//snakeHead.increaseYPos();
				for(int i = 0; i < grownSnake.getSnakeList().size(); i++) {
					grownSnake.getSnakeList().get(i).increaseYPos();
				}
				break;
			}
		
			case 38: { //UP
				//snakeHead.decreaseYPos();
				for(int i = 0; i < grownSnake.getSnakeList().size(); i++) {
					grownSnake.getSnakeList().get(i).decreaseYPos();
				}
				break;
			}
		
			case 39: { //RIGHT
				//snakeHead.increaseXPos();
				for(int i = 0; i < grownSnake.getSnakeList().size(); i++) {
					grownSnake.getSnakeList().get(i).increaseXPos();
				}
				break;
			}
		
			case 37: { //LEFT
				for(int i = 0; i < grownSnake.getSnakeList().size(); i++) {
					grownSnake.getSnakeList().get(i).decreaseXPos();
				}
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
