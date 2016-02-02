package wayfair.code;

import javax.sound.sampled.ReverbType;

public class CircularLinkedList {

	Node first;
	Node last;
	
	public CircularLinkedList() {
		this.first = null;
		this.last = first;
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
	public static void main(String args[]){
		CircularLinkedList ll = new CircularLinkedList();
		
		for (int i = 0; i < 10; i++) {
			ll.addFirst(i);
		}
		for (int j = 10; j < 20; j++) {
			ll.addLast(j);
		}
		System.out.print("GIVEN:  ");
		ll.displayList();
		System.out.println(" ");
		System.out.print("RETURNED: ");
		//Node root = ll.reverseList(ll.first);
		Node root = ll.reverseIterative(ll.first);
		ll.displayThisList(root);
	}
}
