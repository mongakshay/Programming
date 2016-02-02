package kayak.code.exercise2;

public class CountingExcercise {

	/* Exercise2 Part1:
	 * A program that counts in sequential order when given a start and end
	 * value - without using any iterative programming loops, i.e. while, for,
	 * do, for-each, etc. You can assume that both the start and end values will
	 * always be positive and that the start value will always be less then the
	 * end value. T
	 */
	static void countUp(int start, int end) 
	{
		System.out.println(start);
		if (start < end)
			countUp(start+1, end);
	}

	/* Exercise2 Part2:
	 * Continuing with part 1 change the output of the test, so that it now
	 * prints out in sequential order to the end value (only once), but then
	 * also counts down to the start value. Again, using no iterative loops, and
	 * assuming that both the start and end values will always be positive and
	 * that start value will always be less then the end value.
	 */
	
	static void countUpAndDown(int start, int end) 
	{
		System.out.println(start);
		if(start<end)
		{
			countUpAndDown(start+1, end);
			System.out.println(start);
		}
	}

	public static void main(String[] args) {
		System.out.println("\n------ countUp -------"); 
		countUp(0, 5);
		System.out.println("\n------ countUpAndDown -------"); 
		countUpAndDown(0,5);
	}

}
