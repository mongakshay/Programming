package graphs;
/*
public class TopologicalSort {
	private boolean[] marked;
	private Queue<Integer> pre; // vertices in preorder
	private Queue<Integer> post; // vertices in postorder
	private Stack<Integer> reversePost; // vertices in reverse postorder

	public TopologicalSort(Digraph G) {
		pre = new Queue<Integer>();
		post = new Queue<Integer>();
		reversePost = new Stack<Integer>();
		marked = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++)
			if (!marked[v])
				dfs(G, v);
	}

	private void dfs(Digraph G, int v) {
		pre.enqueue(v);
		marked[v] = true;
		for (int w : G.adj(v))
			if (!marked[w])
				dfs(G, w);
		post.enqueue(v);
		reversePost.push(v);
	}

	public Iterable<Integer> pre() {
		return pre;
	}

	public Iterable<Integer> post() {
		return post;
	}

	public Iterable<Integer> reversePost() {
		return reversePost;
	}
}

//########################### Topological ########################################
 
class Topological {
	private Iterable<Integer> order; // topological order

	public Topological(Digraph G) {
		DirectedCycle cyclefinder = new DirectedCycle(G);
		if (!cyclefinder.hasCycle()) {
			DepthFirstOrder dfs = new DepthFirstOrder(G);
			order = dfs.reversePost();
		}
	}

	public Iterable<Integer> order() {
		return order;
	}

	public boolean isDAG() {
		return order == null;
	}

	public static void main(String[] args) {
		String filename = args[0];
		String separator = args[1];
		SymbolDigraph sg = new SymbolDigraph(filename, separator);
		Topological top = new Topological(sg.G());
		for (int v : top.order())
			StdOut.println(sg.name(v));
	}
}

//########################## DirectedCycle #########################################


public class DirectedCycle {
	private boolean[] marked;
	private int[] edgeTo;
	private Stack<Integer> cycle; // vertices on a cycle (if one exists)
	private boolean[] onStack; // vertices on recursive call stack

	public DirectedCycle(Digraph G) {
		onStack = new boolean[G.V()];
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++)
			if (!marked[v])
				dfs(G, v);
	}

	private void dfs(Digraph G, int v) {
		onStack[v] = true;
		marked[v] = true;
		for (int w : G.adj(v))
			if (this.hasCycle())
				return;
			else if (!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
			} else if (onStack[w]) {
				cycle = new Stack<Integer>();
				for (int x = v; x != w; x = edgeTo[x])
					cycle.push(x);
				cycle.push(w);
				cycle.push(v);
			}
		onStack[v] = false;
	}

	public boolean hasCycle() {
		return cycle != null;
	}

	public Iterable<Integer> cycle() {
		return cycle;
	}
}

*/