import java.io.*;
import java.util.*;

public class Solution {

/*
*
*	Problem Link: https://www.hackerrank.com/challenges/java-bitset/problem?isFullScreen=true
*	Problem Name:Java Bitset
*	Status: Solved
*/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int bitSetSize = in.nextInt();
        int operations = in.nextInt();
      
        //BitSet bitSetOne = new BitSet(bi)
        
        BitSet[] bitset = new BitSet[3];
      
        bitset[1] = new BitSet(bitSetSize);
        bitset[2] = new BitSet(bitSetSize);
      
        while (operations -- > 0) {
          
          String op = in.next();
          
          int value1 = in.nextInt();
          int value2 = in.nextInt();
          
          switch (op) {
            case "AND":
              bitset[value1].and(bitset[value2]);
              break;
            case "OR":
              bitset[value1].or(bitset[value2]);
              break;
            case "XOR":
              bitset[value1].xor(bitset[value2]);
              break;
            case "FLIP":
              bitset[value1].flip(value2);
              break;
            case "SET":
              bitset[value1].set(value2);
          }
          
          System.out.println(bitset[1].cardinality()+" "+bitset[2].cardinality());
        }
        
    }
}
