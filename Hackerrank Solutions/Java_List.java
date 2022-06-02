import java.io.*;
import java.util.*;

public class Solution {
    
    /*
    *   Problem Link: https://www.hackerrank.com/challenges/java-list/problem?isFullScreen=true
    *   Problem Name: Java List
    *   Status: Solved
    */

    public static void main(String[] args) {
       
       Scanner scanner = new Scanner(System.in);
       
       List numberList = new ArrayList();
       
       int numbers =scanner.nextInt();
       
       while(numbers-- > 0){
           numberList.add(scanner.nextInt());
       }
       
       int numberOfOperations = scanner.nextInt();
       
       while(numberOfOperations-- > 0){
           
           String operation = scanner.next();
           
           if(operation.equals("Insert")){
               numberList.add(scanner.nextInt(), scanner.nextInt());
           }else{
               numberList.remove(scanner.nextInt());
           }
           
       }
       
       for(Object number : numberList){
           System.out.print(number+" ");
       }
       
       System.out.println("");
    }
}
