package wayfair.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class ValueComparator<T1,T2 extends Comparable<T2>> implements Comparator<T1> {
    Map<T1,T2> base;
    
    public ValueComparator(Map<T1,T2> base) {
        this.base = base;
    }

    public int compare(T1 k1, T1 k2) {
        T2 val1 = base.get(k1);
        T2 val2 = base.get(k2);

        return val1.compareTo(val2);
    }
}

public class SortCount {
	
    public static void main(String[] args) {
        int nums[] = {0,0,0,1,3,3,2,1,3,5,6,0};
        HashMap<Integer,Integer> counts = new HashMap<Integer,Integer>();

        for(int i = 0; i < nums.length; i++) {
            if(counts.containsKey(nums[i])){
                int c = counts.get(nums[i]) + 1;
                counts.put(nums[i], c);
            }
            else {
                counts.put(nums[i],1);
            }
        }
        
        ValueComparator<Integer,Integer> bvc = new ValueComparator<Integer,Integer>(counts);
        
        TreeMap<Integer,Integer> sortedMap = new TreeMap<Integer,Integer>(bvc);
        
        sortedMap.putAll(counts);

        ArrayList<Integer> output = new ArrayList<Integer>();
        
        for(Integer i : sortedMap.keySet()) {
            for(int c = 0; c < sortedMap.get(i); c++) {
                output.add(i);
            }
        }

        System.out.println(output.toString());
    }
}