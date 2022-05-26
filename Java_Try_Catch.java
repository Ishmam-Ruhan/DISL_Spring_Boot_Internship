import java.io.*;
import java.util.*;

public class Solution {
    
    /*
    *
    *   Problem Link: https://www.hackerrank.com/challenges/java-exception-handling-try-catch/problem
    *   Problem Name: Java Try Catch
    *   Status: Solved
    */
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try{
            long number1 = sc.nextInt();
            long number2 = sc.nextInt();
            
            long result = number1 / number2;
            
            System.out.println(result);
        }
        catch (InputMismatchException e){
            System.out.println("java.util.InputMismatchException");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
