package com.axisrooms;

/**
 * 
 * This class represents the Rover
 *
 * The rover will delegate all the instructions (given by the user) to the
 * currentRoverState
 *
 */
public class Rover {

	RoverState currentRoverState;
	RoverPosition currentRoverPosition;
	RoverFrame roverFrame;

	RoverState northRoverState;
	RoverState southRoverState;
	RoverState eastRoverState;
	RoverState westRoverState;

	public Rover(RoverPosition currentRoverPosition, RoverFrame roverFrame) {

		northRoverState = new NorthRoverState(this);
		southRoverState = new SouthRoverState(this);
		eastRoverState = new EastRoverState(this);
		westRoverState = new WestRoverState(this);

		this.currentRoverPosition = currentRoverPosition;
		this.roverFrame = roverFrame;
	}

	public RoverPosition getCurrentRoverPosition() {
		return currentRoverPosition;
	}

	public void setCurrentRoverPosition(RoverPosition currentRoverPosition) {
		this.currentRoverPosition = currentRoverPosition;
	}

	public RoverFrame getRoverFrame() {
		return roverFrame;
	}

	public void setRoverFrame(RoverFrame roverFrame) {
		this.roverFrame = roverFrame;
	}

	public void setCurrentState(RoverState currentRoverState) {
		this.currentRoverState = currentRoverState;
	}

	public RoverState getCurrentState() {
		return currentRoverState;
	}

	public RoverState getNorthRoverState() {
		return northRoverState;
	}

	public void setNorthRoverState(RoverState northRoverState) {
		this.northRoverState = northRoverState;
	}

	public RoverState getSouthRoverState() {
		return southRoverState;
	}

	public void setSouthRoverState(RoverState southRoverState) {
		this.southRoverState = southRoverState;
	}

	public RoverState getEastRoverState() {
		return eastRoverState;
	}

	public void setEastRoverState(RoverState eastRoverState) {
		this.eastRoverState = eastRoverState;
	}

	public RoverState getWestRoverState() {
		return westRoverState;
	}

	public void setWestRoverState(RoverState westRoverState) {
		this.westRoverState = westRoverState;
	}

	public void orientLeft() {
		currentRoverState.orientLeft();
	}

	public void orientRight() {
		currentRoverState.orientRight();
	}

	public void moveOneForward() {
		currentRoverState.moveOneForward();
	}

}
