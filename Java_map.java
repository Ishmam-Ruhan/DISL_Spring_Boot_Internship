import java.util.*;
import java.io.*;

class Solution{
    
    /*
    *
    *   Problem Link: https://www.hackerrank.com/challenges/phone-book/problem?isFullScreen=true
    *   Problem Name: Java Map
    *   Status: Solved
    */
    
    
	public static void main(String []argh)
	{
		Scanner in = new Scanner(System.in);
		Map<String,String> addressMap = new HashMap<>();
        
        int testCase=in.nextInt();
		in.nextLine();
		
        for(int i = 0; i < testCase; i++)
		{
			String name=in.nextLine();
			int phone=in.nextInt();
			
            addressMap.put(name, String.valueOf(phone));
            
            in.nextLine();
        }
		
        while(in.hasNext())
		{
			String search=in.nextLine();
            
            String output = addressMap.getOrDefault(search, "Not found");
            
            if(!output.equals("Not found")){
                System.out.println(search+"="+output);
            }else{
                System.out.println(output);
            }
            
		}
	}
}



