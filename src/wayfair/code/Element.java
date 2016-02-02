package wayfair.code;

import java.util.ArrayList;
import java.util.Collections;


public class Element implements Comparable<Element>{
	
	Integer start;
	Integer end;
	
	Element(){}
	
	Element(Integer s, Integer e){
		start = s;
		end = e;
	}

	@Override
	public int compareTo(Element o) {
		return this.start.compareTo(o.start);
	}
	
	private void sortList() {
		ArrayList<Element> arr = new ArrayList<Element>();
		arr.add(new Element(1, 2));
		arr.add(new Element(63, 64));
		arr.add(new Element(34, 36));
		arr.add(new Element(12, 18));
		Collections.sort(arr);
		
		for(Element e : arr)
			System.out.println("("+e.start +","+e.end+")");
		}
	

	public static void main(String[] args) {
		(new Element()).sortList();
	}
}