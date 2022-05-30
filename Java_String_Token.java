import java.io.*;
import java.util.*;

public class Solution {

/*
*
*	Problem Link: https://www.hackerrank.com/challenges/java-string-tokens/problem?isFullScreen=true
*	Problem Name: Java String Token
*	Status: Solved
*
*/



    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        String s=scan.nextLine();
        
        if (s.trim().length()==0 || s.trim().length()>400000)
        {
            System.out.println(0);
            return;
        }

        String words[]=s.trim().split("[ !,?.\\_'@]+");
        
        System.out.println(words.length);
        
        for (String word:words){
            System.out.println(word);
        }
            
    }
}

