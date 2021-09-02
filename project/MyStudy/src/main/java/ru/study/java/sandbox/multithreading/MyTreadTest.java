package ru.study.java.sandbox.multithreading;

public class MyTreadTest {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        MyThread thread1 = new MyThread();
       /* thread.start();
        thread1.start();*/

        Thread thread2 = new Thread(new Runner());
        thread2.start();
    }
}

class MyThread extends Thread{
    public void run(){
        for (int i=0;i<25;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Через ранер поток"+i);
        }
    }
}

class Runner implements Runnable {
    @Override
    public void run(){
        for (int i=0;i<25;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Первый поток"+i);
        }
    }
}
