package ru.study.java.sandbox.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class TestSynchroMultiObject {
    public static void main(String[] args) {
        new Worker().main();

    }
}

class Worker {

    Random random = new Random();

    Object lock1 = new Object();//создаем обьект для синхронизации
    Object lock2 = new Object();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public void addToList1(){
        //поток фокусируется на мониторе lock1, другой поток видит это и переходит выполнению
        //другого метода с другим не занятым монитором lock2
           synchronized (lock1){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt(100));
        }
    }
    public void addToList2() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }
    }
    public void main(){
        long before = System.currentTimeMillis();

        //work();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long after = System.currentTimeMillis();

        System.out.println("Prog took: "+ (after-before) + " ms to run");

        System.out.println("List 1 : " + list1.size());
        System.out.println("List 2 : " + list2.size());
    }

    public void work(){
        for(int i = 0; i<1000; i++) {
            addToList1();
            addToList2();
        }
    }
}