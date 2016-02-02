package nutanix.codes;

import java.util.Arrays;

public class LIS {
	
	static public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		int len = 0;
		for (int x : nums) {
			int i = Arrays.binarySearch(dp, 0, len, x);
			if (i < 0)
				i = -(i + 1);
			dp[i] = x;
			if (i == len)
				len++;
		}
		return len;
	}
	
    public static void main(String[] args) {
    	int[] nums = {1,12,3,4,2,8,7,12,0};
    	System.out.println(lengthOfLIS(nums));
    }
    	
}

/*

		######################## Dynamic Programming using Python ########################  
		
		def lis(arr):
		    n = len(arr)
		    lis = [1]*n
		    for i in range (1 , n):
		        for j in range(0 , i):
		            if arr[i] > arr[j] and lis[i]< lis[j] + 1 :
		                lis[i] = lis[j]+1
		    maximum = 0
		    for i in range(n):
		        maximum = max(maximum , lis[i])
		 
		    return maximum
		
		arr = [10, 22, 9, 33, 21, 50, 41, 60]
		print "Length of LIS is", lis(arr)
		
		##################################################################################

*/