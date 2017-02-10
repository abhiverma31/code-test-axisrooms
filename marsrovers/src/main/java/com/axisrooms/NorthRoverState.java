package com.axisrooms;

/**
 * North Rover state implementation
 */
public class NorthRoverState implements RoverState {

	Rover rover;

	public NorthRoverState(Rover rover) {
		this.rover = rover;
	}

	public void orientLeft() {
		rover.setCurrentState(rover.getWestRoverState());
	}

	public void orientRight() {
		rover.setCurrentState(rover.getEastRoverState());
	}

	public void moveOneForward() {
		
		//validation
		if(rover.getRoverFrame().getTopRightY() <= rover.getCurrentRoverPosition().getRoverY())
		{
			throw new RuntimeException("out of frame - exceeding the vertical frame bound(upwards)");
		}

		RoverPosition currentPosition = rover.getCurrentRoverPosition();
		currentPosition.setRoverY(currentPosition.getRoverY() + 1);
		rover.setCurrentRoverPosition(currentPosition);
	}

}
