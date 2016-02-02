package kayak.code.exercise1;

/*
 * This is the main function which provides functionality to feed
 * the robot with a set of instructions and return the final state 
 * the robot.
 * 
 */
public class RobotManeuver {

	/*
	 * This function is a static function as I feel its a stateless 
	 *  and is dependent only on the input given, hence I kept it static.
	 * 
	 * This function iterates over the set of given instruction, 
	 * on the given robot rbt, and modifies the state of the robot
	 * as per the given instruction. Finally returns the robot in its 
	 * final destination.
	 * 
	 * @param instructions
	 * 				Set of instructions as String letters.
	 * 
	 * @param rbt
	 * 			A robot on to which instructions will be applied.
	 * 
	 */
	public static Robot moveRobot(String instructions, Robot rbt){
		if(instructions==null)
			throw new IllegalArgumentException("Entered "
					+ "null instruction : "+  instructions);
		char[] m = instructions.toCharArray();
		for (int i = 0; i < m.length; i++) {
			rbt.feedInstructionToRobot(m[i]);
		}
		return rbt;
	}
}
