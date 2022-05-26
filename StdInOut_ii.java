import java.util.Scanner;

public class Solution {
    
    /*
    *
    *   Problem Link:  https://www.hackerrank.com/challenges/java-stdin-stdout/problem?isFullScreen=false
    *   Problem Name: Java StdIn StdOut - ||
    *   Status: Solved
    */
    

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int integerValue = scan.nextInt();
        double doubleValue = scan.nextDouble();
        scan.nextLine();
        String stringValue = scan.nextLine();

        System.out.println("String: " + stringValue);
        System.out.println("Double: " + doubleValue);
        System.out.println("Int: " + integerValue);
    }
}
