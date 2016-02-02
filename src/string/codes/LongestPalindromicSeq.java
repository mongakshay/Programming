package string.codes;

public class LongestPalindromicSeq {

	static String expandAroundCenter(char[] s, int c1, int c2) {
		int l = c1, r = c2;
		int n = s.length;
		while (l >= 0 && r <= n - 1 && s[l] == s[r]) {
			l--;
			r++;
		}
		String str = "";
		for (int i = 0; i < s.length; i++) {
			str += s[i];
		}
		return str.substring(l + 1, r);
	}

	static String longestPalindromeSimple(String s) {
		char[] s1 = s.toCharArray();
		int n = s.length();
		if (n == 0)
			return "";
		String longest = s.substring(0, 1); // a single char itself is a palindrome
		
		for (int i = 0; i < n - 1; i++) {
			String p1 = expandAroundCenter(s1, i, i);
			if (p1.length() > longest.length())
				longest = p1;

			String p2 = expandAroundCenter(s1, i, i + 1);
			if (p2.length() > longest.length())
				longest = p2;
		}
		return longest;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindromeSimple("1234x4321_987654321x123456789"));
	}
}
