package model;

import java.awt.Rectangle;

import view.GameScreen;

@SuppressWarnings("serial")
public class SnakeComponent extends Rectangle {
	
	private int sWidth; 
	private int sHeight; 
	
	private int direction; //the direction the component is headed in (40 = down)
	
	private double speed = GameScreen.componentLength;
	
	
	public SnakeComponent() {
		
		this.direction = 0; //initially not moving
	}
	
	public SnakeComponent(int xPos, int yPos, int width, int height) {
		
		super(xPos, yPos, width, height);
		this.direction = 0; //initially not moving
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

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}


	
}
