package wayfair.code;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;

public class ArrayCodes {

	static void maxOneIndex(int[] arr) {
		int count = 0;
		int n = arr.length;

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println(" ");

		while (count < n) {
			if (arr[count] == 1) {
				int sum = 0;
				while (count < n && arr[count] == 1) {
					sum += arr[count];
					count += 1;
				}
				arr[count - 1] = sum;
			} else {
				count += 1;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	class Person {
		int salary;
		String name;

		public Person(int salary, String name) {
			super();
			this.salary = salary;
			this.name = name;
		}
	}

	class MyComparator implements Comparator<Person> {
		public int compare(Person x, Person y) {
			return y.salary - x.salary;
		}
	}

	public void priorityQueueDemo() {

		int[][] a = new int[10][11]; // m x n
		int m = a.length;
		int n = a[0].length;

		System.out.println(" -- > " + m * n);
		HashMap<String, String> s = new HashMap<String, String>(10);

		Set<String> s1 = new HashSet<String>();

		PriorityQueue<Person> maxHeap = new PriorityQueue<Person>(10,
				new MyComparator());
		maxHeap.add(new Person(10000, "Akshay1"));
		maxHeap.add(new Person(1000, "Akshay2"));
		maxHeap.add(new Person(100, "Akshay3"));
		maxHeap.add(new Person(10, "Akshay4"));
		maxHeap.add(new Person(199999, "Akshay5"));
		int c = 0;

		maxHeap.remove(new Person(1000, "akshay2"));

		while (c < 5) {
			System.out.println(maxHeap.poll().name);
			c++;
		}
		// System.out.println(maxHeap.poll()); -> null if nothing there
	}

	/*
	 * Random r = new Random(); int Low = 10; int High = 100; int Result =
	 * r.nextInt(High-Low) + Low;
	 * ------------------------------------------------------------------------
	 * ########################## RESERVOIR SAMPLING ##########################
	 * ------------------------------------------------------------------------
	 */
	public static void selectKRand(int[] arr, int k) {
		int[] reservoir = new int[k];

		for (int i = 0; i < k; i++) {
			reservoir[i] = arr[i];
		}

		for (int j = k; j < arr.length; j++) {
			int r = (new Random()).nextInt(j);
			if (r < k)
				reservoir[r] = arr[j];
		}
		for (int i = 0; i < reservoir.length; i++) {
			System.out.print(reservoir[i] + " ");
		}
		System.out.println(" ");
	}

	/*
	 * ------------------------------------------------------------------------
	 * ########################## RESERVOIR SAMPLING ##########################
	 * ------------------------------------------------------------------------
	 */

	/*
	 * Dutch flag problem
	 * 
	 * 1,0,1,2,1,1,0,0,0,1,1,1,2,2,0,1,2,0 --> 0 0 0 0 0 0 1 1 1 1 1 1 1 1 2 2 2
	 * 2
	 */
	static void DutchflagProblem(int a[], int arr_size) {
		int lo = 0;
		int hi = arr_size - 1;
		int mid = 0, temp = 0;
		while (mid <= hi) {
			switch (a[mid]) {
			case 0: {
				temp = a[lo];
				a[lo] = a[mid];
				a[mid] = temp;
				lo++;
				mid++;
				break;
			}
			case 1:
				mid++;
				break;
			case 2: {
				temp = a[mid];
				a[mid] = a[hi];
				a[hi] = temp;
				hi--;
				break;
			}
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static int maxProduct(int[] A) {
		
		if (A == null || A.length == 0)
			return 0;

		int maxLocal = A[0];
		int minLocal = A[0];
		int global = A[0];

		for (int i = 1; i < A.length; i++) {
			int temp = maxLocal;
			maxLocal = Math.max(Math.max(A[i] * maxLocal, A[i]), A[i]* minLocal);
			minLocal = Math.min(Math.min(A[i] * temp, A[i]), A[i] * minLocal);
			global = Math.max(global, maxLocal);
		}
		return maxLocal;
	}

	
	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1 , 1, 1, 0};
		//maxOneIndex(arr);
		// (new ArrayCodes()).priorityQueueDemo();
		// int[] arr2 = {1,2,3,4,5,6,7,8,9};
		// selectKRand(arr2, 8);
		int[] a = { -2, -31, -4, -1, -2, 1, 5, -3 };
		// DutchflagProblem(a, a.length);
	}

}
