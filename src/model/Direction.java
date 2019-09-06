package model;

public class Direction {
	
	private int keyNum;
	
	private double turnXPos;
	private double turnYPos;
	
	
	public Direction() {
		
		this.keyNum = -1;
		this.turnXPos = -1;
		this.turnYPos = -1;
	}

	public Direction(int keyNum, double turnXPos, double turnYPos) {
		
		this.keyNum = keyNum;
		this.turnXPos = turnXPos;
		this.turnYPos = turnYPos;
		
	}

	public int getKeyNum() {
		return keyNum;
	}

	public void setKeyNum(int keyNum) {
		this.keyNum = keyNum;
	}

	public double getTurnXPos() {
		return turnXPos;
	}

	public void setTurnXPos(double turnXPos) {
		this.turnXPos = turnXPos;
	}

	public double getTurnYPos() {
		return turnYPos;
	}

	public void setTurnYPos(double turnYPos) {
		this.turnYPos = turnYPos;
	}


}
