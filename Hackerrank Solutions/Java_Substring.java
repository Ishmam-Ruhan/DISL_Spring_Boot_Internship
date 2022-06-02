import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    /*
    * Problem Link: https://www.hackerrank.com/challenges/java-substring/problem?isFullScreen=true
    * Problem Name: java Substring
    * Status: Solved
    */
    

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        String input = in.next();
        
        int start = in.nextInt();
        int end = in.nextInt();
        
        System.out.println(input.substring(start,end));
        
    }
}
