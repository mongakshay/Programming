package wayfair.code;

import java.util.ArrayList;
import java.util.Random;


public class RearrageArrayPositiveNegative {
	int[] arrA;

	public RearrageArrayPositiveNegative(int[] arrA) {
		this.arrA = arrA;
	}

	public void divideGroups(int low, int high) {
		if (low >= high)
			return;
		int mid = (low + high) / 2;
		divideGroups(low, mid);
		divideGroups(mid + 1 , high);
		merge(low, mid, high);

	}

	public void merge(int low, int mid, int high) {
		int l = low;
		int k = mid + 1;
		while (l <= mid && arrA[l] > 0)   // ++++----- //while (l <= mid && arrA[l] <= 0) // -----++++
			l++;
		while (k <= high && arrA[k] > 0) // while (k <= high && arrA[k] <= 0)
			k++;
		reverse(l, mid);
		reverse(mid + 1, k - 1);
		reverse(l, k - 1);
	}

	public void reverse(int x, int y) {
		while (y > x) {
			int temp = arrA[x];
			arrA[x] = arrA[y];
			arrA[y] = temp;
			x++;
			y--;
		}
	}

	public void display() {
		for (int i = 0; i < arrA.length; i++) {
			System.out.print(" " + arrA[i]);
		}
	}
	
	// #################################################################
	 
	private void extraSpace() {
		int[] space = new int[this.arrA.length];
		int count = 0;
		for (int i = 0; i < arrA.length; i++) {
			if(arrA[i] < 0)
				space[count++] = arrA[i];
		}
		
		for (int i = 0; i < arrA.length; i++) {
			if(arrA[i] > 0)
				space[count++] = arrA[i];
		}
		System.out.println(" ");
		for (int i = 0; i < space.length; i++) {
			System.out.print(" " + space[i]);
		}
	}
	
	// #################################################################
	
	static int sortedRotatedMinIndex(int[] a, int low, int high) {
		if(a[low] < a[high])
			return low;
		else{
			int mid = (low + high)/2;
			if((a[mid] > a[high]) && a[mid+1] < a[mid])
				return mid+1;
			if((a[mid] < a[high]) && a[mid-1] > a[mid])
				return mid;
			if(a[mid] > a[high])
				return sortedRotatedMinIndex(a, mid+1, high);
			else
				return sortedRotatedMinIndex(a, low, mid-1);
		}
		
	}

	static int sortedRotatedMin(int[] a, int low, int high) {
		if(a[low] < a[high])
			return a[low];
		else{
			int mid = (low + high)/2;
			if((a[mid] > a[high]) && a[mid+1] < a[mid])
				return a[mid+1];
			if((a[mid] < a[high]) && a[mid-1] > a[mid])
				return a[mid];
			if(a[mid] > a[high])
				return sortedRotatedMin(a, mid+1, high);
			else
				return sortedRotatedMin(a, low, mid-1);
		}
		
	}
	static int sortedRotatedMinRev(int[] a, int low, int high) {
		if(a[high] < a[low])
			return a[high];
		else{
			int mid = (low + high)/2;
			if((a[mid] < a[low]) && a[mid+1] > a[mid])
				return a[mid];
			if((a[mid] > a[low]) && a[mid-1] < a[mid])
				return a[mid-1];
			if(a[mid] < a[high])
				return sortedRotatedMinRev(a, mid+1, high);
			else
				return sortedRotatedMinRev(a, low, mid-1);
		}
		
	}
	
	public static void findKRand(int[] a) {
		System.out.println(new Random().nextInt(a.length));
	}
	
	public static void Kcombination(int[] a, int k) {
		ArrayList<Integer> arr = new ArrayList<Integer>(k);
		kcombinationUtil(a, k, arr, 0,0);
	}
	
	//  { 1, 2, 3, 4 } and k is 2 --> {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4} and {3, 4}.
	private static void kcombinationUtil(int[] a, int k, ArrayList<Integer> arr, int count, int j) {
		if(count == k){
			for (Integer data : arr) {
				System.out.print(data+ " ");
			}
			System.out.println(" ");
		}else{
			for (int i = j; i < a.length; i++) {
				arr.add(a[i]);
				kcombinationUtil(a, k, arr, count + 1, i+1);
				arr.remove(arr.size()-1);
			}
		}
	}

/*    // A binary search based function that returns index of a peak
    // element
    static int findPeakUtil(int arr[], int low, int high, int n, ArrayList<Integer> alist)
    {
        // Find index of middle element
        int mid = low + (high - low)/2;   (low + high)/2 
 
        // Compare middle element with its neighbours (if neighbours
        // exist)
        if ((mid == 0 || arr[mid-1] <= arr[mid]) && (mid == n-1 ||
             arr[mid+1] <= arr[mid]))
        	alist.add(arr[mid]);
 
        // If middle element is not peak and its left neighbor is
        // greater than it,then left half must have a peak element
        else { 
        	if (mid > 0 && arr[mid-1] > arr[mid]){
        		int x = findPeakUtil(arr, low, (mid -1), n, alist);
        		alist.add(arr[x]);
        	}
        	if (arr[mid+1] > arr[mid]) {
        // If middle element is not peak and its right neighbor
        // is greater than it, then right half must have a peak
        // element
        		int y = findPeakUtil(arr, (mid + 1), high, n, alist);
        		alist.add(arr[y]);
        	}
        }
        
        for(Integer i : alist){
        	System.out.print(i + " ");
        }
        System.out.println(" ");
		return 0;
    }
    
 
    // A wrapper over recursive function findPeakUtil()
    static int findPeak(int arr[], int n)
    {
    	ArrayList<Integer> alist = new ArrayList<Integer>();
        return findPeakUtil(arr, 0, n-1, n, alist);
    }
    */
	
	   static int findPeakUtil(int arr[], int low, int high, int n)
	    {
	        // Find index of middle element
	        int mid = low + (high - low)/2;  /* (low + high)/2 */
	 
	        // Compare middle element with its neighbours (if neighbours
	        // exist)
	        if ((mid == 0 || arr[mid-1] <= arr[mid]) && (mid == n-1 ||
	             arr[mid+1] <= arr[mid]))
	            return mid;
	 
	        // If middle element is not peak and its left neighbor is
	        // greater than it,then left half must have a peak element
	        else if (mid > 0 && arr[mid-1] > arr[mid])
	            return findPeakUtil(arr, low, (mid -1), n);
	 
	        // If middle element is not peak and its right neighbor
	        // is greater than it, then right half must have a peak
	        // element
	        else return findPeakUtil(arr, (mid + 1), high, n);
	    }
	 
	    // A wrapper over recursive function findPeakUtil()
	    static int findPeak(int arr[], int n)
	    {
	        return findPeakUtil(arr, 0, n-1, n);
	    }
	 
	    
		
	    /*
	    	Random r = new Random();
	    	int Low = 10;
	    	int High = 100;
	    	int Result = r.nextInt(High-Low) + Low;
	    	------------------------------------------------------------------------
	    	########################## RESERVOIR SAMPLING ##########################
	    	------------------------------------------------------------------------
	     */
	    
	    	public static void selectKRand(int[] arr, int k) {
	    		int[] reservoir = new int[k];
	    		
	    		for (int i = 0; i < k; i++) {
	    			reservoir[i] = arr[i];
	    		}
	    		
	    		for (int j = k; j < arr.length; j++) {
	    			int r = (new Random()).nextInt(j+1);
	    			if(r == k)
	    				reservoir[r] = arr[j];
	    		}
	    		for (int i = 0; i < reservoir.length; i++) {
	    			System.out.print(reservoir[i] + " ");
	    		}
	    		System.out.println(" ");
	    	}
	    	
	    	/*
	    	------------------------------------------------------------------------
	    	########################## RESERVOIR SAMPLING ##########################
	    	------------------------------------------------------------------------
	    	*/
	    	
	    	static boolean IsSubstring (String s, String t)
	    	{
	    	   for (int i = 0; i <= (s.length() - t.length()); i++)
	    	   {
	    	      boolean found = true;

	    	      for (int j = 0; found && j < t.length(); j++)
	    	      {
	    	         if (s.charAt(i + j) != t.charAt(j))
	    	             found = false;
	    	      }

	    	      if (found)
	    	         return true;
	    	   }

	    	   return false;
	    	}
	    	
	public static void main(String args[]) {
		
		//"sda".contains("asda");
		//int[] a = { 1, -2, -3, -4, 5, -6, 7, -8, 9, -10, -11, -12, 20 };
		int[] a = { 1, 2, -3, -4, -5};
		RearrageArrayPositiveNegative r = new RearrageArrayPositiveNegative(a);
		System.out.print("Input : ");
		r.display();
		r.divideGroups(0, a.length - 1);
		System.out.println("");
		System.out.print("ReArranged Output : ");
		r.display();
		 
		int[] a1 = {4,3,2,1,0,9,8,7,6,5,11, 12};
		int[] a2 = {7,8,9,10,1,2,3,4,5,6};
		//System.out.println(sortedRotatedMinRev(a1, 0, a1.length-1));
		//System.out.println(sortedRotatedMin(a2, 0, a2.length-1));
		//System.out.println(sortedRotatedMinIndex(a2, 0, a2.length-1));
		//findKRand(a2);
		int[] a3 = {1,2,3,4};
		//Kcombination(a3, 2);
		//findPeak(a1,a1.length);
		//selectKRand(a1,10);
		//System.out.println(IsSubstring("abcdef", "abcdefaasdabcdef"));
	}
}
