package ru.study.java.sandbox.multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestThreadPool021 {

    public static void main(String[] args) throws InterruptedException {
        //создаем пул из 2 потоков
        //ExecutorService - сервис по выполнению
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i<5; i++)
            //передаем задания
            executorService.submit(new Work(i));
        //прекращаем передавать задания и говорим что можно начинать выполнять задания
        executorService.shutdown();
        System.out.println("ВСЕ ЗАДАНИЯ ПЕРЕДАНЫ НА ВЫПОЛНЕНИЕ");

        //ожидание окончания. указываем сколько мы хотим ждать пока потоки выполнят свои задания
        executorService.awaitTermination(1, TimeUnit.DAYS);//1 день ждем, если успеют потоки выполнить задание хорошо,
                                                                    // иначе пойдем дальше

    }
}

class Work implements Runnable{
    private int id;
    public Work(int id){
        this.id=id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Work " + id + " была завершена");
    }
}
