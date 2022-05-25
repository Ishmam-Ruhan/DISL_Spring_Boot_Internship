import java.io.*;
import java.util.*;

public class Solution {

    /*
    *   Problem Link: https://www.hackerrank.com/challenges/java-strings-introduction/problem?isFullScreen=true
    *   Problem Name: Java String Introduction
    *   Status: Solved
    */


    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);
        
        String firstString = scanner.next();
        String secondString = scanner.next();
        
        System.out.println(firstString.length()+secondString.length());
        
        
        String firstStringIsGreater = 
                    firstString.compareTo(secondString) > 0 ? "Yes" : "No";
        
        System.out.println(firstStringIsGreater);
        
        String combinationFirstAndSecond = 
                    firstString.substring(0,1).toUpperCase() + firstString.substring(1) + " " +
                    secondString.substring(0,1).toUpperCase() + secondString.substring(1);
        
        System.out.println(combinationFirstAndSecond);
    }
}



