package com.axisrooms;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is only for mapping purpose. We maintain a structure for mapping
 * the rover state to it's display literal and vice-versa
 */
public class RoverStateMapping {

	// maintains a mapping of the rover display literal and the rover state
	Map<Character, RoverState> directionRoverStateMap = new HashMap<Character, RoverState>();

	// maintains a mapping of the rover state and it's corresponding display
	// literal
	static Map<String, Character> roverStateDisplayLiteralMapping = new HashMap<String, Character>();

	public RoverStateMapping(Rover rover) {
		directionRoverStateMap.put('N', new NorthRoverState(rover));
		directionRoverStateMap.put('S', new SouthRoverState(rover));
		directionRoverStateMap.put('E', new EastRoverState(rover));
		directionRoverStateMap.put('W', new WestRoverState(rover));

		/**
		 * we intend to show the final orientation of the rover (depending on
		 * the RoverState) in terms of literals North --> 'N' South --> 'S' East
		 * --> 'E' West --> 'W'
		 */
		roverStateDisplayLiteralMapping.put("NorthRoverState", new Character(
				'N'));
		roverStateDisplayLiteralMapping.put("SouthRoverState", new Character(
				'S'));
		roverStateDisplayLiteralMapping.put("EastRoverState",
				new Character('E'));
		roverStateDisplayLiteralMapping.put("WestRoverState",
				new Character('W'));

	}

}
