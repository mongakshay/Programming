package nutanix.codes;

public class PosNegSeparate {

	static int[] a ;
	
	static int[] doPosNegSeparate(int[] arr){
		a = arr;
		return doPosNegSeparateUtil(0,arr.length-1);
	}
	
	private static int[] doPosNegSeparateUtil(int start, int end) {
		if(start < end ){
			int mid = (start+end)/2;
			doPosNegSeparateUtil(start,mid);
			doPosNegSeparateUtil(mid+1,end);
			return doTheShuffle(start,mid,end);
		}
		return null;
	}

	private static int[] doTheShuffle(int start, int mid, int end) {
		int j = mid+1;
			while(start <= mid && a[start] < 0){  // both should be same symbol
				start++;
			}
			while(j <= end && a[j] < 0){ // both should be same symbol
				j++;
			}
			reverse(start, mid);
			reverse(mid+1, j-1);
			reverse(start, j-1);
		return a;
	}
	
	public static void reverse(int x, int y) {
		while (y > x) {
			int temp = a[x];
			a[x] = a[y];
			a[y] = temp;
			x++;
			y--;
		}
	}
	
	public static void main(String[] args) {
		int[] arrA = { 1, 2, -3, -4, -5, -7, -8, 9, -190, 10, -11, -12, -13, 14, -81};
		int[] updated = doPosNegSeparate(arrA);
		for (int i = 0; i < updated.length; i++) {
			System.out.print(updated[i]+" ");
		}
	}

}
