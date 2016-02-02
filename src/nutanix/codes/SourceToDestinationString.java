package nutanix.codes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

public class SourceToDestinationString {
    // Container for the valid words
    HashSet<String> dictionary = null;
    // Container for words already passed by a word sequence
    HashSet visited;

    public SourceToDestinationString() {
        super();
        visited = new HashSet();
        dictionary = new HashSet();
        initDictionary();
    }

    private void initDictionary() {
        dictionary.add("COT");
        dictionary.add("CAT");
        dictionary.add("COG");
        dictionary.add("DOT");
        dictionary.add("DOG");
    }

    // Returns all valid words suitable for the next step of the path
    private ArrayList<String> generateWords(String source, int position) {
        if (position < 0 || position >= source.length())
            return null;
        ArrayList result = new ArrayList();
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            StringBuffer tmpWord = new StringBuffer(source);
            tmpWord.setCharAt(position, ch);
            String word = tmpWord.toString();
            if (dictionary.contains(word)) {
                result.add(word);
            }
        }

        return result;
    }

    // The sequence of words is written in the stack 'path' 
    public void sourceToDestinationString(Stack<String> path, String destination) {
        String source = path.peek();
        if (source.equals(destination)) {
            System.out.print("\nSolution is : ");
            Iterator<String> i = path.iterator();
            while(i.hasNext())
            	System.out.print(i.next() +" -> ");
            System.out.println(" Null ");
            return;
        }

        visited.add(source);

        for (int i = 0; i < source.length(); i++) {
            ArrayList<String> words = generateWords(source, i);
            for (String nextWord : words) {
                if (visited.contains(nextWord))
                    continue;
                path.push(nextWord);
                sourceToDestinationString(path, destination);
                path.pop();
            }
        }
  
        visited.remove(source);
    }
    
    public static void main(String[] args){
    	
    	
    	SourceToDestinationString o = new SourceToDestinationString();
    	Stack<String> path = new Stack<String>();
    	path.add("CAT");
		String destination="DOG";
		o.sourceToDestinationString(path, destination);
    }
    
}