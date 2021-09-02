package ru.study.java.sandbox.multithreading;


import java.util.Scanner;

public class MySynchroTreadTest {

    public static void main(String[] args) {
        MyThreadSyn thread = new MyThreadSyn();
        thread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        thread.shutdown();
    }
}

class MyThreadSyn extends Thread{

    private volatile boolean runing = true;

    public void run(){
        while (runing){
            System.out.println("Hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown(){
        this.runing=false;
    }
}