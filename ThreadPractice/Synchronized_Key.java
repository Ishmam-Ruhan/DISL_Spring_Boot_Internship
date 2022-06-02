package com.ishmamruhan.HackerrRankPracticeProblem.ThreadPractice;

class Reservation{

    int totalSeat = 50;

    synchronized void reserveSeat(int seat){
        System.out.println(Thread.currentThread().getName()+" entered!");
        System.out.println("Total Seat: "+totalSeat);

        if(seat > totalSeat){
            System.out.println("Not Available!!");
        }else{
            totalSeat-=seat;
            System.out.println("Reserve Success!!");
        }

        System.out.println(Thread.currentThread().getName()+"  Leaving");
        System.out.println("-------------------------------");
    }
}

class Person implements Runnable{
    Reservation reservation;
    int seat;

    public Person(Reservation reservation, int seat) {
        this.reservation = reservation;
        this.seat = seat;
    }

    @Override
    public void run() {
        reservation.reserveSeat(seat);
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Reservation reservation = new Reservation();

        new Thread( new Person(reservation, 40)).start();
        new Thread( new Person(reservation, 20)).start();
        new Thread( new Person(reservation, 10)).start();

    }
}

