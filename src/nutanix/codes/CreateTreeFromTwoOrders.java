package nutanix.codes;

public class CreateTreeFromTwoOrders {

	static int X=0;
	
	static public TreeNode convert(int[] pre, int[] in) {
		return convertUtil(pre, in, 0, 0, in.length);
	}
	static public TreeNode convertUtil(int[] pre, int[] in, int i, int start, int end) {
		if(start >= end)
			return null;
		int rootIndex = getIndexOf(pre[i], in, start, end);
		TreeNode root = new TreeNode(in[rootIndex]);
		X  += 1;
		root.left = convertUtil(pre, in, X, start, rootIndex);
		root.right = convertUtil(pre, in, X, rootIndex+1, end);
		return root;
	}
	
	private static int getIndexOf(int i, int[] in, int start, int end) {
		for (int j = start; j < end; j++) {
			if(i == in[j]){
				return j;
			}
		}
		return -1;
	}
	
	static public void display(TreeNode t) {
		if(t==null)
			return;
		display(t.left);
		System.out.print(t.val+" ");
		display(t.right);
	}
	public static void main(String[] args) {
		int[] pre = {1,2,4,5,3,6,7};
		int[] in = {4,2,5,1,6,3,7};
		TreeNode n = convert(pre, in);
		display(n);
	}
}
