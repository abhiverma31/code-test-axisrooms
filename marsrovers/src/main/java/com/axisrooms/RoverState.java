package com.axisrooms;

/**
 * This interface represents the rover state.
 * The possible actions that can be performed on the 
 * rover in a given state are exposed.
 */

public interface RoverState {

	// all possible actions on a RoverState object
	void orientLeft();

	void orientRight();

	void moveOneForward();

}
