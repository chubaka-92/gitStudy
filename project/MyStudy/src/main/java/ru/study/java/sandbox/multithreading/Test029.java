package ru.study.java.sandbox.multithreading;

import java.util.Random;

public class Test029 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i=0;i<1000000000;i++){
                    if(Thread.currentThread().isInterrupted()){//смотрит хотят ли поток прервать
                        System.out.println("Поток прерван");
                        break;//если true то выходим из цикла
                    }
                    Math.sin(random.nextInt());
                }
            }
        });

        System.out.println("Start");

        thread1.start();

        Thread.sleep(10000);
        thread1.interrupt();//говорим потоку что хотим его завершить

        thread1.join();//поток маин ждет завершение поток тред1

        System.out.println("Finish");
    }
}
