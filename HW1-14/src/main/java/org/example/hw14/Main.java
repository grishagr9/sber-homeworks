package org.example.hw14;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    static void task1(){
        Task<String> task = new Task<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "Task completed successfully";
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(task.get());
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(task.get());
            }
        });

        thread1.start();
        thread2.start();
    }

    static void task2(){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ExecutionManager executionManager = new ExecutionManagerImpl(executorService);

        Runnable task1 = () -> System.out.println("Task 1 is running");
        Runnable task2 = () -> {
            throw new RuntimeException("Task 2 failed");
        };
        Runnable task3 = () -> System.out.println("Task 3 is running");

        Runnable callback = () -> System.out.println("All tasks have been completed");

        Context context = executionManager.execute(callback, task1, task2, task3);

        while (!context.isFinished()) {
            System.out.println("Completed tasks: " + context.getCompletedTaskCount());
            System.out.println("Failed tasks: " + context.getFailedTaskCount());
            System.out.println("Interrupted tasks: " + context.getInterruptedTaskCount());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        task1();
        task2();
    }
}
