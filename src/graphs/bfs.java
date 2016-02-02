package graphs;

import java.util.*;


public class bfs{
	
	private HashMap<String, List<String>> G = new HashMap<String, List<String>>();
	private HashMap<String, String> getParent = new HashMap<String, String>();
	private HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
	
	private boolean isVisited(String node) {
		if(node == null)
			return false;
		if(!visited.containsKey(node))
			return false; 
		return visited.get(node);
	}
	
	public boolean shortestPathTo(String start, String dest) {
		
		Queue<String> q = new LinkedList<String>();
		Stack<String> s = new Stack<String>();
		
		q.add(start);
		boolean found = false;
		
		while(!q.isEmpty() && !found){
			String currentNode = q.poll();
			visited.put(currentNode, true);
			if(this.G.containsKey(currentNode)){
				for(String n : this.G.get(currentNode)){
					if(!isVisited(n)){
						getParent.put(n, currentNode);
						if(n == dest)
							found = true;
						else
							q.add(n);
					}
				}
			}
		}
		
		if(!found)
			return false;
		
		for (String i = dest; i != start; i = getParent.get(i)) {
			s.add(i);
		}
		s.add(start);
		
		while (!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}
		System.out.println(" ");
		return true;
	}
	
	public static void main(String[] args){
		
		bfs b = new bfs();
		HashMap<String, List<String>> G = new HashMap<String, List<String>>();

		List<String> list1 = new ArrayList<String>();
		list1.add("2");
		list1.add("10");
		list1.add("9");
		G.put("1", list1);
		List<String> list2 = new ArrayList<String>();
		list2.add("10");
		list2.add("9");
		list2.add("11");
		list2.add("3");
		G.put("2", list2);
		List<String> list3 = new ArrayList<String>();
		list3.add("2");
		list3.add("10");
		list3.add("11");
		list3.add("12");
		list3.add("4");
		G.put("3", list3);
		List<String> list4 = new ArrayList<String>();
		list4.add("3");
		list4.add("5");
		list4.add("11");
		list4.add("12");
		list4.add("13");
		G.put("4", list4);
		List<String> list5 = new ArrayList<String>();
		list5.add("4");
		list5.add("6");
		list5.add("12");
		list5.add("13");
		list5.add("14");
		G.put("5", list5);
		
		b.setG(G);
		
		System.out.println(b.shortestPathTo("1", "10"));
	}

	public HashMap<String, List<String>> getG() {
		return G;
	}

	public void setG(HashMap<String, List<String>> g) {
		G = g;
	}
	
}











































































