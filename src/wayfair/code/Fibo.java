package wayfair.code;

import java.util.HashMap;

public class Fibo {

	// ################################# nth Fibo codes  ######################################
	static HashMap<Long, Long> cache = new HashMap<Long, Long>();

	private static long printFiboFaster(long n) {
		if (n == 1)
			return 0;
		if (n == 2)
			return 1;
		if (!cache.containsKey(n))
			cache.put(n, printFibo(n - 1) + printFibo(n - 2));
		return cache.get(n);
	}

	private static long printFibo(long n) {
		if (n == 1)
			return 0;
		if (n == 2)
			return 1;
		return printFibo(n - 1) + printFibo(n - 2);
	}

	private static long printFiboIterative(long n) {
		if (n == 1)
			return 0;
		if (n == 2)
			return 1;
		long f = 0;
		long a = 0;
		long b = 1;
		while (n != 2) {
			f = a + b;
			a = b;
			b = f;
			n--;
		}
		return f;
	}

	// ######################################################################################

	public static void printFiboSeries(int upto) {
		int a = 0, b = 1, f = 0;
		if (upto == 1) {
			System.out.println(a);
		} else if (upto == 2) {
			System.out.println(a + " " + b);
		} else {
			System.out.print(a + " " + b);
			while (upto != 2) {
				f = a + b;
				System.out.print(" " + f);
				a = b;
				b = f;
				upto -= 1;
			}
		}
	}

	// ################################# fibo from till end  ########################################

	public static void printFiboSeriesFrom(int from, int until) {
		int a = 0, b = 1, f = -1, end = 0;

		if (from == 0) {
			if (until == 0 || until == 1) {
				System.out.println(a);
				return;
			}
			System.out.print(a + " " + b);
			end = 2;
		}
		if (from == 1) {
			System.out.print(b);
			end = 1;
		}
		while (f < from) {
			f = a + b;
			a = b;
			b = f;
		}
		while (until > end) {
			System.out.print(" " + f);
			f = a + b;
			a = b;
			b = f;
			until -= 1;
		}
	}

	public static void main(String[] args) {
		// System.out.println(printFiboIterative(50));
		// System.out.println(printFiboFaster(50));
		// System.out.println(printFibo(50));
		// printFiboSeries(10);
		// printFiboSeriesFrom(111,6);
	}
}