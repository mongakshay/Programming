package kayak.code.exercise1;


/**
 * This enum signifies the 3 
 * possible instructions which
 * can be given to the robot, and
 * only to which it will respond 
 * appropriately.
 * 
 */
public enum Instruction {
	
	F('F'), L('L'), R('R');
	
	private char val;
	
	Instruction(char v){
		this.val = v;
	}
	
	/*
	 * This helps in converting the character sequence
	 * of the instructions (fed by the user), into the 
	 * appropriate instruction type.
	 * 
	 * @param c
	 * 		 A character signifying an instruction
	 */
	public static Instruction getInstructionVal(char c){
		for (Instruction iType : Instruction.values())
            if (iType.val == c)
                return iType;
        return null;
	}
}
