package kayak.code.exercise1;


/*
 * The Location interface signifies the location
 * a robot can land into. All locations in this 
 * programs, such as mars (or maybe Jupiter, Saturn ...)
 * are implemented as instances of this class. 
 */
public interface Location {
	public boolean isValidPosition(Position p);
}
