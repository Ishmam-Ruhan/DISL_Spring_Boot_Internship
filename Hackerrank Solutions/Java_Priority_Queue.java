import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;


/*
*
*	Problem Link: https://www.hackerrank.com/challenges/java-priority-queue/problem?isFullScreen=true
*	Problem Name: Java Priority Queue
*	Status: Partially Solved
*
*/


class Student{
    private int id;
    private String name;
    private double cgpa;
    
    public Student(int id, String name, double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    
    public int getID(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public double getCGPA(){
        return this.cgpa;
    }
}

class StudentComparator implements Comparator<Student>{
    
    @Override
    public int compare(Student student1, Student student2){
        if(student1.getCGPA()*100 != student2.getCGPA()*100){
            return (int)(student2.getCGPA()*100 - student1.getCGPA()*100);
        }
        else if(!student1.getName().equals(student2.getName())){
            return student1.getName().compareTo(student2.getName());
        }else{
            return student1.getID() - student2.getID();
        }
    }
    
}

class Priorities{
    
    public List<Student> getStudents(List<String> events){
            Queue<Student> studentsPriority = new PriorityQueue<>(new StudentComparator());
        
        
        for(String event : events){
            String[] data = event.split("[\\s]+");
            
            if(data[0].equals("ENTER")){
                studentsPriority.add(new Student(Integer.parseInt(data[3]), data[1], Double.parseDouble(data[2])));
            }else{
                if(studentsPriority.size()>0)studentsPriority.poll();
            }
        }
        
        return new ArrayList<>(studentsPriority);
    }
}




public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
