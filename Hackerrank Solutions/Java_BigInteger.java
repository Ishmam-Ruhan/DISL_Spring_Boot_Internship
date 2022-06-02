import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    /*
    *
    *   Problem Link: https://www.hackerrank.com/challenges/java-biginteger/problem
    *   Problem Name: Java BigInteger
    *   Status: Solved
    */

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        BigInteger numberOne = new BigInteger(scanner.next());
        BigInteger numberTwo = new BigInteger(scanner.next()); 
        
        BigInteger summation, multiplication;
        
        summation = numberOne.add(numberTwo);
        multiplication = numberOne.multiply(numberTwo);
        
        System.out.println(summation);
        System.out.println(multiplication);
        
    }
}
