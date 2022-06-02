import java.util.Scanner;
import java.util.regex.*;
import java.util.*;

/*
*
*	Problem Link: https://www.hackerrank.com/challenges/pattern-syntax-checker/problem
*	Problem Name: Java Syntex Checker
*	Status: Solved
*/



public class Solution
{
	public static void main(String[] args) throws NoSuchElementException{
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
          	String pattern = in.nextLine();
              
              try{
                  Pattern.compile(pattern);
                  System.out.println("Valid");
              }catch(Exception ex){
                  System.out.println("Invalid");
              }
              testCases--;
		}
	}
}



