package wayfair.code;

import javax.sound.sampled.ReverbType;

public class LinkedList {

	Node first;
	Node last;
	
	public LinkedList() {
		this.first = null;
		this.last = null;
	}
	
	public void addFirst(int v) {
		Node newNode = new Node(v);
		if(first == null){
			first = newNode;
			last = newNode;
		}else{
			newNode.next = first;
			first = newNode;
		}
	}
	
	public void addLast(int v) {
		Node newNode = new Node(v);
		if(first == null){
			first = newNode;
			last = newNode;
		}else{
			last.next = newNode;
			last = newNode;
		}
	}
	
	public void swapNodes(int v1, int v2) {
		
	}
	
	public Node reverseList(Node root) {
		if(root == null)
			return null;
		if(root.next == null)
			return root;
		Node secondNode = root.next;
		root.next = null;
		Node reverseList = reverseList(secondNode);
		secondNode.next = root;
		return reverseList;
	}
	
	public Node reverseIterative(Node root) {
		if(root == null)
			return null;
		if(root.next == null)
			return root;
		
		Node prev = root;
		Node current = root.next;
		prev.next = null;
		while(current != null){
			Node temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		return prev;
	}

	public void displayList(){
		if(first == null){
			System.out.println("List is empty...");
		}else{
			Node current = first;
			while(current != null){
				System.out.print(current.val+" ");
				current = current.next;
			}
			System.out.println(" ");
		}
	}
	
	public void displayThisList(Node first){
		if(first == null){
			System.out.println("List is empty...");
		}else{
			Node current = first;
			while(current != null){
				System.out.print(current.val+" ");
				current = current.next;
			}
			System.out.println(" ");
		}
	}
	
	/*
	 * Max sum merge LinkedList
	 */
	public static Node MaxSumMerge(Node list1, Node list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;
		Node current1 = list1;
		Node current2 = list2;
		Node root1 = list1;
		Node root2 = list2;
		Node root = null;
		Node result_last = null;

		while (current1 != null && current2 != null) {

			Node begin1 = current1;
			Node begin2 = current2;
			int sum1 = 0;
			int sum2 = 0;
			while (current1 != null && current2 != null
					&& current1.val != current2.val) {
				if (current1.val < current2.val) {
					sum1 += current1.val;
					current1 = current1.next;
				} else {
					sum2 += current2.val;
					current2 = current2.next;
				}
			}
			
			if (current1 == null) {
				while(current2 != null){
					sum2 += current2.val;
					current2 = current2.next;
				}
			}
			if (current2 == null) {
				while(current1 != null){
					sum1 += current1.val;
					current1 = current1.next;
				}
			}
			
			if (sum1 > sum2) {
				if (root == null) {
					root = root1;
				} else {
					result_last.next = begin1;
				}
				result_last = current1;
			} else {
				if (root == null) {
					root = root2;
				} else {
					result_last.next = begin2;
				}
				result_last = current2;
			}
			
			if(current1 != null){
				current1 = current1.next;
			}if(current2 != null){
				current2 = current2.next;
			}
		}
		return root;
	}
	
	public static void main(String args[]){
		LinkedList ll = new LinkedList();
		
		for (int i = 0; i < 10; i++) {
			ll.addFirst(i);
		}
		for (int j = 10; j < 20; j++) {
			ll.addLast(j);
		}
		//System.out.print("GIVEN:  ");
		//ll.displayList();
		//System.out.println(" ");
		//System.out.print("RETURNED: ");
		//Node root = ll.reverseList(ll.first);
		//Node root = ll.reverseIterative(ll.first);
		//ll.displayThisList(root);
		
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		
		l1.addLast(1);
		l1.addLast(3);
		l1.addLast(30);
		l1.addLast(90);
		l1.addLast(900);
		l1.addLast(910);
		l1.addLast(918);
		l1.addLast(1500);
		/*
		l1.addLast(110);
		l1.addLast(120);
		l1.addLast(125);
		l1.addLast(150);
		
		l2.addLast(0);
		l2.addLast(3);
		l2.addLast(12);
		l2.addLast(32);
		l2.addLast(90);
		l2.addLast(100);
		*/
		l2.addLast(30);
		l2.addLast(122);
		l2.addLast(910);
		l2.addLast(920);
		l2.addLast(1500);
		
		Node n = MaxSumMerge(l1.first,l2.first);
		ll.displayThisList(n);  
	}
}
