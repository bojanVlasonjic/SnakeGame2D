package model;

import java.awt.Rectangle;

import view.GameScreen;

@SuppressWarnings("serial")
public class SnakeComponent extends Rectangle {
	
	private int xPos;
	private int yPos;
	
	private int sWidth; 
	private int sHeight; 
	
	private double speed = GameScreen.movementSpeed;
	
	
	public SnakeComponent() {
		
	}
	
	public SnakeComponent(int xPos, int yPos, int width, int height) {
		
		super(xPos, yPos, width, height);
	}
	
	
	/* METHODS FOR MOVEMENT */
	
	//moving down
	public void increaseYPos() {
		
		if(this.y > GameScreen.windowHeight) {
			this.y -= GameScreen.windowHeight;//if the snake escapes out of the window it spawns on the other side
			
		} else {
			this.y += this.speed;
			
		}
		
	}
	
	
	//moving up
	public void decreaseYPos() {
		
		if(this.y < 0) {
			this.y += GameScreen.windowHeight;//if the snake escapes out of the window it spawns on the other side
			
		} else {
			this.y -= this.speed;
			
		}
		
	}
	
	//moving right
	public void increaseXPos() {
		
		if(this.x > GameScreen.windowWidth) {
			this.x -=GameScreen.windowWidth;//if the snake escapes out of the window it spawns on the other side
			
		} else {
			this.x += this.speed;
			
		}
		
	}
	
	//moving left
	public void decreaseXPos() {
		
		if(this.x < 0) {
			this.x += GameScreen.windowWidth;//if the snake escapes out of the window it spawns on the other side
			
		} else {
			this.x -= this.speed;
			
		}
		
	}
	
	/* Getters and setters */

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getsWidth() {
		return sWidth;
	}

	public void setsWidth(int sWidth) {
		this.sWidth = sWidth;
	}

	public int getsHeight() {
		return sHeight;
	}

	public void setsHeight(int sHeight) {
		this.sHeight = sHeight;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}


	
}
