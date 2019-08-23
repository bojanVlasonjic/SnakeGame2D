package model;

import java.util.ArrayList;

public class GrowingSnake {
	
	private ArrayList<Snake> snakeList;
	
	public GrowingSnake(Snake head) {
		snakeList = new ArrayList<Snake>();
		snakeList.add(head);
	}
	
	public void increaseLength(Snake snake, int currDirection) {
		
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
