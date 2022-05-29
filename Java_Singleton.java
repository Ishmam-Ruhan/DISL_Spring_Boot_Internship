import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;

/*
*
*	Problem Link: https://www.hackerrank.com/challenges/java-singleton/problem?isFullScreen=true
*	Problem Name: Java Singleton
*	Status: Solved
*/

class Singleton{
    public String str;
    
    private Singleton(){
        
    }
    
    static Singleton getSingleInstance(){
        return new Singleton();
    }
}
