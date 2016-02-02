package nutanix.codes;

import java.util.Iterator;
import java.util.Stack;

public class LISMonga {

	static int binSearchUtil(int[] T, int[] I, int start, int end, int item) {
		int index = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (mid < end && item > I[T[mid]] && item <= I[T[mid + 1]])
				return mid + 1;
			else {
				if (item > I[T[mid]]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return index;
	}

	static int LISmain(int[] I) {
		int[] T = new int[I.length];
		int[] R = new int[I.length];

		for (int i = 0; i < R.length; i++) {
			R[i] = -1;
		}

		int len = 0;
		T[0] = 0;
		for (int j = 1; j < T.length; j++) {
			if (I[j] < I[T[0]]) {
				T[0] = j;
			} else if (I[j] > I[T[len]]) {
				len++;
				T[len] = j;
				R[j] = T[len - 1];
			} else {
				int index = binSearchUtil(T, I, 0, len, I[j]);
				T[index] = j;
				R[j] = T[index - 1];
			}
		}

		Stack<Integer> s = new Stack<Integer>();
		for (int j = T[len]; j >= 0; j = R[j]) {
			s.push(I[j]);
		}
		System.out.print("Longest Increasing subsequence: ");
		while (!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}

		System.out.println("");
		return len + 1;
	}

	public static void main(String[] args) {
		int[] a = { 1, 22, 23, 24, 35 };
		int[] b = { 11, 2, 1, 4, 15 };
		System.out.println("Length: "+ LISmain(a));
	}

}
