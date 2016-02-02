package binaryTrees;


class Height
{
    int h;
}

/* Class to print the Diameter */
public class Diameter
{
    Node root;
 
    /* define height =0 globally and  call diameterOpt(root,height)
       from main */
    int diameterOpt(Node root, Height height)
    {
        /* lh --> Height of left subtree
           rh --> Height of right subtree */
        Height lh = new Height(), rh = new Height();
 
        if (root == null)
        {
            height.h = 0;
            return 0; /* diameter is also 0 */
        }
         
        /* ldiameter  --> diameter of left subtree
           rdiameter  --> Diameter of right subtree */ 
        /* Get the heights of left and right subtrees in lh and rh
         And store the returned values in ldiameter and ldiameter */
        lh.h++;     rh.h++; 
        int ldiameter = diameterOpt(root.left, lh);
        int rdiameter = diameterOpt(root.right, rh);
 
        /* Height of current node is max of heights of left and
         right subtrees plus 1*/
        height.h = Math.max(lh.h, rh.h) + 1;
 
        return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter));
    }
 
    /* A wrapper over diameter(Node root) */
    int diameter()
    {
        Height height = new Height();
        return diameterOpt(root, height);
    }
 
    /*The function Compute the "height" of a tree. Height is the
      number f nodes along the longest path from the root node
      down to the farthest leaf node.*/
    static int height(Node node)
    {
        /* base case tree is empty */
        if (node == null)
            return 0;
 
        /* If tree is not empty then height = 1 + max of left
           height and right heights */
        return (1 + Math.max(height(node.left), height(node.right)));
    }
 
    /*
     
     // INORDER ITERATIVE 
      
     while(!s.isEmpty()){
     	node = s.pop();
     	if(!visited(node) and node.left != null){
     		while(node.left != null){
     			s.push(node.left);
     		}
     	} else {
     		visit(node);
     		if(node.right != null){
     			s.push(node.right);
     		}
     	}
     }
     
     while(!done){
     	if( current!= null ){
     		s.push(current.left);
     		current = current.left;
     	}else{
     		if(!s.isEmpty()){
     			current = s.pop();
     			visit(current);
     			current = current.right;
     		}else{
     			done = true;
     		}
     	}
     }
    
	// POST ORDER TRAVERSAL
	 
	 void postOrder(Node root){
	 
	 	if(root == null)
	 		return null;
	 	while(!s.isEmpty()){
	 		while(root!=null){
			 	if(root.right != null){
			 			s.push(root.right);
			 		}
			 		s.push(root)
			 		root = root.left;
			}
			node = s.pop();
			if(node.right != null && node.right == s.peek()){
				right = s.pop();
				s.push(node);
				root = right;
			}else{
				visit(node);
			}
	 	}
	 	
	 	// PRINT ANCESTOR USING POST ORDER TRAVERSAL ITERATIVE
	 	
	 	while (1) {
	        while (root && root->data != key) {
	            s.push(root);   	// push current node
	            root = root->left;  // move to next node
	        }
 
	        if (root && root->data == key)
            	break;
 
	        if (s.peek()->right == NULL) {
            	root = s.pop();
            	while (!s.isEmpty() && peek(stack)->right == root){
               		root = s.pop();
               	}
        	}
        	root = isEmpty(stack)? NULL: peek(stack)->right;
    	}
     */
    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
        Diameter tree = new Diameter();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        System.out.println("The diameter of given binary tree is : "
                           + tree.diameter());
    }
}