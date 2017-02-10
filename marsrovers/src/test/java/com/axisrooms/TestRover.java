package com.axisrooms;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

public class TestRover extends TestCase {
	// maintains a mapping of the rover display literal and the rover state
	Map<Character, RoverState> directionRoverStateMap = new HashMap<Character, RoverState>();

	// maintains a mapping of the rover state and it's corresponding display
	// literal
	Map<String, Character> roverStateDisplayLiteralMapping = new HashMap<String, Character>();

	Rover rover = null;
	char[] instructionsForRoverArray = { 'L', 'M', 'L', 'M', 'L', 'M', 'L',
			'M', 'M' };
	
	// 2nd set of test values
	char[] instructionsForRoverArray_1 = { 'M', 'M', 'R', 'M', 'M', 'R', 'M',
			'R', 'R', 'M' };

	protected void setUp() throws Exception {
		super.setUp();

		int frameX = 5;
		int frameY = 5;

		int positionX = 1;
		int positionY = 2;
		char roverDirection = 'N';

		// 2nd set of test values
		/**
		 int positionX_1 = 3; 
		 int positionY_1 = 3; 
		 char roverDirection_1 ='E';
		 */

		// Create RoverFrame
		RoverFrame frame = new RoverFrame(frameX, frameY);
		RoverPosition currentRoverPosition = new RoverPosition(positionX,
				positionY, roverDirection);
		rover = new Rover(currentRoverPosition, frame);
		directionRoverStateMap.put('N', new NorthRoverState(rover));
		directionRoverStateMap.put('S', new SouthRoverState(rover));
		directionRoverStateMap.put('E', new EastRoverState(rover));
		directionRoverStateMap.put('W', new WestRoverState(rover));

		roverStateDisplayLiteralMapping.put("NorthRoverState", new Character(
				'N'));
		roverStateDisplayLiteralMapping.put("SouthRoverState", new Character(
				'S'));
		roverStateDisplayLiteralMapping.put("EastRoverState",
				new Character('E'));
		roverStateDisplayLiteralMapping.put("WestRoverState",
				new Character('W'));

		rover.setCurrentState(directionRoverStateMap.get(new Character(
				currentRoverPosition.getRoverDirection())));

	}

	public void testProcessInstructions() {

		// test the business logic
		RoverClient.processInstructions(rover, instructionsForRoverArray);

		// assertions to test if the final rover position is
		// computed correctly
		assertEquals(1, rover.getCurrentRoverPosition().getRoverX());
		assertEquals(3, rover.getCurrentRoverPosition().getRoverY());
		assertEquals(
				'N',
				(char) roverStateDisplayLiteralMapping.get(rover
						.getCurrentState().getClass().getSimpleName()));

		/**
		 * 2nd set of test values..
		 * RoverClient.processInstructions(rover, instructionsForRoverArray_1);
		 * assertEquals(5, rover.getCurrentRoverPosition().getRoverX());
		 * assertEquals(1, rover.getCurrentRoverPosition().getRoverY());
		 * assertEquals( 'E', (char) roverStateDisplayLiteralMapping.get(rover
		 * .getCurrentState().getClass().getSimpleName()));
		 */

	}

	protected void tearDown() throws Exception {
		directionRoverStateMap = null;
		roverStateDisplayLiteralMapping = null;
		rover = null;
		instructionsForRoverArray = null;
		instructionsForRoverArray_1 = null;
	}
}
