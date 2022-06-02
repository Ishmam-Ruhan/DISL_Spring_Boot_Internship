package com.ishmamruhan.HackerrRankPracticeProblem.ThreadPractice;

class ReserveSeat{

    int availableSeat = 30;

    synchronized void reserveSeat(int seat){

        System.out.println(Thread.currentThread().getName()+" is entering!!");
        System.out.println("-----------------------------------------------");
        System.out.println("Current Available Status: "+availableSeat);

        if(availableSeat>=seat){
            System.out.println("Seat Available!!");
            availableSeat-=seat;
        }else{
            System.out.println("Not Available Seat Right Now!");
        }

        System.out.println(Thread.currentThread().getName()+" is leaving!!");
        System.out.println("-----------------------------------------------");

    }

}


class CustomerThread implements Runnable
{
    String name;
    ReserveSeat reserveSeat;

    int seat;

    public CustomerThread(String name, ReserveSeat reserveSeat, int seat) {
        this.name = name;
        this.reserveSeat = reserveSeat;
        this.seat = seat;
    }

    @Override
    public void run() {
        reserveSeat.reserveSeat(seat);
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ReserveSeat reserveSeat = new ReserveSeat();

        CustomerThread customer1 = new CustomerThread("Ashish",reserveSeat, 20);
        CustomerThread customer2 = new CustomerThread("Ashish",reserveSeat, 20);
        CustomerThread customer3 = new CustomerThread("Ashish",reserveSeat, 20);

        Thread thread1 = new Thread(customer1);
        thread1.start();
        thread1.join();

        Thread thread2 = new Thread(customer2);
        thread2.start();
        thread2.join();

        Thread thread3 = new Thread(customer3);
        thread3.start();
        thread3.join();

    }
}
