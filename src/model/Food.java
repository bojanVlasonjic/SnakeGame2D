package model;

import java.awt.Rectangle;

import view.GameScreen;

@SuppressWarnings("serial")
public class Food extends Rectangle {
	
	//same width and height as the Snake
	private int fWidth;
	private int fHeight;
	
	/* SINGLETON */
	private static Food instance = null;
	
	private Food() {
		
		//fixed starting position, width and height
		super(GameScreen.componentLength, GameScreen.componentLength);
		setDefaultPosition();
		
	}
	
	public static Food getInstance() {
		
		if(instance == null) {
			instance = new Food();
		}
		
		return instance;
		
	}
	
	public void setDefaultPosition() {
		this.x = GameScreen.windowWidth/2;
		this.y = GameScreen.windowHeight/2;
	}
	
	
	/* MOVEMENT METHOD */
	
	//changes position of the food on screen
	public void changePosition() {
		
		//next position of the food is randomly generated 
		int randX = (int) ( Math.random() * ((GameScreen.windowWidth/GameScreen.componentLength) - 2) ); //returns num between 10 and window width-10
		int randY = (int) ( Math.random() * ((GameScreen.windowHeight/GameScreen.componentLength) - 4) ); //returns num between 10 and window height-10
		
		super.x = randX*10;
		super.y = randY*10;

	}
	
	
	/* GETTERS AND SETTERS */

	
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
