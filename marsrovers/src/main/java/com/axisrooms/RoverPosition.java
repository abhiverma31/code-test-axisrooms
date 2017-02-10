package com.axisrooms;

/**
 * This class represents the position of the rover
 */
public class RoverPosition {

	private int roverX;
	private int roverY;
	private char roverDirection;
	
	public RoverPosition(int roverX, int roverY, char roverDirection){
		this.roverX = roverX;
		this.roverY = roverY;
		this.roverDirection = roverDirection;
	}

	public int getRoverX() {
		return roverX;
	}

	public void setRoverX(int roverX) {
		this.roverX = roverX;
	}

	public int getRoverY() {
		return roverY;
	}

	public void setRoverY(int roverY) {
		this.roverY = roverY;
	}

	public char getRoverDirection() {
		return roverDirection;
	}

	public void setRoverDirection(char roverDirection) {
		this.roverDirection = roverDirection;
	}

}
