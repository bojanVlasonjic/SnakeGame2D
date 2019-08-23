package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import model.Food;
import model.GrowingSnake;
import model.Snake;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	
	private Snake snakeHead = new Snake(); //head of the snake
	private Food food = Food.getInstance();
	private GrowingSnake grownSnake = new GrowingSnake(snakeHead); //whole snake
	
	
	private int keyHeldNum;
	private int oppDirectionKey;
	
	protected void paintComponent(Graphics g) {
		
		Graphics2D graphicSettings = (Graphics2D)g;
		
		//coloring background
		graphicSettings.setColor(Color.BLACK);
		graphicSettings.fillRect(0,0, GameScreen.windowWidth, GameScreen.windowHeight);
		
		//coloring and drawing Snake's head
		graphicSettings.setPaint(Color.WHITE);
		graphicSettings.fill(snakeHead);
		
		//coloring and drawing Food
		graphicSettings.setPaint(Color.RED);
		graphicSettings.fill(food);
		
		//oppDirectionKey = getOppositeDirection(keyHeldNum);
		
		//adding movement to snake
		switch(keyHeldNum) {
			case 40: { //DOWN
				snakeHead.increaseYPos();
				break;
			}
		
			case 38: { //UP
				snakeHead.decreaseYPos();
				break;
			}
		
			case 39: { //RIGHT
				snakeHead.increaseXPos();
				break;
			}
		
			case 37: { //LEFT
				snakeHead.decreaseXPos();
				break;
			}
		}
		
	
		//detecting collision between snake and food
		if(snakeHead.getBounds().intersects(food.getBounds())) {
			food.changePosition(); //food position changes every time the snake eats it
			
			//TODO: increase snake size
			Snake body = new Snake();
			grownSnake.increaseLength(body, keyHeldNum);
			
		}
		
	}
	
	public int getOppositeDirection(int keyNum) {
		
		switch(keyNum) {
		case 40:
			return 38;
		case 38:
			return 40;
		case 37:
			return 39;
		case 39:
			return 37;
		default:
			return 0;
		}
	}
	
	
	/* GETTERS AND SETTERS */

	public int getKeyHeldNum() {
		return keyHeldNum;
	}

	public void setKeyHeldNum(int keyHeldNum) {
		this.keyHeldNum = keyHeldNum;
	}


}
