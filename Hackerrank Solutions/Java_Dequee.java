    import java.util.*;

/*
*
*	Problem Link: https://www.hackerrank.com/challenges/java-dequeue/problem
*	Problem Name: Java Deque
*	Status: Partially Solved - 2 Cases Failed due to TLE
*
*/



    public class test {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            
            Deque<Integer> deque = new ArrayDeque<>();
            
            int numbers = in.nextInt();
            int subarraySize = in.nextInt();
    
            long max = Integer.MIN_VALUE;

            for (int i = 0; i < numbers; i++) {
                int num = in.nextInt();
                
                if(i < subarraySize - 1)deque.offerLast(num);
                else if(i == subarraySize - 1){
                    deque.offerLast(num);
                    long distinctCount = deque.stream()
                                            .distinct()
                                            .count();
               
                    if(distinctCount > max)max = distinctCount;
                }
                else{
                    deque.pollFirst();
                    deque.offerLast(num);
                    
                    long distinctCount = deque.stream()
                                            .distinct()
                                            .count();
               
                    if(distinctCount > max)max = distinctCount;
                }
                
            }
            
            
            System.out.println(max);
        }
    }



