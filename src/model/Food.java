package model;

import java.awt.Polygon;
import java.awt.Rectangle;

import view.GameScreen;

@SuppressWarnings("serial")
public class Food extends Polygon {
	
	//private Snake snake = Snake.getInstance(); //food has same points as snakes
	
	private int xPos;
	private int yPos;
	
	private static int[] xPoints = {40, 50, 50, 40};
	private static int[] yPoints = {40, 40, 50, 50};
	
	//same width and height as the Snake
	private int fWidth = 10;
	private int fHeight = 10;
	
	/* SINGLETON */
	private static Food instance = null;
	
	private Food() {
		
		super(xPoints, yPoints, 4); //the food is the same size as the snake
	}
	
	public static Food getInstance() {
		
		if(instance == null) {
			instance = new Food();
		}
		
		return instance;
		
	}
	
	/* COLLISION DETECTION METHODS */
	
	/*Method draws a rectangle around a snake, and by comparing with the rectangle around food,
	 *I determine whether or not it has come to a collision
	 *return: Rectangle around food */
	public Rectangle getBounds() {
		return new Rectangle(super.xpoints[0], super.ypoints[0], fWidth, fHeight);
	}
	
	/* MOVEMENT METHOD */
	
	//changes position of the food on screen
	public void changePosition() {
		
		int maxNum = GameScreen.windowWidth - 40; //so the food wouldn't go to the corner of the window
		
		//generated random based on which I draw food on another place on the screen
		int randNum = (int) (Math.random() * maxNum + 1); //returns num between 20 and maxNum(380)
		
		//changing xpoints of food
		for(int i = 0; i < super.xpoints.length; i++) {
			if(i == 0 || i == super.xpoints.length - 1) { //first and last xpoints are lower in value
				super.xpoints[i] = randNum;
			} else {
				super.xpoints[i] = randNum + fWidth; //second and third xpoints are higher in value by 10
			}
		}
		
		//changing yPoints of food
		for(int i = 0; i < super.ypoints.length; i++) {
			if(i < super.ypoints.length / 2) {
				super.ypoints[i] = randNum; //first two ypoints are lower in value
			} else {
				super.ypoints[i] = randNum + fHeight; //last two ypoints are higher in value by 10
			}
		}
	}
	
	
	/* GETTERS AND SETTERS */

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
	
	

}
