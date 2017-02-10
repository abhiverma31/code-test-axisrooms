package com.axisrooms;

/**
 * East Rover state implementation
 */
public class EastRoverState implements RoverState {

	Rover rover;

	public EastRoverState(Rover rover) {
		this.rover = rover;
	}

	public void orientLeft() {
		rover.setCurrentState(rover.getNorthRoverState());
	}

	public void orientRight() {
		rover.setCurrentState(rover.getSouthRoverState());
	}

	public void moveOneForward() {
		
		//validation
		if(rover.getCurrentRoverPosition().getRoverX() >= rover.getRoverFrame().getTopRightX())
		{
			throw new RuntimeException("out of frame - exceeding the horizontal frame bound(eastwards)");
		}

		RoverPosition currentPosition = rover.getCurrentRoverPosition();
		currentPosition.setRoverX(currentPosition.getRoverX() + 1);
		rover.setCurrentRoverPosition(currentPosition);
	}

}
