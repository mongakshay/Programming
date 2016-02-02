package kayak.code.exercise1;


/*
 * Position signifies the coordinates of the
 * robot on the location (Mars) it has landed on.
 * 
 * This is represented by X and Y coordinates.
 */
public class Position {

	int X;
	int Y;

	public Position(int x, int y) {
		super();
		X = x;
		Y = y;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}
}
