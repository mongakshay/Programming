package string.codes;


/******************************************************************************
 *  Compilation:  javac Permutations.java
 *  Execution:    java Permutations N
 *  
 *  Enumerates all permutations on N elements.
 *  Two different approaches are included.
 *
 *  % java Permutations 3
 *  abc
 *  acb
 *  bac 
 *  bca
 *  cab
 *  cba
 *
 ******************************************************************************/

public class Permutations {

    // print N! permutation of the characters of the string s (in order)
    public  static void perm1(String s) { perm1("", s); }
    private static void perm1(String prefix, String s) {
        int N = s.length();
        if (N == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < N; i++)
               perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, N));
        }

    }
   
    
    // print N! permutation of the elements of array a (not in order)
    public static void perm2(String s) {
        int N = s.length();
        char[] a = new char[N];
        for (int i = 0; i < N; i++)
            a[i] = s.charAt(i);
        perm2(a, N);
    }

    private static void perm2(char[] a, int n) {
        if (n == 1) {
        	System.out.println(a);
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n-1);
            perm2(a, n-1);
            swap(a, i, n-1);
        }
    }  
    
   static int CountOne(int number){
        int count = 0;
        for(int i=0; i <32;i++){
            if((number&1) == 1){
                count++;
            }
            number = number >>> 1;
        }
        return count;
    }

    // swap the characters at indices i and j
    private static void swap(char[] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }

    public static void getAllChars(String s){
    	char[] arr = s.toCharArray();
    	getAllCharsUtil(arr, arr.length ,0, "", 0);
    }

    /*
    INPUT:  ABCD 
    OUTPUT: A
			AB
			ABC
			ABCD
			B
			BC
			BCD
			C
			CD
			D
     */
    private static void getAllCharsUtil(char[] arr, int length, int count, String s, int x) {
    	if(x < length) {
    		int c = x;
    		while(c < length){
    			s += arr[c];
    			System.out.println(s);
    			c++;
    		}
    		getAllCharsUtil(arr, length, count, "", x+1);
    	}else
    		return;
    	}

	public static void main(String[] args) {
        int N = Integer.parseInt("4");
        String alphabet = "abc";
        //String elements = alphabet.substring(0, N);
        //perm2("abc");
        System.out.println(CountOne(3));
        //getAllChars("ABCDCBAXYX");
        //System.out.println();
    }
}

/*
   input: ab and k = 3
   output: aaa
		   aab
		   aba
		   abb
		   baa
		   bab
		   bba
		   bbb
		   
	  	 0 . . . ...... N
		/   \       / ........\   
	   0     N     0           N
	 /. .\
	0     N
	  
    static void printAllKLength(char set[], int k) {
        int n = set.length;        
        printAllKLengthRec(set, "", n, k);
    }
 
    // The main recursive method to print all possible strings of length k
    static void printAllKLengthRec(char set[], String prefix, int n, int k) {
         
        // Base case: k is 0, print prefix
        if (k == 0) {
            System.out.println(prefix);
            return;
        }
 
        // One by one add all characters from set and recursively 
        // call for k equals to k-1
        for (int i = 0; i < n; ++i) {
             
            // Next character of input added
            String newPrefix = prefix + set[i]; 
             
            // k is decreased, because we have added a new character
            printAllKLengthRec(set, newPrefix, n, k - 1); 
        }
    }
}

/*
Input: ABC
Output: All permutations of ABC with repetition are:
       AAA
       AAB
       AAC
       ABA
       ...
       ...
       CCB
       CCC

# Python program to print all permutations with repetition
# of characters
 
def toString(List):
    return ''.join(List)
 
# The main function that recursively prints all repeated
# permutations of the given string. It uses data[] to store
# all permutations one by one

def allLexicographicRecur(string, data, last, index):
    length = len(string)
    for i in xrange(length):
        data[index] = string[i]
        if index==last:
            print toString(data)
        else:
            allLexicographicRecur(string, data, last, index+1)
 
def allLexicographic(string):
    length = len(string)
    data = [""] * (length+1)
 
    string = sorted(string)
 
    # Now print all permutaions
    allLexicographicRecur(string, data, length-1, 0)
 
# Driver program to test the above functions
string = "ABC"
print "All permutations with repetition of " + string + " are:"
allLexicographic(string)
 
*/