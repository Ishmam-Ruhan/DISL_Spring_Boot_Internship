
package com.ishmamruhan.HackerrRankPracticeProblem.ThreadPractice;

class Manage{
    int totalAmount = 0;

    void start(){
        System.out.println(Thread.currentThread().getName()+" now on action!");
    }

    void end(){
        System.out.println(Thread.currentThread().getName()+" leaving");
    }
    synchronized void deposit(int amount){
        start();
        totalAmount+=amount;
        System.out.println("Successfully Deposited Money: "+amount);
        notify();
        end();
    }

    synchronized void withdraw(int amount) throws InterruptedException {
        start();
        System.out.println("Current Amount: "+totalAmount);

        if(amount > totalAmount){
            System.out.println("Not Possible Right Now!");
            System.out.println("Wait for deposit!");

            wait();

        }

        totalAmount-=amount;

        System.out.println("Successfully Withdrawn Money: "+amount);
        System.out.println("Current Balance: "+totalAmount);
        end();
    }
}



public class Thread_Communication {

    public static void main(String[] args) {

        Manage manage = new Manage();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    manage.withdraw(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    manage.withdraw(15000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
               manage.deposit(12000);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                manage.deposit(15000);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    manage.withdraw(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

    }
}
