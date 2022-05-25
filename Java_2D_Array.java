import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class Solution {
    
    /*
    *
    *   Problem Link: https://www.hackerrank.com/challenges/java-2d-array/problem?isFullScreen=true
    *   Problem name: Java 2D Array
    *   Status: Solved
    */
    
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        
        int data[][] = new int[6][6];
        
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                data[i][j] = scanner.nextInt();
            }
        }
        
        int result = Integer.MIN_VALUE;
        
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                
                int tempResult = 0;
                
                tempResult+=(data[i][j]+data[i][j+1]+data[i][j+2]);
                
                tempResult+=data[i+1][j+1];
                
                tempResult+=(data[i+2][j]+data[i+2][j+1]+data[i+2][j+2]);
                
                if(tempResult > result)result = tempResult;
            }
        }
        
        System.out.println(result);
    }
}
