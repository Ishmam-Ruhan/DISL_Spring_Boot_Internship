package com.ishmamruhan.HackerrRankPracticeProblem.ThreadPractice;

class AtmMachine extends Thread{

    @Override
    public void run() {
        AtmProcess.process();
    }
}

class AtmProcess{
     static synchronized void process(){
        System.out.println(Thread.currentThread().getName()+" Entered");
        System.out.println(Thread.currentThread().getName()+" Peroforming task");
        System.out.println(Thread.currentThread().getName()+" Leaving!");
    }
}


public class Static_Sync {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 4; i++) {
            AtmMachine machine = new AtmMachine();
            machine.setName("Machine-"+i);
            machine.start();
        }

    }

}

