package nutanix.codes;

public class MinWindowSearch {

	static String getMinWindow(String T, String S) {
		int[] needToSearch = new int[256];
		int[] foundSoFar = new int[256];

		for (int i = 0; i < S.length(); i++) {
			needToSearch[S.charAt(i)] += 1;
		}
		int count = 0;
		int minWindowLen = Integer.MAX_VALUE;
		int minWindowBegin = 0;
		int minWindowEnd = 0;
		for (int start = 0, end = 0; end < T.length(); end++) 
		{
			if (needToSearch[T.charAt(end)] == 0)
				continue;

			foundSoFar[T.charAt(end)] += 1;

			if (foundSoFar[T.charAt(end)] <= needToSearch[T.charAt(end)]) 
			{
				count++;
			}

			if (count == S.length()) 
			{
				while (needToSearch[T.charAt(start)] == 0 || foundSoFar[T.charAt(start)] > needToSearch[T.charAt(start)]) 
				{
					if (foundSoFar[T.charAt(start)] > needToSearch[T.charAt(start)]) {
						foundSoFar[T.charAt(start)] -= 1;
					}

					start++;
				}

				int windowLen = end - start + 1;
				if (windowLen < minWindowLen) 
				{
					minWindowBegin = start;
					minWindowEnd = end;
					minWindowLen = windowLen;
				}
			}
		}
		if(!( count == S.length()))
			return null;
		return T.substring(minWindowBegin, minWindowEnd + 1);
	}

	public static void main(String[] args) {
		System.out.println(getMinWindow("abssscdaxxxbeabcabdc", "abcd"));

	}

}
