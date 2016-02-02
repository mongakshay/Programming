package wayfair.code;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class PermuteCombiCodes {

	static int count = 0;
	static int findCombinationsCount(int amount, int coins[]) {
	    return findCombinationsCount(amount, coins, 0);
	}
	
	
	static int findCombinationsCount(int amount, int coins[], int checkFromIndex) {
		if (amount == 0)
	        return 1;
	    else if (amount < 0 || coins.length == checkFromIndex)
	        return 0;
	    else {
	        int withFirstCoin = findCombinationsCount(amount-coins[checkFromIndex], coins, checkFromIndex);
	        int withoutFirstCoin = findCombinationsCount(amount, coins, checkFromIndex+1);
	        return withFirstCoin + withoutFirstCoin;
	    }
	}
	
//  { 1, 2, 3, 4 } and k is 2 --> {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4} and {3, 4}.
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
	
	/* 
	   1111111... 15
	   10 5
	   10 11111
	   11 1111
	   11111...(10) 5
	   5 5 11111
	   10	 
	 */

	    // unique count of the combinations. -> 12
	    public static void combinationSum(int[] candidates, int target) {
	        Arrays.sort(candidates);
	        getResult( new ArrayList<Integer>(), candidates, target, 0, 0);
	    }
	
	    // 7877643
	    private static void getResult( List<Integer> cur, int candidates[], int target, int start, int r){
	        if(target > 0){
	            for(int i = start; i < candidates.length && target >= candidates[i]; i++){
	            	r += candidates[i];
	                getResult(cur, candidates, target - candidates[i], i, r);
	                r -= candidates[start];
	            }
	        }else if(target == 0 ){
	            count+=1;
	        }
	    }
	
	    // list of unique combinations.  ->  ({1,2,3},{1,2,9,3},{1,2,3,4})
	    public static List<List<Integer>> getCombinationSum(int[] candidates, int target) {
	        Arrays.sort(candidates);
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        getResult(result, new ArrayList<Integer>(), candidates, target, 0);
	
	        return result;
	    }
	
	    
	    private static void getResult(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start){
	        if(target > 0){
	            for(int i = start; i < candidates.length && target >= candidates[i]; i++){
	                cur.add(candidates[i]);
	                getResult(result, cur, candidates, target - candidates[i], i+1);
	                cur.remove(cur.size() - 1);
	            }
	        }
	        else if(target == 0 ){
	            result.add(new ArrayList<Integer>(cur));
	        }
	    }
	    
	    //Given a digit string, return all possible letter combinations that the number could represent.
	    //A mapping of digit to letters (just like on the telephone buttons) is given below.
	    
	    //My java solution with FIFO queue
	    public static List<String> letterCombinations(String digits) {
	        LinkedList<String> ans = new LinkedList<String>();
	        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	        ans.add("");
	        for(int i = 0; i < digits.length(); i++){
	            int x = Character.getNumericValue(digits.charAt(i));
	            while(ans.peek().length() == i){
	                String t = ans.remove();
	                for(char s : mapping[x].toCharArray())
	                    ans.add( t + s );
	                }
	            }
	        return ans;
	        }
	    
	    /*
	     Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
	     For example,
	     If n = 4 and k = 2, a solution is
	     */
	    public List<List<Integer>> combine(int n, int k) {
	        if (k == n || k == 0) {
	            List<Integer> row = new LinkedList<>();
	            for (int i = 1; i <= k; ++i) {
	                row.add(i);
	            }
	            return new LinkedList<>(Arrays.asList(row));
	        }
	        List<List<Integer>> result = this.combine(n - 1, k - 1);
	        //result.forEach(e -> e.add(n));    ADD THIS
	        result.addAll(this.combine(n - 1, k));
	        return result;
	    }
	    
	    /*
	     Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
	     For example,
	     If n = 4 and k = 2, a solution is:
	     */
	    public static List<List<Integer>> combineIt(int n, int k) {
	        List<List<Integer>> combs = new ArrayList<List<Integer>>();
	        combine(combs, new ArrayList<Integer>(), 1, n, k);
	        return combs;
	    }
	    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
	        if(k==0) {
	            combs.add(new ArrayList<Integer>(comb));
	            return;
	        }
	        for(int i=start;i<=n;i++) {
	            comb.add(i);
	            combine(combs, comb, i+1, n, k-1);
	            comb.remove(comb.size()-1);
	        }
	    }
	    
	    //Longest substring with unique char
	    public int lengthOfLongestSubstring(String s) {
	        if(s.length()==0)  return 0;
	        char[] str=s.toCharArray();
	        int max=1;
	        int i = 0;
	        int j = 0;
	        int k;
	        int step =1;
	        int count=1;
	        int index=-1;
	        while(i<str.length-1){
	            k=i;
	            if(j==str.length) break;
	            for(j=i+step;j<str.length;j++){
	                index=findChar(str,i,j);
	                if(index==-1){
	                    count++;
	                }
	                else break;

	            }
	            if(count>max) max=count;
	            if(count==1||index+1==j){
	                        step=1;
	                        i=index+1;
	                        count=1;
	                    }else{
	                        i=index+1;
	                        step=j-i+1;
	                        count=count-(index-k);
	                    }
	        }
	        return max;
	    }
	    public int findChar(char[] str,int begin,int end){
	        for(int i=begin;i<end;i++){
	            if(str[i]==str[end])
	                return i;
	        }
	        return -1;
	    }
	    
	    /*
	     IMP:  https://leetcode.com/problems/combination-sum-iii/
	     
	     Find all possible combinations of k numbers that add up to a number n, 
	     given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
	     
	     Ensure that numbers within the set are sorted in ascending order.
	     
	     Example 1:
			Input: k = 3, n = 7
			Output: [[1,2,4]]

		Example 2:
			Input: k = 3, n = 9
			Output: [[1,2,6], [1,3,5], [2,3,4]]

	     */
	    public List<List<Integer>> combinationSum3(int k, int n) {
	        List<List<Integer>> ans = new ArrayList<>();
	        combination(ans, new ArrayList<Integer>(), k, 1, n);
	        return ans;
	    }

	    private void combination(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int n) {
	        if (comb.size() == k && n == 0) {
	            List<Integer> li = new ArrayList<Integer>(comb);
	            ans.add(li);
	            return;
	        }
	        for (int i = start; i <= 9; i++) {
	            comb.add(i);
	            combination(ans, comb, k, i+1, n-i);
	            comb.remove(comb.size() - 1);
	        }
	    }

	    static int numberOfPaths(int m, int n)
	    {
	        // Create a 2D table to store results of subproblems
	        int[][]count = new int[m][n];
	     
	        // Count of paths to reach any cell in first column is 1
	        for (int i = 0; i < m; i++)
	            count[i][0] = 1;
	     
	        // Count of paths to reach any cell in first column is 1
	        for (int j = 0; j < n; j++)
	            count[0][j] = 1;
	     
	        // Calculate count of paths for other cells in bottom-up manner using
	        // the recursive solution
	        for (int i = 1; i < m; i++)
	        {
	            for (int j = 1; j < n; j++)
	     
	                // By uncommenting the last part the code calculatest he total
	                // possible paths if the diagonal Movements are allowed
	                count[i][j] = count[i-1][j] + count[i][j-1]; //+ count[i-1][j-1];
	     
	        }
	        return count[m-1][n-1];
	    }
	    
	    static void priorityQueueTest() {
	    	PriorityQueue<String> s = new PriorityQueue<String>();
		}

	    public static void buildStrings(char[] root, int length)
	    {
	        // allocate an int array to hold the counts:
	        int[] pos = new int[length];
	        // allocate a char array to hold the current combination:
	        char[] combo = new char[length];
	        // initialize to the first value:
	        for(int i = 0; i < length; i++)
	            combo[i] = root[0];

	        while(true)
	        {
	            // output the current combination:
	            System.out.println(String.valueOf(combo));

	            // move on to the next combination:
	            int place = length - 1;
	            while(place >= 0)
	            {
	                if(++pos[place] == root.length)
	                {
	                    // overflow, reset to zero
	                    pos[place] = 0;
	                    combo[place] = root[0];
	                    place--; // and carry across to the next value
	                }
	                else
	                {
	                    // no overflow, just set the char value and we're done
	                    combo[place] = root[pos[place]];
	                    break;
	                }
	            }
	            if(place < 0)
	                break;  // overflowed the last position, no more combinations
	        }
	    }
	     
	        private static void permuteString(String str) {
	            permutation("", str);
	     
	        }
	     
	        private static void permutation(String prefix, String str) {
	            int n = str.length();
	            if (n == 0)
	                System.out.println(prefix);
	            else {
	                for (int i = 0; i < n; i++)
	                    permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
	            }
	        }
	    
	public static void main(String[] args){
	
			int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
			//combinationSum(arr,80);
			for(List<Integer> l : getCombinationSum(arr, 35)){
				for(int i: l)
					System.out.print(i+" ");
				System.out.println(" ");
			}
			//System.out.println(" LEET's SOL: "+ getCombinationSum(arr, 4).size());
			//System.out.println(" MY SOL: "+ count); 
			//for(String s: letterCombinations("2653382")){
		//		System.out.println("------>  "+s);
		//	}
			//permuteString("akshay");
			//buildStrings("ABC".toCharArray(),"ABC".length());
			//System.out.println(getCombinationSum(arr, 12));
			
	}
}
