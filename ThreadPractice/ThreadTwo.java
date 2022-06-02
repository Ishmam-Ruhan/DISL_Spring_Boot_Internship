package com.ishmamruhan.HackerrRankPracticeProblem.ThreadPractice;


/*
*
*	Creating Thread Using Runnable.
*
*	We have to push this runnable object inside a Thread class paramater to run it as thread.
*
*	Best Practice to use Runnable Interface. Cz If we extend Thread class we can't extend any other class as Java doesn't support
*	multiple inheritance.
*
*/



public class ThreadTwo implements Runnable{

    private int machine;

    public ThreadTwo(int machine) {
        this.machine = machine;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i+" Print from Machine: "+machine);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
