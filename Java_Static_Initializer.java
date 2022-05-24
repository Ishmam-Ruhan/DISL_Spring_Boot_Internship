import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

/*
*
* Problem Link: https://www.hackerrank.com/challenges/java-static-initializer-block/problem?isFullScreen=true
*
* Problem Name: Java Static Initializer Block
*
* Status: Solved
*/

static boolean flag = true;

 static int B,H;

static{
  Scanner sc =new Scanner(System.in);
    
   B =  sc.nextInt();
   H =  sc.nextInt();
   
   if( B <= 0 || H <= 0){
       System.out.print("java.lang.Exception: Breadth and height must be positive");
        
        System.exit(0);
   }
}


public static void main(String[] args){
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
		
	}//end of main

}//end of class

