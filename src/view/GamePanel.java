package view;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;

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
		
	}
	
	public void moveSnake() {
		
		//in the initial state the snake does not move
		if(grownSnake.getSnakeList().get(0).getDirection() == 0 && this.keyPressedNum == 0) {
			return;
		} 
		
		//if the direction changed
		if(grownSnake.getSnakeList().get(0).getDirection() != this.keyPressedNum) {
			
			grownSnake.getSnakeList().get(0).setDirection(this.keyPressedNum);
			//grownSnake.getSnakeList().get(0).getTurnDirections().setKeyNum(this.keyPressedNum);
			
			
			//TODO: dodaj svima u listu direkcije za skretanje
			for(int i = 1; i < grownSnake.getSnakeList().size(); i++) {
				grownSnake.getSnakeList().get(i).getTurnDirections().add(new Direction(this.keyPressedNum,
						grownSnake.getSnakeList().get(0).getX(), grownSnake.getSnakeList().get(0).getY()));
				
			}
			
			
			
			/*
			//memorize the turn to the head's successor 
			if(grownSnake.getSnakeList().size() > 1) {
				grownSnake.getSnakeList().get(1).getTurnDirection().setTurnXPos(grownSnake.getSnakeList().get(0).getX());
				grownSnake.getSnakeList().get(1).getTurnDirection().setTurnYPos(grownSnake.getSnakeList().get(0).getY());
				
				grownSnake.getSnakeList().get(1).getTurnDirection().setKeyNum(this.keyPressedNum);
			}*/
			
		}
		
		
		//iterate through all components and move them in the right direction
		for(int i = 0; i < grownSnake.getSnakeList().size(); i++) {
			
			//if the rectangle reached the turn position
			if(i > 0 && grownSnake.getSnakeList().get(i).getTurnDirections().size() > 0
					&& grownSnake.getSnakeList().get(i).getTurnDirections().get(0).getTurnXPos() == grownSnake.getSnakeList().get(i).getX()
					&& grownSnake.getSnakeList().get(i).getTurnDirections().get(0).getTurnYPos() == grownSnake.getSnakeList().get(i).getY()) {
		
				//update it's current direction
				grownSnake.getSnakeList().get(i).setDirection(grownSnake.getSnakeList().get(i).getTurnDirections().get(0).getKeyNum());
				
				grownSnake.getSnakeList().get(i).getTurnDirections().remove(0);
				//TODO: u tom slucaju ovo ne treba
				/*
				//shift the turn to the next rect
				if(i != grownSnake.getSnakeList().size() - 1) {
					grownSnake.getSnakeList().get(i+1).setTurnDirection(grownSnake.getSnakeList().get(i).getTurnDirection());
				}*/
				
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
