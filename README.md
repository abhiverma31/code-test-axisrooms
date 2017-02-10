The design is based on State pattern. Each possible 'State' of the Rover has been represented by it's own class. The Rover then makes transition between states as per the instructions.

Design and implementation notes:
a)All possible states a Rover can be in is derived from the RoverState interface. All possible actions on a rover for transition to another state (and change in position) have been exposed in the RoverState interface
b)Every RoverState is composed of the rover object. The individual RoverState will set the new state of the rover when there is a transition to another state (or a change in position of the rover)
c)It's the responsibility of each of the individual RoverState to implement the (possible)actions on the rover (orientLeft, orientRight, moveOneForward) and set the new state on the rover as mentioned in the above point. The Rover just delegates this responsibility to the current rover state
d)To establish mapping between a RoverState and the way it should be displayed (for example: NorthRoverState <--> N  and vice-versa), I am maintaining a RoverStateMapping file. On instantiation, I'm storing this mapping in two separate HashMaps. The RoverState <-> DisplayLiteral mapping is used in retrieving the final state of the rover (this is for output display). The DisplayLiteral <-> RoverState mapping is used in retrieving the RoverState corresponding to the entered rover direction(this is for setting the initial rover state)
e)On instantiating the Rover :-
   1)the individual RoverStates get initialized
   2)the initial rover state (direction) is set
   3)the initial rover position is set (x coordinate, y coordinate)
   4)the frame limits (bound values) are set (Xmax, Ymax)

Assumptions:
a)The user enters valid data as input which is in the format given as examples in the problem statement:
  This user input should be entered in this format :-
   a)for the upper Right co-ordinates of the rover frame the format should be xy (for example 55)
   b)the current rover position and direction should be entered in this format : xyC ( for example 12N)
   c)the series of instructions for the rover movement should be entered as a string sequence of LMR (for example LMLMLMLMM)

b)There are only four possible directions the rover can be in - North(N), South(S), East(E), West(W)

To trigger the Rover program:
a)Create a project in eclipse and create a default package. Copy all the 10 java files(unzip the attachment to extract the files) in the default package
b)Run the program (as a Java Application) RoverClient.java. This will prompt the user for the input data. Enter the data in the format explained in the assumptions (above)

Comments in the code:
For clarity, I've added appropriate code comments explaining the purpose of creating a particular class, method, variable.
