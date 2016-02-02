package nutanix.codes;



class Add_Mult_Sub_String_Integers {

	private static String pad(final String x, final int n) {
		String res = new String(x);
		for (int i = 1; i <= n; i++) {
			res = "0" + res;
		}
		return res;
	}

	private static String trim_down(final String x) {
		String res = new String(x);
		while (res.startsWith("0")) {
			res = res.substring(1);
		}
		return res;
	}

	public static String shift_n(final String x, final int n) {
		String res = new String(x);
		for (int i = 1; i <= n; i++) {
			res = res + "0";
		}
		return res;
	}

	//--------------------------------------------------------------------------------------------------------
	//   ############################################ SUBTRACTION ############################################
	
	public static String minus(final String x, final String y) {
		char[] tx = new String(x).toCharArray();
		char[] ty = new String(y).toCharArray();
		String res = new String("");
		char borrow = '0';
		int i;

		if (!(tx.length == ty.length)) {
			int diff = tx.length - ty.length;
			if (diff < 0) {
				tx = pad(x, -diff).toCharArray();
			} else {
				ty = pad(y, diff).toCharArray();
			}
		}

		for (i = tx.length - 1; i >= 0; i = i - 1) {
			int bx = (int) tx[i] - (int) borrow;
			int by = (int) ty[i] - (int) '0';
			int tv = bx - by;
			if (tv < 0) {
				borrow = '1';
				tv = tv + 10;
			} else {
				borrow = '0';
			}
			res = (char) (tv + (int) '0') + res;
		}
		return res;
	}
	
	//-----------------------------------------------------------------------------------------------------
	//   ############################################ ADDITION ############################################

	public static String add(final String x, final String y) {
		char[] tx = new String(x).toCharArray();
		char[] ty = new String(y).toCharArray();
		String res = new String("");
		char carry = '0';
		int i;
		if (!(tx.length == ty.length)) {
			int diff = tx.length - ty.length;
			if (diff < 0) {
				tx = pad(x, -diff).toCharArray();
			} else {
				ty = pad(y, diff).toCharArray();
			}
		}

		for (i = tx.length - 1; i >= 0; i = i - 1) {
			int tv = (int) tx[i] - (int) '0' + (int) ty[i] - (int) '0' + (int) carry - (int) '0';
			if (tv > 9) {
				carry = '1';
				tv = tv - 10;
			} else {
				carry = '0';
			}
			res = (char) (tv + (int) '0') + res;
		}
		if (carry == '1') {
			res = "1" + res;
		}
		return res;
	}

	
	//-----------------------------------------------------------------------------------------------------
	//   ############################################ MULTIPLY ############################################
	//   --------------------------------------------------------------------------------------------------
	// 	 ###################################### Karatsuba Algorithm #######################################
	//-----------------------------------------------------------------------------------------------------
	public static String multiply(final String x, final String y) {
		
		if(x.equals("0") || y.equals("0"))
			return "0";

		if(x.equals("1"))
			return y;
		
		if(y.equals("1"))
			return x;
		
		char[] tx = new String(x).toCharArray();
		char[] ty = new String(y).toCharArray();
		int n;
		String res = new String();

		if (!(tx.length == ty.length)) {
			int diff = tx.length - ty.length;
			if (diff < 0) {
				tx = pad(x, -diff).toCharArray();
			} else {
				ty = pad(y, diff).toCharArray();
			}
		}

		if (tx.length <= 4) {
			res = String.valueOf(Integer.parseInt(String.valueOf(tx))
					* Integer.parseInt(String.valueOf(ty)));
			return res;
		} else {
			if (tx.length % 2 == 1) {
				tx = pad(String.valueOf(tx), 1).toCharArray();
				ty = pad(String.valueOf(ty), 1).toCharArray();
			}

			n = tx.length;

			String a = new String((String.valueOf(tx)).substring(0, n / 2));
			String b = new String((String.valueOf(tx)).substring(n / 2, n));
			String c = new String((String.valueOf(ty)).substring(0, n / 2));
			String d = new String((String.valueOf(ty)).substring(n / 2, n));

			String a_plus_b = new String(add(a, b));
			String c_plus_d = new String(add(c, d));

			String u = new String(multiply(a, c));
			String v = new String(multiply(b, d));
			String w = new String(multiply(a_plus_b, c_plus_d));
		
			// a.d + b.c --> w - (u + v) X.Y = [10^n]*(a.c) + [10^(n/2)]*(a.d + b.c) + b.d
			 
			String u_plus_v = new String(add(u, v));
			String w_monus_uv = new String(minus(w, u_plus_v));
			String res1 = new String(shift_n(u, n));
			String res2 = new String(add(res1, shift_n(w_monus_uv, n / 2)));
			String res3 = new String(add(res2, v));
			return trim_down(res3);
		}
	}

	
	
	public static void main(String[] args) {
		// add optimization for 0 & 1 input
	    	System.out.println(" 9 * 10 = "+ multiply("9", "10"));
	    	System.out.println(" 99 + 1 = "+ add("99", "1")); 
	    	System.out.println(" 100 - 1 = "+ minus("100", "1")); // Doesn't handle negative subtractions
	    }
	
	
}
