package nutanix.codes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class element {
	String val;
	List<Integer> index = new ArrayList<Integer>();

	public element(String s, int i) {
		val = s;
		index.add(i);
	}

	public element(String s, List<Integer> i) {
		val = s;
		index.addAll(i);
	}
}

public class SrcToDestString {

	static void reachDestString(String src, String dst) {

		char[] source = src.toCharArray();
		Stack<element> worker = new Stack<element>();
		Queue<String> q = new LinkedList<String>();
		int i = 0;
		int index = -1;
		char[] destination = dst.toCharArray();
		q.add(src);
		worker.add(new element(src, -1));

		while (!worker.isEmpty()) {
			element x = worker.pop();

			Queue<element> newE = getValidNextVersion(x.val.toCharArray(),
					destination, x.index);
			for (element el : newE) {
				q.add(el.val);
				worker.add(el);
			}
		}
		// q.add("DOG");
		// access via Iterator
		Iterator iterator = q.iterator();
		while (iterator.hasNext()) {
			String element = (String) iterator.next();
			System.out.println(element);
		}

	}

	static private Queue<element> getValidNextVersion(char[] s, char[] d,
			List<Integer> skip) {

		Queue<element> result = new LinkedList<element>();

		int N = 0;
		while (N < s.length) {
			if (skip.contains(N)) {
				N++;
				continue;
			}
			char temp = s[N];
			s[N] = d[N];
			if (checkIfInDict(String.valueOf(s))) {
				skip.add(N);
				result.add(new element(String.valueOf(s), skip));
			}
			s[N] = temp;
			N++;
		}
		return result;
	}

	static private boolean checkIfInDict(String s) {
		return s.equals("COT") || s.equals("COG") || s.equals("DOT") || s.equals("DOG");
	}

	public static void main(String[] args) {

		reachDestString("CAT", "DOG");
		/*
		 * for(element e: getValidNextVersion("CAT".toCharArray(),
		 * "DOG".toCharArray(),-1)) System.out.println(e.val+" "+e.index);
		 */

	}

}
