import java.io.*;
import java.util.*;

public class Solution {

    /*
    *   Problem Link: https://www.hackerrank.com/challenges/java-end-of-file/problem?isFullScreen=true
    *
    *  Problem Name: Java EOF
    *
    * Status: Solved
     */

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);


        int count = 1;

        while(sc.hasNext()){

            String line =sc.nextLine();

            System.out.println(count+" "+line);

            count++;
        }

    }
}