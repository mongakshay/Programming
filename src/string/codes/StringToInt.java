package string.codes;

public class StringToInt {

	static int stringToInt(String s){
		if(s == null || s.length() == 0){ return -1; }
		boolean isNeg = false;
		int result = 0;
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == '-'){
				isNeg = true;
				continue;
			}
			result += (arr[i] - '0') ;
			result *= 10;
		}
		if(isNeg)
			return -result/10;
		
		return result/10;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(stringToInt("12312123"));
	}

}
