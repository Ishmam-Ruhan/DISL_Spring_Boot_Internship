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
    *   Problem Link: https://www.hackerrank.com/challenges/java-primality-test/problem?isFullScreen=true
    *   Problem Name: Java Primality Test
    *   Status: Solved
    */
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String number = bufferedReader.readLine();

        BigInteger bigNumber = new BigInteger(number);
        
        if(bigNumber.isProbablePrime(10)){
            System.out.println("prime");
        }else{
            System.out.println("not prime");
        }


        bufferedReader.close();
    }
}
