package Trie;

import java.util.LinkedList;
import java.util.Queue;


public class TST<Value> {
	private int N; // size
	private Node<Value> root; // root of TST

	// ############################################ NODE Class #####################################
	
	private static class Node<Value> {
		private char c; // character
		private Node<Value> left, mid, right; // left, middle, and right
		
	//______________________________________________________________________________________________
		
		private Value val; // value associated with string
	}

	public TST() {
	}

	public int size() {
		return N;
	}

	public boolean contains(String key) {
		return get(key) != null;
	}

	// ############################################ GET #####################################
	public Value get(String key) {
		if (key == null)
			throw new NullPointerException();
		if (key.length() == 0)
			throw new IllegalArgumentException("key must have length >= 1");
		Node<Value> x = get(root, key, 0);
		if (x == null)
			return null;
		return x.val;
	}

	private Node<Value> get(Node<Value> x, String key, int d) {
		if (key == null)
			throw new NullPointerException();
		if (key.length() == 0)
			throw new IllegalArgumentException("key must have length >= 1");
		if (x == null)
			return null;
		char c = key.charAt(d);
		if (c < x.c)
			return get(x.left, key, d);
		else if (c > x.c)
			return get(x.right, key, d);
		else if (d < key.length() - 1)
			return get(x.mid, key, d + 1);
		else
			return x;
	}
	//***************************************************************************************
	
	
	
	
	// ############################################ PUT #####################################	
	public void put(String key, Value val) {
		if (!contains(key))
			N++;
		root = put(root, key, val, 0);
	}

	private Node<Value> put(Node<Value> x, String key, Value val, int d) {
		char c = key.charAt(d);
		if (x == null) {
			x = new Node<Value>();
			x.c = c;
		}
		if (c < x.c)
			x.left = put(x.left, key, val, d);
		else if (c > x.c)
			x.right = put(x.right, key, val, d);
		else if (d < key.length() - 1)
			x.mid = put(x.mid, key, val, d + 1);
		else
			x.val = val;
		return x;
	}
	//*****************************************************************************************
	
	
	
	
	// ############################################ longest Prefix from the dictionary #####################################
	public String longestPrefixOf(String query) {
		if (query == null || query.length() == 0)
			return null;
		int length = 0;
		Node<Value> x = root;
		int i = 0;
		while (x != null && i < query.length()) {
			char c = query.charAt(i);
			if (c < x.c)
				x = x.left;
			else if (c > x.c)
				x = x.right;
			else {
				i++;
				if (x.val != null){
					length = i;
				}
				x = x.mid;
			}
		}
		return query.substring(0, length);
	}
	//***********************************************************************************************************************
	
	
	
	
	public Iterable<String> keys() {
		Queue<String> queue = new LinkedList<String>();
		collect(root, new StringBuilder(), queue);
		return queue;
	}

	
	
	
	// ############################################ keysWithPrefix MAIN FUNCTION #####################################
	
	public Iterable<String> keysWithPrefix(String prefix) {
		Queue<String> queue = new LinkedList<String>();
		Node<Value> x = get(root, prefix, 0);
		if (x == null)
			return queue;
		if (x.val != null)
			queue.add(prefix);
		collect(x.mid, new StringBuilder(prefix), queue);
		return queue;
	}

	// all keys in subtrie rooted at x with given prefix
	private void collect(Node<Value> x, StringBuilder prefix,
			Queue<String> queue) {
		if (x == null)
			return;
		collect(x.left, prefix, queue);
		if (x.val != null)
			queue.add(prefix.toString() + x.c);
		collect(x.mid, prefix.append(x.c), queue);
		prefix.deleteCharAt(prefix.length() - 1);
		collect(x.right, prefix, queue);
	}
	//*****************************************************************************************************************
	
	

	// ############################################ keys That Match asd.a.sd. #####################################
	
	public Iterable<String> keysThatMatch(String pattern) {
		Queue<String> queue = new LinkedList<String>();
		collect(root, new StringBuilder(), 0, pattern, queue);
		return queue;
	}

	private void collect(Node<Value> x, StringBuilder prefix, int i,
			String pattern, Queue<String> queue) {
		if (x == null)
			return;
		char c = pattern.charAt(i);
		if (c == '.' || c < x.c)
			collect(x.left, prefix, i, pattern, queue);
		if (c == '.' || c == x.c) {
			if (i == pattern.length() - 1 && x.val != null)
				queue.add(prefix.toString() + x.c);
			if (i < pattern.length() - 1) {
				collect(x.mid, prefix.append(x.c), i + 1, pattern, queue);
				prefix.deleteCharAt(prefix.length() - 1);
			}
		}
		if (c == '.' || c > x.c)
			collect(x.right, prefix, i, pattern, queue);
	}

	//*****************************************************************************************************************
	
	public static void main(String[] args) {

		// build symbol table from standard input
		/*
		 * TST<Integer> st = new TST<Integer>(); for (int i = 0;
		 * !StdIn.isEmpty(); i++) { String key = StdIn.readString(); st.put(key,
		 * i); }
		 */

		TST<Integer> st = new TST<Integer>();
		st.put("she", 0);
		st.put("sells", 1);
		st.put("sea", 2);
		st.put("shells", 3);
		st.put("shellso", 4);
		st.put("shellsor", 9);
		st.put("sea", 5);
		st.put("shore", 6);
		st.put("How to fix computer", 7);
		st.put("How to write a check", 7);

		// print results
		if (st.size() < 100) {
			System.out.println("keys(\"\"):");
			for (String key : st.keys()) {
				System.out.println(key + " " + st.get(key));
			}
			System.out.println();
		}

		System.out.println("longestPrefixOf(\"shellsorting\"):");
		System.out.println(st.longestPrefixOf("shellsorting"));
		System.out.println();

		System.out.println("longestPrefixOf(\"shell\"):");
		System.out.println(st.longestPrefixOf("shell"));
		System.out.println();

		System.out.println("keysWithPrefix(\"How\"):");
		for (String s : st.keysWithPrefix("How"))
			System.out.println(s);
		System.out.println();

		System.out.println("keysThatMatch(\".he.l.\"):");
		for (String s : st.keysThatMatch(".he.l."))
			System.out.println(s);
	}
}