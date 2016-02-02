package nutanix.codes;


public class dpExp {
	
	
	static int maxSumDP(int[] a) {
		int N = a.length;
		int[] dp = new int[N];
		dp[0] = a[0];

		for (int i = 1; i < N; i++) {
			dp[i] = Math.max(a[i], a[i] + dp[i - 1]);
		}
		return dp[N - 1];
	}

	/*
	 * I have a set of N jobs, and two machines A and B. 
	 * Job i takes A[i] time on machine A, and B[i] time on machine B. 
	 * What is the minimum amount of time I need to finish all the jobs?
	 */
	static void getMinTime(int[] a, int[] b) {
		int[] dp = new int[a.length];
		dp[0] = Math.min(a[0], b[0]);
		for (int i = 1; i < dp.length; i++) 
			dp[i] = Math.min(a[i] + dp[i - 1], b[i] + dp[i - 1]);
		System.out.println(dp[a.length-1]);
	}
	
	public static void testName(Integer i) {
		System.out.println(i.intValue());
	}

	public static void main(String[] args) {
		int[] a = { 1, 22, 23, 24, 35 };
		int[] b = { 11, 2, 1, 4, 15 };
		//System.out.println(maxSumDP(a));
		getMinTime(a, b);
	}

}
