package kayak.code.exercise1;

/*
 * Robot is the class which signifies the Robot 
 * itself. Each robot is supposed to have some location,
 * a Position on that location and certain direction. 
 * 
 * roboPos: Robot's position
 * roboDirection: Robot's direction
 * roboLoc: Robot's location
 * 
 * Below is the convention which I have used throughout
 * my program.
 * 
 * 
 * (0,0)         x  --->
 * 	  x-------------------------->
 *    |						     |
 * y  |          NORTH			 |
 * |  |                          |
 * |  |   WEST  [robot]   EAST   |
 * v  |  		                 |
 * 	  |          SOUTH           |
 *    |                          |
 *    |     	                 |
 *    v..........................|
 *    			(mars)			 (XLIMIT,YLIMIT)
 *    
 *    
 */
public class Robot {

	private Position roboPos;
	private Direction roboDirection;
	private Mars roboLoc;

	public Robot(Position position, Direction direction, Mars mars) 
	{
		this.roboDirection = direction;
		this.roboLoc = mars;
		if (!roboLoc.isValidPosition(position))
			throw new IllegalArgumentException("Invalid position of Robot entered...");
		this.roboPos = position;
	}

	public Mars getRoboLoc() 
	{
		return roboLoc;
	}

	public void setRoboLoc(Mars roboLocation) 
	{
		this.roboLoc = roboLocation;
	}

	public void setRoboPos(Position roboPosition) 
	{
		this.roboPos = roboPosition;
	}

	public Position getRoboPos() 
	{
		return roboPos;
	}

	public Direction getRoboDirection() 
	{
		return roboDirection;
	}

	public void setRoboDirection(Direction direction) 
	{
		this.roboDirection = direction;
	}

	/*
	 * This function makes the appropriate changes in the 
	 * location and direction of the current robot, as per the 
	 * instruction given.
	 *  
	 * @param instruction
	 * 			A character denoting the instruction given to the robot.
	 */
	public void feedInstructionToRobot(char instruction) 
	{
		int currX = this.roboPos.getX();
		int currY = this.roboPos.getY();

		Position newPosition = new Position(currX, currY);
		Instruction robotInst = Instruction.getInstructionVal(instruction);
		
		if(wrongInstructionGiven(robotInst))
			throw new IllegalArgumentException("Entered an "
					+ "invalid instruction : "+  instruction);
		
		/*
		 * This switch case handles the various scenarios that need to be taken
		 * into consideration when giving a robot an instruction.
		 */
		switch (robotInst) 
		{
		case F:
			switch (this.roboDirection) 
			{
			case NORTH:
				newPosition = new Position(currX, currY-1);
				break;
			case EAST:
				newPosition = new Position(currX+1, currY);
				break;
			case WEST:
				newPosition = new Position(currX-1, currY);
				break;
			case SOUTH:
				newPosition = new Position(currX, currY+1);
				break;
			}
			break;
		case L:
			switch (this.roboDirection) 
			{
			case NORTH:
				this.setRoboDirection(Direction.WEST);
				break;
			case EAST:
				this.setRoboDirection(Direction.NORTH);
				break;
			case WEST:
				this.setRoboDirection(Direction.SOUTH);
				break;
			case SOUTH:
				this.setRoboDirection(Direction.EAST);
				break;
			}
			break;
		case R:
			switch (this.roboDirection) 
			{
			case NORTH:
				this.setRoboDirection(Direction.EAST);
				break;
			case EAST:
				this.setRoboDirection(Direction.SOUTH);
				break;
			case WEST:
				this.setRoboDirection(Direction.NORTH);
				break;
			case SOUTH:
				this.setRoboDirection(Direction.WEST);
				break;
			}
			break;
		}
		
		/*
		 *  Here we update the position of the robot if it seems a valid one.
		 *  
		 *  NOTE: We just ignore the instruction which makes the robot goto
		 *  an invalid location (out of the grid), and the robot maintains the
		 *  same state as before.
		 */
		if (roboLoc.isValidPosition(newPosition)) 
		{
			this.setRoboPos(newPosition);
		}
	}
	
	/*
	 * This check if the user has entered a 
	 * valid instruction or not (i.e 'F', 'R' or 'L' only).
	 */
	private boolean wrongInstructionGiven(Instruction robotInstruction) 
	{
		return robotInstruction==null;
	}
}
