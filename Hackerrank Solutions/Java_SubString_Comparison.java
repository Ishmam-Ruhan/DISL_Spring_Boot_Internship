import java.util.Scanner;

public class Solution {

    /**
     *
     * Problem Link: https://www.hackerrank.com/challenges/java-string-compare/problem?isFullScreen=true
     *
     * Problem Name: Java Substring Comparison
     *
     * Status: Solved
     */

    public static String getSmallestAndLargest(String s, int k) {


        String[] array = new String[s.length()-k+1];

        int  index = 0;;

        for(int i = 0; i < s.length(); i++){

            if(i+k <= s.length()){
                array[index] = s.substring(i,i+k);
                ++index;
            }else{
                break;
            }

        }

        String smallest = array[0];
        String largest = array[0];

        for (int i = 1; i < array.length; i++) {
            int comparisonWithSmallest = smallest.compareTo(array[i]);
            if(comparisonWithSmallest < 0)smallest = array[i];

            int comparisonWithlargest = largest.compareTo(array[i]);
            if(comparisonWithlargest > 0)largest = array[i];

        }


        return largest + "\n" + smallest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}