package binaryTrees;

import java.util.*;

import binaryTrees.temp.temp2;

interface temp{
	
	class temp2{
		int var;
		public temp2(int i) {
			this.var = i;
		}
		
		public int getVar() {
			return var;
		}
		
		public void setVar(int var) {
			this.var = var;
		}
		
		public void display() {
			System.out.println(var);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + var;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			temp2 other = (temp2) obj;
			if (var != other.var)
				return false;
			return true;
		}
		
		
	}
}

class Node{
	
    int data;
    Node left, right;
    public static int count= 0; 
    
    public Node(int item)
    {	count++;
        data = item;
        left = right = null;
    }
    
    private static void temp1(List<? extends Object> lo) {
    	for (int j = 0; j < 5; j++) {
    		System.out.println(lo.get(j));;
		}
	}
    
    public static void test(){
    	
    	
    	
    	List<String> list =  new ArrayList<String>();
    	HashMap<String, Object> h = new HashMap<String, Object>();
    	h.put(null, "akshay");
    	h.put(null, "1");
    	Integer i = Integer.valueOf("123");
    	System.out.println(i);
    	List<String> l = Collections.synchronizedList(list);
    	l.add("akshay");
    	l.add(null);
    	l.add("ankeeta");
    	l.add("saakshi");
    	List<String> temp = new ArrayList<String>();
    	Iterator<String> itr = l.iterator();
    	int count = 2;
    	try{
    		while(itr.hasNext()){
    			if(count == 0)
    				l.add("anish");
    			temp.add(itr.next());
    			count--;
    		}
    	}catch(ConcurrentModificationException e){
    		for (String s: temp) {
				System.out.println("--> "+ s);
			}
    	}
    } 
    
    private static void temp(List<String> list) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args){
    	//test();
    	//1829164700
    	
		List<String> ls = new ArrayList<String>(); // 1
    	List<? extends Object> lo = new ArrayList<String>();
    	ls.add("sdsd1");
    	ls.add("sdsd2");
    	ls.add("sdsd3");
    	ls.add("sdsd4");
    	ls.add("sdsd5");
    	temp1(ls);	    
    	/*
    	temp2 a = new temp2(2);
    	a.setVar(2);
    	System.out.println((new temp2(2)).hashCode());
    	System.out.println(a.hashCode());
    	System.out.println(a.hashCode());
    	a.setVar(13);
    	a.display();
 */   }
}
 