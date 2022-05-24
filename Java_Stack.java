import java.util.*;

class Solution{
    
    /**
    *
    *   Problem Link: https://www.hackerrank.com/challenges/java-stack/problem?isFullScreen=true
    *
    *   Problem Name: Java Stack
    *
     *  Status: Solved
    */
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.next();
            
            System.out.println(checkValidity(input));
		}
		
	}
    
    
    static boolean checkValidity(String pattern){
        
        Stack<Integer> characterValueStack = new Stack<Integer>();
        
        for(int i = 0; i < pattern.length(); i++){
            
            char character = pattern.charAt(i);
            
            if(getCharacterValue(character) >= 21 && 
                    getCharacterValue(character) <=23){
                        
                int temporaryValue = 0;
                
                if(!characterValueStack.isEmpty())temporaryValue = characterValueStack.pop();
                
                if(temporaryValue != getCharacterValue(character) - 10)return false;
                        
            }else{
                characterValueStack.push(getCharacterValue(character));
            }
            
        }
        
        if(!characterValueStack.isEmpty())return false;
        
        return true;
        
    }
    
    
    static int getCharacterValue(char character){
        
        switch(character){ 
            case '(':
                return 11;
            
            case '{':
                return 12;
            
            case '[':
                return 13;
                
            case ')':
                return 21;
            
            case '}':
                return 22;
            
            case ']':
                return 23;
            
            default:
                return -1;      
        }
        
    }
}




