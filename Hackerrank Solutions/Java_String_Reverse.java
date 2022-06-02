import java.io.*;
import java.util.*;

public class Solution {
    
    /*
    *   Problem Link: https://www.hackerrank.com/challenges/java-string-reverse/problem?isFullScreen=true
    *   
    *   Problem Name: java String Reverse
    *
    *   Status: Solved
    */
    

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        
        String input=sc.next();
        
        StringBuilder myStringBuilder = new StringBuilder(input);
        
        String isPalindrome = 
                myStringBuilder.reverse().toString().equals(input) ? "Yes" : "No";
                
        System.out.println(isPalindrome);
        
    }
}



