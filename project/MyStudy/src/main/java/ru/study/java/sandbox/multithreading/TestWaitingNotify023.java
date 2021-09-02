package ru.study.java.sandbox.multithreading;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestWaitingNotify023 {

    public static void main(String[] args) throws InterruptedException {
        WaitAndNotify wn = new WaitAndNotify();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}

class WaitAndNotify{
    public void produce() throws InterruptedException {
        synchronized (this){
            System.out.println("Producer thread started...");
            wait(); //1)отдаем поток(intrinsic lock), 2 ждем пока будет вызван notify() на обьекте this
            System.out.println("Producer thread resumed...");
        }

    }

    public void consumer() throws InterruptedException {

        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);

        synchronized (this){
                System.out.println("Waiting for return key pressed");
                scanner.nextLine();
                notify(); //не возвращает монитор

            Thread.sleep(5000);
            }
        }

}