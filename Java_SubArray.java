import java.io.*;
import java.util.*;

/*
*
*	Problem Link: https://www.hackerrank.com/challenges/java-negative-subarray/problem?isFullScreen=true
*	Problem name: Java Sub Array
*	Status: Solved
*
*/


public class Solution {

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        
        int number = scanner.nextInt();
        
        int[] arr = new int[number];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        } 
        
        
        int ans =0, sum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                sum+=arr[j];
                if(sum < 0){
                    ans++;
                }
            }
            sum = 0;
        }
        
        System.out.println(ans);
    }
}
