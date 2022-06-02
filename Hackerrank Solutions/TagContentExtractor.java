import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{

/*
*	Problem Link: https://www.hackerrank.com/challenges/tag-content-extractor/problem?isFullScreen=true
*
*	Problem Name: tag Content Extractor
*	
*	Status: Partially Solved (One testcase not match)
*/


	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String line = in.nextLine();
			
          	System.out.println(lineExtractor(line));
			
			testCases--;
		}
	}
    
     static String lineExtractor(String line){

        Stack tagStack = new Stack();

        String output = "", currentTagElement = "", temporaryLine = "";

        boolean isTagElement = false;

        for(int i = 0; i < line.length(); i++){

            char character = line.charAt(i);

            if(character == '<'){
                isTagElement = true; currentTagElement += character;

            }
            else if(character == '>'){
                isTagElement = false; currentTagElement += character;

                
               if(currentTagElement.startsWith("</") && currentTagElement.length() > 3){

                    String modifiedEndString =
                            currentTagElement.substring(0,1) +
                                    currentTagElement.substring(2,currentTagElement.length());


                    if(!tagStack.isEmpty() && modifiedEndString.equals(tagStack.peek())){
                        output += temporaryLine; temporaryLine = "";
                    }

                    tagStack.push(currentTagElement);
                }
                else if(currentTagElement.length() > 2)tagStack.push(currentTagElement);
                
                currentTagElement = ""; temporaryLine = "";

            }
            else if(isTagElement){
                currentTagElement += character;
            }else{
                temporaryLine += character;
            }

        }

        if(output.length() == 0)output = "None";

        return output;
    }
}



