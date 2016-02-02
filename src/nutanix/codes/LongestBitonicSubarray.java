package nutanix.codes;

public class LongestBitonicSubarray {

	static int getLongestBitonicSubarray(int[] arr)
	{
		if(arr.length <= 2)
			return arr.length;
		int maxSubarray = Integer.MIN_VALUE;
		int start = 0, end = 1, counter = 0;
		int minI = 0;
		int minJ = 0;
		
		while(end < arr.length){
			start = counter;
			int j = start;

			while(end < arr.length && (arr[j] <= arr[end])) 
			{
				j = end;
				end++;
				counter++;
			}
		
			while(end < arr.length && (arr[j] >= arr[end]))
			{
				j = end;
				counter++;
				end++;
			}

			int soFarMax = end - start;
			if(soFarMax > maxSubarray){
				minI = start;
				minJ = end-1;
				maxSubarray = soFarMax;
			}
		}

		return maxSubarray;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,4,3,2,4,5,6,2,1,3,4,5,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,20,19,18,17,16,15,14,13,12,11,10,9,10,11,12,10,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,119,118,117,116,115,114,113,112,111,110,109,108,107,106,105,104,103,102,101,100,99,98,97,96,95,94,93,92,91,90,20,19,18,17,16,15,9,8,7,6,5,4,3,2,1};
		//int[] a = {1,2,7,3,8};
		System.out.println(getLongestBitonicSubarray(a));
	}

}
