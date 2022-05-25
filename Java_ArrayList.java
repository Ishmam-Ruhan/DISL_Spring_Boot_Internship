import java.io.*;
import java.util.*;

public class Solution {
    
    /*
    *   Problem Link: https://www.hackerrank.com/challenges/java-arraylist/problem?isFullScreen=true
    *   Problem name: Java ArrayList
    *   Status: Solved
    */
    

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        List<List<Integer>> numberList = new ArrayList<>();
        
        
        int numberOfList = scanner.nextInt();
        
        int checker = 0;
        
        while(-- numberOfList >= 0){
            
            List<Integer> numbers = new ArrayList<>();
            
            int counter = scanner.nextInt();
            
            while(--counter >= 0){
                numbers.add(scanner.nextInt());
            }
            
            numberList.add(checker,numbers);
            checker++;
        }
        
        int queries = scanner.nextInt();
        
        
        while(--queries >= 0){
            
            int queryParam1 = scanner.nextInt();
            int queryParam2 = scanner.nextInt();

            List<Integer> getNumberList = numberList.get(--queryParam1);
            
            if(getNumberList.size() < queryParam2)System.out.println("ERROR!");
            else{
                System.out.println(getNumberList.get(--queryParam2));
            }          
        }
        
    }
}
