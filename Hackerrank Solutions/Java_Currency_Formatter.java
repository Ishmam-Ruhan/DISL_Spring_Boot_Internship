import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    /*
    * Problem Link: https://www.hackerrank.com/challenges/java-currency-formatter/problem?isFullScreen=true
    *
    * Problem Name: Java Currency Formatter
    *
    * Status: Solved
    */
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        System.out.println("US: " + getLocalCurrency(new Locale("en","US"), payment));
        System.out.println("India: " + getLocalCurrency(new Locale("en","IN"), payment));
        System.out.println("China: " + getLocalCurrency(new Locale("zh","CN"), payment));
        System.out.println("France: " + getLocalCurrency(new Locale("fr","FR"), payment));
    }
    
    static String getLocalCurrency(Locale locale, double amount){
        
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        
        return numberFormat.format(amount);
        
    }
}
