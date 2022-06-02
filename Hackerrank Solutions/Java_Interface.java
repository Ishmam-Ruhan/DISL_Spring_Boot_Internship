import java.util.*;

/*
*	Problem Link: https://www.hackerrank.com/challenges/java-interface/problem?isFullScreen=true
*	Problem name:Java Inerface
*	Status: Solved
*
*/



interface AdvancedArithmetic{
  int divisor_sum(int n);
}

class MyCalculator implements AdvancedArithmetic{
    @Override
    public int divisor_sum(int number) {
        if(number==1)return 1;
        
        int sum = 0;
        
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if(number % i == 0){
                sum+=i;
                sum+=(number/i);
            }
        }
        return sum;
    }
}

class Solution{
    public static void main(String []args){
        MyCalculator my_calculator = new MyCalculator();
        System.out.print("I implemented: ");
        ImplementedInterfaceNames(my_calculator);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(my_calculator.divisor_sum(n) + "\n");
      	sc.close();
    }
    /*
     *  ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented
     */
    static void ImplementedInterfaceNames(Object o){
        Class[] theInterfaces = o.getClass().getInterfaces();
        for (int i = 0; i < theInterfaces.length; i++){
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }
    }
}

