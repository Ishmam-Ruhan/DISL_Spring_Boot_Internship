package com.ishmamruhan.HackerrRankPracticeProblem.ThreadPractice;

/*
*
*	Creating Thread using  THREAD class
*
*/


public class ThreadOne extends Thread{

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i+"");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
