package wayfair.code;

public class Node {

	public Node next;
	public int val;
	
	public Node(int v) {
		this.val = v;
		this.next = null;
	}
	
	public void display() {
		System.out.println(this.val);
	}
}
