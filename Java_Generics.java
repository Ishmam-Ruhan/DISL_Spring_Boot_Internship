
import java.io.IOException;
import java.lang.reflect.Method;

/*
*
*	Problem Link: https://www.hackerrank.com/challenges/java-generics/problem?isFullScreen=true
*	Problem Name: Java Generics
*	Status: Solved
*/


class Printer
{
   public <T> void printArray(T[] array){
       for(T data : array){
           System.out.println(data);
       }
   }
 
}

public class Solution {


    public static void main( String args[] ) {
        Printer myPrinter = new Printer();
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
        int count = 0;

        for (Method method : Printer.class.getDeclaredMethods()) {
            String name = method.getName();

            if(name.equals("printArray"))
                count++;
        }

        if(count > 1)System.out.println("Method overloading is not allowed!");
      
    }
}
