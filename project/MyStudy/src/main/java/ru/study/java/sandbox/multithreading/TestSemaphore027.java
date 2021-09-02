package ru.study.java.sandbox.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TestSemaphore027 {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Connection connection =  Connection.getConnnection();
        for (int i = 0; i<10; i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.work();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }

}

class Connection{
    private static Connection connnection = new Connection();
    private int connectionCount;
    private Semaphore semaphore = new Semaphore(10);//количество разрешений. кол потоков которые могут использовать ресурс

    private Connection(){
    }

    public static Connection getConnnection(){
        return connnection;
    }

    public void work() throws InterruptedException {

        semaphore.acquire(); //забираем разрешение
        try {
            doWork();
        }
        finally {
            semaphore.release(); //release лучше вызывать в файнал блоке. отпускает разрешение
        }


    }

    private void doWork() throws InterruptedException {
        synchronized (this){
            connectionCount++;
            System.out.println(connectionCount);
        }
        Thread.sleep(5000);
        synchronized (this){
            connectionCount--;
        }
    }
}
