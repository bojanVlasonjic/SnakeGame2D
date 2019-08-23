package model;

import java.util.ArrayList;

public class GrownSnake {
	
	private ArrayList<SnakeComponent> snakeList; //collection of rectangles representing snake components
	
	public GrownSnake(SnakeComponent head) {
		snakeList = new ArrayList<SnakeComponent>();
		snakeList.add(head);
	}
	
	public void increaseLength(SnakeComponent snake, int currDirection) {
		
		switch(currDirection) {
		case 40: { //DOWN
			
			break;
		}

		case 38: { //UP
			break;
		}

		case 39: { //RIGHT
			break;
		}

		case 37: { //LEFT
			break;
		}
	}
	}

}
