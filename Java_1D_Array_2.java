import java.util.*;

public class Solution {

    /*
    *
    *   Problem Link: https://www.hackerrank.com/challenges/java-1d-array/problem
    *   Problem Name: java 1D Array Problem
    *   Status: Solved
    */



    public static boolean canWin(int start, int leap, int[] game) {
       
        if(start < 0)return false;
       
        else if(start >= game.length )return true;
        
        else if(game[start]  == 1)return false;
        
        game[start] = 1;
        
        boolean check = ( 
                        canWin(start+leap, leap, game) || 
                        canWin(start+1, leap, game) ||    
                        canWin(start-1, leap, game) 
                    );
        
        
        return check;
        
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(0,leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
    
}
