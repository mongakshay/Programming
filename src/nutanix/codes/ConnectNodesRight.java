package nutanix.codes;

import wayfair.code.Node;


class TreeNode{
	
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode nextRight;
	
	public TreeNode(int v) {
		this.val = v;
		this.left = null;
		this.right =  null;
		this.nextRight = null;
	}
}
public class ConnectNodesRight {

	static public void connectNode(TreeNode root) {
		if(root == null){
			return;
		}
		
		if(root.nextRight != null){
			connectNode(root.nextRight);
		}
		
		if(root.left != null){
			if(root.right != null){
				root.left.nextRight = root.right;
				root.right.nextRight = getNextRight(root);
			}else{
				root.left.nextRight = getNextRight(root);
			}
			connectNode(root.left);
		}else if(root.right != null){
			root.right.nextRight = getNextRight(root);
			connectNode(root.right);
		}else{
			connectNode(getNextRight(root));
		}
	} 

	private static TreeNode getNextRight(TreeNode root) {
		TreeNode temp = root.nextRight;
		while(temp != null){
			if(temp.left != null)
				return temp.left;
			if(temp.right != null)
				return temp.right;
			temp = temp.nextRight;
		}
		return null;
	}

	public static void main(String[] args) {
		
	}

}
