package ru.study.java.sandbox.multithreading;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test025 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
    for (int i = 0; i<3; i++){
        executorService.submit(new Processor(countDownLatch));
    }
        executorService.shutdown();
        countDownLatch.await();
        System.out.println("Что то там происходит!");
    }
}

class Processor implements Runnable{
    private CountDownLatch countDownLatch;

    public Processor(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }
}