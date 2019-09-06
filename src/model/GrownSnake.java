package model;

import java.util.ArrayList;

import view.GameScreen;

public class GrownSnake {
	
	private ArrayList<SnakeComponent> snakeList; //collection of rectangles representing snake components
	
	public GrownSnake(SnakeComponent head) {
		snakeList = new ArrayList<SnakeComponent>();
		snakeList.add(head); //head is always at index 0
	}
	
	public void increaseLength(SnakeComponent newComponent, int keyPressed) {
		
		newComponent.width = GameScreen.componentLength;
		newComponent.height = GameScreen.componentLength;
				
		//calculating the position of the new rectangle and adding it to the list
		snakeList.add(calculateNewComponentPosition(newComponent, keyPressed));
		
		//the new component will be going in the same direction as it's predecessor
		snakeList.get(snakeList.size()-1).setDirection(snakeList.get(snakeList.size()-2).getDirection());
		snakeList.get(snakeList.size()-1).setTurnDirection(snakeList.get(snakeList.size()-2).getTurnDirection());

	}
	
	/** Inserting new rectangle behind the last one based on snake's direction 
	 * @param newComp - new rectangle added to the snake
	 * @param keyPressed - the direction the snake is headed
	 * @return rectangle object with it's calculated position */
	public SnakeComponent calculateNewComponentPosition(SnakeComponent newComp, int keyPressed) {
		
		switch(keyPressed) {
		
		case 40: { //DOWN
			newComp.x = snakeList.get(snakeList.size() - 1).x;
			newComp.y = snakeList.get(snakeList.size() - 1).y - GameScreen.componentLength;
			break;
		}
	
		case 38: { //UP
			newComp.x = snakeList.get(snakeList.size() - 1).x;
			newComp.y = snakeList.get(snakeList.size() - 1).y + GameScreen.componentLength;
			break;
		}
	
		case 39: { //RIGHT
			newComp.x = snakeList.get(snakeList.size() - 1).x - GameScreen.componentLength;
			newComp.y = snakeList.get(snakeList.size() - 1).y;
			break;
		}
	
		case 37: { //LEFT
			newComp.x = snakeList.get(snakeList.size() - 1).x + GameScreen.componentLength;
			newComp.y = snakeList.get(snakeList.size() - 1).y;
			break;
		}
		
	}
		return newComp;
		
	}
	

	public ArrayList<SnakeComponent> getSnakeList() {
		return snakeList;
	}

	public void setSnakeList(ArrayList<SnakeComponent> snakeList) {
		this.snakeList = snakeList;
	}

}
