import java.util.*;
import java.io.*;

class Solution{

    /*
    *   Problem Link: https://www.hackerrank.com/challenges/java-loops/problem
    *
    *   Problem Name: Java Loop 2
    *
    *   Status: Solved
     */

    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            int calculation = a + (int)(Math.pow(2,0)*b);

            System.out.print(calculation);

            for(int j = 1; j < n; j++){

                calculation = calculation + (int)(Math.pow(2,j)*b);


                System.out.print(" "+calculation);
            }

            System.out.println("");

        }
        in.close();
    }
}
