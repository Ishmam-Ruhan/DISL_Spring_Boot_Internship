import java.util.Scanner;

/*
*
*	Problem Link: https://www.hackerrank.com/challenges/java-exception-handling/problem?isFullScreen=false
*	Problem name: Java Exception Handeling 2
*	Status: Solved
*
*/



class CustomException extends RuntimeException{
    
    public CustomException(String message){
        super("java.lang.Exception: "+message);
    }
}

class MyCalculator {
    long power(int base, int power) throws Exception{
        long ans = 0;
            if(base < 0 || power < 0){
                throw new Exception("n or p should not be negative.");
            }
            if(base == 0 && power == 0){
                throw new Exception("n and p should not be zero.");
            }
            
            ans = (long)Math.pow(base, power);
            
       
        
        return ans;
    }
}

public class Solution {
