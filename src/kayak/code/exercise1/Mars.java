package kayak.code.exercise1;

/*
 * Mars is the instance of Location interface,
 * this is the location at which our current 
 * robot (in the problem statement) has landed.
 * 
 * It has two member variable, XLIMIT and YLIMIT,
 * which are the max limit of the Mars (i.e
 * supposed to be a Cartesian grid). 
 * 
 * It also has grid as a member variable, although it
 * doesn't make any contribution in the main functionality 
 * but I kept it in order to signify the requirement 
 * of Mars being a Cartesian grid.
 * 
 */
public class Mars implements Location {
	
	private int XLIMIT;
	private int YLIMIT;
	private int[][] grid;
	
	public Mars(int x, int y){
		XLIMIT = x;
		YLIMIT = y;
		grid = new int[x][y];
	}

	public int getXLIMIT() {
		return XLIMIT;
	}

	public int getYLIMIT() {
		return YLIMIT;
	}
	
	public int[][] getGrid() {
		return grid;
	}
	
	/**
	 * Verifies if the given position object is a valid.
	 * Valid is defined as a position which is on or inside
	 * the boundary of the Mars's area.
	 * 
     * @param  Position
     *         A Position/coordinate of the robot on mars
     */
	public boolean isValidPosition(Position p) 
	{
		return (p.getX() >= 0 && p.getX() <= this.getXLIMIT() && 
				p.getY() >= 0 && p.getY() <= this.getYLIMIT());
	}
}
