package model;

import java.awt.Rectangle;

import view.GameScreen;

@SuppressWarnings("serial")
public class Food extends Rectangle {
	
	private int xPos;
	private int yPos;
	
	//same width and height as the Snake
	private int fWidth;
	private int fHeight;
	
	/* SINGLETON */
	private static Food instance = null;
	
	private Food() {
		
		//fixed starting position, width and height
		super(GameScreen.windowWidth/2, GameScreen.windowHeight/2,
				GameScreen.componentLength, GameScreen.componentLength); 
		
	}
	
	public static Food getInstance() {
		
		if(instance == null) {
			instance = new Food();
		}
		
		return instance;
		
	}
	
	
	/* MOVEMENT METHOD */
	
	//changes position of the food on screen
	public void changePosition() {
		
		int maxNum = GameScreen.windowWidth - 40; //maximum x or y position of food so that it would not escape the window
		
		//next position of the food is randomly generated
		int randNum = (int) (Math.random() * maxNum + 1); //returns num between 20 and maxNum(380)
		
		super.x = randNum;
		super.y = randNum;
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

	public int getfWidth() {
		return fWidth;
	}

	public void setfWidth(int fWidth) {
		this.fWidth = fWidth;
	}

	public int getfHeight() {
		return fHeight;
	}

	public void setfHeight(int fHeight) {
		this.fHeight = fHeight;
	}
	
	

}
