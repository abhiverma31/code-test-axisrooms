package com.axisrooms;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RoverClient {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		// upper right coordinates of the frame
		System.out
				.println("Enter the upper Right coordinates(x, y - for example '55') of the Rover frame and hit Enter -->> ");

		Integer frameCoordinates = null;
		try {
			frameCoordinates = in.nextInt();
		} catch (Exception e) {
			System.out
					.println("Incorrect frame coordinate values entered. Only two digit integer expected");
			in.close();
			return;
		}
		if (frameCoordinates.toString().length() != 2) {
			System.out
					.println("Incorrect frame coordinate values entered. Only two digit integer expected");
			in.close();
			return;
		}

		System.out.println("You entered : " + frameCoordinates.toString());

		// set up the frame
		RoverFrame roverFrame = new RoverFrame(Integer.parseInt((new Character(
				frameCoordinates.toString().charAt(0))).toString()),
				Integer.parseInt((new Character(frameCoordinates.toString()
						.charAt(1))).toString()));

		System.out
				.print("Enter the current position(x,y,direction('N'/'S'/'E'/'W')-for example '12N'))of the rover and hit Enter-->> ");

		String currentRoverPosition = in.next();
		System.out.println("You entered : " + currentRoverPosition);

		boolean roverPositionValidated = validateCurrentRoverPosition(currentRoverPosition);

		if (!roverPositionValidated) {
			System.out
					.println("Incorrect Rover position entered. Correct format should be: {int}{int}{'N'/'S'/'E'/'W'}");
			in.close();
			return;
		}
		// set up current position of a rover
		RoverPosition roverPosition = new RoverPosition(
				Integer.parseInt(new Character(currentRoverPosition.charAt(0))
						.toString()), Integer.parseInt(new Character(
						currentRoverPosition.charAt(1)).toString()),
				currentRoverPosition.charAt(2));

		// instructions for the rover
		System.out
				.print("Enter the series of instructions(for eg. LMLMLMLMM) and hit Enter -->> ");
		String instructionsForRover = in.next();
		System.out.println("You entered : " + instructionsForRover);

		boolean instructionSetValidated = validateInstructionsForRover(instructionsForRover);
		if (!instructionSetValidated) {
			System.out
					.println("Incorrect instructions entered. Only series of the following characters are permissible -> LMR...");
			in.close();
			return;
		}

		char[] instructionsForRoverArray = instructionsForRover.toCharArray();

		// create rover instance
		Rover rover = new Rover(roverPosition, roverFrame);

		// instantiate mapping
		RoverStateMapping mapping = new RoverStateMapping(rover);
		// set current rover state
		rover.setCurrentState(mapping.directionRoverStateMap.get(new Character(
				currentRoverPosition.charAt(2))));

		processInstructions(rover, instructionsForRoverArray);

		// final rover direction
		Character roverFinalDirection = RoverStateMapping.roverStateDisplayLiteralMapping
				.get(rover.getCurrentState().getClass().getSimpleName());

		// Display the final rover position
		System.out.print("\n");
		System.out
				.print("---------------------------------------------------------------------------------------------------------------- "
						+ "\n");
		System.out
				.println("FINAL POSITION (X coordinate, Y coordinate, Direction) OF THE ROVER IS: "
						+ "\n"
						+ rover.getCurrentRoverPosition().getRoverX()
						+ " "
						+ rover.getCurrentRoverPosition().getRoverY()
						+ " " + roverFinalDirection);
		
		in.close();

	}

	private static boolean validateInstructionsForRover(
			String instructionsForRover) {
		List<Character> instructionLiterals = Arrays.asList('L', 'M', 'R');
		char[] instructionsArray = instructionsForRover.toCharArray();
		for (char eachInstruction : instructionsArray) {
			if (!instructionLiterals.contains((Character) eachInstruction)) {
				return false;
			}
		}
		return true;
	}

	private static boolean validateCurrentRoverPosition(
			String currentRoverPosition) {
		if (currentRoverPosition.length() != 3) {
			return false;
		}

		if (!Character.isDigit(currentRoverPosition.charAt(0))
				&& !Character.isDigit(currentRoverPosition.charAt(1))) {
			return false;
		}

		List<Character> directionLiterals = Arrays.asList('N', 'S', 'E', 'W');
		Character roverDirection = new Character(currentRoverPosition.charAt(2));
		if (!directionLiterals.contains(roverDirection)) {
			return false;
		}

		return true;

	}

	public static void processInstructions(Rover rover,
			char[] instructionsForRoverArray) {
		for (char instruction : instructionsForRoverArray) {
			switch (instruction) {
			case 'L':
				rover.orientLeft();
				break;
			case 'R':
				rover.orientRight();
				break;
			case 'M':
				rover.moveOneForward();
				break;

			}
		}
	}
}
