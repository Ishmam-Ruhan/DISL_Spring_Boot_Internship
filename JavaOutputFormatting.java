import java.io.*;
import java.util.*;

public class Solution {

    /*
    *
    * Problem Link: https://www.hackerrank.com/challenges/java-output-formatting/problem?isFullScreen=true
    *
    * Problem Name: Output Formating
    *
    * Status: Solved
    *
     */

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++)
        {
            String s1=sc.next();
            int x=sc.nextInt();
            String s2 = String.valueOf(x);

            if(x < 100){

                int len = s2.length();

                for(int  j = 1; j <= (3 - len); j++){
                    s2 = "0"+s2;
                }

            }

            System.out.print(s1);

            for(int  j = 0; j < (15 - s1.length()); j++){
                System.out.print(" ");
            }


            System.out.println(s2);
        }
        System.out.println("================================");

    }
}