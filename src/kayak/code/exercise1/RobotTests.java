package kayak.code.exercise1;

import static org.junit.Assert.*;
import org.junit.*;

/*
 * Tests related to the robot exercise.
 */
public class RobotTests {

	
	// Various constants which I would need for writing tests.
	
	private  static final String INSTRUCTIONS = "LFFFRFFFRRFFF";
	private  static final String WRONG_INSTRUCTIONS = "LRRFxF";
	private  static final String NULL_INSTRUCTION = null;
	
	private  static final String LEFT_MOVE = "L";
	private  static final String RIGHT_MOVE = "R";
	
	private  static final int MARS_X = 1000;
	private  static final int MARS_Y = 1000;
	private  static final int OUT_MARS_X = MARS_X + 10;
	private  static final int OUT_MARS_Y = MARS_Y + 10;
	private  static final int IN_MARS_X = MARS_X - 100;
	private  static final int IN_MARS_Y = MARS_Y - 100;
	private  static final int AT_BOUNDARY_MARS_X = MARS_X;
	private  static final int AT_BOUNDARY_MARS_Y = MARS_Y;

	private Robot southFacingInsideMarsRobot, 
		  		  westFacingCornerRobot;
	
	private Position outOfMarsPos, 
			 		 insideOfMarsPos, 
			 		 atBoundaryMarsPos;
	
	private Mars mars;

	@Before
	public void setUp() throws Exception 
	{
		mars = new Mars(MARS_X, MARS_Y);
		outOfMarsPos = new Position(OUT_MARS_X, OUT_MARS_Y);
		insideOfMarsPos = new Position(IN_MARS_X, IN_MARS_Y);
		atBoundaryMarsPos = new Position(AT_BOUNDARY_MARS_X, 
										 AT_BOUNDARY_MARS_Y);
		southFacingInsideMarsRobot = new Robot(insideOfMarsPos, 
										Direction.SOUTH, mars);
		westFacingCornerRobot = new Robot(atBoundaryMarsPos, 
									  Direction.WEST, mars);
	}

	/**
	 * This test will try to create a robot on a position which is 
	 * outside the boundary of the Mars.
	 * 
	 * @result Exception will be thrown, stating that wrong position 
	 * 		   was given.
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void wrongRobotInitialPositionTest() 
	{
		new Robot(outOfMarsPos, Direction.NORTH, mars);
	}

	/**
	 * This test will try to send a wrong set of instructions
	 * 
	 * @result Exception will be thrown, stating that wrong 
	 * 		   instruction was given.
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void wrongInstructionTest() 
	{
		RobotManeuver.moveRobot(WRONG_INSTRUCTIONS, 
					   southFacingInsideMarsRobot);
	}

	/**
	 * This test will try to send  null instructions
	 * 
	 * @result Exception will be thrown, stating that null 
	 * 		   instruction was given.
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void nullInstructionTest() 
	{
		RobotManeuver.moveRobot(NULL_INSTRUCTION, 
					  southFacingInsideMarsRobot);
	}


	/**
	 * This test will try to maneuver robot inside the
	 * mars (within its boundary). This tests the normal
	 * execution of the program. 
	 * 
	 * @result Robot follows the instructions given and 
	 * 		   reaches the desired location.
	 *
	 */
	@Test
	public void robotInsideMarsMovementTest() 
	{
		Robot rbt = RobotManeuver.moveRobot(INSTRUCTIONS, 
							 southFacingInsideMarsRobot);
		
		int[] finalCoordinate = { rbt.getRoboPos().getX(), 
								  rbt.getRoboPos().getY() };
		int[] expectedCoordinate = { 903, 900 };
		
		assertTrue(expectedCoordinate[0] == finalCoordinate[0]
				&& expectedCoordinate[1] == finalCoordinate[1]);
	}

	/**
	 * Tests whether the robot is able to tackle the instructions
	 * when it is at the corner/boundary.
	 * 
	 * @result The robot will ignore the instruction which will lead it
	 * 		   to an invalid location (outside the Mars), and will move 
	 * 		   to appropriate location after entire instructions are done.
	 */
	@Test
	public void robotBoundaryMovementTest() 
	{
		Robot rbt = RobotManeuver.moveRobot(INSTRUCTIONS, 
								  westFacingCornerRobot);
		int[] finalCoordinate = { rbt.getRoboPos().getX(), 
								  rbt.getRoboPos().getY() };
		int[] expectedCoordinate = { MARS_X, MARS_Y };
		assertTrue(expectedCoordinate[0] == finalCoordinate[0]
				&& expectedCoordinate[1] == finalCoordinate[1]);
	}

	/**
	 * Tests whether robot is able to listen to the instructions
	 * of turning left and right properly
	 * 
	 * @result A West facing robot turns to South direction on giving
	 * 		   L ( turn left) instruction.
	 */
	@Test
	public void turnLeftTest() 
	{
		Robot rbt = RobotManeuver.moveRobot(LEFT_MOVE, 
								westFacingCornerRobot);
		assertTrue(rbt.getRoboDirection() == Direction.SOUTH);
	}

	/**
	 * Tests whether robot is able to listen to the instructions
	 * of turning left and right properly
	 * 
	 * @result A South facing robot turns to West direction on giving
	 * 		   R ( turn Right) instruction.
	 */
	@Test
	public void turneRightTest() 
	{
		Robot rbt = RobotManeuver.moveRobot(RIGHT_MOVE, 
							southFacingInsideMarsRobot);
		assertTrue(rbt.getRoboDirection() == Direction.WEST);
	}
}
