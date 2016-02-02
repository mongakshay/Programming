package nutanix.codes;

public class MinInSortedRotatedArray {

	
	static int minInSortedRotatedArray(int[] a, int start, int end){
		if(start>=end)
			return start;
		
		if(a[start] < a[end])
			return start;
		
		int mid = (start+end)/2;
		
		if(a[start] == a[end])
			return minInSortedRotatedArray(a, start+1, end);
		
		if(a[mid] < a[mid-1] && a[mid] < a[mid+1])
			return mid;
		
		if(a[mid] < a[end])
			return minInSortedRotatedArray(a,start,mid-1);
		else
			return minInSortedRotatedArray(a,mid+1,end);
	}
	
	public static void main(String[] args) {
		int[] a = {5, 6, 7, 9, 11, 2};
		System.out.println(a[minInSortedRotatedArray(a, 0, a.length-1)]);
	}

}
