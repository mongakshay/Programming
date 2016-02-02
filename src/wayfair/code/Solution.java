package wayfair.code;
import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

/*
You're given a vector of vectors of words, e.g.: 
[['quick', 'lazy'], ['brown', 'black', 'grey'], ['fox', 'dog']]. 

Write a generalized function that prints all combinations of one word from the first vector, one word from the second vector, etc.
NOTE: the number of vectors and number of elements within each vector may vary.

For the input above, it should print (in any order): 
quick brown fox 
quick brown dog 
quick black fox 
quick black dog 
... 
lazy grey dog
*/



public class Solution {

  public void getCombination(Vector<Vector<String>> vectorOfVectors) {
      if (vectorOfVectors == null){
          System.out.println("The input vector is empty");
          return;
      }
      ArrayList<String> output = new ArrayList<String>();
      getCombinations(output, 0, vectorOfVectors);
  }


  private void getCombinations(ArrayList<String> so_far, int index, Vector<Vector<String>> vectorOfVectors) {
      if (index == vectorOfVectors.size()) {
          for (String word : so_far)
              System.out.print(word + " ");
          System.out.println("");
      } else {
          for (String word : vectorOfVectors.elementAt(index)) {
              so_far.add(word);
              getCombinations(so_far, index + 1, vectorOfVectors);
              so_far.remove(so_far.size() - 1);
          }
      }
  }

  public static void main(String[] args) 
                            throws IOException {
    
      //Constructing a test vector of vectors array
      Vector<Vector<String>> vectorOfVectors = 
                               new Vector<Vector<String>>();
    
      Vector<String> vectorD = new Vector<String>();
      vectorD.add("A");
    
      Vector<String> vectorA = new Vector<String>();
      vectorA.add("quick");
      vectorA.add("lazy");
      vectorA.add("sleepy");
      
      Vector<String> vectorB = new Vector<String>();
      vectorB.add("brown");      
      vectorB.add("black");      
      vectorB.add("grey");
      
      Vector<String> vectorC = new Vector<String>();
      vectorC.add("fox");      
      vectorC.add("dog"); 
      vectorC.add("cat"); 
      vectorC.add("fish"); 
      
      vectorOfVectors.add(vectorD);
      vectorOfVectors.add(vectorA);
      vectorOfVectors.add(vectorB);
      vectorOfVectors.add(vectorC);
      
      
      /**
        * Instantiating the solutions class to call the 
        * required method which will give the output for 
        * the given input vectorOfVectors array.
        */
      Solution s = new Solution();
      s.getCombination(vectorOfVectors);
    
    
    /*
     * Below is the commented out code which I 
     * wrote incase we want to take input from 
     * the user, and contruct the output from 
     * input stream data
     * 
     * The Coderpad did not support the user 
     * input somehow, so I have kept it commented out.
     * 
     * The way it would have worked is, it asks 
     * user to specify the number of vector arrays 
     * he needs to feed.
     * 
     * Then prompts the user to feed each vector 
     * array, and later spits the required output 
     * on the output stream.
     * 
     * It demands user to feed each array as a 
     * sequence of comma separated strings.
     */
    
    /*
      Vector<Vector<String>> vectorOfVectors = 
                               new Vector<Vector<String>>();
      String numVectors;
    
      while (true) {
          try {
              System.out.print("Enter number of vectors : ");
              BufferedReader br1 = 
                  new BufferedReader(new InputStreamReader(System.in));
              numVectors = br1.readLine();
              break;
          } catch (NumberFormatException e) {
              System.out.println("Please enter a 
                              valid Integer value and try again...");
          }
      }
 
      System.out.println("Please enter your vector lists as-> abc, xyz, lmn");

      for (int i = 0; i < Integer.parseInt(numVectors); i++) {
          BufferedReader br2 = 
              new BufferedReader(new InputStreamReader(System.in));
          System.out.print("Enter vector list " + (i + 1) + ": ");
          String[] list = br2.readLine().split(",");
          Vector<String> words = new Vector<String>();
          for (int j = 0; j < list.length; j++) {
              if (list[j].equals("")) {
                  words.add("NULL");
              } else {
                  words.add(list[j].trim());
              }
          }
          vectorOfVectors.add(words);
      }
      */
  }
}