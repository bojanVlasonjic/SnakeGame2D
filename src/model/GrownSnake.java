package model;

import java.util.ArrayList;

import view.GameScreen;

public class GrownSnake {
	
	private ArrayList<SnakeComponent> snakeList; //collection of rectangles representing snake components
	
	public GrownSnake(SnakeComponent head) {
		snakeList = new ArrayList<SnakeComponent>();
		snakeList.add(head); //head is always at index 0
	}
	
	public void increaseLength(SnakeComponent newComponent) {
		
		newComponent.width = GameScreen.componentLength;
		newComponent.height = GameScreen.componentLength;
				
		//calculating the position of the new rectangle and adding it to the list
		snakeList.add(calculateNewComponentPosition(newComponent, snakeList.get(snakeList.size()-1).getDirection()));
		
		//the new component will be going in the same direction as it's predecessor
		snakeList.get(snakeList.size()-1).setDirection(snakeList.get(snakeList.size()-2).getDirection());
		
		//memorizing turn directions of the predecessor if there are any
		if(snakeList.get(snakeList.size()-2).getTurnDirections().size() > 0) {
			
			for (Direction direction : snakeList.get(snakeList.size()-2).getTurnDirections()) {
				snakeList.get(snakeList.size()-1).getTurnDirections().add(direction);
			}
			//snakeList.get(snakeList.size()-1).getTurnDirections().add(snakeList.get(snakeList.size()-2).getTurnDirections().get(0));
		}
		
	}
	
	/** Inserting new rectangle behind the last one based on snake's direction 
	 * @param newComp - new rectangle added to the snake
	 * @param tailDirection - the direction the tail is headed in
	 * @return rectangle object with it's calculated position */
	public SnakeComponent calculateNewComponentPosition(SnakeComponent newComp, int tailDirection) {
		
		switch(tailDirection) {
		
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
