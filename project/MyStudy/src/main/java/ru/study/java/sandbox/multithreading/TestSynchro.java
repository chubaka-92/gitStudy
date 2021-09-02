package ru.study.java.sandbox.multithreading;

public class TestSynchro {
    private int counter;
    public static void main(String[] args) throws InterruptedException {
        TestSynchro test = new TestSynchro();
        test.doWork();
    }
    //НЕ ЯВНАЯ СИНХРОНИЗАЦИЯ
    public synchronized void increment(){
        counter++;
    }
    //явная синхронизация
    public void increment2(){
        synchronized (this){//синхронизация на обьекте TestSynchro
            counter++;
        }
    }
    public void doWork() throws InterruptedException {
        Thread thead1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<10000; i++)
                    increment();
            }
        });

        Thread thead2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<10000; i++)
                    increment();
            }
        });

        thead1.start();
        thead2.start();

        thead1.join(); //ждем пока поток завершится
        thead2.join();

        System.out.println(counter);
    }
}
