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
	
	//private SnakeComponent snakeHead; //head of the snake
	private Food food;
	private GrownSnake grownSnake; //whole snake
	
	private int keyPressedNum = 0; //initially no keys were pressed
	private int prevKeyNum = 0; //initially no previous keys were pressed
	
	private Direction turnDirection = new Direction();
	
	
	
	
	protected void paintComponent(Graphics g) {
		
		Graphics2D graphicSettings = (Graphics2D)g;
		
		//coloring background
		graphicSettings.setColor(Color.BLACK);
		graphicSettings.fillRect(0,0, GameScreen.windowWidth, GameScreen.windowHeight);
		
		
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
			SnakeComponent newComponent = new SnakeComponent();
			grownSnake.increaseLength(newComponent, grownSnake.getSnakeList().get(0).getDirection());
			
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
			turnDirection.setTurnXPos(grownSnake.getSnakeList().get(0).getX());
			turnDirection.setTurnYPos(grownSnake.getSnakeList().get(0).getY());
			turnDirection.setKeyNum(this.keyPressedNum);
		}
		
			
			//memorizing turn position of the head, and the new direction
			//Direction direction = new Direction(this.keyPressedNum, grownSnake.getSnakeList().get(0).getX(),
				//	grownSnake.getSnakeList().get(0).getY());
			
			//directions.add(direction);
		
		
		/*
		if(directions.size() > 0 && grownSnake.getSnakeList().size() > 1) {
			
			System.out.println(grownSnake.getSnakeList().get(directions.get(0).getNextRect()).getX()
					+ " " + directions.get(0).getTurnXPos());
			
			if(grownSnake.getSnakeList().get(directions.get(0).getNextRect()).getX() == directions.get(0).getTurnXPos()
					&& grownSnake.getSnakeList().get(directions.get(0).getNextRect()).getY() == directions.get(0).getTurnYPos()) {
				grownSnake.getSnakeList().get(directions.get(0).getNextRect()).setDirection(directions.get(0).getKeyNum());
				directions.get(0).setNextRect(directions.get(0).getNextRect() + 1);
			}
		}*/
		
		//iterate through all components and move them in the right direction
		for(int i = 0; i < grownSnake.getSnakeList().size(); i++) {
			
			if(i > 0 && grownSnake.getSnakeList().get(i).getX() == turnDirection.getTurnXPos()
					&& grownSnake.getSnakeList().get(i).getY() == turnDirection.getTurnYPos()) {
				grownSnake.getSnakeList().get(i).setDirection(turnDirection.getKeyNum());
			}
			moveSnakeComponent(grownSnake.getSnakeList().get(i));
			//System.out.print(grownSnake.getSnakeList().get(i).x + "," + grownSnake.getSnakeList().get(i).y + "    ");
			
		}
		
		//System.out.println();
		
		/*
		if(directions.size() > 0) {
			//if all rectangles have turned, the direction can be removed
			if(directions.get(0).getNumOfRects() == directions.get(0).getNextRect()) {
				directions.remove(0);
			}
		}*/
		
		
		
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
