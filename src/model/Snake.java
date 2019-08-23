package model;

import java.awt.Polygon;
import java.awt.Rectangle;

import view.GameScreen;

@SuppressWarnings("serial")
public class Snake extends Polygon {

	private static int[] xPoints = {10, 20, 20, 10};
	private static int[] yPoints = {10, 10, 20, 20};
	
	private int sWidth = 10; //calculated distance using xPoints and yPoints
	private int sHeight = 10; //calculated distance using xPoints and yPoints
	
	private double speed = 2.0;
	
	public Snake() {
		
		super(xPoints, yPoints, 4);
	}
	
	
	/* METHODS FOR COLLISION DETECTION */
	
	/* Method draws a rectangle around a snake, and by comparing with the rectangle around food,
	 * I determine whether or not it has come to a collision
	 * return: rectangle around Snake */
	public Rectangle getBounds() {
		return new Rectangle(super.xpoints[0], super.ypoints[0], sWidth, sHeight);
	}
	
	/* METHODS FOR MOVEMENT */
	
	/* They may appear a bit odd because the coordinating system of a window starts in the
	 * upper left corner, the x-axis increases to the right, the y-axis increases to the bottom */
	
	public void increaseYPos() {
		
		//in case the snake is out of bounds(reached out of the window) it spawns on the other side
		if(this.ypoints[2] > GameScreen.windowHeight) { //index of 2 because the ypoint higher in value is the first to reach the bottom
			for(int i = 0; i < this.ypoints.length; i++) { 
				this.ypoints[i] -= GameScreen.windowHeight;
			}
		//otherwise I just increase it's ypositions
		} else {
			for(int i = 0; i < this.ypoints.length; i++) {
				this.ypoints[i] += this.speed;
			}
		}
	}
	
	public void decreaseYPos() {
		
		//in case the snake is out of bounds(reached out of the window) it spawns on the other side
		if(this.ypoints[0] < 0) { //index of 0 because the ypoint lower in value is the first to reach the top of the window
			for(int i = 0; i < this.ypoints.length; i++) {
				this.ypoints[i] += GameScreen.windowHeight;
			}
		//otherwise I just decrease it's ypositions
		} else {
			for(int i = 0; i < this.ypoints.length; i++) {
				this.ypoints[i] -= this.speed;
			}
		}
		
	}
	
	public void increaseXPos() {
		//in case the snake is out of bounds(reached out of the window) it spawns on the other side
		if(this.xpoints[1] > GameScreen.windowWidth) { //index of 1 because the xpoint closer to the right is the one that matters
			for(int i = 0; i < this.xpoints.length; i++) {
				this.xpoints[i] -= GameScreen.windowWidth;
			}
		//otherwise I just increase it's xpositions
		} else {
			for(int i = 0; i < this.xpoints.length; i++) {
				this.xpoints[i] += this.speed;
			
			}
		}
		
	}
	
	public void decreaseXPos() {
		//in case the snake is out of bounds(reached out of the window) it spawns on the other side
		if(this.xpoints[0] < 0) { //index of 0 because the xpoint closer to the left is the one that matters
			for(int i = 0; i < this.xpoints.length; i++) {
				this.xpoints[i] += GameScreen.windowWidth;
			}
		//otherwise I just decrease it's xpositions
		} else {
			for(int i = 0; i < this.xpoints.length; i++) {
				this.xpoints[i] -= this.speed;
			
			}
		}
		
	}
	
	public void increaseSpeed() {
		//TODO:
	}
	
	public void decreaseSpeed() {
		//TODO:
	}
	

	/* GETTERS AND SETTERS */
	
	
	public static int[] getxPoints() {
		return xPoints;
	}

	public static void setxPoints(int[] xPoints) {
		Snake.xPoints = xPoints;
	}

	public static int[] getyPoints() {
		return yPoints;
	}

	public static void setyPoints(int[] yPoints) {
		Snake.yPoints = yPoints;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
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

	
}
