package com.axisrooms;

/**
 * West Rover state implementation
 */
public class WestRoverState implements RoverState {

	Rover rover;

	public WestRoverState(Rover rover) {
		this.rover = rover;
	}

	public void orientLeft() {
		rover.setCurrentState(rover.getSouthRoverState());
	}

	public void orientRight() {
		rover.setCurrentState(rover.getNorthRoverState());
	}

	public void moveOneForward() {
		
		//validation
		if(rover.getCurrentRoverPosition().getRoverX()== 0)
		{
			throw new RuntimeException("out of frame - exceeding the horizontal frame bound(westwards)");
		}

		RoverPosition currentPosition = rover.getCurrentRoverPosition();
		currentPosition.setRoverX(currentPosition.getRoverX() - 1);
		rover.setCurrentRoverPosition(currentPosition);
	}

}
