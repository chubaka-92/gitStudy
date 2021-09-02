package ru.study.java.sandbox.multithreading;

import java.util.Random;
import java.util.concurrent.*;

public class Test030 {
    //private static int result;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
/*        executorService.submit(new Runnable() { // Runnable не возвращает значение
        @Override
        public void run() {
            System.out.println("Starting");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished");
        }
        });*/

/*        executorService.submit(new Callable<Integer>() { // Callable возвращает значение
            @Override
            public Integer  call() {
                System.out.println("Starting");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished");
                return 9;
                //result++;
            }
        });*/

/*        executorService.submit(new Callable<Integer>() { // Callable возвращает значение
            @Override
            public Integer  call() {
                System.out.println("Starting");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished");
                return 9;
                //result++;
            }
        });*/
        Future<Integer> future = executorService.submit(()->{
            System.out.println("Starting");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished");

            Random random = new Random();
            int ranVal = random.nextInt(10);
            if(ranVal <5)
                throw new Exception("OOOu nooooou");
            return random.nextInt(10);
        });



        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int result= 0;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            Throwable ex = e.getCause();
            System.out.println(ex.getMessage());
        }
        System.out.println(result);
    }
}
