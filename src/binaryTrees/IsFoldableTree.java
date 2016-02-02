package binaryTrees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IsFoldableTree {

    public static boolean ifFoldable(Node root) {
    	if(root == null)
    		return false;
    	return IsFoldableTreeUtil(root.left, root.right);
    }
    
	private static boolean IsFoldableTreeUtil(Node left, Node right) {
		if((left == null) ^ (right == null))
			return false;
		if(left == null && right == null)
			return true;
		return IsFoldableTreeUtil(left.left, right.right) && IsFoldableTreeUtil(left.right, right.left);
	}
	
	/*public static void addRectangle(List<? extends Node> shapes) {
	    // Compile-time error!
	    Node n = shapes.get(0);
	}*/
	
	public static void main(String[] args) {
		/*List<Node> l = new ArrayList<Node>();
		addRectangle(l);*/
		Node r = new Node(1);
		Node r1 = new Node(1);
		Node r2 = new Node(1);
		Node r3 = new Node(1);
		Node r4 = new Node(1);
		Node r5 = new Node(1);
		//Node r6 = new Node(1);
		
		
		System.out.println(" There are "+ Node.count + " Node objects created... ");
		r.left = r1;
		r.right = r2;
		r1.right = r3;
		r2.left = r4;
		r4.right = r5;
		//r3.left = r6;
/*
	 	   r
	 	/    \
	   r1     r2
	    \    /
	    r3  r4
*/
		System.out.println(ifFoldable(r));
	}

}
