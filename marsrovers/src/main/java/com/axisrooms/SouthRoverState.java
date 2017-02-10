package com.axisrooms;

/**
 * South Rover state implementation
 */
public class SouthRoverState implements RoverState {

	Rover rover;

	public SouthRoverState(Rover rover) {
		this.rover = rover;
	}

	public void orientLeft() {
		rover.setCurrentState(rover.getEastRoverState());
	}

	public void orientRight() {
		rover.setCurrentState(rover.getWestRoverState());
	}

	public void moveOneForward() {
		
		//validation
		if(rover.getCurrentRoverPosition().getRoverY() <= 0)
		{
			throw new RuntimeException("out of frame - exceeding the vertical frame bound(downwards)");
		}

		RoverPosition currentPosition = rover.getCurrentRoverPosition();
		currentPosition.setRoverY(currentPosition.getRoverY() - 1);
		rover.setCurrentRoverPosition(currentPosition);
	}

}
