import java.util.Scanner;

public class Solution {

    /*
    *   Problem Link: https://www.hackerrank.com/challenges/java-anagrams/problem?isFullScreen=true
    *   Problem Name: java Anargams
    *   Status: Solved
    *
    */


    static boolean isAnagram(String a, String b) {
        
        if(a.length() != b.length())return false;
        
        char[] input1Characters = a.toLowerCase().toCharArray();
        
        char[] input2Characters = b.toLowerCase().toCharArray();
        
        java.util.Arrays.sort(input1Characters);
        java.util.Arrays.sort(input2Characters);
        
        return java.util.Arrays.equals(input1Characters,input2Characters);
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
