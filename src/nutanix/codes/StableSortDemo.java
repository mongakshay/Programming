package nutanix.codes;


public class StableSortDemo {

	long[] theArray;
	
	public StableSortDemo(long[] a) {
		this.theArray = a;
	}

	private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
		if( lowerBound == upperBound ) // if range is 1,
			return; // no use sorting
		else {
				 // find midpoint
				int mid = (lowerBound+upperBound) / 2;
				// sort low half
				recMergeSort(workSpace, lowerBound, mid);
				// sort high half
				recMergeSort(workSpace, mid+1, upperBound);
				// merge them
				merge(workSpace, lowerBound, mid+1, upperBound);
			} // end else
	} // end recMergeSort()



	//-----------------------------------------------------------

	private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound) {

		int j = 0; // workspace index
		int lowerBound = lowPtr;
		int mid = highPtr-1;
		int n = upperBound-lowerBound+1; // # of items
		while(lowPtr <= mid && highPtr <= upperBound) {
			if( theArray[lowPtr] < theArray[highPtr] )
				workSpace[j++] = theArray[lowPtr++];
			else
				workSpace[j++] = theArray[highPtr++];
		}

		while(lowPtr <= mid) {
			workSpace[j++] = theArray[lowPtr++]; 
		}

		while(highPtr <= upperBound) {
			workSpace[j++] = theArray[highPtr++];
		}

		for(j=0; j<n; j++) {
			theArray[lowerBound+j] = workSpace[j];
		}

	} // end merge()


	void display(){
		for (int i = 0; i < theArray.length; i++) {
			System.out.print(theArray[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		long[] a = {9,1,2,2,3,4,3,5,5,1};
		StableSortDemo o = new StableSortDemo(a);
		o.recMergeSort(new long[a.length], 0, a.length-1);
		o.display();
	}

}