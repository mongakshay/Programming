package string.codes;


public class IsSubstring {
	
	public static boolean isSubtring(String pat, String txt) {
        int pattern_len = pat.length();
        int text_len = txt.length();
        for (int i = 0; i <= text_len - pattern_len; i++) {
            int j;
            for (j = 0; j < pattern_len; j++) {
                if (txt.charAt(i+j) != pat.charAt(j))
                    break;
            }
            if (j == pattern_len) {
            	return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String txt = "abcdefghijklmnopqrstuvwxyz";
        String pat = "fghij";
        System.out.println(isSubtring(pat, txt));
    }
}
