package nutanix.codes;

public class isStringInterleaved {

	private static boolean checkInterlieved(char[] A, char[] B, char[] C){

	boolean[][] dp = new boolean[A.length+1][B.length+1];
	int M = A.length;
	int N = B.length;
	
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			
			if(i==0&&j==0){
				System.out.println("1: " + i +" "+j);
				dp[i][j]=true;
			}
			else if(i==0 && C[j-1]==B[j-1]){
				System.out.println("2: " + i +" "+j);
				dp[i][j]=dp[i][j-1];
			}
			else if(j==0 && A[i-1]==C[i-1]){
				System.out.println("3: " + i +" "+j);
				dp[i][j]=dp[i-1][j];
			}
			else if((B[j-1]!=C[i+j-1])&&(A[i-1]==C[i+j-1])){
				System.out.println("5: " + i +" "+j);
				dp[i][j]=dp[i-1][j];
			}
			else if((B[j-1]==C[i+j-1])&&(A[i-1]!=C[i+j-1])){
				System.out.println("4: " + i +" "+j);
				dp[i][j]=dp[i][j-1];
			}
			else if((B[j-1]==C[i+j-1])&&(A[i-1]==C[i+j-1])){
				System.out.println("6: " + i +" "+j);
				dp[i][j]=dp[i-1][j]||dp[i][j-1];
			}
		}
	}
	return dp[M][N];
	
	}

	public static void main(String[] args) {
		String A = "abc";
		String B = "def";
		String C = "adbecf";
		System.out.println(checkInterlieved(A.toCharArray(), B.toCharArray(), C.toCharArray()));
	}
}
