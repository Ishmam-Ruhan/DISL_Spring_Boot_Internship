import java.io.*;
import java.util.*;
import java.security.*;

/*
*
*	Problem Link: https://www.hackerrank.com/challenges/java-md5/problem
*	Problem Name: Java MD5 Password Encryption
*	Status: Solved
*/



public class Solution {

    public static void main(String[] args) throws NoSuchAlgorithmException{
        Scanner scanner = new Scanner(System.in);
        
        MessageDigest md = MessageDigest.getInstance("MD5");
        
        md.update(scanner.next().getBytes());
        
        byte[] digest = md.digest();
        
        String ans = "";
        
        for(byte byteValue : digest){
            ans+=String.format("%02X", byteValue);
        }
        
        System.out.println(ans.toLowerCase());
    }
}
