/*package string.codes;


*//******************************************************************************
 *  Compilation:  javac PermutationsLex.java
 *  Execution:    java PermutationsLex N
 *  
 *  Generate all N! permutations of N elements in lexicographic order.
 *
 *  This program is a Java version based on the program Permlex.c
 *  writen by Frank Ruskey and Joe Sawada.
 *  
 *     http://theory.cs.uvic.ca/inf/perm/PermInfo.html
 * 
 *  % java PermutationsLex 3
 *  012
 *  021
 *  102
 *  120
 *  201
 *  210
 *
 ******************************************************************************//*


public class PermutationsLex {

    public static void show(int[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.printf("%d", a[i]);
        System.out.printf("\n");
    } 

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean hasNext(int[] a) {
        int N = a.length;

        // find rightmost element a[k] that is smaller than element to its right
        int k; 
        for (k = N-2; k >= 0; k--)
            if (a[k] < a[k+1]) break;
        if (k == -1) return false;

        // find rightmost element a[j] that is larger than a[k]
        int j = N-1;
        while (a[k] > a[j])
            j--;
        swap(a, j, k);

        for (int r = N-1, s = k+1; r > s; r--, s++)
            swap(a, r, s);

        return true;
    }

    public static void perm(int N) {

        // initialize permutation
        int[] a  = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = i;

        // print permutations
        show(a);
        while (hasNext(a))
           show(a);
    }


    public static void main(String[] args) {
        int N = 9;//Integer.parseInt(args[0]);
        perm(N);
    }
}*/

package string.codes;

import java.util.Arrays;


/******************************************************************************
 *  Compilation:  javac PermutationsLex.java
 *  Execution:    java PermutationsLex N
 *  
 *  Generate all N! permutations of N elements in lexicographic order.
 *
 *  This program is a Java version based on the program Permlex.c
 *  writen by Frank Ruskey and Joe Sawada.
 *  
 *     http://theory.cs.uvic.ca/inf/perm/PermInfo.html
 * 
 *  % java PermutationsLex 3
 *  012
 *  021
 *  102
 *  120
 *  201
 *  210
 *
 ******************************************************************************/


public class PermutationsLex {

    public static void show(char[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i]);
        System.out.println(" ");
    } 

    public static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean hasNext(char[] a) {
        int N = a.length;

        // find rightmost element a[k] that is smaller than element to its right
        int k; 
        for (k = N-2; k >= 0; k--)
            if (a[k] < a[k+1]) break;
        if (k == -1) return false;

        // find rightmost element a[j] that is larger than a[k]
        int j = N-1;
        while (a[k] > a[j])
            j--;
        swap(a, j, k);

        for (int r = N-1, s = k+1; r > s; r--, s++)
            swap(a, r, s);

        return true;
    }

    public static void perm(char[] N) {

        // initialize permutation
        char[] a  = new char[N.length];
        for (int i = 0; i < N.length; i++)
            a[i] = N[i];

        // print permutations
        show(a);
        while (hasNext(a))
           show(a);
    }


    public static void main(String[] args) {
        String s = "string";
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        perm(arr);
    }
}