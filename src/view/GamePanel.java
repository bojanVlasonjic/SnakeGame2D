package view;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Direction;
import model.Food;
import model.GrownSnake;
import model.SnakeComponent;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	
	private Food food;
	private GrownSnake grownSnake; //whole snake
	
	private int keyPressedNum = 0; //initially no keys were pressed
	private int prevKeyNum = 0; //initially no previous keys were pressed
	
	
	protected void paintComponent(Graphics g) {
		
		Graphics2D graphicSettings = (Graphics2D)g;
		
		//coloring background
		graphicSettings.setColor(Color.BLACK);
		graphicSettings.fillRect(0, 0, GameScreen.windowWidth, GameScreen.windowHeight);
		
		
		drawSnake(graphicSettings);
		
		drawFood(graphicSettings);
		
		//if the player tried to move the snake in the opposite direction (opposite for 38 is 40, opposite for 37 is 39)
		if(this.keyPressedNum + 2 == this.prevKeyNum ||
				this.keyPressedNum - 2 == this.prevKeyNum) {
			
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
	
	//detects collision between snake components or snake head and it's food
	public void detectCollision(Graphics2D graphicSettings) {
		
		//detecting collision between snake and food
		if(grownSnake.getSnakeList().get(0).getBounds().intersects(food.getBounds())) {
			
			food.changePosition(); //food position changes every time the snake eats it
			
			//increasing snake length
			grownSnake.increaseLength(new SnakeComponent());
			
		}
		
		//there have to be at least 4 rectangles to be able to intersect
		if(grownSnake.getSnakeList().size() > 3) {
			
			for(int i = 1; i < grownSnake.getSnakeList().size(); i++) {
				if(grownSnake.getSnakeList().get(0).intersects(grownSnake.getSnakeList().get(i))) {
					GameScreen.executor.shutdown();
					JOptionPane.showMessageDialog(null, "Game over");
					System.exit(1);
					return;
				}
			}
			
		}
		
	}
	
	public void moveSnake() {
		
		//in the initial state the snake does not move
		if(grownSnake.getSnakeList().get(0).getDirection() == 0 && this.keyPressedNum == 0) {
			return;
		} 
		
		//if the direction changed
		if(grownSnake.getSnakeList().get(0).getDirection() != this.keyPressedNum) {
			
			grownSnake.getSnakeList().get(0).setDirection(this.keyPressedNum);
			
			//add turn directions to all the successors
			for(int i = 1; i < grownSnake.getSnakeList().size(); i++) {
				grownSnake.getSnakeList().get(i).getTurnDirections().add(new Direction(this.keyPressedNum,
						grownSnake.getSnakeList().get(0).getX(), grownSnake.getSnakeList().get(0).getY()));
				
			}
			
		}
		
		
		//iterate through all components and move them in the right direction
		for(int i = 0; i < grownSnake.getSnakeList().size(); i++) {
			
			//if the rectangle reached the turn position
			if(i > 0 && grownSnake.getSnakeList().get(i).getTurnDirections().size() > 0
					&& grownSnake.getSnakeList().get(i).getTurnDirections().get(0).getTurnXPos() == grownSnake.getSnakeList().get(i).getX()
					&& grownSnake.getSnakeList().get(i).getTurnDirections().get(0).getTurnYPos() == grownSnake.getSnakeList().get(i).getY()) {
		
				//update it's current direction
				grownSnake.getSnakeList().get(i).setDirection(grownSnake.getSnakeList().get(i).getTurnDirections().get(0).getKeyNum());
				
				//the direction is updated so I no longer need to memorize it
				grownSnake.getSnakeList().get(i).getTurnDirections().remove(0);
				
			}
			
			moveSnakeComponent(grownSnake.getSnakeList().get(i));
			
		}
		
	}
	
	
	public void moveSnakeComponent(SnakeComponent component) {
		
		switch(component.getDirection()) {
		
			case 40: { //DOWN
				component.increaseYPos();
				break;
			}
		
			case 38: { //UP
				component.decreaseYPos();
				break;
			}
		
			case 39: { //RIGHT
				component.increaseXPos();
				break;
			}
		
			case 37: { //LEFT
				component.decreaseXPos();
				break;
			}
			
		}
		
	}
	
	
	/* GETTERS AND SETTERS */

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
